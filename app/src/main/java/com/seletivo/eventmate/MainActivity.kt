package com.seletivo.eventmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    var recycleradapter : RecyclerAdapter? = null
    var listadados :ArrayList<DadosItem> = arrayListOf()
    val dados = Dados()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler_eventos: RecyclerView = findViewById(R.id.recycler_view_dados)
        recycler_eventos.adapter = recycleradapter
        recycler_eventos.layoutManager = LinearLayoutManager(this)

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
                        }
                    }
                }

            })
    }


}


