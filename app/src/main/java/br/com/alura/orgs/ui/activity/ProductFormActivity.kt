package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.dao.ProductsDao
import br.com.alura.orgs.databinding.ActivityFormProductBinding
import br.com.alura.orgs.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setsUpButtonSaving()
    }

    private fun setsUpButtonSaving() {
        val buttonSaving = binding.activityFormProductButtonSaving
        val dao = ProductsDao()
        buttonSaving.setOnClickListener {
            val newProduct = createProduct()
            dao.add(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {
        val nameField = binding.activityFormProductName
        val name = nameField.text.toString()
        val descriptionField = binding.activityFormProductDescription
        val description = descriptionField.text.toString()
        val valueField = binding.activityFormProductValue
        val valueInText = valueField.text.toString()
        val value = if (valueInText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valueInText)
        }

        return Product(
            nome = name,
            descricao = description,
            valor = value
        )
    }

}