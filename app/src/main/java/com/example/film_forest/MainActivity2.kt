package com.example.film_forest

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity2 : AppCompatActivity() {

    lateinit var radio_group: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_by)

        val backButton:ImageView = findViewById(R.id.back_arrow)
        val button: Button = findViewById(R.id.submit_button)
        radio_group = findViewById(R.id.radioGenre)

        //Radio button on click change
        radio_group.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener{
                    group, checkedId ->

                    val radio_langange: RadioButton = findViewById(checkedId)
                    Toast.makeText(applicationContext,"On Checked change: ${radio_langange.text}",Toast.LENGTH_SHORT).show()
                }
        )
        // Get radio group selected status and text using button click event
        button.setOnClickListener{
            // Get the checked radio button id from radio group
            var id: Int = radio_group.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio:RadioButton = findViewById(id)
                Toast.makeText(applicationContext,"On button click : ${radio.text}",
                        Toast.LENGTH_SHORT).show()
            }else{
                // If no radio button checked in this radio group
                Toast.makeText(applicationContext,"On button click : nothing selected",
                        Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
    // Get the selected radio button text using radio button on click listener
    fun radio_button_click(view: View){
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.text}",
                Toast.LENGTH_SHORT).show()
    }

}