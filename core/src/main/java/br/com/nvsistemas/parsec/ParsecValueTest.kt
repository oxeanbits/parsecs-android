package br.com.nvsistemas.parsec

import android.util.Log

class ParsecValueTest {
    val parsec = Parsec()

    init {
        //test_simple_math_equations
        assert(10, "(5 + 1) + (6 - 2)")
        assert(16, "4 + 4 * 3")
        assert(2, "10.5 / 5.25")
        assert(5, "abs(-5)")
        assert(1, "log10(10)")
        assert(4, "round(4.4)")
        assert(729, "(3^3)^2")
        assert(19683, "3^(3^(2))")
        assert(3628800, "10!")

        //test_complex_math_equations
        assert(6, "sqrt(16) + cbrt(8)")
        assert(4.30259, "log10(10) + ln(e) + log(10)")
        assert(2.0, "sin(1) + cos(0) + tan(0.15722)")
        assert(16, "max(1, 2) + min(3, 4) + sum(5, 6)")
        assert(9.6, "avg(9, 9.8, 10)")
        assert(8, "pow(2, 3)")
        assert(4.56, "round_decimal(4.559, 2)")

        //test_if_then_else_equations
        assert("bigger", "4 > 2 ? \"bigger\" : \"smaller\"")
        assert(true, "2 == 2 ? true : false")
        assert(false, "2 != 2 ? true : false")
        assert("yes", "\"this\" == \"this\" ? \"yes\" : \"no\"")
        assert("yes", "\"this\" != \"that\" ? \"yes\" : \"no\"")

        //test_logic_manipulation
        assert(false, "true and false")
        assert(true, "true or false")
        assert(false, "(3==3) and (3!=3)")
        assert(true, "exp(1) == e")

        //test_simple_string_manipulation
        assert(11, "length(\"test string\")")
        assert("TEST STRING", "toupper(\"test string\")")
        assert("test string", "tolower(\"TEST STRING\")")
        assert("Hello World", "concat(\"Hello \", \"World\")")
        assert(5, "str2number(\"5\")")
        assert("Hello", "left(\"Hello World\", 5)")
        assert("World", "right(\"Hello World\", 5)")

        //test_complex_string_manipulation
        assert("HELLO WORLD", "toupper(concat(\"hello \", \"world\"))")
        assert("test lowercase", "tolower(\"TEST LOWERCASE\")")
        assert("Hello", "left(\"Hello World\", 5)")
        assert("World", "right(\"Hello World\", 5)")

        //test_general_equations
        assert(1, "((0.09/1.0)+2.58)-1.67")
        assert(40.6853, "10^log(3+2)")
        assert(1, "log(e)")
        assert(2, "2^5^0")
        assert("yes", "5 > 3 ? \"yes\" : \"no\"")
        assert(1, "\"this\" == \"this\" ? 1 : 0")
        assert(9.9812, "sqrt(9)+cbrt(8)+abs(-4.9812)")
        assert(3628680, "10! - 5! * -(-1)")
        assert(true, "sum(1,2,3,4,5) == max(14.99, 15)")
        assert(0.55, "avg(1,2,3,4,5,6,7,8,9,10) / 10")
        assert(5, "round(4.62)")
        assert(4.63, "round_decimal(4.625, 2)")
        assert(2.71828, "e")
        assert(3.14159, "pi")

        //test_return_exception
        assert("", "something_wrong")
        assert("", "1+2=3")
    }

    private fun assert(expected: Any, calc: String) {
        try {
            val result = parsec.evalValue(calc)
            if(result.getValue() == expected) {
                Log.i(ParsecValueTest::class.java.simpleName, "formula: $calc result: [$result]")
            } else {
                Log.e(ParsecValueTest::class.java.simpleName,
                        "formula: $calc, expected: [$expected], returns: [${result.getValue()}]")
            }
        } catch (ex: UnsupportedOperationException) {
            Log.e(ParsecValueTest::class.java.simpleName, ex.message)
        }
    }

}