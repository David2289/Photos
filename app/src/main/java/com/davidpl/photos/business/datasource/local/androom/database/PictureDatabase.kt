package com.example.photos.business.datasource.local.androom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.photos.business.datasource.local.androom.dao.PictureDao
import com.example.photos.business.datasource.local.androom.entity.PictureEntity

@Database(
    entities = [PictureEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PictureDatabase: RoomDatabase() {
    abstract fun pictureDao(): PictureDao
}