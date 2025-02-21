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

        val btnCelsiusToFahrenheit: Button = findViewById(R.id.btnCelsiusToFahrenheit)
        val btnFahrenheitToCelsius: Button = findViewById(R.id.btnFahrenheitToCelsius)
        val etTemperaturaInput: EditText = findViewById(R.id.etTemperaturaInput)
        val tvResultadoTemperatura: TextView = findViewById(R.id.tvResultadoTemperatura)
        val mainLayout = findViewById<android.view.View>(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCelsiusToFahrenheit.setOnClickListener {
            val input = etTemperaturaInput.text.toString()
            if (input.isNotEmpty()) {
                val celsius = input.toDouble()
                val fahrenheit = (celsius * 9/5) + 32
                val redondeado = String.format("%.2f", fahrenheit).toDouble()
                tvResultadoTemperatura.text = "Resultado: $redondeado °F"
            } else {
                Toast.makeText(this, "Por favor ingresa un valor", Toast.LENGTH_SHORT).show()
            }
        }

        btnFahrenheitToCelsius.setOnClickListener {
            val input = etTemperaturaInput.text.toString()
            if (input.isNotEmpty()) {
                val fahrenheit = input.toDouble()
                val celsius = (fahrenheit - 32) * 5/9
                val redondeado = String.format("%.2f", fahrenheit).toDouble()
                tvResultadoTemperatura.text = "Resultado: $redondeado °C"
            } else {
                Toast.makeText(this, "Por favor ingresa un valor", Toast.LENGTH_SHORT).show()
            }
        }
    }
}