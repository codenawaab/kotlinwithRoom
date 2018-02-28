package com.blog.room.dao

import android.arch.persistence.room.*
import com.blog.room.model.Customer



/**
 * Created by parthasarkar on 2/26/18.
 */

@Dao
interface CustomerDao {

    @Query("SELECT * from Customers WHERE FirstName LIKE :firstName ")
    fun allCustomersWithName(firstName: String) : List<Customer>

    // Adds a person to the database
    @Insert
    fun insert(customer: Customer): Long

    @Update
    fun update(customer: Customer)

    @Delete
    fun delete(customer: Customer)
}
