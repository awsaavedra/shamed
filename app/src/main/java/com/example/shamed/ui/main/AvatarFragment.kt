package com.example.shamed.ui.main

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shamed.R
import kotlinx.android.synthetic.main.fragment_avatar.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [AvatarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AvatarFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.apply {

            recyclerView = this.recycler_view
            recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

            recyclerView.adapter = RecyclerViewAdapter(context, arrayListOf("a","b","c"))

            val cardWidthPixels = view.context.resources.displayMetrics.widthPixels * 0.80f
            val cardHintPercent = 0.01f

            recyclerView.addItemDecoration(RVPagerSnapFancyDecorator(view.context, cardWidthPixels.toInt(), cardHintPercent))
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_avatar, container, false)
        view.recycler_view.setOnClickListener {
//            findNavController().navigate(R.id.dest_goals)
        }
        // Usual setups
        return view
    }

}
