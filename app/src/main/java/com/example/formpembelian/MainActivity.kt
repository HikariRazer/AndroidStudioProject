package com.example.formpembelian

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNama = findViewById<EditText>(R.id.nama)
        val inputBuku = findViewById<EditText>(R.id.buku)
        val inputHarga = findViewById<EditText>(R.id.harga)
        val inputJumlah = findViewById<EditText>(R.id.jumlah)
        val inputBayar = findViewById<EditText>(R.id.bayar)
        val hasil = findViewById<TextView>(R.id.hasil)

        val submitButton = findViewById<Button>(R.id.proses)
        val resetButton = findViewById<Button>(R.id.reset)
        val exitButton = findViewById<Button>(R.id.exit)

        var harga :Double = (inputHarga.text.toString().toDoubleOrNull() ?: 0.0) as Double
        var jumlah :Double = (inputJumlah.text.toString().toDoubleOrNull() ?: 0.0) as Double
        var bayar :Double = (inputBayar.text.toString().toDoubleOrNull() ?: 0.0) as Double

        var total :Double = (jumlah * bayar)
        var kembalian :Double = (bayar - harga)


        fun bonus(harga: Double): String{
            if (harga > 500000)
                return "Bonus Keyboard"
            else if (harga > 300000 && harga <= 500000 )
                return "Bonus Mouse"
            else if (harga > 200000 && harga <= 300000 )
                return "Bonus flashdisk"
            else
                return "Tidak dapat bonus"
        }


        fun keterangan (bayar: Double, total : Double): String{
            if (bayar > total)
                return "Tunggu kembalian"
            else if (bayar == total)
                return "Uang sudah pas"
            else
                return "Kurang bayar sebesar RP. " + kembalian
        }


        submitButton.setOnClickListener {
            hasil.setText(
                "Total Belanja\t\t\t\t: RP." + total + "\n" +
                "Uang Kembalian\t\t\t\t: RP." + kembalian + "\n" +
                "Bonus\t\t\t\t\t\t\t\t: " + bonus(harga) + "\n" +
                "Keterangan\t\t\t\t\t\t: " + keterangan(bayar,total)
            )
        }

        resetButton.setOnClickListener {
            inputNama.setText("")
            inputBuku.setText("")
            inputHarga.setText("")
            inputJumlah.setText("")
            inputBayar.setText("")
            hasil.setText("")
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}