package com.example.wagh.textspeech;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by wagh on 15/7/16.
 */
public class additionallistviewseperateview extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.additionallistviewseperateview);

        TextView ttt=(TextView)findViewById(R.id.finallistviewpage);

        Intent icatch =getIntent();
        String ss=icatch.getStringExtra("KEY");
        ttt.setText(ss);

    }
}
