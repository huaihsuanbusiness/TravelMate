package com.huaihsuanhuang.TravelMate;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class Tools_Currency extends AppCompatActivity {
  //  TextView testonly;
    AutoCompleteTextView suggestion_box;
    TextView currency_name,currency_rate,currency_inverse,currency_update;
    String set_currencytype;
    TextView currency_cal_one;
    EditText currency_input_one,currency_input_two;
    String server_url = "http://www.floatrates.com/daily/twd.json";
    String usd_name,usd_rate, usd_inverse, usd_update;
    String eur_name, eur_rate, eur_inverse, eur_update;
    String gbp_name,gbp_rate, gbp_inverse,gbp_update;
    String cad_name, cad_rate,cad_inverse, cad_update;
    String jpy_name, jpy_rate, jpy_inverse, jpy_update;
    String chf_name, chf_rate,chf_inverse,chf_update;
    String aud_name, aud_rate, aud_inverse,aud_update;
    String cny_name,cny_rate, cny_inverse, cny_update;
    String krw_name, krw_rate, krw_inverse,krw_update;
    String thb_name, thb_rate,thb_inverse, thb_update;
    String vnd_name, vnd_rate, vnd_inverse,vnd_update;
    String myr_name, myr_rate, myr_inverse,myr_update;
    String hkd_name, hkd_rate,hkd_inverse,hkd_update;
    String sgd_name,sgd_rate, sgd_inverse, sgd_update;
    String idr_name, idr_rate, idr_inverse, idr_update;
    LinearLayout currency_ll_one,currency_ll_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_currency);
        currency_name=findViewById(R.id.currency_name);
        currency_rate=findViewById(R.id.currency_rate);
        currency_inverse=findViewById(R.id.currency_inverse);
        currency_update=findViewById(R.id.currency_update);
       final Spinner spin_type = findViewById(R.id.spinner_currencytype);
        suggestion_box = findViewById(R.id.er_suggestion_box);
        currency_cal_one=findViewById(R.id.currency_cal_one);
        currency_input_one=findViewById(R.id.currency_input_one);
        currency_input_two=findViewById(R.id.currency_input_two);
        currency_ll_one=findViewById(R.id.currency_ll_one);
        currency_ll_two=findViewById(R.id.currency_ll_two);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(server_url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("metro_requesttest", "response = " + response.toString());
                        parserJson(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("metro_requesttestsomethingwentwrong", "error : " + error.toString());
            }
        });
        Volley.newRequestQueue(this).add(jsonObjectRequest);

        String myString = "USD";
        ArrayAdapter<CharSequence> myAdapter_currency = ArrayAdapter.createFromResource(
                this, R.array.Currency, android.R.layout.simple_spinner_dropdown_item );
        int spinnerPosition = myAdapter_currency.getPosition(myString);
        spin_type.setSelection(spinnerPosition);
        spin_type.setAdapter(myAdapter_currency);
        suggestion_box.setAdapter(myAdapter_currency);

        suggestion_box.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                set_currencytype = spin_type.getSelectedItem().toString();
