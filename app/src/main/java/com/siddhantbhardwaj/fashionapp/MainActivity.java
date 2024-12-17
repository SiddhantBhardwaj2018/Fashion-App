package com.siddhantbhardwaj.fashionapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView staggeredRV;
    private RecyclerViewAdapter adapter;
    private StaggeredGridLayoutManager manager;
    private List<Row> appList;

    int[] covers = new int[]{
      R.drawable.fash1,
      R.drawable.fash2,
      R.drawable.fash3,
      R.drawable.fash4,
      R.drawable.fash5,
      R.drawable.fash6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        staggeredRV = findViewById(R.id.recyclerViewy);
        appList = new ArrayList<>();
        adapter = new RecyclerViewAdapter(this,appList);
        manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        staggeredRV.setLayoutManager(manager);
        staggeredRV.setAdapter(adapter);
        
        initializeDataInRecyclerView();

    }

    private void initializeDataInRecyclerView() {
        Row a  = new Row(covers[0],"Box Tee");
        Row b = new Row(covers[1],"Long Tee");
        Row c = new Row(covers[2],"Short Tee");
        Row d = new Row(covers[3],"Amazing Tee");
        Row e = new Row(covers[4],"Beautiful Tee");
        Row f = new Row(covers[5],"Tee");
        appList.add(a);
        appList.add(b);
        appList.add(c);
        appList.add(d);
        appList.add(e);
        appList.add(f);

    }
}