package com.example.menachoprimerparcial

import android.widget.Toast

interface Comportamientos {
    fun mostrarDatosProducto(producto: Producto): String {
        val prodExist: String
        if (producto.productoExis){
            prodExist = "El producto es nuevo en inventario."
        }else{
            prodExist = "El producto ya existía en inventario."
        }
        return """
            El producto registrado es: ${producto.nombreProducto}.
            Tiene un precio de: ${producto.precioProducto} Bs.
            $prodExist
            Su código de registro es: ${calcularCodigoProducto()}
            El producto fue registrado correctamente.
        """.trimIndent()
    }
    fun calcularCodigoProducto(): String{
        var count = 5
        val rangoRandom = (5..20).random()
        for (i in 0 until rangoRandom){
            /*val serie = mutableListOf<Int>()
            serie.add(count)*/
            count += 3
        }
        return count.toString()
    }
}