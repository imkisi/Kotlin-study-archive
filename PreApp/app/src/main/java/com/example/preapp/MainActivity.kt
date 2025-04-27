package com.example.preapp

import android.content.Intent
import android.icu.util.Calendar
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.greetings)
        val greeting = getGreeting()
        greetingTextView.text = greeting

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val githubButton = findViewById<MaterialButton>(R.id.github)
        val facebookButton = findViewById<MaterialButton>(R.id.facebook)
        val dribbbleButton = findViewById<MaterialButton>(R.id.dribbble)
        val behanceButton = findViewById<MaterialButton>(R.id.behance)

        githubButton.setOnClickListener {
            val url = "https://github.com/imkisi"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        facebookButton.setOnClickListener {
            val url = "https://facebook.com/bagas.anggoro.942/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        dribbbleButton.setOnClickListener {
            val url = "https://dribbble.com/Shirr0"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        behanceButton.setOnClickListener {
            val url = "https://www.behance.net/bagasanggoro1"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }


    }

    private fun getGreeting(): String {
        val calendar = Calendar.getInstance()
        val timeOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        return when (timeOfDay) {
            in 4..10 -> "Selamat PAgi"
            in 11..14 -> "Selamat Siang"
            in 15..18 -> "Selamat Sore"
            in 17..23 -> "Selamat Malam"
            in 0..3 -> "Selamat Malam"
            else -> "Halo"
        }
    }
}