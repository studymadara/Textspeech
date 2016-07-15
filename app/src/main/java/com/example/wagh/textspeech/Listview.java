package com.example.wagh.textspeech;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by wagh on 15/7/16.
 */
public class Listview extends AppCompatActivity implements TextToSpeech.OnInitListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TextToSpeech ttss=new TextToSpeech(this,this);

        setContentView(R.layout.listviewparent);

        try {

            //BINDING OF LISTVIEW

         final ListView ll = (ListView) findViewById(R.id.listView);

            //GETTING THE DATA INTO THE ARRAY

            String[] heart = getResources().getStringArray(R.array.heart);

            //NO CUSTOM ADAPTERS FOR NOW

            //JUST CUSTOM LAYOUT AND DATA THROWN IN THE {PARENT) LISTVIEW!
            
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textviewlist, heart);

            ll.setAdapter(arrayAdapter);

            ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                    //GETTING THE ID OF THE ITEM CLICKED

                    int pops=i;

                    //NOW GETTING THE CONTENT OF THAT ID

                    String ss=(String) ll.getItemAtPosition(i);

                    ttss.speak(ss,TextToSpeech.QUEUE_FLUSH,null);

                    Intent ii =new Intent(Listview.this,additionallistviewseperateview.class);

                    ii.putExtra("KEY",ss);

                    startActivity(ii);
                    /*********  TEXT TO SPEECH********/
                    ttss.setPitch(0.1f);
                    //ttss.shutdown();

                }
            });



        }
        catch (Exception e)
        {
            Log.e("ERROR","CHECK ARRAY PART",e);
        }

    }

    @Override
    public void onInit(int i) {

    }
}
