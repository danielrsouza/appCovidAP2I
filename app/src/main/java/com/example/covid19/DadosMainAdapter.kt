package com.example.covid19

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class DadosMainAdapter(contexto: Context) : ArrayAdapter<DadosCovidMain>(contexto, 0){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v:View

        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.dados_covid_list, parent, false)
        }

        val item = getItem(position)

        val mortes = v.findViewById<TextView>(R.id.txMortes)
        val suspeitos = v.findViewById<TextView>(R.id.txSuspeitos)
        val data = v.findViewById<TextView>(R.id.txData)

        mortes.text = item?.mortes.toString()
        suspeitos.text = item?.suspeitos.toString()
        data.text = item?.data.toString()

        return v
    }


}