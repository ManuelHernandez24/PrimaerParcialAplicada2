package com.aplicada2.tareai.data.database.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "prestamos")
data class Prestamo (
    @PrimaryKey(autoGenerate = true)
    val PrestamoId: Int,
    val Deudor: String,
    val Concepto: String,
    val Monto: Double

):Parcelable