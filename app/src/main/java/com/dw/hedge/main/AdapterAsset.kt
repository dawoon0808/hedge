package com.dw.hedge.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dw.hedge.databinding.ItemAssetBinding
import com.dw.hedge.room.Asset

class AssetAdapter(private val assets: List<Asset>) : RecyclerView.Adapter<AssetAdapter.AssetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        // ViewBinding을 사용하여 아이템 뷰를 inflate
        val binding = ItemAssetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AssetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        // 데이터를 ViewBinding을 통해 아이템 뷰에 바인딩
        val asset = assets[position]
        holder.binding.tvAssetType.text = asset.name
        holder.binding.tvAssetName.text = asset.symbol
        holder.binding.tvCount.text = asset.count.toString()
        holder.binding.tvPriceNow.text = asset.price.toString()

    }

    override fun getItemCount(): Int {
        return assets.size
    }

    // ViewHolder 클래스
    class AssetViewHolder(val binding: ItemAssetBinding) : RecyclerView.ViewHolder(binding.root)
}