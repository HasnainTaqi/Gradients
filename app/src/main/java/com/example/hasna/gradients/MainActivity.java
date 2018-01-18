package com.example.hasna.gradients;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
        private boolean isButtonClicked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        final String[] day_of_week = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thr", "Fri"};
        final Calendar c = Calendar.getInstance();

        final Calendar cld = Calendar.getInstance();

        Button button = findViewById(R.id.button1);
        button.setText("Back");
        final String day = day_of_week[cld.get(Calendar.DAY_OF_WEEK)];
        final String current_month = month[cld.get(Calendar.MONTH)];

        ////////////////////////////////////////////////////////////////
        final GradientDrawable gradientDrawable= new GradientDrawable();
//        int List[]={Color.GREEN,Color.WHITE,Color.GREEN};
        final ImageView image_View_Top = findViewById(R.id.img1);
        final ImageView image_View_Bottom = findViewById(R.id.img2);


        ImageView image_View_Last= findViewById(R.id.image3);
        image_View_Last.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                gradientDrawable.setCornerRadius(10);
                gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                gradientDrawable.setColors(new int[]{
                        Color.rgb(151,224,31),
                        Color.WHITE,
                        Color.rgb(151,224,31)
                });

                image_View_Top.setBackground(gradientDrawable);

                image_View_Bottom.setBackground(gradientDrawable);
            }
        });

        /////////////////////////////////////////////////////////////////

        final GradientDrawable gradientDrawable1= new GradientDrawable();
        ImageView image_View_First= findViewById(R.id.image1);
        image_View_First.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                gradientDrawable1.setCornerRadius(10);
                gradientDrawable1.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                gradientDrawable1.setColors(new int[]{
                        Color.rgb(109,1,162),
                        Color.WHITE,
                        Color.rgb(109,1,162)
                });

                image_View_Top.setBackground(gradientDrawable1);

                image_View_Bottom.setBackground(gradientDrawable1);
            }
        });

        ////////////////////////////////////////////////////////////////


        final GradientDrawable gradientDrawable2= new GradientDrawable();
        ImageView image_View_Middle= findViewById(R.id.image2);
        image_View_Middle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                gradientDrawable2.setCornerRadius(10);
                gradientDrawable2.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                gradientDrawable2.setColors(new int[]{
                        Color.rgb(108,187,18),
                        Color.WHITE,
                        Color.rgb(108,187,18)
                });

                image_View_Top.setBackground(gradientDrawable2);

                image_View_Bottom.setBackground(gradientDrawable2);
            }
        });

        ////////////////////////////////////////////////////////////////

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(view.getId()==R.id.button1)
              {
                  isButtonClicked= !isButtonClicked;
                  view.setBackgroundResource(isButtonClicked ? R.drawable.button_clicked : R.drawable.button_style);
              }
          }
      });

//        textView1.setText(day + "  " + current_month + ", " + cld.get(Calendar.DATE) + "  " + cld.get(Calendar.HOUR) + ":" + cld.get(Calendar.MINUTE) + ":"
//                + cld.get(Calendar.SECOND));
        final Timer timer = new Timer();
        //Set the schedule function
        timer.scheduleAtFixedRate(new TimerTask() {

                                      @Override
                                      public void run() {
                                          TextView textView1 = findViewById(R.id.text1);
                                          textView1.setText(day + "  " + current_month + ", " + cld.get(Calendar.DATE) + "  " + cld.get(Calendar.HOUR) + ":" + cld.get(Calendar.MINUTE) + ":"
                                                  + cld.get(Calendar.SECOND));
                                          while(true){
//                                              textView1.setText(day);

                                              try {
                                                  sleep(1000);
                                                 sleep(1000);
                                              }catch (Exception e) {
                                                  textView1.setText(e.toString());
                                              }
                                          }

                                      }
                                  },
                0, 1000);

        final TextView textView2 = findViewById(R.id.text2);

        new CountDownTimer(480000000, 100) {

            public void onTick(long millisUntilFinished) {
                Calendar c = Calendar.getInstance();
                int today = c.get(Calendar.DATE);
                int day_of_month = c.getActualMaximum(Calendar.DAY_OF_MONTH);

                long hours = (millisUntilFinished / 1000000) % 24;
                long minutes = (millisUntilFinished / 60000) % 60;
                long second = (millisUntilFinished / 1000) % 60;
                long milisecond = (millisUntilFinished / 20) % 60;
                int left=day_of_month-today;
                textView2.setText("Expires in : "  + left + " : " + hours + ":" + minutes + ":" + second + ":" + milisecond);
                if (day_of_month - today == 0)
                    onFinish();
//
            }

            public void onFinish() {
                textView2.setText("Expired!");
            }
        }.start();

        TextView textView3 = findViewById(R.id.text_view1);

        textView3.setText(c.get(Calendar.DATE) + " " + c.get(Calendar.YEAR));
    }
}

