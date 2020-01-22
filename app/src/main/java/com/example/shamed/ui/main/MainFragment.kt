package com.example.shamed.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shamed.R
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.button_sign_in.setOnClickListener {
            findNavController().navigate(R.id.dest_sign_in)
        }

        view.button_sign_up.setOnClickListener {
            findNavController().navigate(R.id.dest_sign_up)
        }

    return view
    }
}
