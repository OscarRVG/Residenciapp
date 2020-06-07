package com.example.residenciapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.residenciapp.PreferenceHelper
import com.example.residenciapp.PreferenceHelper.set
import com.example.residenciapp.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Area_comun.setOnClickListener {

            val intent = Intent(this, AreaComunActivity::class.java)
            startActivity(intent)
        }

        avisos.setOnClickListener {

            val intent = Intent(this, AvisosActivity::class.java)
            startActivity(intent)
        }

        mantenimiento.setOnClickListener {

            val intent = Intent(this, mantenimiento::class.java)
            startActivity(intent)
        }


        sugerencias.setOnClickListener {

            val intent = Intent(this, QuejasActivity::class.java)
            startActivity(intent)
        }

        emergencia.setOnClickListener {

            val intent = Intent(this, EmergenciaActivity::class.java)
            startActivity(intent)
        }

        visitas.setOnClickListener {

            val intent = Intent(this, VisitasActivity::class.java)
            startActivity(intent)
        }

      /*  btnLogout.setOnClickListener{
            clearSessionPreference()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }*/
    }

    private fun clearSessionPreference()
    {
        /*
        val preferences = getSharedPreferences("general", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean("session", false)
        editor.apply()
         */


        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = false

    }
}