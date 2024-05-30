package com.example.proyectofinal

import android.os.Parcel
import android.os.Parcelable

data class ClasePersonajes(
    var nombre: String,
    var concepto: String,
    var culto:String,
    var cita:String,
    var fortaleza:String,
    var reflejos:String,
    var voluntad:String,
    var inteligencia:String,
    var fisica:String,
    var combate:String,
    var subterfugio:String,
    var interactuación:String,
    var cultura:String,
    var profesion:String,
    var ocultismo:String,
    var arcano1:String,
    var arcano2:String,
    var arcano3:String,
    var fortalezaN:Int,
    var reflejosN:Int,
    var voluntadN:Int,
    var inteligenciaN:Int,
    var fisicaN:Int,
    var combateN:Int,
    var subterfugioN:Int,
    var interactuacionN:Int,
    var culturaN:Int,
    var profesionN:Int,
    var ocultismoN:Int,
    var arcano1N:Int,
    var arcano2N:Int,
    var arcano3N:Int,
    var hitos: String,
    var complicacion: String,
    var dano: Int,
    var danoD: Int,
    var arma1: String,
    var arma2:String,
    var arma3: String,
    var da1: Int,
    var da2: Int,
    var da3: Int,
    var secuelas: String,
    var degeneracion: String,
    var degeneracionN: Int,
    var drama: Int,
    var transfondo: String,
    var imagen: String
): Parcelable {
    var iniciativa: Int = 0
    var defensa: Int = 0
    var defensaD: Int = 0
    var aguante: Int  = 0
    var resistencia: Int = 0
    var restado: String = ""
    var entereza: Int = 0
    var mental: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
    ) {
        iniciativa = parcel.readInt()
        defensa = parcel.readInt()
        aguante = parcel.readInt()
        restado = parcel.readString().toString()
        entereza = parcel.readInt()
        defensa = parcel.readInt()
        defensaD = parcel.readInt()
        aguante = parcel.readInt()
        resistencia = parcel.readInt()
        entereza = parcel.readInt()
        mental = parcel.readInt()
    }

    init {
        calcularDefensas()
        calcularIniciativa()
        calcularAguante()
        calcularResistencia()
        calcularEntereza()
        calcularMental()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(concepto)
        parcel.writeString(culto)
        parcel.writeString(cita)
        parcel.writeString(fortaleza)
        parcel.writeString(reflejos)
        parcel.writeString(voluntad)
        parcel.writeString(inteligencia)
        parcel.writeString(fisica)
        parcel.writeString(combate)
        parcel.writeString(subterfugio)
        parcel.writeString(interactuación)
        parcel.writeString(cultura)
        parcel.writeString(profesion)
        parcel.writeString(ocultismo)
        parcel.writeString(arcano1)
        parcel.writeString(arcano2)
        parcel.writeString(arcano3)
        parcel.writeInt(fortalezaN)
        parcel.writeInt(reflejosN)
        parcel.writeInt(voluntadN)
        parcel.writeInt(inteligenciaN)
        parcel.writeInt(fisicaN)
        parcel.writeInt(combateN)
        parcel.writeInt(subterfugioN)
        parcel.writeInt(interactuacionN)
        parcel.writeInt(culturaN)
        parcel.writeInt(profesionN)
        parcel.writeInt(ocultismoN)
        parcel.writeInt(arcano1N)
        parcel.writeInt(arcano2N)
        parcel.writeInt(arcano3N)
        parcel.writeString(hitos)
        parcel.writeString(complicacion)
        parcel.writeInt(dano)
        parcel.writeInt(danoD)
        parcel.writeString(arma1)
        parcel.writeString(arma2)
        parcel.writeString(arma3)
        parcel.writeInt(da1)
        parcel.writeInt(da2)
        parcel.writeInt(da3)
        parcel.writeString(secuelas)
        parcel.writeString(degeneracion)
        parcel.writeInt(degeneracionN)
        parcel.writeInt(drama)
        parcel.writeString(transfondo)
        parcel.writeString(imagen)
        parcel.writeInt(iniciativa)
        parcel.writeInt(defensa)
        parcel.writeInt(aguante)
        parcel.writeString(restado)
        parcel.writeInt(entereza)
    }

    fun calcularDefensas(){
        if(fisicaN>combateN){
            defensa = reflejosN + fisicaN + 5
        }else{
            defensa = reflejosN + combateN + 5
        }
        defensaD = defensa - 3
    }

    fun calcularIniciativa(){
        iniciativa = reflejosN + (inteligenciaN/2)
    }

    fun calcularAguante(){
        aguante = fortalezaN + (voluntadN/2)
    }

    fun calcularResistencia(){
        resistencia = aguante * 3
    }

    fun calcularEntereza(){
        entereza = voluntadN + inteligenciaN
    }

    fun calcularMental(){
        mental = entereza * 3
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ClasePersonajes> {
        override fun createFromParcel(parcel: Parcel): ClasePersonajes {
            return ClasePersonajes(parcel)
        }

        override fun newArray(size: Int): Array<ClasePersonajes?> {
            return arrayOfNulls(size)
        }
    }
}