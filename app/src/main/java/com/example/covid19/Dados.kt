package com.example.covid19

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.dados_completos.*

class Dados :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dados_completos)

        val suspeitos = intent.getIntExtra("suspeitos", 0)
        val confirmados = intent.getIntExtra("confirmados", 0)
        val descartados = intent.getIntExtra("descartados", 0)
        val monitoramento = intent.getIntExtra("monitoramento", 0)
        val curados = intent.getIntExtra("curados", 0)
        val sdomiciliar = intent.getIntExtra("sdomiciliar", 0)
        val shopitalar = intent.getIntExtra("shospitalar", 0)
        val chospitalar = intent.getIntExtra("chospitalar", 0)
        val mortes = intent.getIntExtra("mortes", 0)

        text_casos_suspeitos.text = suspeitos.toString()
        text_casos_confirmados.text = confirmados.toString()
        text_descartados.text = descartados.toString()
        text_monitoramento.text = monitoramento.toString()
        text_curados.text = curados.toString()
        text_isolamento_domiciliar.text = sdomiciliar.toString()
        text_tratamento_hospitalar.text = shopitalar.toString()
        text_em_tratamento_hospitalar_confirmados.text = chospitalar.toString()




    }
}

