package net.androidbootcamp.animalvoiceschildrensapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    MediaPlayer mpCows, mpPigs;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.btnCows);
        button2 = (Button)findViewById(R.id.btnPigs);
        button1.setOnClickListener(bcows);
        button2.setOnClickListener(bpigs);
        mpCows = new MediaPlayer();
        mpCows = MediaPlayer.create(this, R.raw.cows);
        mpPigs = new MediaPlayer();
        mpPigs = MediaPlayer.create(this, R.raw.pigs);
        playing = 0;
    }
    Button.OnClickListener bcows= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpCows.start();
                    playing = 1;
                    button1.setText("Pause Listen to the Cows ");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpCows.pause();
                    playing = 0;
                    button1.setText("Listen to the Cows");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }

        }

    };
    Button.OnClickListener bpigs= new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpPigs.start();
                    playing = 1;
                    button2.setText("Pause Listen to the Pigs ");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPigs.pause();
                    playing = 0;
                    button2.setText("Listen to the Pigs");
                    button1.setVisibility(View.VISIBLE);
                    break;




            }
        }

    };
}



