package com.fatkus.submission.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fatkus.submission.DetailProductActivity
import com.fatkus.submission.R
import com.fatkus.submission.model.Product

class GridProductAdapter(val listProduct: ArrayList<Product>) : RecyclerView.Adapter<GridProductAdapter.GridViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup,i: Int): GridProductAdapter.GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid, viewGroup, false)
        return GridViewHolder(view)
        }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val product = listProduct[position]
        Glide.with(holder.itemView.context)
            .load(listProduct[position].photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listProduct[holder.adapterPosition])

            val intent = Intent(it.context, DetailProductActivity::class.java)
            intent.putExtra(DetailProductActivity.SHOW_NAME,product.name)
            intent.putExtra(DetailProductActivity.SHOW_DETAIL,product.detail)
            intent.putExtra(DetailProductActivity.SHOW_PHOTO,product.photo)
            it.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return  listProduct.size
    }
    inner class GridViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.show_poster)
    }
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback{
        fun onItemClicked(data: Product)
    }
}
