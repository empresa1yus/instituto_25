package com.example.convertidor_unidades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Usamos findViewById para obtener las vistas
        val btnTemperatura: Button = findViewById(R.id.btnTemperatura)
        val btnMonedas: Button = findViewById(R.id.btnMonedas)
        val btnLongitudes: Button = findViewById(R.id.btnLongitudes)
        val mainLayout = findViewById<android.view.View>(R.id.main)

        // Ajuste de padding para los bordes
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnTemperatura.setOnClickListener {
            val intent = Intent(this, Temperature::class.java)
            startActivity(intent)
        }

        btnMonedas.setOnClickListener {
            val intent = Intent(this, monedas::class.java)
            startActivity(intent)
        }

        btnLongitudes.setOnClickListener {
            val intent = Intent(this, longitudes::class.java)
            startActivity(intent)
        }
    }
}