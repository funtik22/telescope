package ru.a.o.mikhailov.telescope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Telescope)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}