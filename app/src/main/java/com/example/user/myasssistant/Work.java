package com.example.user.myasssistant;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Work extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productList = new ArrayList<>();
        productList.add(
                new Product("number1")
        );
        productList.add(
                new Product("number3")
        );
        productList.add(
                new Product("number4")
        );
        productList.add(
                new Product("number5")
        );
        productList.add(
                new Product("number6")
        );
        setContentView(R.layout.activity_work);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(this,productList);
        mRecyclerView.setAdapter(mAdapter);


    }




    }
    // ...vh.cardView.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //                MyViewHolder veh ;
    //                veh = vh;
    //                veh.cardView.setCardBackgroundColor(Color.parseColor("#FF0000FF"));
    //            }
    //        });
