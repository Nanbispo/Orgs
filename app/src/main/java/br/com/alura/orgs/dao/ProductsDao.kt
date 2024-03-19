package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Product

class ProductsDao {

    fun add(product: Product){
        products.add(product)
    }

    fun searchAll() : List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }

}