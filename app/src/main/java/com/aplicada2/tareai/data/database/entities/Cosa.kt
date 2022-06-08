package com.aplicada2.tareai.data.database.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tabla_cosa")
data class Cosa (
    @PrimaryKey(autoGenerate = true)
    val CosaId: Int

):Parcelable