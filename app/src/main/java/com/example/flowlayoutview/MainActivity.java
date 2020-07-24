package com.example.flowlayoutview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FlowLayoutView flowLayoutView;

    private String[] tagTextArray = new String[]{"天猫精灵", "充电台灯", "睡衣", "手表", "创意水杯", "夏天T恤男", "灯光机械键盘",
            "计算机原理", "学霸笔记本", "可口可乐", "跑步机", "旅行箱", "竹浆卫生纸", "吹风机", "洗面奶", "窗帘"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        flowLayoutView = findViewById(R.id.flowlayout);

        TextView tvAddTag = findViewById(R.id.tv_addtag);
        tvAddTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_tagview, null);
                TextView tvContent = view.findViewById(R.id.tv_content);
                tvContent.setText(tagTextArray[(int) (Math.random()*tagTextArray.length)]);
                flowLayoutView.addView(view);
            }
        });

    }

}