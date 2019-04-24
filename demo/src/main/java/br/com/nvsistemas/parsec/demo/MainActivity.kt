package br.com.nvsistemas.parsec.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.nvsistemas.parsec.Parsec
import kotlinx.android.synthetic.main.activity_main.expression
import kotlinx.android.synthetic.main.activity_main.result
import kotlinx.android.synthetic.main.activity_main.show_result_btn

class MainActivity : AppCompatActivity() {

    private val parsec = Parsec()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        show_result_btn.setOnClickListener {
            result.text = eval(expression.text.toString())
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
}
