package com.blog.room.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.blog.room.dao.CustomerDao
import com.blog.room.model.Customer

/**
 * Created by parthasarkar on 2/24/18.
 */

@Database(entities = [(Customer::class)], version = 1)
abstract class SampleDatabase : RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {

        @Volatile
        private var INSTANCE: SampleDatabase? = null

        @Synchronized
        fun getInstance(context: Context): SampleDatabase? {
            if (INSTANCE == null) {
                synchronized(SampleDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                SampleDatabase::class.java,
                                "SampleDatabase")
                                //On real app you may want to remove this configuration item
                                // so all db operations are done in a background thread
                                .allowMainThreadQueries()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
