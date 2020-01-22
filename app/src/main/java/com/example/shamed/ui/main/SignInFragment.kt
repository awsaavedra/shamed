package com.example.shamed.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.shamed.R

class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var hostActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            hostActivity = context as FragmentActivity
            viewModel = ViewModelProviders.of(hostActivity).get(MainViewModel::class.java)

        } catch (e: ClassCastException) {
            throw java.lang.ClassCastException("attach main fragment to an activity")
        }
    }
}
