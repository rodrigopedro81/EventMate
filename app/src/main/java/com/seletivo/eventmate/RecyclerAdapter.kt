package com.seletivo.eventmate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val listadados: List<DadosItem>) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.conteudo_item, parent, false)
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = listadados[position]
        holder.titulo_evento.text = currentItem.title
        holder.descricao_evento.text = currentItem.description
        //Linkar imagens no mesmo processo
    }

    override fun getItemCount(): Int = listadados.size


    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo_evento: TextView = itemView.findViewById(R.id.nome_evento)
        val descricao_evento: TextView = itemView.findViewById(R.id.descricao_evento)
        //Imagem fazer mesmo processo

    }
}