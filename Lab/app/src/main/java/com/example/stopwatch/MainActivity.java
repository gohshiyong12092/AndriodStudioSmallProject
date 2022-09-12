package com.example.stopwatch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import andriodx.appcompat.app.StopWatch_ViewModel;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private boolean IsStart = false;
    private Button button_Start, button_Reset;
    private TextView Textbox;
    private String timerStr;
    private boolean running = false;
    private long StartTime = 0;
    private long saveTime = 0;
    private StopWatch_ViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Textbox = findViewById(R.id.TextBox);
        Textbox.setTextSize(30f);
        button_Start = findViewById(R.id.StartButton);
        button_Reset = findViewById(R.id.ResetButton);

       model = new ViewModelProvider(this).get(StopWatch_ViewModel.class);
        //create the observer which updates the UI
        final Observer<String> TimeObserver = new Observer<String>(){
            @Override
            public void onChanged(@Nullable final String newTime){
                //Update the UI , in this case ,a TextView
                Textbox.setText(newTime);
            }
        };
        final Observer<Runnable> RunnableObserver = new Observer<Runnable>(){
            @Override
            public void onChanged(@Nullable final Runnable newRunnable){
                //Update the UI , in this case ,a TextView
                runnable = newRunnable;
            }
        };
        model.getTime().observe(this, TimeObserver);
        model.getRunnable().observe(this, RunnableObserver);
//        final Observer<Handler> HandlerObserver = new Observer<Handler>(){
//            @Override
//            public void onChanged(@Nullable final Handler newHandler){
//                //Update the UI , in this case ,a TextView
//                handler = newHandler;
//            }
//        };
    }
    /**
     * call when the start button is pressed
     * @param
     */
    public void OnStartButtonClick(View view){
        //super.onStart();
        if(!IsStart){
            running = true;
            IsStart = true;
            button_Start.setText("Stop");
            StartTime = SystemClock.uptimeMillis();
            handler.postAtTime(runnable,0L);
        }
        else{
            IsStart = false;
            button_Start.setText("Start");
            running = false;
            handler.removeCallbacks(runnable);
            saveTime = seconds;
        }

    }
    /**
     * call when the start button is pressed
     * @param v
     */
    public void OnResetButtonClick(View v){
        handler.removeCallbacks(runnable);
        StartTime = SystemClock.uptimeMillis();
        Textbox.setText("00:00:00");
        seconds = 0;
        saveTime = 0;
    }
    long seconds = 0;
    final Handler handler = new Handler();

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(running){
                seconds = SystemClock.uptimeMillis() - StartTime + saveTime;
                double secs = (seconds / 1000.0) % 60;
                int minutes = (int) ((seconds / 1000.0) / 60) % 60;
                int hours = (int) ((seconds / 1000.0) / 60) / 60;

                String timeStr = String.format(Locale.getDefault(), "%2d:%02d:%2.1f", hours, minutes, secs);
                model.getTime().setValue(timeStr);
                model.getRunnable().setValue(this);
                //model.getHandle().setValue(handler);
                handler.postDelayed(this, 0);
            }

        }
    };
}



