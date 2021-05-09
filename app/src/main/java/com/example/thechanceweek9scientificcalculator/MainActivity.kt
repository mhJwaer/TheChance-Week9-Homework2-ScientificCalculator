package com.example.thechanceweek9scientificcalculator

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.thechanceweek9scientificcalculator.databinding.ActivityMainBinding
import java.lang.Math.*
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

@SuppressLint("NewApi")
class MainActivity : AppCompatActivity() {
    private var txtResult = ""
    private var temp1: Double = 0.0
    private var temp2: Double = 0.0
    private var activeOpButton: Button? = null
    lateinit var binding: ActivityMainBinding
    private var orientation: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        orientation = resources.configuration.orientation
    }


    fun opBtnClick(view: View) {
        val btn = view as Button
        if (activeOpButton != btn) {
            disSelectOpBtn(activeOpButton)
        }
        selectOpBtn(btn)
        activeOpButton = btn
        if (txtResult == "") txtResult = "0"
        temp1 = txtResult.toDouble()
        txtResult = ""

    }

    fun equalBtnClick(view: View) {
        if (txtResult == "") txtResult = "0"
        temp2 = txtResult.toDouble()
        when (activeOpButton?.text) {
            "/" -> {
                txtResult = (temp1 / temp2).toString()
                binding.txtResult.text = txtResult
            }
            "X" -> {
                txtResult = (temp1 * temp2).toString()
                binding.txtResult.text = txtResult
            }
            "-" -> {
                txtResult = (temp1 - temp2).toString()
                binding.txtResult.text = txtResult
            }
            "+" -> {
                txtResult = (temp1 + temp2).toString()
                binding.txtResult.text = txtResult
            }
            "x^y" -> {
                txtResult = (temp1.pow(temp2)).toString()
                binding.txtResult.text = txtResult
            }
            "y√x" -> {
                txtResult = (temp1.pow(1 / temp2)).toString()
                binding.txtResult.text = txtResult
            }
            "ee" -> {
                txtResult = (temp1 * ((10.0).pow(temp2))).toString()
                binding.txtResult.text = txtResult
            }
            "y^x" -> {
                txtResult = (temp1.pow(temp2)).toString()
                binding.txtResult.text = txtResult
            }
            else -> {
                binding.txtResult.text = temp2.toString()
            }
        }
        disSelectOpBtn(activeOpButton)

    }

    fun digitClick(view: View) {
        val btn = view as Button
        if (temp2 != 0.0) {
            txtResult = ""
            temp2 = 0.0
        }
        if (txtResult.length >= 8) {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                binding.txtResult.textSize = 32f
            }
        }
        txtResult += btn.text
        binding.txtResult.text = txtResult
    }

    fun acClick(view: View) {
        txtResult = ""
        binding.txtResult.text = "0"
        disSelectOpBtn(activeOpButton)

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.txtResult.textSize = 64f
        }

    }

    fun dotClick(view: View) {
        if (txtResult.contains(".")) return
        val btn = view as Button
        if (temp2 != 0.0) {
            txtResult = ""
            temp2 = 0.0
        }
        txtResult += btn.text
        binding.txtResult.text = txtResult
    }

    fun negPos(view: View) {
        if (txtResult == "") txtResult = "0"
        if (txtResult.startsWith("-")) {
            txtResult = txtResult.removePrefix("-")
            binding.txtResult.text = txtResult
        } else {
            txtResult = "-$txtResult"
            binding.txtResult.text = txtResult
        }
    }

    fun percentBtnClick(view: View) {
        txtResult = (txtResult.toDouble() / 100).toString()
        binding.txtResult.text = txtResult
    }

    private fun disSelectOpBtn(btn: Button?) {
        btn?.isSelected = false
        btn?.setTextColor(getColor(R.color.white))
    }

    private fun selectOpBtn(btn: Button?) {
        btn?.isSelected = true
        btn?.setTextColor(getColor(R.color.yellow_dark))
    }

    //one operand buttons functions
    fun sqrRoot(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = sqrt(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
    }

    fun cubeRoot(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = cbrt(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
    }

    fun tenBaseX(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = (10.0).pow(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
    }

    fun logTen(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.log10(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
    }

    fun e(view: View) {
        txtResult = ""
        binding.txtResult.text = getString(R.string.eValue)
    }

    fun ex(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.exp(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
    }

    fun ln(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.ln(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
    }

    fun pie(view: View) {
        txtResult = ""
        binding.txtResult.text = getString(R.string.pie)
    }

    fun pwr2(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = ((txtResult.toDouble()).pow(2)).toString()
        binding.txtResult.text = txtResult
    }

    fun pwr3(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = ((txtResult.toDouble()).pow(3)).toString()
        binding.txtResult.text = txtResult
    }

    fun rand(view: View) {
        val rnds = Random.nextDouble(0.0, 1.0)
        txtResult = rnds.toString()
        binding.txtResult.text = txtResult
        txtResult = ""
    }

    fun tan(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.tan(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
        txtResult = ""
    }

    fun sin(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.sin(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
        txtResult = ""
    }

    fun cos(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.cos(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
        txtResult = ""
    }

    fun tanh(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.tanh(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
        txtResult = ""
    }

    fun cosh(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.cosh(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
        txtResult = ""
    }

    fun sinh(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.sinh(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
        txtResult = ""
    }

    fun factorialX(view: View) {
        if (txtResult == "") txtResult = "0.0"
        var factorial: Long = 1
        for (i in 1..txtResult.toLong()) {
            // factorial = factorial * i;
            factorial *= i
        }
        txtResult = factorial.toString()
        binding.txtResult.text = txtResult
    }

    fun oneOverX(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = (1 / txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
    }

    fun towPowerX(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = ((2.0).pow(txtResult.toDouble())).toString()
        binding.txtResult.text = txtResult
    }


    fun logTow(view: View) {
        if (txtResult == "") txtResult = "0.0"
        txtResult = kotlin.math.log2(txtResult.toDouble()).toString()
        binding.txtResult.text = txtResult
    }
}