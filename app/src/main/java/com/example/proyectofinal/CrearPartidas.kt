package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import com.example.proyectofinal.ClasePartidas
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CrearPartidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_partidas)

        val intent = intent
        val email = intent.getStringExtra("email")!!

        val db : DatabaseReference = FirebaseDatabase.getInstance().getReference("Partidas")

        var array: ArrayList<String> = ArrayList(4)

        val nombre: EditText = findViewById(R.id.editTextText48)
        val jugador: EditText = findViewById(R.id.editTextText49)
        val descripcion: EditText = findViewById(R.id.editTextText50)
        val est: Spinner = findViewById(R.id.spinner)
        val img: ImageView = findViewById(R.id.imageView)
        val selecImg: Button = findViewById(R.id.button10)

        val crear: Button = findViewById(R.id.button7)
        val cancelar: Button = findViewById(R.id.button8)
        val anadir: Button = findViewById(R.id.button9)

        array.add(email)

        cancelar.setOnClickListener {
            val intent = Intent(this@CrearPartidas, Partidas::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
        anadir.setOnClickListener {
            if (array.size<4){
                array.add(jugador.text.toString())
                jugador.text.clear()
            }else{
                jugador.text.clear()
                jugador.setError("No caben más jugadores")
            }
        }

        crear.setOnClickListener {
            if (nombre.text.isBlank()) {
                nombre.setError("El campo nombre es necesario")
            }
            if (descripcion.text.isBlank()) {
                descripcion.setError("El campo descripcion es necesario")
            }
            val part = ClasePartidas(
                nombre.text.toString(),
                array,
                descripcion.text.toString(),
                est.selectedItem as String,
                img.toString()
            )
            val id = db.push().key!!

            db.child(id).push().setValue(part)
                .addOnCompleteListener{
                    Toast.makeText(this,"Partida Creada", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@CrearPartidas, Partidas::class.java)
                    intent.putExtra("email", email)
                    startActivity(intent)

                }.addOnFailureListener{ err->
                    Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
                }
        }
    }
}