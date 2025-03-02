package com.dw.hedge.insert

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.dw.hedge.R
import com.dw.hedge.databinding.ActivityInsertItemBinding
import com.dw.hedge.util.Content

class InsertItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityInsertItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val insertType = intent.getStringExtra("type")
        if(insertType.equals(Content.INSERT_TYPE)){
            bindType(binding)
        }

    }

    fun bindType(binding: ActivityInsertItemBinding){
        binding.tvTitle.text = getString(R.string.asset_type_title)
        val lists = mutableListOf<String>()
        lists.add(Content.ASSET_TYPE_STOKE)
        lists.add(Content.ASSET_TYPE_ETF)
        lists.add(Content.ASSET_TYPE_GOLD)
        lists.add(Content.ASSET_TYPE_COIN)
        lists.add(Content.ASSET_TYPE_BOND)
        lists.add(Content.ASSET_TYPE_CASH)
        binding.itemList.layoutManager = LinearLayoutManager(this)
        val  adapter = AdapterInsertItem(lists)
        adapter.setOnItemClickListener(object : onItemClickListener{
            override fun onItemClick(value: String) {
                val reseult = Intent()
                reseult.putExtra("result",value)
                reseult.putExtra("type",Content.INSERT_TYPE)
                setResult(RESULT_OK,reseult)
                finish()
            }
        })
        binding.itemList.adapter = adapter





    }
}