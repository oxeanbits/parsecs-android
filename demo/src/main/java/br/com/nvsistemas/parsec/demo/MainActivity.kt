package br.com.nvsistemas.parsec.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.nvsistemas.parsec.Parsec
import br.com.nvsistemas.parsec.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val parsec = Parsec()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.showResultBtn.setOnClickListener {
            binding.result.text = eval(binding.expression.text.toString())
        }

        binding.showResultBtn2.setOnClickListener {
            binding.result2.text = eval(binding.expression2.text.split(",").map { it.trim() })
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
