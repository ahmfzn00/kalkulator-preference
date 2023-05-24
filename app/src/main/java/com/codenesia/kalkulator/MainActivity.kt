package com.codenesia.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codenesia.kalkulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var numberData: NumberData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Inisialisasi Binding dan NumberData*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        numberData = NumberData(this)

        setContentView(binding.root)

        val data = numberData.getData()
        if (data != null) {
            binding.hasil.text = data
        }


        /* Menyembunyikan Action Bar */
        supportActionBar?.hide()

        binding.btnPlus.setOnClickListener { penjumlahan("+") }
        binding.btnMin.setOnClickListener { penjumlahan("-") }
        binding.btnBagi.setOnClickListener { penjumlahan("/") }
        binding.btnKali.setOnClickListener { penjumlahan("*") }


    }

    fun penjumlahan(type: String) {
        var number1 = binding.number1
        var number2 = binding.number2

        if (number1.text.isEmpty() == true || number2.text.isEmpty() == true) {
            number1.error = "Lengkapi Form"
            number2.error = "Lengkapi Form"
        } else {
            var angka1 = number1.text.toString()
            var angka2 = number2.text.toString()
            when(type) {
                "+" -> {
                    var hasil = (angka1.toDouble() + angka2.toDouble()).toString()
                    binding.hasil.text = hasil
                    numberData.setData(hasil)
                }
                "-" -> {
                    var hasil = angka1.toDouble() - angka2.toDouble()
                    binding.hasil.text = hasil.toString()
                    numberData.setData(hasil.toString())
                }
                "/" -> {
                    var hasil = angka1.toDouble() / angka2.toDouble()
                    binding.hasil.text = hasil.toString()
                    numberData.setData(hasil.toString())
                }
                "*" -> {
                    var hasil = angka1.toDouble() * angka2.toDouble()
                    binding.hasil.text = hasil.toString()
                    numberData.setData(hasil.toString())
                }
            }
        }
    }

}