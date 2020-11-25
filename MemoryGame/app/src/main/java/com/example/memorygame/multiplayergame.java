package com.example.memorygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class multiplayergame extends AppCompatActivity {

    TextView tv_p1,tv_p2,tv_sc1,tv_sc2;
    String p1name,p2name;
    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34, iv_41, iv_42, iv_43, iv_44, iv_51, iv_52, iv_53, iv_54, iv_61, iv_62, iv_63, iv_64, iv_71, iv_72, iv_73, iv_74;
    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214};
    int image101, image102, image103, image104, image105, image106, image107, image108, image109, image110, image111, image112, image113, image114, image201, image202, image203, image204, image205, image206, image207, image208, image209, image210, image211, image212, image213, image214;
    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int CardNumber = 1;
    int turn = 1;
    int player1Points = 0,player2Points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayergame);

        tv_p1 = (TextView) findViewById(R.id.tv_p1);
        tv_p2 = (TextView)findViewById(R.id.tv_p2);
        tv_sc1=findViewById(R.id.tv_sc1);
        tv_sc2=findViewById(R.id.tv_sc2);

        p1name=getIntent().getExtras().getString("name1");
        p2name=getIntent().getExtras().getString("name2");
        tv_p1.setText(p1name+" : ");
        tv_p2.setText(p2name+" : ");

        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_14 = (ImageView) findViewById(R.id.iv_14);
        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        iv_24 = (ImageView) findViewById(R.id.iv_24);
        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        iv_34 = (ImageView) findViewById(R.id.iv_34);
        iv_41 = (ImageView) findViewById(R.id.iv_41);
        iv_42 = (ImageView) findViewById(R.id.iv_42);
        iv_43 = (ImageView) findViewById(R.id.iv_43);
        iv_44 = (ImageView) findViewById(R.id.iv_44);
        iv_51 = (ImageView) findViewById(R.id.iv_51);
        iv_52 = (ImageView) findViewById(R.id.iv_52);
        iv_53 = (ImageView) findViewById(R.id.iv_53);
        iv_54 = (ImageView) findViewById(R.id.iv_54);
        iv_61 = (ImageView) findViewById(R.id.iv_61);
        iv_62 = (ImageView) findViewById(R.id.iv_62);
        iv_63 = (ImageView) findViewById(R.id.iv_63);
        iv_64 = (ImageView) findViewById(R.id.iv_64);
        iv_71 = (ImageView) findViewById(R.id.iv_71);
        iv_72 = (ImageView) findViewById(R.id.iv_72);
        iv_73 = (ImageView) findViewById(R.id.iv_73);
        iv_74 = (ImageView) findViewById(R.id.iv_74);

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
        iv_41.setTag("12");
        iv_42.setTag("13");
        iv_43.setTag("14");
        iv_44.setTag("15");
        iv_51.setTag("16");
        iv_52.setTag("17");
        iv_53.setTag("18");
        iv_54.setTag("19");
        iv_61.setTag("20");
        iv_62.setTag("21");
        iv_63.setTag("22");
        iv_64.setTag("23");
        iv_71.setTag("24");
        iv_72.setTag("25");
        iv_73.setTag("26");
        iv_74.setTag("27");

        //card images
        frontOfCardResources();

        //shuffle images
        Collections.shuffle(Arrays.asList(cardsArray));

        //changing color of second player
        tv_p2.setTextColor(Color.GRAY);

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
        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_41, theCard);
            }
        });
        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_42, theCard);
            }
        });
        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_43, theCard);
            }
        });
        iv_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_44, theCard);
            }
        });
        iv_51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_51, theCard);
            }
        });
        iv_52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_52, theCard);
            }
        });
        iv_53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_53, theCard);
            }
        });
        iv_54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_54, theCard);
            }
        });
        iv_61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_61, theCard);
            }
        });
        iv_62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_62, theCard);
            }
        });
        iv_63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_63, theCard);
            }
        });
        iv_64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_64, theCard);
            }
        });
        iv_71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_71, theCard);
            }
        });
        iv_72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_72, theCard);
            }
        });
        iv_73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_73, theCard);
            }
        });
        iv_74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_74, theCard);
            }
        });
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
        } else if (cardsArray[card] == 107) {
            iv.setImageResource(image107);
        } else if (cardsArray[card] == 108) {
            iv.setImageResource(image108);
        } else if (cardsArray[card] == 109) {
            iv.setImageResource(image109);
        } else if (cardsArray[card] == 110) {
            iv.setImageResource(image110);
        } else if (cardsArray[card] == 111) {
            iv.setImageResource(image111);
        } else if (cardsArray[card] == 112) {
            iv.setImageResource(image112);
        } else if (cardsArray[card] == 113) {
            iv.setImageResource(image113);
        } else if (cardsArray[card] == 114) {
            iv.setImageResource(image114);
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
        } else if (cardsArray[card] == 207) {
            iv.setImageResource(image207);
        } else if (cardsArray[card] == 208) {
            iv.setImageResource(image208);
        } else if (cardsArray[card] == 209) {
            iv.setImageResource(image209);
        } else if (cardsArray[card] == 210) {
            iv.setImageResource(image210);
        } else if (cardsArray[card] == 211) {
            iv.setImageResource(image211);
        } else if (cardsArray[card] == 212) {
            iv.setImageResource(image212);
        } else if (cardsArray[card] == 213) {
            iv.setImageResource(image213);
        } else if (cardsArray[card] == 214) {
            iv.setImageResource(image214);
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
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);
            iv_44.setEnabled(false);
            iv_51.setEnabled(false);
            iv_52.setEnabled(false);
            iv_53.setEnabled(false);
            iv_54.setEnabled(false);
            iv_61.setEnabled(false);
            iv_62.setEnabled(false);
            iv_63.setEnabled(false);
            iv_64.setEnabled(false);
            iv_71.setEnabled(false);
            iv_72.setEnabled(false);
            iv_73.setEnabled(false);
            iv_74.setEnabled(false);

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

    private void calculate() {
        //if images are equal remove them
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 16) {
                iv_51.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 17) {
                iv_52.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 18) {
                iv_53.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 19) {
                iv_54.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 20) {
                iv_61.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 21) {
                iv_62.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 22) {
                iv_63.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 23) {
                iv_64.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 24) {
                iv_71.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 25) {
                iv_72.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 26) {
                iv_73.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 27) {
                iv_74.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 16) {
                iv_51.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 17) {
                iv_52.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 18) {
                iv_53.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 19) {
                iv_54.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 20) {
                iv_61.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 21) {
                iv_62.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 22) {
                iv_63.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 23) {
                iv_64.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 24) {
                iv_71.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 25) {
                iv_72.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 26) {
                iv_73.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 27) {
                iv_74.setVisibility(View.INVISIBLE);
            }
            //adding points
            if (turn == 1) {
                player1Points++;
                tv_sc1.setText("" + player1Points);
            }
            else if(turn==2){
                player2Points++;
                tv_sc2.setText("" + player2Points);
            }
        } else {
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
            iv_41.setImageResource(R.drawable.initial);
            iv_42.setImageResource(R.drawable.initial);
            iv_43.setImageResource(R.drawable.initial);
            iv_44.setImageResource(R.drawable.initial);
            iv_51.setImageResource(R.drawable.initial);
            iv_52.setImageResource(R.drawable.initial);
            iv_53.setImageResource(R.drawable.initial);
            iv_54.setImageResource(R.drawable.initial);
            iv_61.setImageResource(R.drawable.initial);
            iv_62.setImageResource(R.drawable.initial);
            iv_63.setImageResource(R.drawable.initial);
            iv_64.setImageResource(R.drawable.initial);
            iv_71.setImageResource(R.drawable.initial);
            iv_72.setImageResource(R.drawable.initial);
            iv_73.setImageResource(R.drawable.initial);
            iv_74.setImageResource(R.drawable.initial);

            //change player turn
            if(turn==1){
                turn=2;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.BLACK);
            }else if (turn==2){
                turn=1;
                tv_p2.setTextColor(Color.GRAY);
                tv_p1.setTextColor(Color.BLACK);
            }
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
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        iv_44.setEnabled(true);
        iv_51.setEnabled(true);
        iv_52.setEnabled(true);
        iv_53.setEnabled(true);
        iv_54.setEnabled(true);
        iv_61.setEnabled(true);
        iv_62.setEnabled(true);
        iv_63.setEnabled(true);
        iv_64.setEnabled(true);
        iv_71.setEnabled(true);
        iv_72.setEnabled(true);
        iv_73.setEnabled(true);
        iv_74.setEnabled(true);

        //check if the game is over
        checked();
    }

    private void checked() {
        if (iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&
                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE &&
                iv_44.getVisibility() == View.INVISIBLE &&
                iv_51.getVisibility() == View.INVISIBLE &&
                iv_52.getVisibility() == View.INVISIBLE &&
                iv_53.getVisibility() == View.INVISIBLE &&
                iv_54.getVisibility() == View.INVISIBLE &&
                iv_61.getVisibility() == View.INVISIBLE &&
                iv_62.getVisibility() == View.INVISIBLE &&
                iv_63.getVisibility() == View.INVISIBLE &&
                iv_64.getVisibility() == View.INVISIBLE &&
                iv_71.getVisibility() == View.INVISIBLE &&
                iv_72.getVisibility() == View.INVISIBLE &&
                iv_73.getVisibility() == View.INVISIBLE &&
                iv_74.getVisibility() == View.INVISIBLE) {

            showResult();

        }
    }

    private void showResult() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(multiplayergame.this);
        alertDialogBuilder
                .setMessage("Game Over ! \n"+tv_p1.getText()+" : " + tv_sc1.getText() + "\n"+tv_p2.getText()+" : " + tv_sc2.getText())
                .setCancelable(false)
                .setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), multiplayergame.class);
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
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void frontOfCardResources() {
        image101 = R.drawable.angry;
        image102 = R.drawable.blush;
        image103 = R.drawable.celebration;
        image104 = R.drawable.confused;
        image105 = R.drawable.crying;
        image106 = R.drawable.lol;
        image105 = R.drawable.loving;
        image106 = R.drawable.nerd;
        image107 = R.drawable.origin;
        image108 = R.drawable.sad;
        image109 = R.drawable.sad2;
        image110 = R.drawable.shade;
        image111 = R.drawable.sleeping;
        image112 = R.drawable.smirk;
        image113 = R.drawable.sorry;
        image114 = R.drawable.tongue;
        image201 = R.drawable.angry;
        image202 = R.drawable.blush;
        image203 = R.drawable.celebration;
        image204 = R.drawable.confused;
        image205 = R.drawable.crying;
        image206 = R.drawable.lol;
        image205 = R.drawable.loving;
        image206 = R.drawable.nerd;
        image207 = R.drawable.origin;
        image208 = R.drawable.sad;
        image209 = R.drawable.sad2;
        image210 = R.drawable.shade;
        image211 = R.drawable.sleeping;
        image212 = R.drawable.smirk;
        image213 = R.drawable.sorry;
        image214 = R.drawable.tongue;
    }
}
