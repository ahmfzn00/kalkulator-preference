package com.codenesia.kalkulator

import android.content.Context

class NumberData(context: Context) {

    /* membuat superclass */
    companion object {
        private val PREF_NAME = "database_number" //nama database
        private val hasil = "hasil" //nama column hasil
    }

    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    /* function setData digunakan untuk menyimpan data */
    fun setData(jumlah: String) {
        val numberAdd = preferences.edit()
        numberAdd.putString(hasil, jumlah)
        numberAdd.apply()
    }

    /* function getData digunakan untuk mengambil data */
    fun getData(): String {
        val data = preferences.getString(hasil, "")
        return data!!
    }

}