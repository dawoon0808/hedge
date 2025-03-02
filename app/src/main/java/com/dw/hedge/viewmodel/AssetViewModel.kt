package com.dw.hedge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.dw.hedge.room.Asset
import com.dw.hedge.room.AssetDatabase
import kotlinx.coroutines.launch

class AssetViewModel(application: Application):AndroidViewModel(application) {
    private val assetDao = AssetDatabase.getDatabase(application).assetDao()

    fun insert(asset: Asset) = viewModelScope.launch{

        assetDao.insert(asset)
    }
    fun delete(asset: Asset) = viewModelScope.launch {
        assetDao.delete(asset)
    }

    suspend fun getAllAsset(): List<Asset>{
        return assetDao.getAllAssets()
    }
}