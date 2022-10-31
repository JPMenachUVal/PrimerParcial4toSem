package com.example.menachoprimerparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.menachoprimerparcial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegistro.setOnClickListener{
            validarDatos()
        }
    }

    private fun validarDatos() {
        if(binding.etNProducto.text.isBlank() || binding.etPrecio.text.isBlank()) {
            Toast.makeText(this, "Falta completar información", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            pasarPantalla()
        }
    }

    private fun pasarPantalla() {
            val intent = Intent(this,GenProductoActivity::class.java)
            intent.apply {
                putExtra("nombreProd", (binding.etNProducto.text).toString())
                putExtra("precioProd", (binding.etPrecio.text).toString())
                putExtra("prodExis", binding.swExis.isChecked.toString())
            }
            startActivity(intent)
    }
}