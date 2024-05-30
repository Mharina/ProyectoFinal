package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonI: Button = findViewById(R.id.iniciar)
        val botonR: Button = findViewById(R.id.regis)
        val email: EditText = findViewById(R.id.usuario)
        val pass: EditText = findViewById(R.id.password)

        val auth: FirebaseAuth = Firebase.auth

        botonI.setOnClickListener{
            if (email.text.isNotEmpty() && pass.text.isNotEmpty()){
                auth.signInWithEmailAndPassword(email.text.toString(), pass.text.toString()).addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this@MainActivity, Menu::class.java)
                        intent.putExtra("email", email.text.toString())
                        startActivity(intent)

                    } else {
//                        val builder = AlertDialog.Builder(this)
//                        builder.setTitle("Error")
//                        builder.setMessage("Se ha producido un error en la autenticacion del ususario")
//                        builder.setPositiveButton("Aceptar",null)
//                        val dialog: AlertDialog = builder.create()
//                        dialog.show()
                        Toast.makeText(this, "Error en el login", Toast.LENGTH_SHORT).show()
                    }
                }
            } else{
//                val builder = AlertDialog.Builder(this)
//                builder.setTitle("Error")
//                builder.setMessage("No puede dejar los campos en blanco")
//                builder.setPositiveButton("Aceptar",null)
//                val dialog: AlertDialog = builder.create()
//                dialog.show()
                Toast.makeText(this, "No puedes dejar los campos en blanco", Toast.LENGTH_SHORT).show()
            }
        }
        botonR.setOnClickListener{
            val intent = Intent(this@MainActivity, CrearUsuario::class.java)
            startActivity(intent)
        }

    }
}