package com.example.stopwatch;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


    public class StopWatch_ViewModel extends ViewModel {
        private MutableLiveData<String> time;
        private MutableLiveData<Runnable> runnableTask;
        private MutableLiveData<Handler> handler;

        public MutableLiveData<String> getTime() {
            if (time == null) {
                time = new MutableLiveData<String>();
            }
            return time;
        }
        public MutableLiveData<Runnable> getRunnable() {
            if (runnableTask == null) {
                runnableTask = new MutableLiveData<Runnable>();
            }
            return runnableTask;
        }
        public MutableLiveData<Handler> getHandle() {
            if (handler == null) {
                handler = new MutableLiveData<Handler>();
            }
            return handler;
        }


    }

