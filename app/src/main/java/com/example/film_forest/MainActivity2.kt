package com.example.film_forest

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    lateinit var radio_group: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_by)

        val backButton: ImageView = findViewById(R.id.back_arrow)
        val button: Button = findViewById(R.id.submit_button)
        radio_group = findViewById(R.id.radioGenre)

        //Radio button on click change
        radio_group.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->

                val radio_langange: RadioButton = findViewById(checkedId)
                Toast.makeText(
                    applicationContext,
                    "${radio_langange.text} has been selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
        // Get radio group selected status and text using button click event
        button.setOnClickListener {
            // Get the checked radio button id from radio group
            var id: Int = radio_group.checkedRadioButtonId
            if (id != -1) { // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                Toast.makeText(
                    applicationContext, "${radio.text} has been selected",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // If no radio button checked in this radio group
                Toast.makeText(
                    applicationContext, "On button click : nothing selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val releaseYearSpinner: Spinner = findViewById(R.id.release_year_spinner)
        val releaseYearSize: Int = 104
        val years = arrayOfNulls<String>(releaseYearSize)
        years[0] = "Select a release year"
        for (i in 1 until (releaseYearSize - 1)) {
            val startingYear = 2021
            var nowYear = startingYear - i
            years[i] = nowYear.toString()
        }
        years[releaseYearSize - 1] = "Before 1920"

        val adapter: ArrayAdapter<String> =
            object : ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, years) {
                override fun getDropDownView(
                    position: Int,
                    convertView: View?,
                    parent: ViewGroup
                ): View {
                    val view: TextView = super.getDropDownView(
                        position,
                        convertView,
                        parent
                    ) as TextView

                    // set item text bold and sans serif font
                    view.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL)

                    if (position == 0) {
                        // set the spinner disabled item text color
                        view.setTextColor(Color.LTGRAY)
                    }

                    // set selected item style
                    if (position == releaseYearSpinner.selectedItemPosition) {
                        view.background = ColorDrawable(Color.parseColor("#F5F5F5"))
                    }

                    return view
                }

                override fun isEnabled(position: Int): Boolean {
                    // disable the third item of spinner
                    return position != 0
                }
            }

        releaseYearSpinner.adapter = adapter

        releaseYearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    applicationContext, "On button click : nothing selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getItemAtPosition(position)!! == "Select a release year") {
                    //do nothing
                } else {
                    val text: String = releaseYearSpinner.getSelectedItem().toString()
                    Toast.makeText(
                        applicationContext, "$text has been selected",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        val runtimeSpinner: Spinner = findViewById(R.id.runtime_spinner)
        val runtimeSize: Int = 6
        val times = arrayOfNulls<String>(runtimeSize)
        times[0] = "Select a runtime"
        times[1] = "30-60 minutes"
        times[2] = "60-90 minutes"
        times[3] = "90-120 minutes"
        times[4] = "120-150 minutes"
        times[5] = "150-180 minutes"


        val runtimeAdapter: ArrayAdapter<String> =
            object : ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, times) {
                override fun getDropDownView(
                    position: Int,
                    convertView: View?,
                    parent: ViewGroup
                ): View {
                    val view: TextView = super.getDropDownView(
                        position,
                        convertView,
                        parent
                    ) as TextView

                    // set item text bold and sans serif font
                    view.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL)

                    if (position == 0) {
                        // set the spinner disabled item text color
                        view.setTextColor(Color.LTGRAY)
                    }

                    // set selected item style
                    if (position == releaseYearSpinner.selectedItemPosition) {
                        view.background = ColorDrawable(Color.parseColor("#F5F5F5"))
                    }

                    return view
                }

                override fun isEnabled(position: Int): Boolean {
                    // disable the third item of spinner
                    return position != 0
                }
            }

        runtimeSpinner.adapter = runtimeAdapter

        runtimeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    applicationContext, "On button click : nothing selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getItemAtPosition(position)!! == "Select a runtime") {
                    //do nothing
                } else {
                    val text: String = runtimeSpinner.getSelectedItem().toString()
                    Toast.makeText(
                        applicationContext, "$text has been selected",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        val findMovieButton: Button = findViewById(R.id.submit_button)

        findMovieButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent);
        }
    }

    // Get the selected radio button text using radio button on click listener
    fun radio_button_click(view: View) {
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        Toast.makeText(
            applicationContext, "${radio.text} has been selected",
            Toast.LENGTH_SHORT
        ).show()
    }
}