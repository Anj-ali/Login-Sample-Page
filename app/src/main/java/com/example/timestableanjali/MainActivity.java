package com.example.timestableanjali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTable;
    int timesTableNumber;

    public void generatett(int timesTableNumber){

        ArrayList<String> ttcontent = new ArrayList<String>();

        for(int i =1;i<=100;i++){

            ttcontent.add(timesTableNumber+" X " + i +" = " + Integer.toString(i*timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ttcontent);

        timesTable.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar seekBar = findViewById(R.id.seekBar);

        timesTable = findViewById(R.id.timesTable);

        int max = 100;
        int startingPoint = 10;

        seekBar.setMax(max);
        seekBar.setProgress(startingPoint);

        generatett(startingPoint);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;

                if(progress<min){
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }
                else{
                    timesTableNumber = progress;
                }

                Log.i("SeekBar Value",Integer.toString(timesTableNumber));

                generatett(timesTableNumber);
            }



            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
