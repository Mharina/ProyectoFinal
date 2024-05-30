package com.example.proyectofinal

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class PartidasAdapter(private val partidaList: ArrayList<ClasePartidas>) : RecyclerView.Adapter<PartidasAdapter.ViewHolder>(){
//
//    private lateinit var Listener: onItemClickListener
//
//    interface onItemClickListener{
//        fun onItemClick(position: Int)
//    }
//
//    fun setOnItemClickListener(clickListener: onItemClickListener){
//        Listener = clickListener
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.partidas_list_item, parent, false)
//        return ViewHolder(itemView, Listener)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val currentPartida = partidaList[position]
//        holder.tvPartidaName.text = currentPartida.nombre
////        holder.tvPartidaEstado.text = currentPartida.estado
////        holder.tvPartidaDescipcion.text = currentPartida.descripcion
////        holder.tvPartidaTam.text = currentPartida.tamJ.toString()
//    }
//
//    override fun getItemCount(): Int {
//        return partidaList.size
//    }
//
//    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
//        val tvPartidaName : TextView = itemView.findViewById(R.id.tvPartidaName)
////        val tvPartidaEstado : TextView = itemView.findViewById(R.id.tvPartidaEstado)
////        val tvPartidaTam : TextView = itemView.findViewById(R.id.tvPartidaTam)
////        val tvPartidaDescipcion : TextView = itemView.findViewById(R.id.tvPartidaDescripcion)
//
//        init {
//            itemView.setOnClickListener {
//                clickListener.onItemClick(adapterPosition)
//            }
//        }
//    }
//}
class PartidasAdapter(private val partidaList: ArrayList<ClasePartidas>) : RecyclerView.Adapter<PartidasAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.partidas_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val currentPartida = partidaList[position]
        Log.d("partida", partidaList.toString())
        holder.tvPartidaName.text = currentPartida.nombre
//        holder.tvPartidaEstado.text = currentPartida.estado
//        holder.tvPartidaTam.text = currentPartida.tamJ.toString()
//        holder.tvPartidaDescripcion.text = currentPartida.descripcion
    }

    override fun getItemCount(): Int {
        return partidaList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvPartidaName : TextView = itemView.findViewById(R.id.tvPartidaName)
//        val tvPartidaEstado : TextView = itemView.findViewById(R.id.tvPartidaEstado)
//        val tvPartidaTam : TextView = itemView.findViewById(R.id.tvPartidaTam)
//        val tvPartidaDescripcion : TextView = itemView.findViewById(R.id.tvPartidaDescripcion)

    }

}