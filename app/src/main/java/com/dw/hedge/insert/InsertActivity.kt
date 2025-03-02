package com.dw.hedge.insert

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dw.hedge.R
import com.dw.hedge.databinding.ActivityInsertBinding
import com.dw.hedge.util.Content

class InsertActivity : AppCompatActivity() {
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val type = result.data?.getStringExtra("type")
            val resultData = result.data?.getStringExtra("result")
            if(type.equals(Content.INSERT_TYPE)){

                binding.tvTypeValue.setText(resultData)
            }

         }
    }

    private lateinit var binding: ActivityInsertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.etType.setOnClickListener {
            val intent = Intent(this,InsertItemActivity::class.java)
            intent.putExtra("type",Content.INSERT_TYPE)
            resultLauncher.launch(intent)

        }


    }
}