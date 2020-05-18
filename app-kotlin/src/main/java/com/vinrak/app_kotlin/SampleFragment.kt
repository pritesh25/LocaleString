package com.vinrak.app_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class SampleFragment : BaseFragment() {

    private var prefData: PrefData? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefData = PrefData(requireContext())

        view.findViewById<View>(R.id.btnEn).setOnClickListener(View.OnClickListener {
            prefData!!.currentLanguage = "en"
            startActivity(Intent(requireContext(), MainActivity::class.java))
        })

        view.findViewById<View>(R.id.btnAr).setOnClickListener(View.OnClickListener {
            prefData!!.currentLanguage = "ar"
            startActivity(Intent(requireContext(), MainActivity::class.java))
        })

        view.findViewById<View>(R.id.btnUr).setOnClickListener(View.OnClickListener {
            prefData!!.currentLanguage = "hi"
            Toast.makeText(requireContext(),"Fragment",Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), MainActivity::class.java))
        })
    }

}
