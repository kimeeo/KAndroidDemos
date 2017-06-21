package com.kimeeo.kAndroidDemos.map.mapSyncWithList;

import android.location.Location;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.kimeeo.kAndroid.listViews.BaseListDataView;
import com.kimeeo.kAndroid.listViews.recyclerView.BaseRecyclerView;
import com.kimeeo.kAndroid.map.BaseMapView;
import com.kimeeo.kAndroid.map.IPOI;
import com.kimeeo.kAndroidDemos.stack.BaseFragmentStacks;

/**
 * Created by bpa001 on 6/17/17.
 */

abstract public class AbstractMapRecyclerView extends BaseFragmentStacks implements OnPageChange {
    protected ViewGroup.LayoutParams createFragmentHolderLayoutFor(BaseListDataView fragment) {
        if(fragment instanceof BaseRecyclerView)
        {
            ViewGroup.LayoutParams layoutParams=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
            if(fragment.getView().getLayoutParams()!=null && fragment.getView().getLayoutParams() instanceof RelativeLayout.LayoutParams)
                layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,getRecyclerViewHeight());
            else if(fragment.getView().getLayoutParams()!=null && fragment.getView().getLayoutParams() instanceof FrameLayout.LayoutParams)
                layoutParams=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,getRecyclerViewHeight());
            else if(fragment.getView().getLayoutParams()!=null && fragment.getView().getLayoutParams() instanceof LinearLayout.LayoutParams)
                layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,getRecyclerViewHeight());
            return layoutParams;
        }
        return super.createFragmentHolderLayoutFor(fragment);
    }
    protected int getRecyclerViewHeight() {
        return 300;
    }
    BaseRecyclerView recyclerView;
    public BaseRecyclerView getViewpager() {
        return recyclerView;
    }
    public BaseMapView getMapView() {
        return mapView;
    }
    OnPageChange onPageChange;
    @Override
    public void setOnPageChange(OnPageChange listner)
    {
        this.onPageChange=listner;
    }
    @Override
    public void onPageChange(int page) {
        if(onPageChange!=null)
            onPageChange.onPageChange(page);
        if(autoSyncPager())
            syncPager(page);
    }
    protected void syncPager(int page) {
        Object data = getDataProvider().get(page);
        if(data instanceof IPOI && mapView!=null)
            mapView.moveCameraToLocation((IPOI)data);
        else if(data instanceof Location && mapView!=null)
            mapView.moveCameraToLocation((Location)data);
        else if(mapView!=null)
            zoomToMapTo(mapView.getGoogleMap(),data);

        if(recyclerView!=null && recyclerView instanceof MapRecyclerView)
            ((MapRecyclerView)recyclerView).recyclerView().scrollToPosition(page);
        else if(recyclerView!=null && recyclerView instanceof MapRecyclerView)
            scrollToPosition(recyclerView,page);
    }
    protected void scrollToPosition(BaseRecyclerView recyclerView, int page) {

    }
    protected void zoomToMapTo(GoogleMap googleMap, Object data) {
        /*
        if(data != null && googleMap != null) {
            CameraPosition cameraPosition = (new com.google.android.gms.maps.model.CameraPosition.Builder()).target(new LatLng(location.getLatitude(), location.getLongitude())).zoom(15.0F).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        */
    }
    protected boolean autoSyncPager() {
        return true;
    }
    @Override
    final protected int getAddMethod() {
        return ADDING_METHOD_ADD_NEW;
    }
    AbstractMapView mapView;
    protected BaseListDataView[] configFragments() {
        BaseListDataView[] list= new BaseListDataView[2];

        mapView=createMapView();
        mapView.setOnPageChange(this);
        list[0] = mapView;

        recyclerView=createRecyclerView();
        if(recyclerView instanceof OnPageChange)
            ((OnPageChange)recyclerView).setOnPageChange(this);
        list[1] = recyclerView;
        return list;
    }
    abstract protected BaseRecyclerView createRecyclerView();
    abstract protected AbstractMapView createMapView();
    public static interface MapRecyclerView {
        android.support.v7.widget.RecyclerView recyclerView();
    }
}
