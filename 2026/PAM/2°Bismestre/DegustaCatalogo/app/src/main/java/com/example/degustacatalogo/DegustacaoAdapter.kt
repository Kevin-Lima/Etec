package com.example.degustacatalogo

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DegustacaoAdapter(private val lista: List<Degustacao>) : RecyclerView.Adapter<DegustacaoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivFoto: ImageView = view.findViewById(R.id.ivItemFoto)
        val tvNome: TextView = view.findViewById(R.id.tvItemNome)
        val tvDetalhes: TextView = view.findViewById(R.id.tvItemDetalhes)
        val tvData: TextView = view.findViewById(R.id.tvItemData)
        val rbNota: RatingBar = view.findViewById(R.id.rbItemNota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_degustacao, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lista[position]
        holder.tvNome.text = item.nome
        holder.tvDetalhes.text = "${item.tipo} | Qtd: ${item.quantidade}"
        holder.tvData.text = item.dataCriacao
        holder.rbNota.rating = item.nota

        // Carregamento preventivo contra falhas de ciclo de permissão
        try {
            if (!item.imagemUri.isNullOrEmpty()) {
                val uri = Uri.parse(item.imagemUri)
                val context = holder.itemView.context
                val stream = context.contentResolver.openInputStream(uri)
                stream?.close()
                holder.ivFoto.setImageURI(uri)
            } else {
                holder.ivFoto.setImageResource(android.R.drawable.ic_menu_gallery)
            }
        } catch (e: Exception) {
            holder.ivFoto.setImageResource(android.R.drawable.ic_menu_gallery)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("POSICAO_ITEM", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = lista.size
}