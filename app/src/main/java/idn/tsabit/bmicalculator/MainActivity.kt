package idn.tsabit.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalculate: Button
    private lateinit var edtWeight: EditText
    private lateinit var edtHeight: EditText
    private lateinit var imgBmi: ImageView
    private lateinit var txtYourBmi: TextView
    private lateinit var txtBmi: TextView
    private lateinit var txtDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate = findViewById(R.id.btnCalculate)
        edtWeight = findViewById(R.id.edtWeight)
        edtHeight = findViewById(R.id.edtHeight)
        imgBmi = findViewById(R.id.imgBmi)
        txtYourBmi = findViewById(R.id.txtYourBmi)
        txtBmi = findViewById(R.id.txtBmi)
        txtDesc = findViewById(R.id.txtDesc)

        btnCalculate.setOnClickListener {
            if (edtWeight.text.isNotEmpty() && edtHeight.text.isNotEmpty()) {
                calculateBmi()
            } else {
                Toast.makeText(
                    this,
                    "Please fill out your Height and Weight first!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun calculateBmi() {
        val weight = edtWeight.text.toString().toFloat()
        val height = edtHeight.text.toString().toFloat()
        val bmi = weight / (height * height)

        txtBmi.text = bmi.toString()
        imgBmi.visibility = View.VISIBLE
        txtYourBmi.visibility = View.VISIBLE
        txtBmi.visibility = View.VISIBLE
        txtDesc.visibility = View.VISIBLE

        when {
            bmi < 18.5 -> {
                imgBmi.setImageResource(R.drawable.ic_underweight)
                txtDesc.text = getString(R.string.underweight)
            }
            bmi >= 18.5 && bmi < 24.9 -> {
                imgBmi.setImageResource(R.drawable.ic_healthy)
                txtDesc.text = getString(R.string.healthy)
            }
            bmi >= 24.9 && bmi < 29.9 -> {
                imgBmi.setImageResource(R.drawable.ic_overweight)
                txtDesc.text = getString(R.string.overweight)
            }
            else -> {
                imgBmi.setImageResource(R.drawable.ic_obesity)
                txtDesc.text = getString(R.string.obese)
            }
        }
    }
}