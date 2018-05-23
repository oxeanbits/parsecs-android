package br.com.nvsistemas.parsec

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import br.com.nvsistemas.parsec.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val math = Math()

        sample_text.text = "sum 2+2: ${math.sum(2, 2)}, " +
                "multiply 2+5: ${math.multiply(2, 5)}"
    }
}
