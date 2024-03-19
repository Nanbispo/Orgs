package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.databinding.ProdutoItemBinding
import br.com.alura.orgs.model.Product

class ProductsListAdapter(
    private val context: Context,
    products: List<Product>
) : RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {

    private val productsList = products.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            val name = binding.productItemName
            name.text = product.nome
            val description = binding.productItemDescription
            description.text = product.descricao
            val value = binding.productItemValue
            value.text = product.valor.toPlainString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productsList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productsList.size

    fun update(products: List<Product>) {
        this.productsList.clear()
        this.productsList.addAll(products)
        notifyDataSetChanged()
    }

}
