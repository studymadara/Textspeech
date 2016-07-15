package com.example.wagh.textspeech;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    EditText et1;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bb=(Button)findViewById(R.id.listen);
        et1=(EditText)findViewById(R.id.gettext);
        tts = new TextToSpeech(this,this);


        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakout();

            }
        });

        bb.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent i=new Intent(MainActivity.this,Listview.class);
                startActivity(i);
                
                return true;
            }
        });
    }

    @Override
    public void onInit(int i) {

    }

    public void speakout()
    {
     String s=et1.getText().toString();
     tts.speak(s,TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    protected void onResume() {
        super.onResume();

        tts.setPitch(0.1f);
        tts.speak("Hello there",TextToSpeech.QUEUE_FLUSH,null);
    }
}
