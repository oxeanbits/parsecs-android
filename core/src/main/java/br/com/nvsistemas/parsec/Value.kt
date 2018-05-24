package br.com.nvsistemas.parsec

class Value(private val value: String, private val type: String) {

    fun getValue(): Any {
        return when(type) {
            "i" -> getInteger()
            "f" -> getDouble()
            "b" -> getBoolean()
            else -> value
        }
    }

    private fun getInteger(): Int {
        return value.toIntOrNull() ?: -1
    }

    private fun getDouble(): Double {
        return value.toDoubleOrNull() ?: -1.0
    }

    private fun getBoolean(): Boolean {
        return value == "true"
    }

    override fun toString(): String {
        return value
    }
}