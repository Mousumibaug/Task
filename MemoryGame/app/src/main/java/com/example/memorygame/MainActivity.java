package com.example.memorygame;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private  static final long START_TIME_IN_MILLIS=30000;
    private TextView timer;
    private CountDownTimer mCountDownTimer;
    private long mTimeLeftInMillis=START_TIME_IN_MILLIS;
    private boolean mTimerRunning;

    String pname;
    TextView tv_p1,tv_sc;
    EditText etpn1;
    ImageView iv_11,iv_12,iv_13,iv_14,iv_21,iv_22,iv_23,iv_24,iv_31,iv_32,iv_33,iv_34;
    Integer[] cardsArray = {101,102,103,104,105,106,201,202,203,204,205,206};
    int image101,image102,image103,image104,image105,image106,image201,image202,image203,image204,image205,image206;
    int firstCard, secondCard;
    int clickedFirst,clickedSecond;
    int CardNumber=1;
    int turn=1;
    int player1Points=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTimer();

        tv_p1 = (TextView) findViewById(R.id.tv_p1);
        tv_sc =findViewById(R.id.tv_sc);
        etpn1=findViewById(R.id.etpn1);

        pname=getIntent().getExtras().getString("namesp");
        tv_p1.setText(pname+" : ");

        timer=(TextView)findViewById(R.id.timer);
        iv_11=(ImageView)findViewById(R.id.iv_11);
        iv_12=(ImageView)findViewById(R.id.iv_12);
        iv_13=(ImageView)findViewById(R.id.iv_13);
        iv_14=(ImageView)findViewById(R.id.iv_14);
        iv_21=(ImageView)findViewById(R.id.iv_21);
        iv_22=(ImageView)findViewById(R.id.iv_22);
        iv_23=(ImageView)findViewById(R.id.iv_23);
        iv_24=(ImageView)findViewById(R.id.iv_24);
        iv_31=(ImageView)findViewById(R.id.iv_31);
        iv_32=(ImageView)findViewById(R.id.iv_32);
        iv_33=(ImageView)findViewById(R.id.iv_33);
        iv_34=(ImageView)findViewById(R.id.iv_34);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");


        frontOfCardResources();

        Collections.shuffle(Arrays.asList(cardsArray));

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_11, theCard);
            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_12, theCard);
            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_13, theCard);
            }
        });
        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_14, theCard);
            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_21, theCard);
            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_22, theCard);
            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_23, theCard);
            }
        });
        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_24, theCard);
            }
        });
        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_31, theCard);
            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_32, theCard);
            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_33, theCard);
            }
        });
        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_34, theCard);
            }
        });
    }

    public void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                showResult();
            }
        }.start();
        mTimerRunning =true;
    }


    public void updateCountDownText(){
        int minutes =(int)(mTimeLeftInMillis / 1000)/60;
        int seconds = (int)(mTimeLeftInMillis /1000)%60;
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timer.setText(timeLeftFormatted);
    }


    private void doStuff(ImageView iv, int card) {
        //set the correct image to imageview
        if (cardsArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardsArray[card] == 104) {
            iv.setImageResource(image104);
        } else if (cardsArray[card] == 105) {
            iv.setImageResource(image105);
        } else if (cardsArray[card] == 106) {
            iv.setImageResource(image106);
        } else if (cardsArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardsArray[card] == 203) {
            iv.setImageResource(image203);
        } else if (cardsArray[card] == 204) {
            iv.setImageResource(image204);
        } else if (cardsArray[card] == 205) {
            iv.setImageResource(image205);
        } else if (cardsArray[card] == 206) {
            iv.setImageResource(image206);
        }
        //check which image is selected and save it in temporary variable
        if (CardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            CardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (CardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            CardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if selected images are equal
                    calculate();
                }
            }, 500);
        }
    }

    private  void calculate(){
        //if images are equal remove them
        if (firstCard == secondCard){
            if (clickedFirst ==0){
                iv_11.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==1){
                iv_12.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==2){
                iv_13.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==3){
                iv_14.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==4){
                iv_21.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==5){
                iv_22.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==6){
                iv_23.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==7){
                iv_24.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==8){
                iv_31.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==9){
                iv_32.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==10){
                iv_33.setVisibility(View.INVISIBLE);
            }else if (clickedFirst ==11){
                iv_34.setVisibility(View.INVISIBLE);
            }


            if (clickedSecond ==0){
                iv_11.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==1){
                iv_12.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==2){
                iv_13.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==3){
                iv_14.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==4){
                iv_21.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==5){
                iv_22.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==6){
                iv_23.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==7){
                iv_24.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==8){
                iv_31.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==9){
                iv_32.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==10){
                iv_33.setVisibility(View.INVISIBLE);
            }else if (clickedSecond ==11){
                iv_34.setVisibility(View.INVISIBLE);
            }
                //adding points
            if (turn==1){
                player1Points++;
                tv_sc.setText(""+player1Points);
            }

        }else{
            iv_11.setImageResource(R.drawable.initial);
            iv_12.setImageResource(R.drawable.initial);
            iv_13.setImageResource(R.drawable.initial);
            iv_14.setImageResource(R.drawable.initial);
            iv_21.setImageResource(R.drawable.initial);
            iv_22.setImageResource(R.drawable.initial);
            iv_23.setImageResource(R.drawable.initial);
            iv_24.setImageResource(R.drawable.initial);
            iv_31.setImageResource(R.drawable.initial);
            iv_32.setImageResource(R.drawable.initial);
            iv_33.setImageResource(R.drawable.initial);
            iv_34.setImageResource(R.drawable.initial);
        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);

        //check if the game is over
        checked();
    }

    private void checked(){
        if (iv_11.getVisibility()==View.INVISIBLE &&
                iv_12.getVisibility()==View.INVISIBLE &&
                iv_13.getVisibility()==View.INVISIBLE &&
                iv_14.getVisibility()==View.INVISIBLE &&
                iv_21.getVisibility()==View.INVISIBLE &&
                iv_22.getVisibility()==View.INVISIBLE &&
                iv_23.getVisibility()==View.INVISIBLE &&
                iv_24.getVisibility()==View.INVISIBLE &&
                iv_31.getVisibility()==View.INVISIBLE &&
                iv_32.getVisibility()==View.INVISIBLE &&
                iv_33.getVisibility()==View.INVISIBLE &&
                iv_34.getVisibility()==View.INVISIBLE){

            mCountDownTimer.cancel();
            showResult();
        }
    }

    private void showResult(){
        SharedPreferences settings=getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highscore=settings.getInt("EASY_HIGH_SCORE",0);
        if(player1Points>highscore){
            highscore=player1Points;
            SharedPreferences.Editor editor=settings.edit();
            editor.putInt("EASY_HIGH_SCORE",player1Points);
            editor.commit();
        }
        else{
            highscore=highscore;
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over ! \n" +tv_p1.getText()+ ""+tv_sc.getText()+ "\nHigh Score : "+highscore)
                .setCancelable(false)
                .setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),medium.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }

    private void frontOfCardResources() {
        image101 = R.drawable.angry;
        image102 = R.drawable.blush;
        image103 = R.drawable.celebration;
        image104 = R.drawable.confused;
        image105 = R.drawable.crying;
        image106 = R.drawable.lol;
        image201 = R.drawable.angry;
        image202 = R.drawable.blush;
        image203 = R.drawable.celebration;
        image204 = R.drawable.confused;
        image205 = R.drawable.crying;
        image206 = R.drawable.lol;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer!=null){
            mCountDownTimer.cancel();
        }
    }
}
