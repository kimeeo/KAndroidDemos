package com.kimeeo.kAndroidDemos.pager.viewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.kAndroid.core.fragment.BaseFragment;
import com.kimeeo.kAndroidDemos.R;

/**
 * Created by BhavinPadhiyar on 22/05/16.
 */
public class DummyFragment extends BaseFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.sample_list_view_item, container, false);
        return mRootView;
    }
}
