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

package com.kimeeo.kAndroid_TV_Demo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.kimeeo.kAndroid_TV_Demo.fragments.BrowseFragment;

/*
 * MainActivity class that loads MainFragment1
 */
public class MainActivity extends Activity {

    private TextToSpeech tts;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        if (savedInstanceState == null) {
            Fragment fragment = new BrowseFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
        }

        // startActivity(new Intent(this, OnBoardActivity.class));
        /*
        tts = new TextToSpeech(this.getBaseContext(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {

                    int result = tts.setLanguage(new Locale("hin-IND"));

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        System.out.println("a");
                    } else {
                        tts.speak("नई दिल्ली: भारत ने फ़ाइनल में कोलंबिया को हराकर वर्ल्ड कप कंपाउंड तीरंदाज़ी का गोल्ड मेडल अपने नाम कर लिया है. भारत ने कोलंबिया के ख़िलाफ़ 5 अंकों के अंतर से जीत हासिल की. भारत के अभिषेक वर्मा, अमनजीत सिंह और चिन्नाराजू श्रीथर की तिकड़ी ने रोमांचक फ़ाइनल में अपना संयम बनाए रखा और कोलंबिया को शुरुआत से ही दबाव में रखा. कोलंबिया ने 221 अंक हासिल किए जबकि भारत ने 226 अंक.\n" +
                                "\n" +
                                "वर्ल्ड कप में भारतीय टीम की ये ऐतिहासिक जीत है. वर्ल्ड कप में भारतीय कंपाउंड टीम ने पहली बार स्वर्णिम सफ़लता हासिल की है. फ़ाइनल में पहुंचने से पहले भारत ने अमेरिका,  वियतनाम और वर्ल्ड चैंपियन ईरान जैसी टीम को शिकस्त दी. इस जीत के बाद भारतीय टीम के हौसले बुलंद हो गए हैं और तीरंदाज़ी के जानकार उनसे अभी से ही दूसरे वर्ल्ड कप (जून में तुर्की) में बड़ी उम्मीदें करने लगे हैं.\n" +
                                "\n" +
                                "इंचियन एशियाई गेम्स में गोल्ड मेडल जीतने वाले अभिषेक वर्मा ने इस टूर्नामेंट में भी शानदार प्रदर्शन किया. उनके भारतीय कोच लोकेश कुमार ने उनकी जीत के फ़ौरन बाद उनसे बात की, तो उन्होंने इस बात की खुशी जताई कि दो साल पहले 2015 में उन्होंने पहली बार पोलैंड में वर्ल्ड कप का निजी गोल्ड मेडल जीता था और अब टीम के ऐतिहासिक गोल्ड में भी उनका नाम शामिल है.\n" +
                                "\n" +
                                "अभिषेक ने बताया कि इस बार फ़ाइनल में उनकी टीम कंट्रोल में थी. अभिषेक ये भी कहते हैं कि अमेरिका जैसी मज़बूत टीम को हराना बड़ी चुनौती थी. वो कहते हैं कि इस जीत की वजह से आने वाले टूर्नामेंट में भारतीय टीम और बेहतर प्रदर्शन कर सकती है.\n" +
                                "\n" +
                                "अभिषेक के कोच लोकेश चंद कहते हैं, \"इस बार टीम कॉम्बिनेशन बहुत अच्छा था. दो सीनियर खिलाड़ी- अभिषेक और चिन्नाराजू श्रीथर के साथ एकदम नए खिलाड़ी पंजाब के अमनजीत सिंह के बीच अच्छा तालमेल बन गया जिसका फ़ायदा उन्हें पूरे टूर्नामेंट में हुआ. वो मानते हैं कि नए खिलाड़ियों का फ़ायदा टीम को लंबे समय तक मिलता रह सकता है.\"", TextToSpeech.QUEUE_FLUSH, null);
                    }
                } else {

                }
            }
        });*/
    }

    @Override
    public boolean onSearchRequested() {
        startActivity(new Intent(this, SearchActivity.class));
        return true;
    }

}
