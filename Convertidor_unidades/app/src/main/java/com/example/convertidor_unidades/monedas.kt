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

        val btnSolesToDolares: Button = findViewById(R.id.btnSolesToDolares)
        val btnDolaresToSoles: Button = findViewById(R.id.btnDolaresToSoles)
        val etMonedasInput: EditText = findViewById(R.id.etMonedasInput)
        val tvResultadoMonedas: TextView = findViewById(R.id.tvResultadoMonedas)
        val mainLayout = findViewById<android.view.View>(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSolesToDolares.setOnClickListener {
            val input = etMonedasInput.text.toString()
            if (input.isNotEmpty()) {
                val soles = input.toDouble()
                val dolares = soles / 3.77
                val redondeado = String.format("%.2f", dolares).toDouble()
                tvResultadoMonedas.text = "Resultado: USD $redondeado"
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
                val redondeado = String.format("%.2f", soles).toDouble()
                tvResultadoMonedas.text = "Resultado: S/ $redondeado"
            } else {
                Toast.makeText(this, "Por favor ingresa un valor", Toast.LENGTH_SHORT).show()
            }
        }
    }
}