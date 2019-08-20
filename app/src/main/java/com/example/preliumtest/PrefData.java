package com.example.preliumtest;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by y34h1a on 1/13/16.
 */
class PrefData {
    private static String PREF_NAME = "preference_data";
    private static String PREF_LANG = "current_language";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    PrefData(Context context) {
        this.context = context;
        pref = this.context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    String getCurrentLanguage() {
        return pref.getString(PREF_LANG, "ur");
    }

    void setCurrentLanguage(String language) {
        editor.putString(PREF_LANG, language);
        editor.commit();
    }
}