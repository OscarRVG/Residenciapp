package com.example.residenciapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.residenciapp.R
import com.example.residenciapp.io.ApiService
import com.example.residenciapp.model.AreaComun
import kotlinx.android.synthetic.main.activity_area_comun.*
import kotlinx.android.synthetic.main.activity_area_comun.inicio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.ArrayAdapter as ArrayAdapter

class AreaComunActivity : AppCompatActivity() {

    private val apiService: ApiService by lazy{
        ApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area_comun)


 /*       apartar1.setOnClickListener {

            val intent = Intent(this, CalendarioActivity::class.java)
            startActivity(intent)
        }
        apartar2.setOnClickListener {

            val intent = Intent(this, CalendarioActivity::class.java)
            startActivity(intent)
        }*/
        inicio.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

        }

        loadAreasComunes()
        loadAreasComunesOptions()
    }

    private fun loadAreasComunes()
    {
        val call = apiService.getAreasComunes()
        call.enqueue(object: Callback<ArrayList<AreaComun>>{
            override fun onFailure(call: Call<ArrayList<AreaComun>>, t: Throwable) {
               Toast.makeText(this@AreaComunActivity, getString(R.string.error_loading_areas), Toast.LENGTH_LONG).show()
                finish()
            }

            override fun onResponse(
                call: Call<ArrayList<AreaComun>>,
                response: Response<ArrayList<AreaComun>>
            ) {
              if(response.isSuccessful) // 200...300
              {
                  response.body()?.let {
                      val areas = it.toMutableList()
                      spinnerAreasComunes.adapter = ArrayAdapter<AreaComun>(this@AreaComunActivity, android.R.layout.simple_list_item_1, areas)
                  }
              }
              else
              {
                  Toast.makeText(this@AreaComunActivity, response.isSuccessful.toString(), Toast.LENGTH_SHORT).show()
              }
            }
        })
        // apiService.getAreasComunes()

    }

    private fun loadAreasComunesOptions()
    {
        spinnerAreasComunes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                adapter: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val option = adapter?.getItemAtPosition(position) as AreaComun


            }


        }
    }
}
