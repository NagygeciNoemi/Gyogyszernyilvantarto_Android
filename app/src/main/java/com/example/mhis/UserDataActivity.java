package com.example.mhis;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserDataActivity extends AppCompatActivity {

    private static final String URL_PRODUCTS = "http://10.0.11.119/mhis/Api.php";

    List<UserData> dataList;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_userdatas);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        loadDatas();
    }

    private void loadDatas() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                response -> {
                    try {
                        JSONArray array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {

                            JSONObject data = array.getJSONObject(i);

                            dataList.add(new UserData(
                                    data.getInt("taj"),
                                    data.getString("username"),
                                    data.getString("p_name"),
                                    data.getString("p_address"),
                                    data.getString("p_birthday"),
                                    data.getString("p_birthplace"),
                                    data.getString("p_password"),
                                    data.getString("allergy"),
                                    data.getString("p_email")
                            ));
                        }

                        DatasAdapter adapter = new DatasAdapter(UserDataActivity.this, dataList);
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
