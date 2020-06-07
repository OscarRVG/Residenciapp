package com.example.residenciapp.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
//import androidx.preference.PreferenceManager
import android.widget.Toast
import com.example.residenciapp.PreferenceHelper
import com.example.residenciapp.R
import kotlinx.android.synthetic.main.activity_main.*
import com.example.residenciapp.PreferenceHelper.get
import com.example.residenciapp.PreferenceHelper.set

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SP
        /*
        val preferences = getSharedPreferences("general", Context.MODE_PRIVATE)
        val session = preferences.getBoolean("session", false)
        */

        val preferences = PreferenceHelper.defaultPrefs(this)
        if(preferences["session", false]!!)
            goToMenuActivity()

        Entrar.setOnClickListener {
            //Validando usuario...
            createSessionPreference()
            goToMenuActivity()
        }

        TvGoToRegister.setOnClickListener {
            Toast.makeText(this, "Registro", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        /*val= variable que no puede cambiar, es una constante
        * intent clase de java para hacer un evento se necesitan los otros dos parametros
        * staractivity recibe un intent al presionarlo
        * */
    }

    private fun createSessionPreference()
    {
        //PreferenceManager.getDefaultSharedPreferences()
        /*
        val preferences = getSharedPreferences("general", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean("session", true)
        editor.apply()
         */
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
    }

    private fun goToMenuActivity()
    {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }
}
