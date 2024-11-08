package com.example.layoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val layout = findViewById<ConstraintLayout>(R.id.layout_principal)
        val editNome = findViewById<EditText>(R.id.editNome)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)


        btnEnviar.setBackgroundColor(Color.parseColor("#2196F3"))


        btnEnviar.setOnClickListener {
            val nome = editNome.text.toString()
            if (nome.isNotEmpty()) {
                Toast.makeText(this, "Olá, $nome!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, digite seu nome.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}