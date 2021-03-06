package com.kimeeo.kAndroid_TV_Demo.presenter;

import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;

import com.kimeeo.kAndroidTV.core.ProgressCardVO;
import com.kimeeo.kAndroid_TV_Demo.dataProviders.Movie;

import java.util.HashMap;

/**
 * Created by BhavinPadhiyar on 5/17/17.
 */

public class Row1PresenterSelector extends PresenterSelector {

    private final HashMap<Integer, Presenter> presenters = new HashMap<Integer, Presenter>();

    @Override
    public Presenter getPresenter(Object item) {
        Presenter presenter;
        if (item instanceof ProgressCardVO) {
            presenter = presenters.get(500000);
            if (presenter == null) {
                presenter = new ProgressViewPresenter();
            }
            presenters.put(500000, presenter);
        } else {
            Movie m = (Movie) item;
            presenter = presenters.get(m.getType());
            if (presenter == null) {
                if (m.getType() == 1)
                    presenter = new TextCardPresenter();
                else
                    presenter = new TextCardPresenter();
            }
            presenters.put(m.getType(), presenter);
        }
        return presenter;
    }
}
