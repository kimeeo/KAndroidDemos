package com.kimeeo.kAndroid_TV_Demo.presenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kimeeo.kAndroidTV.cards.CustomViewCardPresenter;
import com.kimeeo.kAndroid_TV_Demo.R;
import com.kimeeo.kAndroid_TV_Demo.dataProviders.Movie;

/**
 * Created by BhavinPadhiyar on 5/17/17.
 */

public class TextCardPresenter extends CustomViewCardPresenter {
    @Override
    public void updateItemView(View view, Object data) {
        TextView extraText = (TextView) view.findViewById(R.id.extra_text);
        TextView primaryText = (TextView) view.findViewById(R.id.primary_text);
        final ImageView imageView = (ImageView) view.findViewById(R.id.main_image);

        if (data instanceof Movie) {
            Movie m = (Movie) data;
            extraText.setText(m.getStudio());
            primaryText.setText(m.getTitle());
        }

        imageView.setImageResource(R.drawable.image);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.text_icon_card;
    }
}
