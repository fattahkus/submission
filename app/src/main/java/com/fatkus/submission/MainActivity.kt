package com.fatkus.submission

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.fatkus.submission.adapter.CardViewProductAdapter
import com.fatkus.submission.adapter.GridProductAdapter
import com.fatkus.submission.adapter.ListProductAdapter
import com.fatkus.submission.model.Product
import com.fatkus.submission.model.ProductData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Product> = arrayListOf()

    private lateinit var user_profil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        initComponent()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.user, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.user_profil -> startActivity(Intent(this, AccountActivity::class.java))

//            R.id.grid -> {
//                showProductGrid()
//            }
//            R.id.CardView -> {
//                showProductCardView()
//            }

        }

        return true
    }


    private fun initComponent() {

        initData()
        initTabLayout()

        adaterList()
    }

    private fun initData() {

        list.addAll(ProductData.listProduct)

    }

    private fun initTabLayout() {

        viewPager.adapter = MyPagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                when (position) {

                    0 -> adaterList()
                    1 -> adaterGrid()
                    else -> adapterCard()

                }

            }
        })

    }

    private fun adaterList() {

        val adapter = ListProductAdapter(list)

        rv_product.adapter = adapter
        rv_product.layoutManager = LinearLayoutManager(this)
        rv_product.setHasFixedSize(true)

        adapter.setOnItemClickCallback(object : ListProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {

                showSelectedProduct(data)

            }
        })

    }

    private fun adaterGrid() {

        val adapter = GridProductAdapter(list)

        rv_product.adapter = GridProductAdapter(list)
        rv_product.layoutManager = GridLayoutManager(this, 3)
        rv_product.setHasFixedSize(true)

        adapter.setOnItemClickCallback(object : GridProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {

                showSelectedProduct(data)

            }
        })

    }

    private fun adapterCard() {

        val adapter = CardViewProductAdapter(list)

        rv_product.adapter = adapter
        rv_product.layoutManager = LinearLayoutManager(this)
        rv_product.setHasFixedSize(true)

        adapter.setOnItemClickCallback(object : CardViewProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {

                showSelectedProduct(data)

            }
        })

    }

    private fun showSelectedProduct(data: Product) {
        Toast.makeText(this, data.name, Toast.LENGTH_LONG).show()
    }

}