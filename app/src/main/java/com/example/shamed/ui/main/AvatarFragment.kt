package com.example.shamed.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shamed.R
import kotlinx.android.synthetic.main.fragment_avatar.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [AvatarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AvatarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_avatar, container, false)
        view.imageView.setOnClickListener {
            findNavController().navigate(R.id.dest_goals)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment AvatarFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AvatarFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
