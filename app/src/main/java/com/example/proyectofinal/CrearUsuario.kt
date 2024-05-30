package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class CrearUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_usuario)

        val email: EditText = findViewById(R.id.editText)
        val pass: EditText = findViewById(R.id.editText3)
        val botonI: Button = findViewById(R.id.reg)
        val botonR: Button = findViewById(R.id.volver)

        val auth: FirebaseAuth = Firebase.auth

        botonI.setOnClickListener{
            if (email.text.isNotEmpty() && pass.text.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email.text.toString(), pass.text.toString()).addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this@CrearUsuario, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("Error")
                        builder.setMessage("Error al crear el usuario")
                        builder.setPositiveButton("Aceptar",null)
                        val dialog: AlertDialog = builder.create()
                        dialog.show()
                    }
                }
            } else{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("No puede dejar los campos en blanco")
                builder.setPositiveButton("Aceptar",null)
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
        botonR.setOnClickListener{
            val intent = Intent(this@CrearUsuario, MainActivity::class.java)
            startActivity(intent)
        }
    }
}