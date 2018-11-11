package com.dvinasystems.carservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.dvinasystems.carservice.json.Orders;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<OrdersList> mOrdersList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private OrdersAdapter mOrdersAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.order_list);
        mOrdersAdapter = new OrdersAdapter(mOrdersList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mOrdersAdapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mRecyclerView.setAdapter(mOrdersAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Orders>> call = api.getOrders();
        call.enqueue(new Callback<List<Orders>>() {
            @Override
            public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
                List<Orders> orders = response.body();

                Log.v("response", "Retrofit OK");

                for (Orders currentOrders : orders) {

                    OrdersList order = new OrdersList(currentOrders.getId().toString(), currentOrders.getStartAddress().getCity(), currentOrders.getStartAddress().getAddress(), currentOrders.getEndAddress().getCity(),
                            currentOrders.getEndAddress().getAddress(), currentOrders.getPrice().getAmount().toString().substring(0, 3) + " " + currentOrders.getPrice().getCurrency(), currentOrders.getPrice().getCurrency(), currentOrders.getOrderTime(),
                            currentOrders.getVehicle().getRegNumber(), currentOrders.getVehicle().getModelName(), currentOrders.getVehicle().getPhoto(), currentOrders.getVehicle().getDriverName());
                    mOrdersList.add(order);

                }
                mOrdersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Orders>> call, Throwable t) {
                Log.v("response", "failure from retrofit");

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}