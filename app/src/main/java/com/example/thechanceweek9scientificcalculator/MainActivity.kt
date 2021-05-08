package com.example.thechanceweek9scientificcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.thechanceweek9scientificcalculator.databinding.ActivityMainBinding

@SuppressLint("NewApi")
class MainActivity : AppCompatActivity() {
    private var txtResult = ""
    private var temp1: Double = 0.0
    private var temp2: Double = 0.0
    private var activeOpButton: Button? = null
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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
        if (txtResult.length >= 8) binding.txtResult.textSize = 32f
        txtResult += btn.text
        binding.txtResult.text = txtResult
    }

    fun acClick(view: View) {
        txtResult = ""
        binding.txtResult.text = "0"
        disSelectOpBtn(activeOpButton)
        binding.txtResult.textSize = 64f

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


}