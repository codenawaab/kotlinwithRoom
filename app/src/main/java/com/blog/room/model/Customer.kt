package com.blog.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by parthasarkar on 2/24/18.
 */

@Entity(tableName = "Customers")
class Customer(@ColumnInfo(name = "FirstName")
               val firstName: String,
               @ColumnInfo(name = "LastName")
               val lastName: String,
               @ColumnInfo(name = "CreatedAt")
               val createdAt: String,
               @ColumnInfo(name = "IsDeleted")
               var isDeleted: Boolean = false) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int = 0
}
