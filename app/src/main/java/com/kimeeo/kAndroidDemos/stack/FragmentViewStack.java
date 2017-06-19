package com.kimeeo.kAndroidDemos.stack;

import android.support.v4.app.FragmentTransaction;

/**
 * Created by BhavinPadhiyar on 3/26/17.
 */

abstract public class FragmentViewStack extends BaseFragmentStacks
{
    final protected int getAddMethod() {
        return ADDING_METHOD_ADD_STACK;
    }
    private int selectedIndex=0;
    public int getSelectedIndex() {
        return selectedIndex;
    }
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        if(getFragments()!=null && isViewCreated())
            showOnlyFragments(getFragments()[selectedIndex]);
    }
    @Override
    protected void onViewComplete() {
        super.onViewComplete();
        setSelectedIndex(selectedIndex);
    }
}
