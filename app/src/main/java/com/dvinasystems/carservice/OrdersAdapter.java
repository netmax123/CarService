package com.dvinasystems.carservice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {

    private List<OrdersList> ordersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView startAddress, endAddress, tripDate, tripCost;

        public MyViewHolder(View view) {
            super(view);
            startAddress = view.findViewById(R.id.start_address);
            endAddress = view.findViewById(R.id.end_address);
            tripDate = view.findViewById(R.id.trip_date);
            tripCost = view.findViewById(R.id.trip_cost);

        }
    }

    public OrdersAdapter(List<OrdersList> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_list_row, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final OrdersList orders = ordersList.get(position);
        holder.startAddress.setText(orders.getStartAddres());
        holder.endAddress.setText(orders.getEndAddress());
        holder.tripDate.setText(orders.getOrderTime());
        holder.tripCost.setText(orders.getAmount());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context c = v.getContext();
                Intent intent = new Intent(c, DetailsActivity.class);
                intent.putExtra("startAddress", orders.getStartAddres());
                intent.putExtra("endAddress", orders.getEndAddress());
                intent.putExtra("date", orders.getOrderTime());
                intent.putExtra("price", orders.getAmount());
                intent.putExtra("regNumber", orders.getRegNumber());
                intent.putExtra("modelName", orders.getModelName());
                intent.putExtra("photo", orders.getPhoto());
                intent.putExtra("driverName", orders.getDriverName());
                c.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }

}