package br.com.nvsistemas.parsec

import android.util.Log
import org.json.JSONException
import org.json.JSONObject

class Parsec {
    @Throws(UnsupportedOperationException::class)
    fun eval(calc: String): String {
        val result = nativeEval(calc)

        if(result.startsWith("Error: "))
            throw UnsupportedOperationException(result)

        return result
    }

    fun evalValue(calc: String): Value {
        val result = nativeEvalJson(calc)

        if(result.startsWith("{\"error\"")) {
            val error = result.substring(11, result.length - 1)
            throw UnsupportedOperationException(error)
        }

        try {
            val json = JSONObject(result)

            return Value(json.optString("val", ""),
                    json.optString("type", ""))
        } catch (ex: JSONException) {
            Log.e(Parsec::class.java.simpleName, "Error on try parser json.", ex)
        }

        return Value("", "")
    }

    fun evalValues(equations: Map<Int, String>): Map<Int, Value> {
        val values = mutableMapOf<Int, Value>()

        equations.forEach {
            val result = nativeEvalJson(it.value)

            if(result.startsWith("{\"error\"")) {
                val error = result.substring(11, result.length - 1)
                throw UnsupportedOperationException(error)
            }

            try {
                val json = JSONObject(result)
                values[it.key] = Value(json.optString("val", ""),
                    json.optString("type", ""))
            } catch (ex: JSONException) {
                Log.e(Parsec::class.java.simpleName, "Error on try parser json.", ex)
            }
        }

        return values
    }

    private external fun nativeEval(formula: String): String

    private external fun nativeEvalJson(formula: String): String

    companion object {
        init {
            System.loadLibrary("parsec-lib")
        }
    }
}