//TODO 用suggestionbox選擇的set_text無法同步到其他地方

            }@Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spin_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                set_currencytype = spin_type.getSelectedItem().toString();
                current_currency(set_currencytype);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }});
        currency_input_one.addTextChangedListener(TextWatcher_one);
        currency_input_one.addTextChangedListener(TextWatcher_two);
        View view =findViewById(R.id.currency_layout);
        view.getBackground().setAlpha(60);
    }

    private void current_currency(String set_currencytype) {
        switch (set_currencytype) {
            case "USD":

                currency_name.setText(usd_name);
                currency_rate.setText(usd_rate);
                currency_inverse.setText(usd_inverse);
                currency_update.setText(usd_update);
                break;
            case "EUR":
                currency_name.setText(eur_name);
                currency_rate.setText(eur_rate);
                currency_inverse.setText(eur_inverse);
                currency_update.setText(eur_update);
                break;
            case "GBP":
                currency_name.setText(gbp_name);
                currency_rate.setText(gbp_rate);
                currency_inverse.setText(gbp_inverse);
                currency_update.setText(gbp_update);
                break;
            case "CAD":
                currency_name.setText(cad_name);
                currency_rate.setText(cad_rate);
                currency_inverse.setText(cad_inverse);
                currency_update.setText(cad_update);
                break;
            case "JPY":
                currency_name.setText(jpy_name);
                currency_rate.setText(jpy_rate);
                currency_inverse.setText(jpy_inverse);
                currency_update.setText(jpy_update);
                break;
            case "CHF":
                currency_name.setText(chf_name);
                currency_rate.setText(chf_rate);
                currency_inverse.setText(chf_inverse);
                currency_update.setText(chf_update);
                break;
            case "AUD":
                currency_name.setText(aud_name);
                currency_rate.setText(aud_rate);
                currency_inverse.setText(aud_inverse);
                currency_update.setText(aud_update);
                break;
            case "CNY":
                currency_name.setText(cny_name);
                currency_rate.setText(cny_rate);
                currency_inverse.setText(cny_inverse);
                currency_update.setText(cny_update);
                break;
            case "KRW":
                currency_name.setText(krw_name);
                currency_rate.setText(krw_rate);
                currency_inverse.setText(krw_inverse);
                currency_update.setText(krw_update);
                break;
            case "THB":
                currency_name.setText(thb_name);
                currency_rate.setText(thb_rate);
                currency_inverse.setText(thb_inverse);
                currency_update.setText(thb_update);
                break;
            case "VND":
                currency_name.setText(vnd_name);
                currency_rate.setText(vnd_rate);
                currency_inverse.setText(vnd_inverse);
                currency_update.setText(vnd_update);
                break;
            case "MYR":
                currency_name.setText(myr_name);
                currency_rate.setText(myr_rate);
                currency_inverse.setText(myr_inverse);
                currency_update.setText(myr_update);
                break;
            case "HKD":
                currency_name.setText(hkd_name);
                currency_rate.setText(hkd_rate);
                currency_inverse.setText(hkd_inverse);
                currency_update.setText(hkd_update);
                break;
            case "SGD":
                currency_name.setText(sgd_name);
                currency_rate.setText(sgd_rate);
                currency_inverse.setText(sgd_inverse);
                currency_update.setText(sgd_update);
                break;
            case "IDR":
                currency_name.setText(idr_name);
                currency_rate.setText(idr_rate);
                currency_inverse.setText(idr_inverse);
                currency_update.setText(idr_update);
                break;
            default:
                currency_name.setText(" ");
                break;

        }
    }


    private void parserJson(JSONObject jsonObject) {

        try {
            JSONObject data_usd = jsonObject.getJSONObject("usd");
            JSONObject data_eur = jsonObject.getJSONObject("eur");
            JSONObject data_gbp = jsonObject.getJSONObject("gbp");
            JSONObject data_cad = jsonObject.getJSONObject("cad");
            JSONObject data_jpy = jsonObject.getJSONObject("jpy");
            JSONObject data_chf = jsonObject.getJSONObject("chf");
            JSONObject data_aud = jsonObject.getJSONObject("aud");
            JSONObject data_cny = jsonObject.getJSONObject("cny");
            JSONObject data_krw = jsonObject.getJSONObject("krw");
            JSONObject data_thb = jsonObject.getJSONObject("thb");
            JSONObject data_vnd = jsonObject.getJSONObject("vnd");
            JSONObject data_myr = jsonObject.getJSONObject("myr");
            JSONObject data_hkd = jsonObject.getJSONObject("hkd");
            JSONObject data_sgd = jsonObject.getJSONObject("sgd");
            JSONObject data_idr = jsonObject.getJSONObject("idr");

            DecimalFormat df=new DecimalFormat("#.##");
            usd_name=data_usd.get("name").toString();
            usd_rate=df.format(Double.valueOf(data_usd.get("rate").toString()));
            usd_inverse=df.format(Double.valueOf(data_usd.get("inverseRate").toString()));
            usd_update= data_usd.get("date").toString();
            eur_name=data_eur.get("name").toString();
            eur_rate=df.format(Double.valueOf(data_eur.get("rate").toString()));
            eur_inverse=df.format(Double.valueOf(data_eur.get("inverseRate").toString()));
            eur_update= data_eur.get("date").toString();
            gbp_name=data_gbp.get("name").toString();
            gbp_rate=df.format(Double.valueOf(data_gbp.get("rate").toString()));
            gbp_inverse=df.format(Double.valueOf(data_gbp.get("inverseRate").toString()));
            gbp_update= data_gbp.get("date").toString();
            cad_name=data_cad.get("name").toString();
            cad_rate=df.format(Double.valueOf(data_cad.get("rate").toString()));
            cad_inverse=df.format(Double.valueOf(data_cad.get("inverseRate").toString()));
            cad_update= data_cad.get("date").toString();
            jpy_name=data_jpy.get("name").toString();
            jpy_rate=df.format(Double.valueOf(data_jpy.get("rate").toString()));
            jpy_inverse=df.format(Double.valueOf(data_jpy.get("inverseRate").toString()));
            jpy_update= data_jpy.get("date").toString();
            chf_name=data_chf.get("name").toString();
            chf_rate=df.format(Double.valueOf(data_chf.get("rate").toString()));
            chf_inverse=df.format(Double.valueOf(data_chf.get("inverseRate").toString()));
            chf_update= data_chf.get("date").toString();
            aud_name=data_aud.get("name").toString();
            aud_rate=df.format(Double.valueOf(data_aud.get("rate").toString()));
            aud_inverse=df.format(Double.valueOf(data_aud.get("inverseRate").toString()));
            aud_update= data_aud.get("date").toString();
            cny_name=data_cny.get("name").toString();
            cny_rate=df.format(Double.valueOf(data_cny.get("rate").toString()));
            cny_inverse=df.format(Double.valueOf(data_cny.get("inverseRate").toString()));
            cny_update= data_cny.get("date").toString();
            krw_name=data_krw.get("name").toString();
            krw_rate=df.format(Double.valueOf(data_krw.get("rate").toString()));
            krw_inverse=df.format(Double.valueOf(data_krw.get("inverseRate").toString()));
            krw_update= data_krw.get("date").toString();
            thb_name=data_thb.get("name").toString();
            thb_rate=df.format(Double.valueOf(data_thb.get("rate").toString()));
            thb_inverse=df.format(Double.valueOf(data_thb.get("inverseRate").toString()));
            thb_update= data_thb.get("date").toString();
            vnd_name=data_vnd.get("name").toString();
            vnd_rate=df.format(Double.valueOf(data_vnd.get("rate").toString()));
            vnd_inverse=df.format(Double.valueOf(data_vnd.get("inverseRate").toString()));
            vnd_update= data_vnd.get("date").toString();
            myr_name=data_myr.get("name").toString();
            myr_rate=df.format(Double.valueOf(data_myr.get("rate").toString()));
            myr_inverse=df.format(Double.valueOf(data_myr.get("inverseRate").toString()));
            myr_update= data_myr.get("date").toString();
            hkd_name=data_hkd.get("name").toString();
            hkd_rate=df.format(Double.valueOf(data_hkd.get("rate").toString()));
            hkd_inverse=df.format(Double.valueOf(data_hkd.get("inverseRate").toString()));
            hkd_update= data_hkd.get("date").toString();
            sgd_name=data_sgd.get("name").toString();
            sgd_rate=df.format(Double.valueOf(data_sgd.get("rate").toString()));
            sgd_inverse=df.format(Double.valueOf(data_sgd.get("inverseRate").toString()));
            sgd_update= data_sgd.get("date").toString();
            idr_name=data_idr.get("name").toString();
            idr_rate=df.format(Double.valueOf(data_idr.get("rate").toString()));
            idr_inverse=df.format(Double.valueOf(data_idr.get("inverseRate").toString()));
            idr_update= data_idr.get("date").toString();


        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("objectstestwrong", e.getLocalizedMessage());
        }



    }

    protected void calculate (CharSequence value_s, double value_rate, int id){

        DecimalFormat df=new DecimalFormat("#.###");
        if(id==1) {
            Double value_input=Double.valueOf(value_s.toString());
            Double transformat = value_input / value_rate;
            String result =df.format(transformat);
            Log.d("test_result_1", result);
            currency_input_two.setText(result);


        }
        if (id==2){
            Double value_input=Double.valueOf(value_s.toString());
            Double transformat = value_input * value_rate;
            String result=df.format(transformat);
            currency_input_one.setText(result);
            Log.d("bbbtest",transformat.toString());

        }
    }

    private TextWatcher TextWatcher_one = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            switch (set_currencytype){
                case "USD":
                    calculate(s,Double.valueOf(usd_rate),1);

                    break;
                case "EUR":
                    calculate(s,Double.valueOf(eur_rate),1);
                    break;
                case "GBP":
                    calculate(s,Double.valueOf(gbp_rate),1);
                    break;
                case "CAD":
                    calculate(s,Double.valueOf(cad_rate),1);
                    break;
                case "JPY":
                    calculate(s,Double.valueOf(jpy_rate),1);
                    break;
                case "CHF":
                    calculate(s,Double.valueOf(chf_rate),1);
                    break;
                case "AUD":
                    calculate(s,Double.valueOf(aud_rate),1);
                    break;
                case "CNY":
                    calculate(s,Double.valueOf(cny_rate),1);
                    break;
                case "KRW":
                    calculate(s,Double.valueOf(krw_rate),1);
                    break;
                case "THB":
                    calculate(s,Double.valueOf(thb_rate),1);
                    break;
                case "VND":
                    calculate(s,Double.valueOf(vnd_rate),1);
                    break;
                case "MYR":
                    calculate(s,Double.valueOf(myr_rate),1);
                    break;
                case "HKD":
                    calculate(s,Double.valueOf(hkd_rate),1);
                    break;
                case "SGD":
                    calculate(s,Double.valueOf(sgd_rate),1);
                    break;
                case "IDR":
                    calculate(s,Double.valueOf(idr_rate),1);
                    break;
                default:
                    calculate(s,Double.valueOf(usd_rate),2);
                    break;
            }

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher TextWatcher_two = new TextWatcher() {
//TODO textwatcher 閃退
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // DO THE CALCULATIONS HERE AND SHOW THE RESULT AS PER YOUR CALCULATIONS
            switch (set_currencytype){
                case "USD":
                    calculate(s,Double.valueOf(usd_rate),2);
                    break;
                case "EUR":
                    calculate(s,Double.valueOf(eur_rate),2);
                    break;
                case "GBP":
                    calculate(s,Double.valueOf(gbp_rate),2);
                    break;
                case "CAD":
                    calculate(s,Double.valueOf(cad_rate),2);
                    break;
                case "JPY":
                    calculate(s,Double.valueOf(jpy_rate),2);
                    break;
                case "CHF":
                    calculate(s,Double.valueOf(chf_rate),2);
                    break;
                case "AUD":
                    calculate(s,Double.valueOf(aud_rate),2);
                    break;
                case "CNY":
                    calculate(s,Double.valueOf(cny_rate),2);
                    break;
                case "KRW":
                    calculate(s,Double.valueOf(krw_rate),2);
                    break;
                case "THB":
                    calculate(s,Double.valueOf(thb_rate),2);
                    break;
                case "VND":
                    calculate(s,Double.valueOf(vnd_rate),2);
                    break;
                case "MYR":
                    calculate(s,Double.valueOf(myr_rate),2);
                    break;
                case "HKD":
                    calculate(s,Double.valueOf(hkd_rate),2);
                    break;
                case "SGD":
                    calculate(s,Double.valueOf(sgd_rate),2);
                    break;
                case "IDR":
                    calculate(s,Double.valueOf(idr_rate),2);
                    break;
                    default:
                        calculate(s,Double.valueOf(usd_rate),2);
                        break;
            }

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void onclick_sharecurrency(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Name: "+currency_name.getText().toString()+
                        " Rate: "+currency_rate.getText().toString()+
                        " Inverse Rate: "+currency_inverse.getText().toString()+
                        " Update time: "+currency_update.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
    }
}
