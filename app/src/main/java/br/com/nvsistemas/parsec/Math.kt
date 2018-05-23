package br.com.nvsistemas.parsec

class Math {

    external fun sum(num1: Int, num2: Int): Int
    external fun multiply(num1: Int, num2: Int): Int

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("math-lib")
        }
    }
}