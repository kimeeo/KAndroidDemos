package com.kimeeo.kAndroidDemos.pager;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.kimeeo.kAndroid.listViews.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.pager.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.pager.viewPager.BaseViewPagerAdapter;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * Created by BhavinPadhiyar on 22/05/16.
 */
public class Indicator_SmartTab extends com.kimeeo.kAndroid.listViews.pager.viewPager.HorizontalViewPager {


    @Override
    protected void setUpIndicator(final View indicator, ViewPager viewPager, boolean isFirstTime) {
        if (isFirstTime && indicator instanceof SmartTabLayout) {
            SmartTabLayout pageIndicator = (SmartTabLayout) indicator;
            pageIndicator.setViewPager(viewPager);
            SmartTabLayout.TabProvider tabProvider = getTabProvider();
            if (tabProvider != null)
                pageIndicator.setCustomTabView(tabProvider);
        } else if (indicator instanceof SmartTabLayout) {
            SmartTabLayout pageIndicator = (SmartTabLayout) indicator;
            pageIndicator.setViewPager(viewPager);
            SmartTabLayout.TabProvider tabProvider = getTabProvider();
            if (tabProvider != null)
                pageIndicator.setCustomTabView(tabProvider);
        }
    }

    protected SmartTabLayout.TabProvider getTabProvider() {
        /*
        final LayoutInflater inflater = LayoutInflater.from(getActivity());
        final Resources res = getActivity().getResources();

        SmartTabLayout.TabProvider tabProvider = new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                ImageView icon = (ImageView) inflater.inflate(R.layout.custom_tab_icon2, container, false);
                switch (position) {
                    case 0:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_home_white_24dp));
                        break;
                    case 1:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_search_white_24dp));
                        break;
                    case 2:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_person_white_24dp));
                        break;
                    case 3:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_flash_on_white_24dp));
                        break;
                    default:
                        throw new IllegalStateException("Invalid position: " + position);
                }
                return icon;
            }
        };
        return  tabProvider;
        */
        return null;
    }

    @Override
    @LayoutRes
    protected int getRootRefreshLayoutResID() {
        return R.layout._fragment_view_pager_indicator_smart_tab;
    }

    @Override
    @LayoutRes
    protected int getRootLayoutResID() {
        return R.layout._fragment_view_pager_indicator_smart_tab;
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
}
