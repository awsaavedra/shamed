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
class AnimalOneFragment : Fragment() {

    companion object{
        fun newInstance() = AnimalOneFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal_one, container, true)
    }


}
