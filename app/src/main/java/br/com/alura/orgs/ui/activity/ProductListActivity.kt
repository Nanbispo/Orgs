package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.dao.ProductsDao
import br.com.alura.orgs.databinding.ActivityListaProdutosActivityBinding
import br.com.alura.orgs.ui.recyclerview.adapter.ProductsListAdapter

class ProductListActivity : AppCompatActivity() {

    private val dao = ProductsDao()
    private val adapter = ProductsListAdapter(context = this, products = dao.searchAll())
    private val binding by lazy {
        ActivityListaProdutosActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setsUpRecyclerView()
        setsUpFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.searchAll())
    }

    private fun setsUpFab() {
        val fab = binding.activityListProductsFab
        fab.setOnClickListener {
            goToFormProduct()
        }
    }

     private fun goToFormProduct() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }

    private fun setsUpRecyclerView() {
        val recyclerView = binding.activityListProductsRecyclerView
        recyclerView.adapter = adapter
    }

}