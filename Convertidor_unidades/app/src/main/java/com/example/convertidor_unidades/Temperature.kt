package com.example.convertidor_unidades

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class Temperature : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_temperature)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Usamos findViewById para obtener las vistas
        val btnCelsiusToFahrenheit: Button = findViewById(R.id.btnCelsiusToFahrenheit)
        val btnFahrenheitToCelsius: Button = findViewById(R.id.btnFahrenheitToCelsius)
        val etTemperaturaInput: EditText = findViewById(R.id.etTemperaturaInput)
        val tvResultadoTemperatura: TextView = findViewById(R.id.tvResultadoTemperatura)
        val mainLayout = findViewById<android.view.View>(R.id.main)

        // Ajuste de padding para los bordes
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Convertir Celsius a Fahrenheit
        btnCelsiusToFahrenheit.setOnClickListener {
            val input = etTemperaturaInput.text.toString()
            if (input.isNotEmpty()) {
                val celsius = input.toDouble()
                val fahrenheit = (celsius * 9/5) + 32
                tvResultadoTemperatura.text = "Resultado: $fahrenheit °F"
            } else {
                Toast.makeText(this, "Por favor ingresa un valor", Toast.LENGTH_SHORT).show()
            }
        }

        // Convertir Fahrenheit a Celsius
        btnFahrenheitToCelsius.setOnClickListener {
            val input = etTemperaturaInput.text.toString()
            if (input.isNotEmpty()) {
                val fahrenheit = input.toDouble()
                val celsius = (fahrenheit - 32) * 5/9
                tvResultadoTemperatura.text = "Resultado: $celsius °C"
            } else {
                Toast.makeText(this, "Por favor ingresa un valor", Toast.LENGTH_SHORT).show()
            }
        }
    }
}