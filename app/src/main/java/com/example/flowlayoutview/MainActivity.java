package com.example.flowlayoutview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private FlowLayoutView flowLayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        flowLayoutView = findViewById(R.id.flowlayout);

        //循环添加标签子view
        for (int i=0;i<4;i++) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_tagview, null);
            flowLayoutView.addView(view);
        }
    }

}