package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Partidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partidas)

        val intent = intent
        val email = intent.getStringExtra("email")!!

        val boton: Button = findViewById(R.id.button2)
        val boton2: Button = findViewById(R.id.button3)

        boton.setOnClickListener {
            val intent = Intent(this@Partidas, CrearPartidas::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
        boton2.setOnClickListener {
            val intent = Intent(this@Partidas, Menu::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}
