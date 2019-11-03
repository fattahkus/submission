package com.fatkus.submission.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fatkus.submission.R
import com.fatkus.submission.adapter.CardViewProductAdapter
import com.fatkus.submission.adapter.GridProductAdapter

/**
 * A simple [Fragment] subclass.
 */
class CardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false)
        val intent = Intent(context, CardViewProductAdapter::class.java)
        context?.startActivity(intent)
    }


}
