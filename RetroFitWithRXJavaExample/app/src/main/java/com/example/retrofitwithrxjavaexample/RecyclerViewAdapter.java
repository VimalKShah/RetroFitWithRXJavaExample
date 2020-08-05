package com.example.retrofitwithrxjavaexample;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Crypto.Market> list;

    RecyclerViewAdapter() {
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recyclerview_item_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Crypto.Market market = list.get(position);
        holder.coin.setText(market.coinName);
        holder.market.setText(market.market);
        holder.price.setText("$" + String.format("%.2f", Double.parseDouble(market.price)));
        if (market.coinName.equalsIgnoreCase("eth")) {
            holder.cardView.setCardBackgroundColor(Color.GRAY);
        } else {
            holder.cardView.setCardBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void setData(List<Crypto.Market> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}

class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView coin, market, price;
    CardView cardView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        coin = itemView.findViewById(R.id.txtCoin);
        market = itemView.findViewById(R.id.txtMarket);
        price = itemView.findViewById(R.id.txtPrice);
        cardView = itemView.findViewById(R.id.cardView);
    }
}
