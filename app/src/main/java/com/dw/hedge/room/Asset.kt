package com.dw.hedge.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "assets")
data class Asset(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // id는 자동 생성
    @ColumnInfo(name = "type") val name: String?,
    @ColumnInfo(name = "platform") val platform: String?,
    @ColumnInfo(name = "symbol") val symbol: String?,
    @ColumnInfo(name = "count") val count: Int,
    @ColumnInfo(name = "price") val price: Double// count는 non-nullable
)