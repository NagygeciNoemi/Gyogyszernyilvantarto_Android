package com.example.mhis;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mhis.databinding.ActivityMenuBinding;
import com.example.mhis.databinding.FragmentDoctorsBinding;
import com.example.mhis.databinding.FragmentMedicineBinding;
import com.example.mhis.ui.medicine.MedicineViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class DoctorActivity extends AppCompatActivity {
    ListView listView, listViewName, listViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_doctors);


        listViewName = (ListView) findViewById(R.id.listViewName);
        listView = (ListView) findViewById(R.id.listView);
        listViewEmail = (ListView) findViewById(R.id.listViewEmail);

        getJSON("http://192.168.43.147/mhis/Api.php");
    }


    private void getJSON(final String urlWebService) {
        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);

        String[] offices = new String[jsonArray.length()];
        String[] names = new String[jsonArray.length()];
        String[] emails = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);

            offices[i] = obj.getString("office");
            names[i] = obj.getString("d_name");
            emails[i] = obj.getString("d_email");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, offices);
        ArrayAdapter<String> arrayAdapterName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        ArrayAdapter<String> arrayAdapterEmail = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emails);

        listView.setAdapter(arrayAdapter);
        listViewName.setAdapter(arrayAdapterName);
        listViewEmail.setAdapter(arrayAdapterEmail);
    }
}

