package com.fatkus.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_product.*
import org.w3c.dom.Text

class DetailProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        var Photo : ImageView = findViewById(R.id.show_poster)
        var Name : TextView = findViewById(R.id.show_item_name)
        var Detail: TextView = findViewById(R.id.show_item_detail)

        val name = intent.getStringExtra(SHOW_NAME)
        val detail = intent.getStringExtra(SHOW_DETAIL)
        val image = intent.getIntExtra(SHOW_PHOTO, 0)

        Glide.with(this)
            .load(image)
            .into(Photo)
        Name.text = name
        Detail.text = detail

        val actionbar = supportActionBar
        if (actionbar != null) {
            (actionbar as ActionBar).title = name
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    companion object{
        const val SHOW_NAME = "show_name"
        const val SHOW_DETAIL = "show_detail"
        const val SHOW_PHOTO = "show_photo"
    }

}
