package com.example.calculator10

class CalcLogic{

    private val ADD='+'
    private val SUB ='-'
    private val MUL='*'
    private val DIV='/'

    fun evaluate(num1:Double, num2: Double, op:Char):Double
    {
        var result=when(op)
        {
            ADD-> num1+num2
            SUB->num1-num2
            MUL->num1*num2
            DIV-> num1 / num2
            else -> throw Exception("INVALID OPERATOR")
        }
        return result

    }

}