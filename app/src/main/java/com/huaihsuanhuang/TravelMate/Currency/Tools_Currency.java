package com.huaihsuanhuang.TravelMate.Currency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huaihsuanhuang.TravelMate.Currency.listener.SimpleOnItemSelectedListener;
import com.huaihsuanhuang.TravelMate.Currency.listener.SimpleTextWatcher;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Currency;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.Map;

public class Tools_Currency extends AppCompatActivity {

    private static final String TAG = "Tools_Currency";

    private TextView mCurrencyName, mCurrencyRate, mCurrencyInverse, mCurrencyUpdate, currency_input_title;
    private String mCurrencyType;
    private EditText mCurrencyInput, mCurrencyInputTarget;
    private Map<String, Currency> mCurrencyMap;
    private Spinner mSpinner;
    private CardView currency_inputlayout;
    private CardView currency_targetlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_currency);
        initData();
        initView();
    }

    private void initData() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://www.floatrates.com/daily/twd.json",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Type currencyMapType = new TypeToken<Map<String, Currency>>() {
                        }.getType();
                        mCurrencyMap = new Gson().fromJson(response.toString(), currencyMapType);
                        Log.d(TAG, "mCurrencyMap:" + mCurrencyMap);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "error : " + error.toString());
                    }
                });
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }

    private void initView() {
        findViewById(R.id.currency_layout).getBackground().setAlpha(60);
        mCurrencyName = findViewById(R.id.currency_name);
        mCurrencyRate = findViewById(R.id.currency_rate);
        mCurrencyInverse = findViewById(R.id.currency_inverse);
        mCurrencyUpdate = findViewById(R.id.currency_update);
        currency_input_title = findViewById(R.id.currency_input_title);
        mSpinner = findViewById(R.id.spinner_currencytype);
        AutoCompleteTextView suggestionBox = findViewById(R.id.er_suggestion_box);
        mCurrencyInput = findViewById(R.id.currency_input);
        mCurrencyInputTarget = findViewById(R.id.currency_input_target);
        currency_inputlayout = findViewById(R.id.currency_inputlayout);
        currency_targetlayout = findViewById(R.id.currency_targetlayout);
        ArrayAdapter<CharSequence> myAdapter_currency = ArrayAdapter.createFromResource(
                this, R.array.Currency, R.layout.support_simple_spinner_dropdown_item);
        int spinnerPosition = myAdapter_currency.getPosition("USD");
        mSpinner.setSelection(spinnerPosition);
        mSpinner.setAdapter(myAdapter_currency);
        suggestionBox.setAdapter(myAdapter_currency);
        //  mCurrencyType = mCurrencyMap.get("usd").getName();
//TODO 抓不到 map key
        //   updateCurrencyInfo();


        suggestionBox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrencyType = parent.getItemAtPosition(position).toString().toLowerCase();
                updateCurrencyInfo();
                mCurrencyInput.setText("");
                mCurrencyInputTarget.setText("");
            }
        });

        mSpinner.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCurrencyType = parent.getItemAtPosition(position).toString().toLowerCase();
                updateCurrencyInfo();
                mCurrencyInput.setText("");
                mCurrencyInputTarget.setText("");
            }
        });

        mCurrencyInput.addTextChangedListener(TextWatcherInput);


    }

    public void onClick_exchangeposition(View view) {

        exchangeposition();


    }

    private void exchangeposition() {
        float posOneX = currency_inputlayout.getX();
        float posOneY = currency_inputlayout.getY();

        float posTwoX = currency_targetlayout.getX();
        float posTwoY = currency_targetlayout.getY();

        currency_inputlayout.setX(posTwoX);
        currency_inputlayout.setY(posTwoY);

        currency_targetlayout.setX(posOneX);
        currency_targetlayout.setY(posOneY);
        mCurrencyInput.setText("");
        mCurrencyInputTarget.setText("");
        if (currency_inputlayout.getY() < currency_targetlayout.getY()) {
            mCurrencyInput.addTextChangedListener(TextWatcherInput);
            mCurrencyInputTarget.removeTextChangedListener(TextWatchertarget);
        } else {
            mCurrencyInput.removeTextChangedListener(TextWatcherInput);
            mCurrencyInputTarget.addTextChangedListener(TextWatchertarget);
        }
    }

    private void updateCurrencyInfo() {
        if (mCurrencyMap == null) return;

        String name = mCurrencyMap.get(mCurrencyType.toLowerCase()).getName();
        String rate = String.valueOf(mCurrencyMap.get(mCurrencyType.toLowerCase()).getRate());
        String inverseRate = String.valueOf(mCurrencyMap.get(mCurrencyType.toLowerCase()).getInverseRate());
        String date = mCurrencyMap.get(mCurrencyType.toLowerCase()).getDate();
        currency_input_title.setText(name);
        mCurrencyName.setText(name);
        mCurrencyRate.setText(rate);
        mCurrencyInverse.setText(inverseRate);
        mCurrencyUpdate.setText(date);
    }

    protected void calculateinput(CharSequence currencyTypeName, double valueRate) {
        DecimalFormat df = new DecimalFormat("#.###");
        Double value_input = Double.valueOf(currencyTypeName.toString());
        Double transformat = value_input / valueRate;
        String result = df.format(transformat);
        Log.d("test_result_1", result);
        mCurrencyInputTarget.setText(result);
    }

    protected void calculatetarget(CharSequence currencyTypeName, double valueRate) {
        DecimalFormat df = new DecimalFormat("#.###");
        Double value_input = Double.valueOf(currencyTypeName.toString());
        Double transformat = value_input / valueRate;
        String result = df.format(transformat);
        Log.d("test_result_2", result);
        mCurrencyInput.setText(result);
    }

    private TextWatcher TextWatcherInput = new SimpleTextWatcher() {

        @Override
        public void onTextChanged(CharSequence currencyTypeNumber, int start, int before, int count) {
            if (mCurrencyMap == null) return;
            if (TextUtils.isEmpty(currencyTypeNumber)) {
                currencyTypeNumber = "0";
            }
            double rate = mCurrencyMap.get(mCurrencyType.toLowerCase()).getRate();
            calculateinput(currencyTypeNumber, rate);
        }
    };


    private TextWatcher TextWatchertarget = new SimpleTextWatcher() {

        @Override
        public void onTextChanged(CharSequence currencyTypeNumber, int start, int before, int count) {
            if (mCurrencyMap == null) return;
            if (TextUtils.isEmpty(currencyTypeNumber)) {
                currencyTypeNumber = "0";
            }
            double rate = mCurrencyMap.get(mCurrencyType.toLowerCase()).getInverseRate();
            calculatetarget(currencyTypeNumber, rate);

        }
    };

    public void onClickShareCurrency(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Name: " + mCurrencyName.getText().toString() +
                        " Rate: " + mCurrencyRate.getText().toString() +
                        " Inverse Rate: " + mCurrencyInverse.getText().toString() +
                        " Update time: " + mCurrencyUpdate.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
    }


}
