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

class monedas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_monedas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Usamos findViewById para obtener las vistas
        val btnSolesToDolares: Button = findViewById(R.id.btnSolesToDolares)
        val btnDolaresToSoles: Button = findViewById(R.id.btnDolaresToSoles)
        val etMonedasInput: EditText = findViewById(R.id.etMonedasInput)
        val tvResultadoMonedas: TextView = findViewById(R.id.tvResultadoMonedas)
        val mainLayout = findViewById<android.view.View>(R.id.main)

        // Ajuste de padding para los bordes
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Convertir Soles a Dólares
        btnSolesToDolares.setOnClickListener {
            val input = etMonedasInput.text.toString()
            if (input.isNotEmpty()) {
                val soles = input.toDouble()
                val dolares = soles / 3.75 // Supongamos que 1 USD = 3.75 soles
                tvResultadoMonedas.text = "Resultado: $dolares USD"
            } else {
                Toast.makeText(this, "Por favor ingresa un valor", Toast.LENGTH_SHORT).show()
            }
        }

        // Convertir Dólares a Soles
        btnDolaresToSoles.setOnClickListener {
            val input = etMonedasInput.text.toString()
            if (input.isNotEmpty()) {
                val dolares = input.toDouble()
                val soles = dolares * 3.75
                tvResultadoMonedas.text = "Resultado: $soles S/"
            } else {
                Toast.makeText(this, "Por favor ingresa un valor", Toast.LENGTH_SHORT).show()
            }
        }
    }
}