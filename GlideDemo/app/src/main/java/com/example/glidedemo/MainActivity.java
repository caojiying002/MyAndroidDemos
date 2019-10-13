package com.example.glidedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.target.ViewTarget;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://raw.githubusercontent.com/bumptech/glide/master/static/glide_logo.png";

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Glide.with(this).load(URL).into(imageView);
        /*
        RequestManagerRetriever requestManagerRetriever = Glide.get(this).getRequestManagerRetriever();
        RequestManager requestManager = requestManagerRetriever.get(this);
        RequestBuilder<Drawable> drawableRequestBuilder = requestManager.asDrawable()
                .load(URL);
        @SuppressWarnings("deprecation") ViewTarget<ImageView, Drawable> viewTarget = drawableRequestBuilder.into(imageView);
        */
    }
}
