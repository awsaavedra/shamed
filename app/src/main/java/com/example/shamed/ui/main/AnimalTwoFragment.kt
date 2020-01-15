package com.example.shamed.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shamed.R

/**
 * A simple [Fragment] subclass.
 */
class AnimalTwoFragment : Fragment() {

    companion object{
        fun newInstance() = AnimalTwoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal_two, container, true)
    }


}
