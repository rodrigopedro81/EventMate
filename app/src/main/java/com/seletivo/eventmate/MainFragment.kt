package com.seletivo.eventmate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainFragment : Fragment() {

    var recycleradapter : RecyclerAdapter? = null
    var listadados :ArrayList<DadosItem> = arrayListOf()
    val dados = Dados()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_main, container, false)

        retrofit().create(InterfaceAPI::class.java).ListEventos()
            .enqueue(object : retrofit2.Callback<Dados> {
                override fun onFailure(call: retrofit2.Call<Dados>, t: Throwable) {

                }
                override fun onResponse(
                    call: retrofit2.Call<Dados>,
                    response: retrofit2.Response<Dados>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            dados.clear()
                            dados.addAll(it)
                            recycleradapter = RecyclerAdapter(dados)
                            recycleradapter!!.notifyDataSetChanged()
                            val recycler_eventos: RecyclerView = view.findViewById(R.id.recycler_view_dados)
                            recycler_eventos.adapter = recycleradapter
                            recycler_eventos.layoutManager = LinearLayoutManager(context)
                        }
                    }
                }

            })

        return view
    }


}