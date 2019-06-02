package com.example.user.myasssistant;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorLong;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.user.myasssistant.Product;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mcntx;
    private List<Product>productList;
    private MyViewHolder vh;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public CardView cardView;
        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.tvTitle);
            cardView = v.findViewById(R.id.cvCard);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context mcntx,List<Product> productList) {
        this.mcntx = mcntx;
        this.productList = productList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(mcntx);
        View v = inflater.inflate(R.layout.my_text_view , null);
        vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder( MyViewHolder holder, final int position) {
        Product p = productList.get(position);
        holder.mTextView.setText(p.getText());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 v.setBackgroundColor(Color.parseColor("#FF0000FF"));
            }

        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return productList.size();
    }





}