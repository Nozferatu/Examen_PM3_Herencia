package com.cmj.examen

open class Circunferencia(
    open var radio: Float
) {
    lateinit var posicionCentro: Pair<Int, Int>
    open lateinit var puntoCualquiera: Pair<Int, Int>

    constructor(posicionCentro: Pair<Int, Int>, puntoCualquiera: Pair<Int, Int>) : this(0F ){
        this.posicionCentro = posicionCentro
        this.puntoCualquiera = puntoCualquiera
    }

    open fun longitud(): Double { return radio * 2 * Math.PI }

    override fun toString(): String {
        return "Circunferencia(radio=$radio, puntoCualquiera=$puntoCualquiera)"
    }
}