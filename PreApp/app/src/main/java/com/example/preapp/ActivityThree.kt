package com.example.preapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ActivityThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_three)

        val squareLengthEditText = findViewById<TextInputEditText>(R.id.squareLength)
        val squareWidthEditText = findViewById<TextInputEditText>(R.id.squareWidth)
        val squareOutputTextView = findViewById<TextView>(R.id.squareOutput)
        val squareButton = findViewById<Button>(R.id.squareBtn)

        squareButton.setOnClickListener {
            val length = squareLengthEditText.text.toString().toDoubleOrNull() ?: 0.0
            val width = squareWidthEditText.text.toString().toDoubleOrNull() ?: 0.0

            val area = length * width

            squareOutputTextView.text = area.toString()
        }

        val triangBaseEditText = findViewById<TextInputEditText>(R.id.triangBase)
        val triangleHeightEditText = findViewById<TextInputEditText>(R.id.triangleHeight)
        val triangleOutputTextView = findViewById<TextView>(R.id.triangleOutput)
        val triangleButton = findViewById<Button>(R.id.triangleBtn)

        triangleButton.setOnClickListener {
            val base = triangBaseEditText.text.toString().toDoubleOrNull() ?: 0.0
            val height = triangleHeightEditText.text.toString().toDoubleOrNull() ?: 0.0

            val area = 0.5 * base * height

            triangleOutputTextView.text = area.toString()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}