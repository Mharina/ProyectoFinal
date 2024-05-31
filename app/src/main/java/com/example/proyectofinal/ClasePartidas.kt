//package com.example.proyectofinal
//
//import android.os.Parcel
//import android.os.Parcelable
//
//data class ClasePartidas(
//    var nombre: String,
//    var jugadores: ArrayList<String> = ArrayList(4),
//    var descripcion: String,
//    var estado: String,
//    var img: String
//): Parcelable {
//    var tamJ: Int = 1
//
//    constructor(parcel: Parcel) : this(
//        parcel.readString().toString(),
//        arrayListOf<String>().apply {
//            parcel.readStringList(this)
//        },
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString()
//    ) {
//        tamJ = parcel.readInt()
//    }
//
//    init {
//        calcularTamJ()
//    }
//
//    fun calcularTamJ(){
//        this.tamJ=jugadores.size
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(nombre)
//        parcel.writeStringList(jugadores)
//        parcel.writeString(descripcion)
//        parcel.writeString(estado)
//        parcel.writeString(img)
//        parcel.writeInt(tamJ)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<ClasePartidas> {
//        override fun createFromParcel(parcel: Parcel): ClasePartidas {
//            return ClasePartidas(parcel)
//        }
//
//        override fun newArray(size: Int): Array<ClasePartidas?> {
//            return arrayOfNulls(size)
//        }
//    }
//}

package com.example.proyectofinal

data class ClasePartidas(
    var descripcion: String = "",
    var estado: String = "",
    var img: String = "",
    var jugadores: ArrayList<String> = ArrayList(3),
    var nombre: String = "",
    var master: String=""
)