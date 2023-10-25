package com.service.tasks;

import com.service.model.Target;
import com.service.model.enums.PurchaseMeta;

import java.util.ArrayList;

public class DataControlTask implements Runnable {

    @Override
    public void run() {
        //Data Access Codes
        //Listeyi aldın
        ArrayList<Target> targets = new ArrayList<>();
        for(Target target: targets){
            if(target.getPurchaseMeta().contains(PurchaseMeta.DRESSING)){
                //send mail
            }
        }

    }

}
