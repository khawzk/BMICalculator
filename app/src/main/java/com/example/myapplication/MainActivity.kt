package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        fun calculateBMI(weight: Double, height: Double): Double {

            return weight / Math.pow(height, 2.0)
        }
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            btnCal.setOnClickListener() {
                val weight: Double = weightt.text.toString().toDouble()
                val height: Double = heightt.text.toString().toDouble()
                val bmi: Double = calculateBMI(weight, height / 100)
                /*if(bmi<18.5){
                img.setImageResource(R.drawable.under)
            }else if(bmi<=24.9){
                img.setImageResource(R.drawable.normal)
            }else{
                img.setImageResource(R.drawable.over)
            }*/
                val status: String
                try {
                    when {

                        bmi < 18.5 -> {
                            img.setImageResource(R.drawable.under)
                            status = "Under"
                            display.setText("BMI<18.5(Underweight)")
                        }
                        bmi < 24.9 -> {
                            img.setImageResource(R.drawable.normal)
                            status = "Normal"
                            display.setText("18.5<BMI<24.9(Normal)")
                        }
                        else -> {
                            img.setImageResource(R.drawable.over)
                            display.setText("BMI>24.9(Overweight)")
                            status = "Over"
                        }
                    }
                    display.setText("BMI%.2f(%s)".format(bmi, status))
                } catch (ex: Exception) {
                    val toast: Toast =
                        Toast.makeText(applicationContext, "Invalid Input", Toast.LENGTH_LONG)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()

                }
                btnReset.setOnClickListener() {
                    img.setImageResource(R.drawable.empty)
                    display.setText("")
                    weightt.setText("")
                    heightt.setText("")
                    heightt.requestFocus()
                }
            }


        }
    }

