package br.com.nvsistemas.parsec.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.nvsistemas.parsec.Parsec
import kotlinx.android.synthetic.main.activity_main.expression
import kotlinx.android.synthetic.main.activity_main.expression2
import kotlinx.android.synthetic.main.activity_main.result
import kotlinx.android.synthetic.main.activity_main.result2
import kotlinx.android.synthetic.main.activity_main.show_result_btn
import kotlinx.android.synthetic.main.activity_main.show_result_btn2

class MainActivity : AppCompatActivity() {

    private val parsec = Parsec()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        show_result_btn.setOnClickListener {
            result.text = eval(expression.text.toString())
        }

        show_result_btn2.setOnClickListener {
            result2.text = eval(expression2.text.split(",").map { it.trim() })
        }
    }

    private fun eval(formula: String): String {
        return try {
            val result = parsec.evalValue(formula)
            "$result (return type: ${result.getValue()::class.java.simpleName})"
        } catch (ex: UnsupportedOperationException) {
            ex.localizedMessage
        }
    }

    private fun eval(formulas: List<String>): String {
        return try {
            val result = parsec.evalValues(formulas)
            result.joinToString {
                "$it (return type: ${it?.getValue()?.javaClass?.kotlin?.simpleName.toString()})"
            }
        } catch (ex: UnsupportedOperationException) {
            ex.localizedMessage
        }
    }
}
