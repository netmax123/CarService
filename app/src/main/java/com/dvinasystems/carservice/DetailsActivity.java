package com.dvinasystems.carservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    String PHOTO_URL = "http://www.roxiemobile.ru/careers/test/images/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Bundle extras = getIntent().getExtras();

        String downloadUrl = PHOTO_URL + extras.getString("photo");


        ImageView carPhoto = findViewById(R.id.details_photo);

        Glide.with(this).load(downloadUrl).into(carPhoto);


        TextView startAddress = findViewById(R.id.details_start);
        startAddress.setText(extras.getString("startAddress"));

        TextView endAddress = findViewById(R.id.details_end);
        endAddress.setText(extras.getString("endAddress"));

        TextView tripDate = findViewById(R.id.details_date);
        tripDate.setText(extras.getString("date"));

        TextView price = findViewById(R.id.details_price);
        price.setText(extras.getString("price"));

        TextView regNumber = findViewById(R.id.details_regnumber);
        regNumber.setText(extras.getString("regNumber"));

        TextView modelName = findViewById(R.id.details_model);
        modelName.setText(extras.getString("modelName"));

        TextView driverName = findViewById(R.id.details_driver);
        driverName.setText(extras.getString("driverName"));

    }


}