package com.kimeeo.kAndroidDemos.pager.viewPager;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.kimeeo.kAndroid.listViews.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.pager.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.pager.viewPager.BaseViewPagerAdapter;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;
import com.nshmura.recyclertablayout.RecyclerTabLayout;

/**
 * Created by BhavinPadhiyar on 22/05/16.
 */
public class Indicator_RecycleView extends com.kimeeo.kAndroid.listViews.pager.viewPager.HorizontalViewPager {


    @Override
    protected void setUpIndicator(final View indicator, ViewPager viewPager, boolean isFirstTime) {
        if (isFirstTime && indicator instanceof RecyclerTabLayout) {
            RecyclerTabLayout pageIndicator = (RecyclerTabLayout) indicator;
            RecyclerTabLayout.Adapter<?> tabProvider = getRecyclerViewTabProvider(viewPager);
            if (tabProvider != null)
                pageIndicator.setUpWithAdapter(tabProvider);
            else
                pageIndicator.setUpWithViewPager(viewPager);
        } else if (indicator instanceof RecyclerTabLayout) {
            RecyclerTabLayout pageIndicator = (RecyclerTabLayout) indicator;
            pageIndicator.getAdapter().notifyDataSetChanged();
        }
    }

    protected RecyclerTabLayout.Adapter<?> getRecyclerViewTabProvider(ViewPager viewPager) {
        //return new TabIndicatorRecyclerViewAdapter1(viewPager,getDataProvider());
        return null;
    }

    @Override
    @LayoutRes
    protected int getRootRefreshLayoutResID() {
        return R.layout._fragment_view_pager_indicator_recycle;
    }

    @Override
    @LayoutRes
    protected int getRootLayoutResID() {
        return R.layout._fragment_view_pager_indicator_recycle;
    }


    public String getItemTitle(int position, Object o) {
        if (o instanceof DataBean) {
            DataBean data = (DataBean) o;
            return data.getName();
        }
        return "";
    }

    protected void configViewPager(ViewPager viewPager, BaseViewPagerAdapter mAdapter, View indicator) {
        viewPager.setPageTransformer(true, new StackTransformer());
    }

    @Override
    public View getView(int i, Object o) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.sample_list_view_item, null);
        return view;
    }

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), true, true);
    }

    @Override
    public BaseItemHolder getItemHolder(View view, int i, Object o) {
        return new BaseItemHolder1(view);
    }

    public class BaseItemHolder1 extends BaseItemHolder {
        public BaseItemHolder1(View itemView) {
            super(itemView);
        }

        @Override
        public void cleanView(View view, int i) {

        }

        @Override
        public void updateItemView(Object o, View view, int i) {
            DataBean data = (DataBean) o;
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(i + ". " + data.getName());
        }
    }


    //TAB Start Here
    public class TabIndicatorRecyclerViewAdapter1 extends TabIndicatorRecyclerViewAdapter {

        public TabIndicatorRecyclerViewAdapter1(ViewPager viewPager, DataProvider dataManager) {
            super(viewPager, dataManager);
        }

        protected ViewHolder getViewHolder(View view, int pos) {
            return new MyViewHolder(view);
        }

        protected View getView(ViewGroup parent, int pos) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_custom_tab_view, parent, false);
        }

        public int getItemCount() {
            return getDataManager().size();
        }


        public class MyViewHolder extends ViewHolder {

            public TextView textView;
            public ProgressBar progressBar2;


            public MyViewHolder(View itemView) {
                super(itemView);
                progressBar2 = (ProgressBar) itemView.findViewById(R.id.progressBar2);
                textView = (TextView) itemView.findViewById(R.id.textView);
            }

            @Override
            public void udateItem(int position, Object item) {
                DataBean data = (DataBean) item;
                textView.setText(data.getName());
            }

            @Override
            public void updatedSelectedItem(Object o) {
                textView.setTextColor(textView.getContext().getResources().getColor(R.color.colorPrimaryDark));
            }

            @Override
            public void updatedNormalItem(Object o) {
                textView.setTextColor(textView.getContext().getResources().getColor(R.color.colorAccent));
            }

            @Override
            public void configProgressItem() {
                progressBar2.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
            }

            @Override
            public void configNormalItem() {
                progressBar2.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
            }

            @Override
            public void updateFirst(Object item) {
                textView.setText("F - >" + textView.getText());
            }

            @Override
            public void updateLast(Object item) {
                textView.setText("L - >" + textView.getText());
            }

            @Override
            public void updateMiddel(Object item) {
                textView.setText(textView.getText());
            }
        }
    }
    //TAB VIEW ENDS HERE
}
