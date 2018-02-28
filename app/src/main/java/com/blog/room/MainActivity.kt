package com.blog.room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.blog.room.model.Customer
import com.blog.room.repository.CustomerRepository
import com.blog.room.utilities.DateHelpers

class MainActivity : AppCompatActivity() {

    private val customerRepository: CustomerRepository by lazy { CustomerRepository(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Save a new Customer
        this.saveNewCustomer()

        //Fetch List of all customers with name like John
        val customers : List<Customer> = this.customerRepository.getAllCustomersWithName("John")
        customers.forEach {
            Log.d("Customer" , it.firstName + it.id)
        }
    }

    private fun saveNewCustomer() {
        val customer = Customer("John", "Smith", DateHelpers.getCurrentUTCDateTime())
        //customer.firstName = "John"
        //customer.lastName = "Smith"
        //customer.createdAt = DateHelpers.getCurrentUTCDateTime()
        this.customerRepository.createNewCustomer(customer)
    }
}
