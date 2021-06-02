package com.example.photos.business.datasource.local.androom.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_picture")
data class PictureEntity(
    @ColumnInfo(name = "picture_uri")
    val pictureUri: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "key")var key: Int? = null
}