/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.kimeeo.kAndroid_TV_Demo.presenter;

import android.view.View;

import com.kimeeo.kAndroidTV.cards.CustomViewCardPresenter;
import com.kimeeo.kAndroid_TV_Demo.R;


/*
 * A CardPresenter is used to generate Views and bind Objects to them on demand.
 * It contains an Image CardView
 */
public class ProgressCardPresenter extends CustomViewCardPresenter {

    @Override
    public void updateItemView(View view, Object data) {

    }

    @Override
    public int getLayoutRes() {
        return R.layout.text_line_progress_card;
    }

    @Override
    final public boolean getFocusable() {
        return false;
    }
}
