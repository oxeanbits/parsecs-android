package br.com.nvsistemas.parsec

class Parsec {
    @Throws(UnsupportedOperationException::class)
    fun eval(calc: String): String {
        val result = nativeEval(calc)

        if(result.startsWith("Error: "))
            throw UnsupportedOperationException(result)

        return result
    }

    private external fun nativeEval(formula: String): String

    companion object {
        init {
            System.loadLibrary("parsec-lib")
        }
    }
}