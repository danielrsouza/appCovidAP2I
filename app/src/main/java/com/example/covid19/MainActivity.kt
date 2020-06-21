package com.example.covid19

import android.content.Context
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.io.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter


val listaDadosCovidMain = mutableListOf<DadosCovidMain>()
val dadosMain = ArrayList<DadosCovidMain>()



class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    readJson(this)

    val dadosMainAdapter = DadosMainAdapter(this)
    dadosMainAdapter.addAll(dadosMain)

    lista_view.adapter = dadosMainAdapter


  dadosBoletimCompleto()



  }

  fun dadosBoletimCompleto()
  {
    lista_view.setOnItemClickListener { parent, view, position, id ->

      val intent = Intent(this, Dados::class.java)
      intent.putExtra("suspeitos", dadosMain[position].suspeitos)
      intent.putExtra("confirmados", dadosMain[position].confirmados)
      intent.putExtra("descartados", dadosMain[position].descartados)
      intent.putExtra("monitoramento", dadosMain[position].monitoramento)
      intent.putExtra("curados", dadosMain[position].curados)
      intent.putExtra("sdomiciliar", dadosMain[position].sdomiciliar)
      intent.putExtra("shospitalar", dadosMain[position].shospitalar)
      intent.putExtra("chospitalar", dadosMain[position].chospitalar)
      startActivity(intent)

    }
  }


  fun readJson(context: Context){
    var json: String?=null
    val listaBoletins = mutableListOf<Boletim>()
    try {
      val inputStream: InputStream= context.assets.open("data.json")
      json = inputStream.bufferedReader().use { it.readText() }
     // txtValue.text=json.toString()
      var jsonArray =JSONArray(json)
      for (i in 0 .. jsonArray.length()-1){
        var js = jsonArray.getJSONObject(i)
        val dia = formatarData(js.getString("boletim").substring(0,10))
        val suspeitos = js.getInt("Suspeitos")
        val mortes= js.getInt("mortes")
        val confirmados = js.getInt("Confirmados")
        val descartados = js.getInt("Descartados")
        val monitoramento = js.getInt("Monitoramento")
        val curados = js.getInt("Curados")
        val sdomiciliar = js.getInt("Sdomiciliar")
        val shospitalar = js.getInt("Shopitalar")
        val chospitalar = js.getInt("Chospitalar")

        val dados = DadosCovidMain(mortes, suspeitos, dia, confirmados, descartados, monitoramento, curados, sdomiciliar, shospitalar, chospitalar)
        listaDadosCovidMain.add(dados)

        Log.e("TAGE", listaDadosCovidMain.toString())


      }
      dadosMain.addAll(listaDadosCovidMain)
      Log.e("DADOS MAIN", dadosMain.toString())
    }
    catch (e : IOException){
    Log.e("Erro", "Impossivel ler JSON")
    }

  }
  fun formatarData(data: String): String {
    val diaString =data
    var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var date = LocalDate.parse(diaString)
    var formattedDate = date.format(formatter)
    return formattedDate
  }

}

private fun Parcelable.putExtra(s: String, dadosCovidMain: DadosCovidMain) {

}

private fun Intent.putParcelableArrayListExtra(s: String, dadosCovidMain: DadosCovidMain) {

}
