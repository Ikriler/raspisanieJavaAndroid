package com.example.rasp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView_main;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        recyclerView_main = findViewById(R.id.recycleView_main);
        DayRecycleViewAdapter adapter = new DayRecycleViewAdapter(this, InitRecycleView());
        recyclerView_main.setAdapter(adapter);
    }

    public String loadJSONFromAsset(Context context)  {
        String jsonText = null;
        try {
            jsonText = readText(context, R.raw.raspisanie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonText;
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<Day> InitRecycleView() {
        List<Day> days = new ArrayList<Day>();
        try {
            JSONArray raspisanie = new JSONObject(loadJSONFromAsset(context)).getJSONArray("days");
            for (int i = 0; i < raspisanie.length(); i++) {
                List<Para> parasList = new ArrayList<Para>();
                JSONArray paras = raspisanie.getJSONObject(i).getJSONArray("paras");
                for(int j = 0; j < paras.length(); j++){
                    List<Predmet> predmetsList = new ArrayList<Predmet>();
                    JSONArray predmets = paras.getJSONObject(j).getJSONArray("predmets");
                    for(int h = 0; h < predmets.length(); h++){
                        predmetsList.add(new Predmet(predmets.getJSONObject(h).getString("name_predmet"),predmets.getJSONObject(h).getString("name_prepod")));
                    }
                    parasList.add(new Para(paras.getJSONObject(j).getString("para_number"), predmetsList));
                }
                days.add(new Day(raspisanie.getJSONObject(i).getString("title_day"), parasList));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return days;
    }

}