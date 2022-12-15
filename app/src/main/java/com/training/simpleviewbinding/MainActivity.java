package com.training.simpleviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.training.simpleviewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View rootView = activityMainBinding.getRoot();
        setContentView(rootView);
//        setContentView(R.layout.activity_main);

        activityMainBinding.btnHideShow.setText("Hide");
        activityMainBinding.btnHideShow.setOnClickListener(v -> hideOrShow());

        activityMainBinding.button.setOnClickListener(v -> setText());
    }

    private void hideOrShow() {
        int visibility = (activityMainBinding.imageView.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
        activityMainBinding.imageView.setVisibility(visibility);
        if(visibility == View.VISIBLE) {
            activityMainBinding.btnHideShow.setText("Hide");
        } else {
            activityMainBinding.btnHideShow.setText("Show");
        }
    }

    private void setText() {
        String str = activityMainBinding.editText.getText().toString();
        activityMainBinding.textView.setText(str);
    }
}