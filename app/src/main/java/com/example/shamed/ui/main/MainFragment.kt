package com.example.shamed.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.shamed.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var hostActivity: FragmentActivity

    // todo BAD, fix by grabbing views correctly
    private lateinit var userNameEditText: EditText// = v.findViewById<View>(R.id.username)
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v = inflater.inflate(R.layout.main_fragment, container, false)

        userNameEditText = v.findViewById<View>(R.id.username) as EditText
        heightEditText = v.findViewById<View>(R.id.height) as EditText
        weightEditText = v.findViewById<View>(R.id.weight) as EditText

        viewModel.player.observe(viewLifecycleOwner, Observer {
            updateHeight(it.height)
            updateWeight(it.weight)
            updateUsername(it.username)
        })
        return v
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

    // todo, import kapt, use runOnUiThread {}
    fun updateHeight(height: Int) {
       activity?.runOnUiThread {
           heightEditText.setText("$height")
       }
    }

    fun updateWeight(weight: Int) {
        activity?.runOnUiThread {
            weightEditText.setText("$weight")
        }
    }

    fun updateUsername(name: String) {
        activity?.runOnUiThread {
            userNameEditText.setText(name)
        }
    }
}
