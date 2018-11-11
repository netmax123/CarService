package com.dvinasystems.carservice;

import com.dvinasystems.carservice.json.Orders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://www.roxiemobile.ru/careers/test/";

    @GET("orders.json")
    Call<List<Orders>> getOrders();

}
