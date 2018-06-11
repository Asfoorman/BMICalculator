package com.asfoor.bmicalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmiresult_screen.*
import java.text.DecimalFormat
import com.asfoor.bmicalculator.R
import com.asfoor.bmicalculator.R.id.btnExit

/**
 *
 */
class BMIResultScreen : AppCompatActivity() {

    /**
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiresult_screen)

        showBMIResult()
        findBMICategory()

        //Set Listeners
        setExitListener()
        setCheckAgainListener()
    }


    /**
     *
     */
    fun showBMIResult(){
        var decFormat = DecimalFormat("#.#")
        var bmiFormat = decFormat.format(getIntent().getExtras().getDouble("BMIResult"))

        //change the Text in the GUI
        lblBMIResult.setText(bmiFormat.toString())
    }

    /**
     *
     */
    fun findBMICategory(){
        var bmiCategory = "Unknown"
        var bmiResult = getIntent().getExtras().getDouble("BMIResult")

        //if-else/if statement to determine users BMI fitness level

        if(bmiResult < 15){
            bmiCategory = "Very Dangerously Severely Underweight"
        } else if(bmiResult in 15..16){
            bmiCategory = "Severely Underweight"
        } else if(bmiResult > 16 && bmiResult <= 18.5) {
            bmiCategory = "Underweight"
        } else if (bmiResult > 18.5 && bmiResult <= 25) {
            bmiCategory = "Normal (Healthy Weight)"
        } else if (bmiResult in 25..30){
            bmiCategory = "Overweight"
        } else if (bmiResult in 30..35){
            bmiCategory = "Moderately Obese"
        } else if (bmiResult in 35..40){
            bmiCategory = "Severely Obese"
        } else if (bmiResult >= 40){
            bmiCategory = "Very Dangerously Severely Obese"
        }

        //Change the textView label in GUI to the appropriate
        lblBMIResultCategory.setText(bmiCategory)
    }

    /**
     *
     */
    fun setExitListener(){
        btnExit.setOnClickListener{
            this.finishAffinity()
            //to finish activity
        }

    }

    /**
     *
     */
    fun setCheckAgainListener(){
        btnCheckAgain.setOnClickListener {
            val intent = Intent("com.asfoor.bmicalculator.MainActivity")
            //This will send the activity back to main activity when clicking check again button (listener)

            startActivity(intent)
        }

    }



}
