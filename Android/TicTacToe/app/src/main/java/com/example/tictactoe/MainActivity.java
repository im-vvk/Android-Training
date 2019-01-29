package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int myActivePlayer=0;//0=cross, 1= circle
    int gameState[]={2,2,2,2,2,2,2,2,2};
    public void imageTapped(View view) {
        ImageView myTapped = (ImageView) view;
        // Log.i("Tag",""+myTapped.getTag().toString());
        int tagValue = Integer.parseInt(myTapped.getTag().toString());

        if (gameState[tagValue] == 2) {
            gameState[tagValue] = myActivePlayer;
            if (myActivePlayer == 0) {
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;
            } else {
                myTapped.setImageResource(R.drawable.circle);
                myActivePlayer = 0;
            }
        } else {
            Log.i("message", "Position is already filled");
        }
    }

    public void buttonTapped(View view)
    {
        //game state=2
        for(int i=0;i<gameState.length;i++)
            gameState[i]=2;
        //myActivePlayer = 0
        myActivePlayer=0;
        //set ic_launcher
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.lineone);
        for(int i=0;i<linearLayout1.getChildCount();i++)
        {
            ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linetwo);
        for(int i=0;i<linearLayout2.getChildCount();i++)
        {
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.linethree);
        for(int i=0;i<linearLayout3.getChildCount();i++)
        {
            ((ImageView) linearLayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
