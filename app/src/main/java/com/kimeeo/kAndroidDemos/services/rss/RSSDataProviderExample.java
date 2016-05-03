package com.kimeeo.kAndroidDemos.services.rss;


import com.kimeeo.kAndroid.rssDataProvider.RSSDataManager;

/**
 * Created by BhavinPadhiyar on 03/05/16.
 */
public class RSSDataProviderExample extends RSSDataManager {
    public RSSDataProviderExample()
    {
        setNextEnabled(true);
    }
    private int curruntPage=0;

    @Override
    protected String getNextURL() {
        if(curruntPage!=3) {
            curruntPage +=1;
            return "http://feeds.bbci.co.uk/news/world/rss.xml";
        }
        else
            return null;
    }
}
