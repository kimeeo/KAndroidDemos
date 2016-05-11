package com.kimeeo.kAndroidDemos.bindingDemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimeeo.kAndroid.listViews.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.recyclerView.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.recyclerView.verticalViews.ListView;
import com.kimeeo.kAndroidDemos.BR;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.bindingDemo.core.RecyclerViewBindingItemHolder;
import com.kimeeo.kAndroidDemos.databinding.SampleListBindingViewItemBinding;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

/**
 * Created by BhavinPadhiyar on 02/05/16.
 */
public class RecyclerView extends ListView{
    @Override
    public View getItemView(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {

        View view =layoutInflater.inflate(R.layout.sample_list_binding_view_item, viewGroup, false);
        ViewDataBinding binding = DataBindingUtil.bind(view);
        return binding.getRoot();
    }
    @Override
    public BaseItemHolder getItemHolder(int i, View view){
        return new BaseItemHolder1(view, BR.data);
    }

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(),true,true);
    }

    public class BaseItemHolder1<SampleListBindingViewItemBinding> extends RecyclerViewBindingItemHolder
    {
        public BaseItemHolder1(View itemView,int variableID) {
            super(itemView,variableID);
        }
    }
}
