package com.example.preapp

import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.min


class ActivityFour : AppCompatActivity() {

    private lateinit var chk1: CheckBox
    private lateinit var chk2: CheckBox
    private lateinit var chk3: CheckBox
    private lateinit var chk4: CheckBox
    private lateinit var chk5: CheckBox

    private lateinit var price1TextView: TextView
    private lateinit var price2TextView: TextView
    private lateinit var price3TextView: TextView
    private lateinit var price4TextView: TextView
    private lateinit var price5TextView: TextView

    private lateinit var paymentRadioGroup: RadioGroup
    private lateinit var normalPriceRadioButton: RadioButton
    private lateinit var discPriceRadioButton: RadioButton

    private lateinit var subtotalPriceTextView: TextView
    private lateinit var statusTextView: TextView
    private lateinit var finalPriceTextView: TextView

    private val itemPrices = mapOf(
        "item1" to 12000.0,
        "item2" to 8000.0,
        "item3" to 12000.0,
        "item4" to 7000.0,
        "item5" to 5000.0
    )

    // Use java.util.Locale
    private val localeID = Locale("in", "ID")
    // currencyFormat will now correctly use java.text.NumberFormat
    private val currencyFormat: NumberFormat = NumberFormat.getCurrencyInstance(localeID).apply {
        maximumFractionDigits = 0 // This should now be resolved
    }

    // MERGED onCreate method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_four)

        // Ensure R.id.main is the correct ID of your root layout that should handle insets
        val mainView = findViewById<android.view.View>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        } else {
            // Log an error or handle the case where R.id.main is not found
            // android.util.Log.e("ActivityFour", "Root view with ID R.id.main not found for insets handling.")
        }

        initializeViews()
        setupInitialState()
        setupListeners()
    }

    private fun initializeViews() {
        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        chk4 = findViewById(R.id.chk4)
        chk5 = findViewById(R.id.chk5)

        price1TextView = findViewById(R.id.price1)
        price2TextView = findViewById(R.id.price2)
        price3TextView = findViewById(R.id.price3)
        price4TextView = findViewById(R.id.price4)
        price5TextView = findViewById(R.id.price5)

        paymentRadioGroup = findViewById(R.id.paymentRadioGroup)
        normalPriceRadioButton = findViewById(R.id.normalPrice)
        discPriceRadioButton = findViewById(R.id.discPrice)

        subtotalPriceTextView = findViewById(R.id.price)
        statusTextView = findViewById(R.id.status)
        finalPriceTextView = findViewById(R.id.finalPrice)
    }

    private fun setupInitialState() {
        price1TextView.text = formatCurrency(0.0)
        price2TextView.text = formatCurrency(0.0)
        price3TextView.text = formatCurrency(0.0)
        price4TextView.text = formatCurrency(0.0)
        price5TextView.text = formatCurrency(0.0)

        subtotalPriceTextView.text = formatCurrency(0.0)
        finalPriceTextView.text = formatCurrency(0.0)

        if (normalPriceRadioButton.isChecked) {
            statusTextView.text = "Tunai"
        } else if (discPriceRadioButton.isChecked) {
            statusTextView.text = "Non Tunai"
        } else {
            statusTextView.text = "-"
            // Consider checking one by default in XML or here
            // normalPriceRadioButton.isChecked = true
            // statusTextView.text = "Tunai"
        }
    }

    private fun formatCurrency(amount: Double): String {
        return currencyFormat.format(amount)
    }

    private fun setupListeners() {
        val checkBoxListener: (CheckBox, String, TextView) -> Unit =
            { checkBox, itemName, priceTextView ->
                if (checkBox.isChecked) {
                    priceTextView.text = formatCurrency(itemPrices[itemName] ?: 0.0)
                } else {
                    priceTextView.text = formatCurrency(0.0)
                }
                calculateTotalPrice()
            }

        chk1.setOnCheckedChangeListener { _, _ -> checkBoxListener(chk1, "item1", price1TextView) }
        chk2.setOnCheckedChangeListener { _, _ -> checkBoxListener(chk2, "item2", price2TextView) }
        chk3.setOnCheckedChangeListener { _, _ -> checkBoxListener(chk3, "item3", price3TextView) }
        chk4.setOnCheckedChangeListener { _, _ -> checkBoxListener(chk4, "item4", price4TextView) }
        chk5.setOnCheckedChangeListener { _, _ -> checkBoxListener(chk5, "item5", price5TextView) }

        paymentRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.normalPrice -> {
                    statusTextView.text = "Tunai"
                }
                R.id.discPrice -> {
                    statusTextView.text = "Non Tunai"
                }
            }
            calculateTotalPrice()
        }
    }

    private fun calculateTotalPrice() {
        var currentSubtotal = 0.0

        if (chk1.isChecked) currentSubtotal += itemPrices["item1"] ?: 0.0
        if (chk2.isChecked) currentSubtotal += itemPrices["item2"] ?: 0.0
        if (chk3.isChecked) currentSubtotal += itemPrices["item3"] ?: 0.0
        if (chk4.isChecked) currentSubtotal += itemPrices["item4"] ?: 0.0
        if (chk5.isChecked) currentSubtotal += itemPrices["item5"] ?: 0.0

        subtotalPriceTextView.text = formatCurrency(currentSubtotal)

        var finalPrice = currentSubtotal
        if (discPriceRadioButton.isChecked) {
            val discountPercentage = 0.10
            val maxDiscount = 8000.0
            var calculatedDiscount = currentSubtotal * discountPercentage
            calculatedDiscount = min(calculatedDiscount, maxDiscount)
            finalPrice = currentSubtotal - calculatedDiscount
        }
        finalPriceTextView.text = formatCurrency(finalPrice)
    }
}