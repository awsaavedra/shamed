package com.example.shamed.ui.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.shamed.R
import kotlinx.android.synthetic.main.fragment_user_input.*
import kotlinx.android.synthetic.main.fragment_user_input.view.*

/**
 * A simple [Fragment] subclass.
 */
class UserInputFragment : Fragment() {
    companion object {
        fun newInstance() = UserInputFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var hostActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v = inflater.inflate(R.layout.fragment_user_input, container, false)

        v.button_save.setOnClickListener {
            viewModel.save(Player(username=input_username.text.toString(),
                height=input_height.text.toString().toInt(),
                weight=input_weight.text.toString().toInt(), gems=0)
            )

            findNavController().navigate(R.id.dest_space_ship)
        }

        viewModel.player.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                initializePlayerValues()
                return@Observer
            }

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
    private fun updateHeight(height: Int) {
        activity?.runOnUiThread {
            input_height.setText("$height")
        }
    }

    private fun updateWeight(weight: Int) {
        activity?.runOnUiThread {
            input_weight.setText("$weight")
        }
    }

    private fun updateUsername(name: String) {
        activity?.runOnUiThread {
            input_username.setText(name)
        }
    }

    private fun initializePlayerValues() {
        updateHeight(0)
        updateWeight(250)
        updateUsername("")
    }
}
