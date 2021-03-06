package com.kimeeo.kAndroid_TV_Demo.fragments;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v17.leanback.app.DetailsFragmentBackgroundController;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.DetailsOverviewLogoPresenter;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroidTV.core.IHeaderItem;
import com.kimeeo.kAndroidTV.detailsFragment.AbstractDetailsFragment;
import com.kimeeo.kAndroid_TV_Demo.R;
import com.kimeeo.kAndroid_TV_Demo.SearchActivity;
import com.kimeeo.kAndroid_TV_Demo.dataProviders.HeaderDataProvider;
import com.kimeeo.kAndroid_TV_Demo.dataProviders.Movie;
import com.kimeeo.kAndroid_TV_Demo.presenter.Row1PresenterSelector;
import com.kimeeo.kAndroid_TV_Demo.presenter.Row2PresenterSelector;
import com.kimeeo.kAndroid_TV_Demo.presenter.TextCardPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by BhavinPadhiyar on 5/18/17.
 */

public class DetailsFragment extends AbstractDetailsFragment {


    @NonNull
    @Override
    public DataProvider createDataProvider() {
        return new HeaderDataProvider();
    }

    @Override
    protected Presenter getCardPresenterSelector() {
        return new TextCardPresenter();
    }

    protected List<Action> createActionlist() {
        List<Action> list = new ArrayList<>();
        list.add(new Action(1, "Buy"));
        list.add(new Action(2, "Sell"));
        list.add(new Action(3, "Rent"));
        return list;
    }

    @Override
    public PresenterSelector getRowItemPresenterSelector(IHeaderItem headerItem) {
        if (headerItem.getID().equals("0"))
            return new Row1PresenterSelector();
        return new Row2PresenterSelector();
    }

    public Row getListRow(IHeaderItem headerItem, HeaderItem header, ArrayObjectAdapter listRowAdapter) {
        return new ListRow(header, listRowAdapter);
    }


    @Override
    protected HashMap<Class<?>, Object> getClassPresenterMap() {
        HashMap<Class<?>, Object> map = new HashMap<>();
        map.put(ListRow.class, new ListRowPresenter());
        return map;
    }

    protected void initializeBackground(DetailsFragmentBackgroundController mDetailsBackground, Object data) {
        mDetailsBackground.enableParallax();
        mDetailsBackground.setCoverBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.background_canyon));
    }

    protected void setImage(DetailsOverviewRow detailsOverview, Object data) {
        detailsOverview.setImageDrawable(getActivity().getDrawable(R.drawable.image));
    }

    @Override
    protected Object createDetailsData() {
        Movie data = new Movie();
        data.setTitle("hellow");

        return data;
    }

    @Override
    protected FullWidthDetailsOverviewRowPresenter createDetailsRowPresenter(Presenter detailsDescriptionPresenter) {
        return new MyFullWidthDetailsOverviewRowPresenter(detailsDescriptionPresenter);
    }

    @Override
    protected Presenter createDetailsDescriptionPresenter() {
        return new DetailsDescriptionPresenter(getActivity());
    }

    public Class getSearchActivity() {
        return SearchActivity.class;
    }

    public class MyFullWidthDetailsOverviewRowPresenter extends FullWidthDetailsOverviewRowPresenter {
        public MyFullWidthDetailsOverviewRowPresenter(Presenter detailsPresenter) {
            super(detailsPresenter);
        }

        public MyFullWidthDetailsOverviewRowPresenter(Presenter detailsPresenter, DetailsOverviewLogoPresenter logoPresenter) {
            super(detailsPresenter, logoPresenter);
        }

        @Override
        protected RowPresenter.ViewHolder createRowViewHolder(ViewGroup parent) {
            RowPresenter.ViewHolder viewHolder = super.createRowViewHolder(parent);
            View actionsView = viewHolder.view.findViewById(R.id.details_overview_actions_background);
            actionsView.setBackgroundColor(getResources().getColor(R.color.fastlane_background));
            View detailsView = viewHolder.view.findViewById(R.id.details_frame);
            return viewHolder;
        }
    }

    public class DetailsDescriptionPresenter extends Presenter {
        private Context mContext;

        public DetailsDescriptionPresenter(Context context) {
            mContext = context;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.detail_view_content, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {

        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {
            // Nothing to do here.
        }
    }
}
