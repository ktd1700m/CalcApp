package jp.techacademy.takeshi.kataoka.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (editNum1.text.toString().equals("") || editNum2.text.toString().equals("")) {
            textViewA.text = "2か所の入力欄の両方に数値を入力してください"
        } else {
            var calcResult = 0.0
            when(v.id) {
                R.id.buttonPlus -> {
                    calcResult =
                        editNum1.text.toString().toDouble() + editNum2.text.toString().toDouble()
                    watchResult(calcResult)
                }
                R.id.buttonMinus -> {
                    calcResult =
                        editNum1.text.toString().toDouble() - editNum2.text.toString().toDouble()
                    watchResult(calcResult)
                }
                R.id.buttonMultiply -> {
                    calcResult =
                        editNum1.text.toString().toDouble() * editNum2.text.toString().toDouble()
                    watchResult(calcResult)
                }
                R.id.buttonDivide -> {
                    if (editNum2.text.toString().toDouble().equals(0.0)) {
                        textViewA.text = "÷0 は無効です"
                    } else {
                        calcResult =
                            editNum1.text.toString().toDouble() / editNum2.text.toString().toDouble()
                        watchResult(calcResult)
                    }
                }
            }
        }
    }

    private fun watchResult(calcResult: Double) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("VALUE", calcResult)
        startActivity(intent)
    }
}