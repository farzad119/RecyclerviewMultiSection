package com.farzad119.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 30; i++) {
            Model model = new Model();
            model.setName("آیتم شماره : "+i);
            arrayList.add(model);
        }

        Adapter adapter = new Adapter(getApplicationContext(),arrayList);
        rv.setAdapter(adapter);

    }
}
