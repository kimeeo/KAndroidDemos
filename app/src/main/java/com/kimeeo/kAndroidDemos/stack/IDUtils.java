package com.kimeeo.kAndroidDemos.stack;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bpa001 on 6/19/17.
 */

public class IDUtils {
    private static AtomicInteger sNextGeneratedId;

    public static int generateViewId() {
        return generateRandomId(822284721,922284721);
        /*
        if(sNextGeneratedId==null)
            sNextGeneratedId = new AtomicInteger(generateRandomId(822284721,922284721));
        for (;;) {
            int result = sNextGeneratedId.get();
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF)
                newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }*/
    }

    static Random r = new Random();
    public static int generateRandomId(int min,int max) {
        return r.nextInt(max - min + 1) + min;
    }

}
