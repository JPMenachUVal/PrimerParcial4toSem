package com.example.menachoprimerparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.Toast
import com.example.menachoprimerparcial.databinding.ActivityGenProductoBinding
import com.example.menachoprimerparcial.databinding.ActivityMainBinding

class GenProductoActivity : AppCompatActivity(), Comportamientos {

    private lateinit var binding: ActivityGenProductoBinding
    private lateinit var mihandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mihandler = Handler(mainLooper)
        /*Toast.makeText(this, intent.getStringExtra("nombreProd").toString(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, intent.getStringExtra("precioProd").toString(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, intent.getStringExtra("prodExis").toString(), Toast.LENGTH_SHORT).show()*/
        /*val producto: Producto = Producto(intent.getStringExtra("nombreProd").toString(),
            intent.getStringExtra("precioProd").toString().toInt(),
            intent.getStringExtra("prodExis").toBoolean())*/
        //binding.txtMostrar.text = mostrarDatosProducto(producto)
        // calcularCodigoProducto()
        //Toast.makeText(this, calcularCodigoProducto(), Toast.LENGTH_SHORT).show()
        cargarPantalla()
    }

    private fun registrarProducto() {
        val producto: Producto = Producto(intent.getStringExtra("nombreProd").toString(),
            intent.getStringExtra("precioProd").toString().toInt(),
            intent.getStringExtra("prodExis").toBoolean())
        binding.txtMostrar.text = mostrarDatosProducto(producto)
    }

    private fun cargarPantalla() {
        Thread {
            try {
                for (i in 0 .. 100){
                    Thread.sleep(100)
                    mihandler.post{
                        binding.apply {
                            if(i/10 != 10){
                                txtContador.text = "${i/10} s"
                            }else{
                                txtContador.text = "Terminado"
                                registrarProducto()
                            }
                            progressBar.progress = i
                        }
                    }
                }
            }catch (e: InterruptedException){
                e.printStackTrace()
            }
        }.start()
    }
}