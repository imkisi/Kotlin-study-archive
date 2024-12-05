package com.example.lonetrail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class CreatorProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.creator_profile)
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

        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = false

        val backButton = findViewById<ImageButton>(R.id.back)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}