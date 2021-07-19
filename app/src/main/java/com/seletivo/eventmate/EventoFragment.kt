package com.seletivo.eventmate

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.makeText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response

private var current_item: DadosItem =
    DadosItem(listOf(), 0, "", "", "", 0.0, 0.0, listOf(), 0.0, "")

class EventoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.evento_fragment, container, false)
        var currentitem: DadosItem = current_item
        conteudo(currentitem)

        //Preenchendo a view
        val imagem = view?.findViewById<ImageView>(R.id.imagem_evento_eventofrag)
        val titulo = view?.findViewById<TextView>(R.id.titulo_evento_eventofrag)
        val descricao_evento = view?.findViewById<TextView>(R.id.descricao_evento_eventofrag)
        val date = view?.findViewById<TextView>(R.id.textview_date)
        val price = view?.findViewById<TextView>(R.id.textview_price)
        if (imagem != null) {
            Picasso.get().load(currentitem.image).into(imagem)
        }
        if (titulo != null) {
            titulo?.text = currentitem.title
        }
        if (descricao_evento != null) {
            descricao_evento?.text = currentitem.description
        }
        if (date != null) {
            date.text = current_item.date.toString()
        }
        if (price != null) {
            price.text = current_item.price.toString()
        }

        //Checkin
        val email = view?.findViewById<EditText>(R.id.edit_email)
        val nome = view?.findViewById<EditText>(R.id.edit_nome)
        val txtview = view.findViewById<TextView>(R.id.textView)

        view?.findViewById<Button>(R.id.checkin_button)?.setOnClickListener {
            if (email?.text != null && nome?.text != null) {
                var checkindata: Checkin = Checkin(
                    nome?.text.toString(), currentitem.id,
                    email?.text.toString()
                )
                PostCheckin(checkindata)
            } else {
                txtview.text = getString(R.string.preencha_todos_os_campos)
            }
        }


        return view
    }

    fun conteudo(currentItem: DadosItem) {
        current_item = currentItem
    }

    //Função que faz o CheckIn
    fun PostCheckin(checkin: Checkin) {
        retrofit().create(InterfaceAPI::class.java).CheckEvento(checkin)
            .enqueue(object : retrofit2.Callback<Checkin> {
                override fun onResponse(call: Call<Checkin>, response: Response<Checkin>) {
                    if (response.isSuccessful) {
                        Toast.makeText(
                            context,
                            getString(R.string.checkin_sucesso),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            getString(R.string.erro_execucao),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<Checkin>, t: Throwable) {
                    Toast.makeText(
                        context,
                        getString(R.string.conexao_api_fail),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}






