package com.fatkus.submission.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fatkus.submission.MainActivity

import com.fatkus.submission.R
import com.fatkus.submission.adapter.GridProductAdapter

/**
 * A simple [Fragment] subclass.
 */
class GridFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false)
        val intent = Intent(context, GridProductAdapter::class.java)
        context?.startActivity(intent)
    }

}
