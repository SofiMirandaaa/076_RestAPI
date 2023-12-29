package com.example.consumeapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kontak(
    val id: Int,
    val name: String,
    val alamat: String,
    @SerialName(value = "telpon")
    val nohp: String,
)
