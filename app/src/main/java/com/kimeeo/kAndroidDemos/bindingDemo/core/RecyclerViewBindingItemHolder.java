package com.kimeeo.kAndroidDemos.bindingDemo.core;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.kimeeo.kAndroid.listViews.recyclerView.BaseItemHolder;

import java.util.Map;

/**
 * Created by bhavinpadhiyar on 3/9/16.
 */
public class RecyclerViewBindingItemHolder<T extends ViewDataBinding> extends BaseItemHolder {

    private final Binding<T> binding;
    private Map<Integer, Object> variables;

    public RecyclerViewBindingItemHolder(View itemView, int variableID, Map<Integer, Object> variables) {
        super(itemView);
        binding = new Binding<T>(itemView, variableID);
        setVariables(variables);
    }

    public RecyclerViewBindingItemHolder(View itemView, int variableID) {
        super(itemView);
        binding = new Binding<T>(itemView,variableID);
        setVariables(getDefaultMap());
    }

    public RecyclerViewBindingItemHolder(View itemView, Map<Integer, Object>  map) {
        super(itemView);
        binding = new Binding<T>(itemView,-1);
        setVariables(map);
        setVariables(getDefaultMap());
    }


    public RecyclerViewBindingItemHolder(View itemView){
        this(itemView, -1);
    }

    protected Map<Integer, Object> getDefaultMap() {
        return variables;
    }

    public Map<Integer, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<Integer, Object> data) {
        variables = data;
        binding.setVariables(data);
    }

    public T getBinding(){
        return binding.getBinding();
    }
    public void updateItemView(Object item, int position){
        setVariable(item);
        super.updateItemView(item, position);
    }
    public void updateItemView(Object data, View view, int position){

    }

    public void setVariable(Object data){
        binding.setVariable(data);
    }
    public void setVariable(int variableID,Object data) {
        binding.setVariable(variableID, data);
    }
    public View getView(int resID){
        return binding.getView(resID);
    }
}
