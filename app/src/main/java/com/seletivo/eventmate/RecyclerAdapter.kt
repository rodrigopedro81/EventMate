package com.seletivo.eventmate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response


class RecyclerAdapter(private val listadados: List<DadosItem>) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.conteudo_item, parent, false)
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = listadados[position]
        //Preenchendo os componentes da ItemView
        holder.titulo_evento.text = currentItem.title
        holder.descricao_evento.text = currentItem.description
        Picasso.get().load(currentItem.image).into(holder.imagemevento)
        //Navegando para o fragmento de +detalhes e checkin
        holder.itemView.setOnClickListener {
            Navigation.findNavController(holder.itemView).navigate(R.id.to_detalhes_fragment)
            holder.eventofragment.conteudo(currentItem)
        }
    }

    override fun getItemCount(): Int = listadados.size


    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Componentes da ItemView
        val titulo_evento: TextView = itemView.findViewById(R.id.nome_evento)
        val descricao_evento: TextView = itemView.findViewById(R.id.descricao_evento)
        val imagemevento: ImageView = itemView.findViewById(R.id.imagem_evento)
        val eventofragment = EventoFragment()
    }
}