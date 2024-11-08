package com.example.layoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    // Infla o menu na ActionBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Lida com cliques nos itens do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                // Ação para o Item 1
                Toast.makeText(this, "Ligar / Desligar selecionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item2 -> {
                // Ação para o Item 2
                Toast.makeText(this, "Configurações selecionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item3 -> {
                // Ação para o Item 3
                Toast.makeText(this, "Ajuda selecionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item4 -> {
                // Ação para o Item 3
                Toast.makeText(this, "Sobre selecionado", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}