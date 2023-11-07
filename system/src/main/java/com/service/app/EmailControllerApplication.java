package com.service.app;

import com.service.tasks.DataControlTask;
import com.service.util.exceptions.other.SynchronizationException;
import com.service.util.exceptions.other.ThreadSleepException;

public class EmailControllerApplication extends Thread{
    @Override
    public void run() {

        while(true){
            DataControlTask task = new DataControlTask();
            task.start();
            try {
                task.join();
            } catch (InterruptedException e) {
                throw new SynchronizationException();
            }

            try {
                Thread.sleep(1200000);
            } catch (InterruptedException e) {
                throw new ThreadSleepException();
            }
        }

    }
}
