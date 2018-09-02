package com.example.giuliam.housecoach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayTasks extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    SensorsValueAdapter sensorsValueAdapter;
    ListView listView;
    int value1, value2, value3, value4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tasks);
        listView = (ListView)findViewById(R.id.listview);
        sensorsValueAdapter = new SensorsValueAdapter(this,R.layout.row_layout);
        listView.setAdapter(sensorsValueAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            String value_1, value_2, value_3, value_4;

            while(count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                value_1 = JO.getString("value_1");
                value_2 = JO.getString("value_2");
                value_3 = JO.getString("value_3");
                value_4 = JO.getString("value_4");
                SensorsValue sensorsValue = new SensorsValue(value_1,value_2,value_3,value_4);
                sensorsValueAdapter.add(sensorsValue);
                count++;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
