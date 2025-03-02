package com.dw.hedge.insert

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dw.hedge.databinding.ItemAssetBinding
import com.dw.hedge.databinding.ItemInsertItemBinding
import com.dw.hedge.room.Asset

class AdapterInsertItem(private val items: List<String>) : RecyclerView.Adapter<AdapterInsertItem.AdapterInsertItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterInsertItemViewHolder {
        // ViewBinding을 사용하여 아이템 뷰를 inflate
        val binding = ItemInsertItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterInsertItemViewHolder(binding)
    }
    private var listner :onItemClickListener? = null

    fun setOnItemClickListener(listener: onItemClickListener){
        this.listner = listener
    }
    override fun onBindViewHolder(holder: AdapterInsertItemViewHolder, position: Int) {
        // 데이터를 ViewBinding을 통해 아이템 뷰에 바인딩
        val item = items[position]
        holder.binding.tvName.text = item

        holder.binding.layoutTitle.setOnClickListener {
            listner?.onItemClick(item)
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }

    // ViewHolder 클래스
    class AdapterInsertItemViewHolder(val binding: ItemInsertItemBinding) : RecyclerView.ViewHolder(binding.root)
}