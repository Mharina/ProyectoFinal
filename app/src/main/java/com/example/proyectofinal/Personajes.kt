package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Personajes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personajes)

        val intent = intent
        val email = intent.getStringExtra("email")!!

        val crear: Button = findViewById(R.id.button)

        crear.setOnClickListener{
            val intent = Intent(this@Personajes, CrearPj::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}