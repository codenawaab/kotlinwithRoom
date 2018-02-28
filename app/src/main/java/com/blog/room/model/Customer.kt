package com.blog.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by parthasarkar on 2/24/18.
 */

@Entity(tableName = "Customers")
class Customer {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int = 0

    @ColumnInfo(name = "FirstName")
    var firstName: String? = null

    @ColumnInfo(name = "LastName")
    var lastName: String? = null

    @ColumnInfo(name = "CreatedAt")
    var createdAt: String? = null

    @ColumnInfo(name = "IsDeleted")
    var isDeleted: Boolean = false
}
