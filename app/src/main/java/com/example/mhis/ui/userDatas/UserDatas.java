package com.example.mhis.ui.userDatas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mhis.UserData;
import com.example.mhis.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserDatas extends AppCompatActivity
{
    private static final String URL_DATAS = "http://192.168.194.77/mhis/Api.php";

    //a list to store all the products
    List<UserData> userDataList;

    //the recyclerview
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datas_list);

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        userDataList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadDatas();
    }

    public void loadDatas() {

        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATAS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject data = array.getJSONObject(i);

                                //adding the product to product list
                                userDataList.add(new UserData(
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

                            //creating adapter object and setting it to recyclerview
                            DatasAdapter adapter = new DatasAdapter(UserDatas.this, userDataList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
