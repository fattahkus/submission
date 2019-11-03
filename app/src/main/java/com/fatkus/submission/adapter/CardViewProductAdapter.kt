package com.fatkus.submission.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fatkus.submission.DetailProductActivity
import com.fatkus.submission.R
import com.fatkus.submission.model.Product

class CardViewProductAdapter(private val listProduct: ArrayList<Product>) : RecyclerView.Adapter<CardViewProductAdapter.CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): CardViewProductAdapter.CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
    return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewProductAdapter.CardViewHolder, position: Int) {
        val product = listProduct[position]
        holder.tvName.text = product.name
        holder.tvDetail.text = product.detail
        Glide.with(holder.itemView.context)
            .load(product.photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)

        holder.tvName.text = product.name
        holder.tvDetail.text = product.detail

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listProduct[holder.adapterPosition])

            val intent = Intent(it.context, DetailProductActivity::class.java)
            intent.putExtra(DetailProductActivity.SHOW_NAME,product.name)
            intent.putExtra(DetailProductActivity.SHOW_DETAIL,product.detail)
            intent.putExtra(DetailProductActivity.SHOW_PHOTO,product.photo)
            it.context.startActivity(intent)

        }
        holder.btnFavorite.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Favorite "+listProduct[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        holder.btnShare.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Share "+listProduct[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu Memilih "+listProduct[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount(): Int {

        return listProduct.size
    }
    inner class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.show_poster)
        var tvName: TextView = itemView.findViewById(R.id.show_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.show_item_detail)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback{
        fun onItemClicked(data: Product)
    }
}
