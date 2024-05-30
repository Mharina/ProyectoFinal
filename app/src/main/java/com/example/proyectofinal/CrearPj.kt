package com.example.proyectofinal

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CrearPj : AppCompatActivity() {

    private val PICK_IMAGE = 100
    private val READ_EXTERNAL_STORAGE_PERMISSION = 1
    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_pj)

        val intent = intent
        val email = intent.getStringExtra("email")!!
        img = findViewById(R.id.imageView2)

        val nombre: EditText = findViewById(R.id.editTextText)
        val concepto: EditText = findViewById(R.id.editTextText2)
        val culto: EditText = findViewById(R.id.editTextText3)
        val cita: EditText = findViewById(R.id.editTextText4)
        val fortaleza: EditText = findViewById(R.id.editTextText5)
        val reflejos: EditText = findViewById(R.id.editTextText6)
        val voluntad: EditText = findViewById(R.id.editTextText7)
        val inteligencia: EditText = findViewById(R.id.editTextText8)
        val fisica: EditText = findViewById(R.id.editTextText9)
        val combate: EditText = findViewById(R.id.editTextText10)
        val subterfugio: EditText = findViewById(R.id.editTextText11)
        val interactuacion: EditText = findViewById(R.id.editTextText12)
        val cultura: EditText = findViewById(R.id.editTextText13)
        val profesion: EditText = findViewById(R.id.editTextText14)
        val ocultismo: EditText = findViewById(R.id.editTextText15)
        val arcano1: EditText = findViewById(R.id.editTextText16)
        val arcano2: EditText = findViewById(R.id.editTextText17)
        val arcano3: EditText = findViewById(R.id.editTextText18)
        val fortalezaN: EditText = findViewById(R.id.editTextText19)
        val reflejosN: EditText = findViewById(R.id.editTextText20)
        val voluntadN: EditText = findViewById(R.id.editTextText21)
        val inteligenciaN: EditText = findViewById(R.id.editTextText22)
        val fisicaN: EditText = findViewById(R.id.editTextText23)
        val combateN: EditText = findViewById(R.id.editTextText24)
        val subterfugioN: EditText = findViewById(R.id.editTextText25)
        val interactuacionN: EditText = findViewById(R.id.editTextText26)
        val culturaN: EditText = findViewById(R.id.editTextText27)
        val profesionN: EditText = findViewById(R.id.editTextText28)
        val ocultismoN: EditText = findViewById(R.id.editTextText29)
        val arcano1N: EditText = findViewById(R.id.editTextText30)
        val arcano2N: EditText = findViewById(R.id.editTextText31)
        val arcano3N: EditText = findViewById(R.id.editTextText32)
        val hitos: EditText = findViewById(R.id.editTextText33)
        val complicacion: EditText = findViewById(R.id.editTextText34)
        val dano: EditText = findViewById(R.id.editTextText35)
        val danoD: EditText = findViewById(R.id.editTextText36)
        val arma1: EditText = findViewById(R.id.editTextText37)
        val arma2: EditText = findViewById(R.id.editTextText38)
        val arma3: EditText = findViewById(R.id.editTextText39)
        val da1: EditText = findViewById(R.id.editTextText40)
        val da2: EditText = findViewById(R.id.editTextText41)
        val da3: EditText = findViewById(R.id.editTextText42)
        val secuelas: EditText = findViewById(R.id.editTextText43)
        val degeneracion: EditText = findViewById(R.id.editTextText44)
        val degeneracionN: EditText = findViewById(R.id.editTextText45)
        val drama: EditText = findViewById(R.id.editTextText46)
        val transfondo: EditText = findViewById(R.id.editTextText47)
        val img: ImageView = findViewById(R.id.imageView2)
        val selecImg: Button = findViewById(R.id.button6)

        val crear: Button = findViewById(R.id.button5)
        val cancelar: Button = findViewById(R.id.button4)

        val usuarioActual: FirebaseUser = FirebaseAuth.getInstance().currentUser!!

        val db : DatabaseReference = FirebaseDatabase.getInstance().getReference(usuarioActual.uid)

        selecImg.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    READ_EXTERNAL_STORAGE_PERMISSION)
            } else {
                openGallery()
            }
        }
        cancelar.setOnClickListener {
            val intent = Intent(this@CrearPj, Personajes::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
        crear.setOnClickListener {
            if (nombre.text.isBlank()) {
                nombre.setError("El campo nombre es necesario")
            }
            if (concepto.text.isBlank()) {
                concepto.setError("El campo concepto es necesario")
            }
            if (culto.text.isBlank()) {
                culto.setError("El campo culto es necesario")
            }
            if (cita.text.isBlank()) {
                cita.setError("El campo cita es necesario")
            }
            if (fortaleza.text.isBlank()) {
                fortaleza.setError("El campo fortaleza es necesario")
            }
            if (reflejos.text.isBlank()) {
                reflejos.setError("El campo reflejos es necesario")
            }
            if (voluntad.text.isBlank()) {
                voluntad.setError("El campo voluntad es necesario")
            }
            if (inteligencia.text.isBlank()) {
                inteligencia.setError("El campo inteligencia es necesario")
            }
            if (fisica.text.isBlank()) {
                fisica.setError("El campo fisica es necesario")
            }
            if (combate.text.isBlank()) {
                combate.setError("El campo combate es necesario")
            }
            if (subterfugio.text.isBlank()) {
                subterfugio.setError("El campo subterfugio es necesario")
            }
            if (interactuacion.text.isBlank()) {
                interactuacion.setError("El campo interactuación es necesario")
            }
            if (cultura.text.isBlank()) {
                cultura.setError("El campo cultura es necesario")
            }
            if (profesion.text.isBlank()) {
                profesion.setError("El campo profesion es necesario")
            }
            if (ocultismo.text.isBlank()) {
                ocultismo.setError("El campo ocultismo es necesario")
            }
            if (arcano1.text.isBlank()) {
                arcano1.setError("El campo arcano1 es necesario")
            }
            if (arcano2.text.isBlank()) {
                arcano2.setError("El campo arcano2 es necesario")
            }
            if (arcano3.text.isBlank()) {
                arcano3.setError("El campo arcano3 es necesario")
            }
            if (fortalezaN.text.isBlank()) {
                fortalezaN.setError("El campo fortalezaN es necesario")
            }
            if (reflejosN.text.isBlank()) {
                reflejosN.setError("El campo reflejosN es necesario")
            }
            if (voluntadN.text.isBlank()) {
                voluntadN.setError("El campo voluntadN es necesario")
            }
            if (inteligenciaN.text.isBlank()) {
                inteligenciaN.setError("El campo inteligenciaN es necesario")
            }
            if (fisicaN.text.isBlank()) {
                fisicaN.setError("El campo fisicaN es necesario")
            }
            if (combateN.text.isBlank()) {
                combateN.setError("El campo combateN es necesario")
            }
            if (subterfugioN.text.isBlank()) {
                subterfugioN.setError("El campo subterfugioN es necesario")
            }
            if (interactuacionN.text.isBlank()) {
                interactuacionN.setError("El campo interactuacionN es necesario")
            }
            if (culturaN.text.isBlank()) {
                culturaN.setError("El campo culturaN es necesario")
            }
            if (profesionN.text.isBlank()) {
                profesionN.setError("El campo profesionN es necesario")
            }
            if (ocultismoN.text.isBlank()) {
                ocultismoN.setError("El campo ocultismoN es necesario")
            }
            if (arcano1N.text.isBlank()) {
                arcano1N.setError("El campo arcano1N es necesario")
            }
            if (arcano2N.text.isBlank()) {
                arcano2N.setError("El campo arcano2N es necesario")
            }
            if (arcano3N.text.isBlank()) {
                arcano3N.setError("El campo arcano3N es necesario")
            }
            if (hitos.text.isBlank()) {
                hitos.setError("El campo hitos es necesario")
            }
            if (complicacion.text.isBlank()) {
                complicacion.setError("El campo complicacion es necesario")
            }
            if (dano.text.isBlank()) {
                dano.setError("El campo daño es necesario")
            }
            if (danoD.text.isBlank()) {
                danoD.setError("El campo dañoD es necesario")
            }
            if (arma1.text.isBlank()) {
                arma1.setError("El campo arma1 es necesario")
            }
            if (arma2.text.isBlank()) {
                arma2.setError("El campo arma2 es necesario")
            }
            if (arma3.text.isBlank()) {
                arma3.setError("El campo arma3 es necesario")
            }
            if (da1.text.isBlank()) {
                da1.setError("El campo da1 es necesario")
            }
            if (da2.text.isBlank()) {
                da2.setError("El campo da2 es necesario")
            }
            if (da3.text.isBlank()) {
                da3.setError("El campo da3 es necesario")
            }
            if (secuelas.text.isBlank()) {
                secuelas.setError("El campo secuelas es necesario")
            }
            if (degeneracion.text.isBlank()) {
                degeneracion.setError("El campo degeneracion es necesario")
            }
            if (degeneracionN.text.isBlank()) {
                degeneracionN.setError("El campo degeneracionN es necesario")
            }
            if (drama.text.isBlank()) {
                drama.setError("El campo drama es necesario")
            }
            if (transfondo.text.isBlank()) {
                transfondo.setError("El campo transfondo es necesario")
            }
            val id = db.push().key!!

            val personaje = ClasePersonajes(
                nombre.text.toString(),
                concepto.text.toString(),
                culto.text.toString(),
                cita.text.toString(),
                fortaleza.text.toString(),
                reflejos.text.toString(),
                voluntad.text.toString(),
                inteligencia.text.toString(),
                fisica.text.toString(),
                combate.text.toString(),
                subterfugio.text.toString(),
                interactuacion.text.toString(),
                cultura.text.toString(),
                profesion.text.toString(),
                ocultismo.text.toString(),
                arcano1.text.toString(),
                arcano2.text.toString(),
                arcano3.text.toString(),
                fortalezaN.text.toString().toInt(),
                reflejosN.text.toString().toInt(),
                voluntadN.text.toString().toInt(),
                inteligenciaN.text.toString().toInt(),
                fisicaN.text.toString().toInt(),
                combateN.text.toString().toInt(),
                subterfugioN.text.toString().toInt(),
                interactuacionN.text.toString().toInt(),
                culturaN.text.toString().toInt(),
                profesionN.text.toString().toInt(),
                ocultismoN.text.toString().toInt(),
                arcano1N.text.toString().toInt(),
                arcano2N.text.toString().toInt(),
                arcano3N.text.toString().toInt(),
                hitos.text.toString(),
                complicacion.text.toString(),
                dano.text.toString().toInt(),
                danoD.text.toString().toInt(),
                arma1.text.toString(),
                arma2.text.toString(),
                arma3.text.toString(),
                da1.text.toString().toInt(),
                da2.text.toString().toInt(),
                da3.text.toString().toInt(),
                secuelas.text.toString(),
                degeneracion.text.toString(),
                degeneracionN.text.toString().toInt(),
                drama.text.toString().toInt(),
                transfondo.text.toString(),
                img.toString()
            )

            db.child(id).push().setValue(personaje)
                .addOnCompleteListener{
                    Toast.makeText(this,"Personaje guardado", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@CrearPj, Personajes::class.java)
                    intent.putExtra("email", email)
                    startActivity(intent)
                }.addOnFailureListener{ err->
                    Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
                }
        }
    }
    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE) {
            val imageUri: Uri? = data?.data
            img.setImageURI(imageUri)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == READ_EXTERNAL_STORAGE_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery()
            }
        }
    }
}