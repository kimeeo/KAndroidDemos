package com.kimeeo.kAndroidDemos.services;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.kimeeo.kAndroidDemos.BR;

/**
 * Created by BhavinPadhiyar on 02/05/16.
 */
public class DataBean extends BaseObservable {
    private String name;
    private String title;
    private String subTitle;
    private String icon;
    private String image;
    private String details;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
