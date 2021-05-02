package com.example.film_forest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_screen)

        val button: Button = findViewById(R.id.main_screen_button2)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent);
        }
    }
}