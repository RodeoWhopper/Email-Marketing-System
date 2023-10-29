package com.service.util;

import com.service.model.User;
import com.service.util.enums.Datum;
import com.service.util.enums.PurchaseMeta;

import java.time.LocalDate;

public class UserUtil {
    public static String checkForMeta(User user){
        if(user.getPurchaseMeta().contains(PurchaseMeta.DRESSING)){
            return PurchaseMeta.DRESSING.toString();
        } else if(user.getPurchaseMeta().contains(PurchaseMeta.TECHNOLOGY)){
            return PurchaseMeta.TECHNOLOGY.toString();
        }
        return null;
    }
    public static Datum checkForDate(User user){
        LocalDate currentDate = LocalDate.now(),lastPurchase = user.getLastPurchaseDate().toLocalDate();
        if(isFiveDaysExpired(currentDate,lastPurchase) && !isThirtyDaysExpired(currentDate,lastPurchase)){
            return Datum.MORE_THAN_5;
        } else if(isThirtyDaysExpired(currentDate,lastPurchase)){
            return Datum.MORE_THAN_30;
        } else {
            return Datum.LESS_THAN_5;
        }
    }

    private static boolean isFiveDaysExpired(LocalDate currentDate,LocalDate lastPurchase){
        return currentDate.minusDays(5).isAfter(lastPurchase);
    }

    private static boolean isThirtyDaysExpired(LocalDate currentDate,LocalDate lastPurchase){
        return currentDate.minusDays(30).isAfter(lastPurchase);
    }
}
