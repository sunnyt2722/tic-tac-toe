package com.sunny.helloworld;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    ImageView sliceOne, sliceTwo, sliceThree, sliceFour, sliceFive, sliceSix, sliceSeven, sliceEight, sliceNine;
    AlertDialog message;
    String currentImage;
    boolean draw = true;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //Access to internet
//
//        webView = findViewById(R.id.WebView1);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("https://www.facebook.com/");

        sliceOne = findViewById(R.id.imgOne);
        sliceTwo = findViewById(R.id.imgTwo);
        sliceThree = findViewById(R.id.imgThree);
        sliceFour = findViewById(R.id.imgFour);
        sliceFive = findViewById(R.id.imgFive);
        sliceSix = findViewById(R.id.imgSix);
        sliceSeven = findViewById(R.id.imgSeven);
        sliceEight = findViewById(R.id.imgEight);
        sliceNine = findViewById(R.id.imgNine);
//        Boolean playerOne=true;
//        Boolean playerTwo=false;
        message = new AlertDialog.Builder(this).create();
        sliceOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(sliceOne);
                getResult(sliceEight);
            }
        });
        sliceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(sliceTwo);
                getResult(sliceEight);
            }
        });
        sliceThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(sliceThree);
                getResult(sliceEight);
            }
        });
        sliceFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(sliceFour);
                getResult(sliceEight);
            }
        });
        sliceFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(sliceFive);
                getResult(sliceEight);
            }
        });
        sliceSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(sliceSix);
                getResult(sliceEight);
            }
        });
        sliceSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(sliceSeven);
                getResult(sliceEight);
            }
        });
        sliceEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(sliceEight);
                getResult(sliceEight);
            }
        });
        sliceNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(sliceNine);
                getResult(sliceNine);
            }
        });
    }

    void setImage(ImageView image) {
        Drawable myDrawable;
        if (i % 2 == 0) {
            myDrawable = getResources().getDrawable(R.drawable.zero);
            image.setTag("Zero");
            currentImage = "Zero";
            Log.d("Value is ", String.valueOf(image.getTag()));
        } else {
            myDrawable = getResources().getDrawable(R.drawable.cross);
            image.setTag("Cross");
            currentImage = "Cross";
            Log.d("Value is ", String.valueOf(image.getTag()));
        }
        image.setImageDrawable(myDrawable);
        image.setEnabled(false);
        i++;
    }

    void getResult(ImageView img) {

        if ((String.valueOf(sliceOne.getTag()).equals(currentImage) && String.valueOf(sliceTwo.getTag()).equals(currentImage) && String.valueOf(sliceThree.getTag()).equals(currentImage))
                || (String.valueOf(sliceOne.getTag()).equals(currentImage) && String.valueOf(sliceFour.getTag()).equals(currentImage) && String.valueOf(sliceSeven.getTag()).equals(currentImage))
                || (String.valueOf(sliceOne.getTag()).equals(currentImage) && String.valueOf(sliceFive.getTag()).equals(currentImage) && String.valueOf(sliceNine.getTag()).equals(currentImage))
                || (String.valueOf(sliceTwo.getTag()).equals(currentImage) && String.valueOf(sliceFive.getTag()).equals(currentImage) && String.valueOf(sliceEight.getTag()).equals(currentImage))
                || (String.valueOf(sliceThree.getTag()).equals(currentImage) && String.valueOf(sliceSix.getTag()).equals(currentImage) && String.valueOf(sliceNine.getTag()).equals(currentImage))
                || (String.valueOf(sliceFour.getTag()).equals(currentImage) && String.valueOf(sliceFive.getTag()).equals(currentImage) && String.valueOf(sliceSix.getTag()).equals(currentImage))
                || (String.valueOf(sliceSeven.getTag()).equals(currentImage) && String.valueOf(sliceEight.getTag()).equals(currentImage) && String.valueOf(sliceNine.getTag()).equals(currentImage))
                || (String.valueOf(sliceThree.getTag()).equals(currentImage) && String.valueOf(sliceFive.getTag()).equals(currentImage) && String.valueOf(sliceSeven.getTag()).equals(currentImage))) {
            if (i % 2 != 0) {
//                message.setMessage("Player Two Won");
                message.setMessage("Played 1 won");
                message.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startNewGame();
                    }
                });
                message.show();
                draw = false;
            } else {
                message.setMessage("Player 2 won");
                message.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startNewGame();
                    }
                });
                message.show();
                draw = false;
            }
//            System.exit(0);
        }
        if (i == 9 && draw) {
            message.setMessage("Match draw");
            message.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    startNewGame();
                }
            });
            message.show();
            startNewGame();
        }
    }

    void startNewGame() {
        sliceOne.setTag("null");
        sliceTwo.setTag("null");
        sliceThree.setTag("null");
        sliceFour.setTag("null");
        sliceFive.setTag("null");
        sliceSix.setTag("null");
        sliceSeven.setTag("null");
        sliceEight.setTag("null");
        sliceNine.setTag("null");

        sliceOne.setEnabled(true);
        sliceTwo.setEnabled(true);
        sliceThree.setEnabled(true);
        sliceFour.setEnabled(true);
        sliceFive.setEnabled(true);
        sliceSix.setEnabled(true);
        sliceSeven.setEnabled(true);
        sliceEight.setEnabled(true);
        sliceNine.setEnabled(true);

        i = 0;
        draw = true;

        sliceOne.setImageDrawable(getResources().getDrawable(R.drawable.blank));
        sliceTwo.setImageDrawable(getResources().getDrawable(R.drawable.blank));
        sliceThree.setImageDrawable(getResources().getDrawable(R.drawable.blank));
        sliceFour.setImageDrawable(getResources().getDrawable(R.drawable.blank));
        sliceFive.setImageDrawable(getResources().getDrawable(R.drawable.blank));
        sliceSix.setImageDrawable(getResources().getDrawable(R.drawable.blank));
        sliceSeven.setImageDrawable(getResources().getDrawable(R.drawable.blank));
        sliceEight.setImageDrawable(getResources().getDrawable(R.drawable.blank));
        sliceNine.setImageDrawable(getResources().getDrawable(R.drawable.blank));
    }
}
