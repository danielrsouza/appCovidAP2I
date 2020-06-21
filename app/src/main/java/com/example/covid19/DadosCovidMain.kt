package com.example.covid19

data class DadosCovidMain(
    val mortes: Int,
    val suspeitos: Int,
    val data: String,
    val confirmados: Int,
    val descartados: Int,
    val monitoramento: Int,
    val curados: Int,
    val sdomiciliar: Int,
    val shospitalar: Int,
    val chospitalar: Int
)