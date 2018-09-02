package com.example.giuliam.housecoach;

/*import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TasksFragment extends android.support.v4.app.Fragment {
    private MyViewModel model;
    private NotificationManagerCompat notificationManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, null);
        model = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        TextView task1 = view.findViewById(R.id.task1);
        TextView task2 = view.findViewById(R.id.task2);
        TextView task3 = view.findViewById(R.id.task3);

        notificationManager = NotificationManagerCompat.from(getContext());

        if (model.GarbageLevel == 0) {
            task1.setTextColor(getResources().getColor(R.color.red));
        } else {
            task1.setTextColor(getResources().getColor(R.color.green));
        }
        if (model.LaundryLevel == 0) {
            task2.setTextColor(getResources().getColor(R.color.red));
        } else {
            task2.setTextColor(getResources().getColor(R.color.green));
        }
        if (model.DustLevel == 0) {
            task3.setTextColor(getResources().getColor(R.color.red));

        } else {
            task3.setTextColor(getResources().getColor(R.color.green));
        }

        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}*/

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TasksFragment extends android.support.v4.app.Fragment {
    String json_string;
    Button b;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, null);
        b = view.findViewById(R.id.status);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJson(v);
            }
        });
        return view;
    }




    public void getJson(View view) {
        new BackgroundTask().execute();
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://musaronaldo16.000webhostapp.com/read.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            json_string = result;
            if (json_string == null) {
                Toast.makeText(getActivity().getApplicationContext(), "Error in getting JSON", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(getContext(), DisplayTasks.class);
                intent.putExtra("json_data", json_string);
                startActivity(intent);
            }
        }


    }
}