package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Model>arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        arrayList=new ArrayList<>();

        for (int i=0;i<10;i++){
            Model model=new Model();
            model.setName("menu"+i);
            model.setImage(R.drawable.ic_home);
            arrayList.add(model);
        }
        recyclerView=findViewById(R.id.rv);

       // RecyclerView.LayoutManager layoutManager=new GridLayoutManager(DashboardActivity.this,2);
        //recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(arrayList,this);
        recyclerView.setAdapter(adapter);

    }
}
