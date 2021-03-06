package com.kimeeo.kAndroid_TV_Demo.dataProviders;

import android.os.Handler;

import com.kimeeo.kAndroid.dataProvider.StaticDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BhavinPadhiyar on 23/05/16.
 */
public class MovieListDataProvider extends StaticDataProvider {
    Handler h = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            List list = new ArrayList();
            for (int i = 0; i < 10; i++) {
                Movie m = new Movie();
                m.setTitle("Item:" + i);
                m.setStudio("Youtunbe");
                if (i > 3)
                    m.setType(1);
                else
                    m.setType(2);
                list.add(m);
            }
            addData(list);
        }
    };
    private int pageCount = 1;

    public MovieListDataProvider() {
        setNextEnabled(true);
        setRefreshEnabled(true);
    }

    @Override
    protected void invokeLoadNext() {
        if (pageCount != 10) {
            h.postDelayed(r, 5000);
            pageCount += 1;
        } else {
            setCanLoadNext(false);
            dataLoadError(null);
        }
    }

    @Override
    protected void invokeLoadRefresh() {
    }
}