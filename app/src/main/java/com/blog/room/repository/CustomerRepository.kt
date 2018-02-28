package com.blog.room.repository

import android.content.Context
import android.util.Log

import com.blog.room.dao.CustomerDao
import com.blog.room.database.SampleDatabase
import com.blog.room.model.Customer
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by parthasarkar on 2/26/18.
 */

class CustomerRepository(context: Context) {
    private var customerDao: CustomerDao? = null
    private val tag = "Customer Repository:"

    init {
        this.initMediaDatabase(context)
    }

    private fun initMediaDatabase(context: Context) {
        val sampleDatabase = SampleDatabase.getInstance(context)
        this.customerDao = sampleDatabase!!.customerDao()// Get DAO object
    }

    fun createNewCustomer(customer: Customer) {
        val executor = Executors.newSingleThreadExecutor()
        this.insertToDbInNewThread(executor, customer)
        this.shutdownExecutor(executor)
    }

    private fun insertToDbInNewThread(executor: ExecutorService, customer: Customer) {
        executor.submit {
            val threadName = Thread.currentThread().name
            Log.d(tag, threadName)
            this.customerDao!!.insert(customer)
        }
    }

    private fun shutdownExecutor(executor: ExecutorService) {
        //Shut down the Executor
        try {
            println("attempt to shutdown executor")
            executor.shutdown()
            executor.awaitTermination(5, TimeUnit.SECONDS)
        } catch (e: InterruptedException) {
            System.err.println("tasks interrupted")
        } finally {
            if (!executor.isTerminated) {
                System.err.println("cancel non-finished tasks")
            }
            executor.shutdownNow()
            println("shutdown finished")
        }
    }

    fun getAllCustomersWithName(firstName: String) : List<Customer> {
        return this.customerDao!!.allCustomersWithName("%$firstName%")
    }
}
