package com.fatkus.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fatkus.submission.adapter.CardViewProductAdapter
import com.fatkus.submission.adapter.GridProductAdapter
import com.fatkus.submission.adapter.ListProductAdapter
import com.fatkus.submission.model.Product
import com.fatkus.submission.model.ProductData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvProduct: RecyclerView
    private var list: ArrayList<Product> = arrayListOf()
    private lateinit var listProductAdapter: ListProductAdapter

    private lateinit var user_profil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = MyPagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        rvProduct = findViewById(R.id.rv_product)
        rvProduct.setHasFixedSize(true)
        list.addAll(ProductData.listProduct)
        showProductList()

    }
    private fun showProductList(){
        rvProduct.layoutManager = LinearLayoutManager(this)
        val listProductAdapter = ListProductAdapter(list)
        rvProduct.adapter = listProductAdapter

        listProductAdapter.setOnItemClickCallback (object : ListProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {
                showSelectedProduct(data)
            }
        })

        }
    private fun showProductGrid() {
        rvProduct.layoutManager = GridLayoutManager(this, 2)
        val gridProductAdapter = GridProductAdapter(list)
        rvProduct.adapter = gridProductAdapter
        //* Back *//
        gridProductAdapter.setOnItemClickCallback (object : GridProductAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Product) {
                showSelectedProduct(data)
            }
        })
    }
    private fun showProductCardView() {
        rvProduct.layoutManager = LinearLayoutManager(this)
        val cardViewProductAdapter = CardViewProductAdapter(list)
        rvProduct.adapter = cardViewProductAdapter

        cardViewProductAdapter.setOnItemClickCallback (object : CardViewProductAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Product) {
                showSelectedProduct(data)
            }
        })
    }

    private fun showSelectedProduct(data: Product) {
        Toast.makeText(this, data.name, Toast.LENGTH_LONG).show()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.user, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.user_profil -> {
//                showProductList()
                intent = Intent(this,AccountActivity::class.java)
                startActivity(intent)
            }
//            R.id.grid -> {
//                showProductGrid()
//            }
//            R.id.CardView -> {
//                showProductCardView()
//            }
        }
    }
}
