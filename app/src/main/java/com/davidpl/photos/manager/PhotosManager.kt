package com.davidpl.photos.manager

import android.content.Context
import androidx.room.Room
import com.davidpl.photos.utility.Constants
import com.example.photos.business.datasource.local.androom.dao.PictureDao
import com.example.photos.business.datasource.local.androom.database.PictureDatabase

class PhotosManager {

    companion object {

        private var instance: PictureDao? = null

        fun pictureDao(context: Context): PictureDao {
            instance?.let { return it }
            val database = Room.databaseBuilder(context, PictureDatabase::class.java, Constants.PICTURE_DATABASE)
                .allowMainThreadQueries()
                .build()
            instance = database.pictureDao()
            return database.pictureDao()
        }

    }

}