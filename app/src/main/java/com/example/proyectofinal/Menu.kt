package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

//class Menu : AppCompatActivity() {
//    private lateinit var rV: RecyclerView
//    private lateinit var tvPartidas: TextView
//    private lateinit var partidaList: ArrayList<ClasePartidas>
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_menu)
//
//        val intent = intent
//        val email = intent.getStringExtra("email")!!
//
//        val perf: ImageButton = findViewById(R.id.imageButton7)
//        val part: ImageButton = findViewById(R.id.imageButton4)
//        val pj: ImageButton = findViewById(R.id.imageButton5)
//
//        rV = findViewById(R.id.rvPartidas)
//        rV.layoutManager = LinearLayoutManager(this)
//        rV.setHasFixedSize(true)
//        tvPartidas = findViewById(R.id.tvPartidas)
//
//        partidaList= arrayListOf<ClasePartidas>()
//
//        getPartidas()
//
//
//        pj.setOnClickListener {
//            val intent = Intent(this@Menu, Personajes::class.java)
//            intent.putExtra("email", email)
//            startActivity(intent)
//        }
//
//        part.setOnClickListener {
//            val intent = Intent(this@Menu, Partidas::class.java)
//            intent.putExtra("email", email)
//            startActivity(intent)
//        }
//
//        perf.setOnClickListener {
//            val intent = Intent(this@Menu, Menu::class.java)
//            intent.putExtra("email", email)
//            startActivity(intent)
//        }
//    }
//    private fun getPartidas() {
//
//        rV.visibility = View.GONE
//        tvPartidas.visibility = View.VISIBLE
//
//        val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("Partidas")
//
//        db.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                partidaList.clear()
//                if (snapshot.exists()){
//                    for (empSnap in snapshot.children){
//                        val empData = empSnap.getValue(ClasePartidas::class.java)
//                        partidaList.add(empData!!)
//                    }
//                    val mAdapter = PartidasAdapter(partidaList)
//                    rV.adapter = mAdapter
//
//                    mAdapter.setOnItemClickListener(object : PartidasAdapter.onItemClickListener{
//                        override fun onItemClick(position: Int) {
//
//                            val intent = Intent(this@Menu, Jugar::class.java)
//
//                            //put extras
//                            intent.putExtra("nombre", partidaList[position].nombre)
//                            intent.putExtra("estado", partidaList[position].estado)
//                            intent.putExtra("descripcion", partidaList[position].descripcion)
//                            intent.putExtra("jugadores", partidaList[position].jugadores)
//                            intent.putExtra("imagen", partidaList[position].img)
//                            intent.putExtra("tam", partidaList[position].tamJ)
//                            startActivity(intent)
//                        }
//
//                    })
//
//                    rV.visibility = View.VISIBLE
//                    tvPartidas.visibility = View.GONE
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }
//}

class Menu : AppCompatActivity() {
    private lateinit var rV: RecyclerView
    private lateinit var tvPartidas: TextView
    private lateinit var partidaList: ArrayList<ClasePartidas>
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val intent = intent
        val email = intent.getStringExtra("email")!!

        val perf: ImageButton = findViewById(R.id.imageButton7)
        val part: ImageButton = findViewById(R.id.imageButton4)
        val pj: ImageButton = findViewById(R.id.imageButton5)

        rV = findViewById(R.id.rvPartidas)
        rV.layoutManager = LinearLayoutManager(this)
        rV.setHasFixedSize(true)
        tvPartidas = findViewById(R.id.tvPartidas)

        partidaList = arrayListOf<ClasePartidas>()

        getPartidas()


        pj.setOnClickListener {
            val intent = Intent(this@Menu, Personajes::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        part.setOnClickListener {
            val intent = Intent(this@Menu, Partidas::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        perf.setOnClickListener {
            val intent = Intent(this@Menu, Menu::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }

    private fun getPartidas() {
        rV.visibility = View.GONE
        tvPartidas.visibility = View.VISIBLE

        db = FirebaseDatabase.getInstance().getReference("Partidas")

        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                partidaList.clear()
                if (snapshot.exists()) {
                    for (snap in snapshot.children) {
                        val data = snap.getValue(ClasePartidas::class.java)
                        partidaList.add(data!!)
                    }
                    val adapterP = PartidasAdapter(partidaList)
                    rV.adapter = adapterP

                    rV.visibility = View.VISIBLE
                    tvPartidas.visibility = View.GONE
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}