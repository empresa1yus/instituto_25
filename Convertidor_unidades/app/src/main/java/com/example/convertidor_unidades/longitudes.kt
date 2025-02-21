package com.example.convertidor_unidades

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class longitudes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_longitudes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Usamos findViewById para obtener las vistas
        val btnMetrosToKilometros: Button = findViewById(R.id.btnMetrosToKilometros)
        val btnKilometrosToMetros: Button = findViewById(R.id.btnKilometrosToMetros)
        val etLongitudesInput: EditText = findViewById(R.id.etLongitudesInput)
        val tvResultadoLongitudes: TextView = findViewById(R.id.tvResultadoLongitudes)
        val mainLayout: View = findViewById(R.id.main)

        // Ajuste de padding para los bordes
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Convertir Metros a Kilómetros
        btnMetrosToKilometros.setOnClickListener {
            val input = etLongitudesInput.text.toString()
            if (input.isNotEmpty()) {
                val metros = input.toDouble()
                val kilometros = metros / 1000
                tvResultadoLongitudes.text = "Resultado: $kilometros km"
            } else {
                Toast.makeText(this, "Por favor ingresa un valor", Toast.LENGTH_SHORT).show()
            }
        }

        // Convertir Kilómetros a Metros
        btnKilometrosToMetros.setOnClickListener {
            val input = etLongitudesInput.text.toString()
            if (input.isNotEmpty()) {
                val kilometros = input.toDouble()
                val metros = kilometros * 1000
                tvResultadoLongitudes.text = "Resultado: $metros m"
            } else {
                Toast.makeText(this, "Por favor ingresa un valor", Toast.LENGTH_SHORT).show()
            }
        }
    }
}