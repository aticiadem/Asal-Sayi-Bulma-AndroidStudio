package com.example.adematici.kotlinprojexdxddxd.asalsayibulma

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    //Asal sayıyı hesaplayan ve gerekli işlemleri yapan fonksiyon
    fun AsalSayiBul(View: View){
        KlavyeGizle()
        var girilenSayi = Integer.valueOf(editTextSayi.text.toString())
        var adet = 0
        if(girilenSayi<2){
            Toast.makeText(this@MainActivity,"ASAL SAYILAR 2'DEN BAŞLAR.",Toast.LENGTH_LONG).show()
        }
        else{
            for(i in 2..girilenSayi){
                if(girilenSayi%i == 0){
                    adet++
                }
            }
        }
        if(adet == 1){
            textViewSonuc.setText("$girilenSayi Asalır.")
        }
        else{
            textViewSonuc.setText("$girilenSayi Asal Değil.")
        }
    }
    // Butona bastığımızda klavyenin kapanması için gerekli kod
    fun KlavyeGizle(){
        val view = this.currentFocus
        if (view != null) {
            val inputManager: InputMethodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

}