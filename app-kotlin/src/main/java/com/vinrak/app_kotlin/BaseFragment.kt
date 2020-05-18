package com.vinrak.app_kotlin

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import java.util.*

open class BaseFragment : Fragment() {
    private var prefData: PrefData? = null
    val mTag = "BaseFragment"

    private lateinit var cxt: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        cxt = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAppLocale()
    }

    private fun setAppLocale() {

        //Toast.makeText(getApplicationContext(), "api = " + Build.VERSION.SDK_INT, Toast.LENGTH_SHORT).show();
        try {
            prefData = PrefData(cxt)
            val language = prefData!!.currentLanguage
            var locale: Locale? = null
            when (language) {
                "en" -> locale = Locale(language, "US")
                "ar" -> locale = Locale(language, "AE")
                "ur", "hi" -> locale = Locale(language, "IN")
            }
            Locale.setDefault(locale)
            val resources = resources
            val configuration = resources.configuration
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                configuration.setLocale(locale)
                cxt.createConfigurationContext(configuration)
            } else {
                configuration.locale = locale
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                configuration.setLayoutDirection(locale)
            } else {
                Log.d(tag, "RTL support not work in below api 17")
            }
            resources.updateConfiguration(configuration, resources.displayMetrics)
        } catch (e: Exception) {
            Log.d(tag, "catch error = " + e.message)
        }
    }

}