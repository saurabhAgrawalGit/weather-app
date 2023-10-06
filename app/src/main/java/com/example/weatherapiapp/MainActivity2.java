package com.example.weatherapiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {


   EditText cityName;
   TextView temp,city,status;
   Button btn;
   ImageView imageView;
    final  String url ="https://api.openweathermap.org/data/2.5/weather";
    final  String appid ="f5432ac9ea83d466e96676f6113bf23e";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cityName=findViewById(R.id.city_et);
        city=findViewById(R.id.name);
        temp=findViewById(R.id.temp);
        status=findViewById(R.id.status);
        imageView=findViewById(R.id.img);
        btn=findViewById(R.id.submit);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"hello new",Toast.LENGTH_LONG).show();

                String city_in=cityName.getText().toString();
                String temp_url=url+"?q="+city_in+"&appid="+appid+"&units=metric";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, temp_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("weather");
                            JSONObject jsonObject1=jsonArray.getJSONObject(0);
                            String sta=jsonObject1.getString("main");
                            JSONObject jsonObjectMain=jsonObject.getJSONObject("main");
                            double tem=jsonObjectMain.getDouble("temp");
                            String name_out=jsonObject.getString("name");
                            city.setText(name_out);
                            temp.setText(Double.toString(tem));
                            status.setText(sta);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d("response",response);
                        Log.d("url",temp_url);
                        Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_LONG).show();

                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                });
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        });

    }
}