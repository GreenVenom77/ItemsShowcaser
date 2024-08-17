package com.example.itemsshowcaser.core.view

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.itemsshowcaser.R
import com.example.itemsshowcaser.core.model.datasource.ProductsDatabase
import com.example.itemsshowcaser.core.model.datasource.LocalDataSourceImpl
import com.example.itemsshowcaser.core.viewmodel.CoreViewModel
import com.example.itemsshowcaser.core.viewmodel.CoreViewModelFactory
import com.example.itemsshowcaser.core.model.service.ProductsApi
import com.example.itemsshowcaser.core.model.datasource.RemoteDataSourceImpl
import com.example.itemsshowcaser.core.model.repository.Repository
import com.example.itemsshowcaser.core.model.repository.RepositoryImpl

class MainActivity : AppCompatActivity() {
    private val repository: Repository by lazy {
        val remote = RemoteDataSourceImpl(ProductsApi.service)
        val database = ProductsDatabase.getDatabaseInstance(applicationContext)
        val productsDao = database.productsDao()
        val local = LocalDataSourceImpl(productsDao)
        RepositoryImpl(remote, local)
    }
    private val viewModelFactory: CoreViewModelFactory by lazy {
        CoreViewModelFactory(repository)
    }
    lateinit var viewModel: CoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this, viewModelFactory)[CoreViewModel::class.java]
        viewModel.getProductsResponse()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController(R.id.navGraphHost).navigateUp()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun showNavigateUp(show: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(show)
    }
}