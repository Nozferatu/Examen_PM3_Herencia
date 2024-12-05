package com.cmj.examen

import kotlin.math.pow

class Circulo(
    override var radio: Float,
    var color: String
): Circunferencia(radio) {
    lateinit var centro:Pair<Int, Int>
    override lateinit var puntoCualquiera: Pair<Int, Int>

    constructor(centro: Pair<Int, Int>, puntoCualquiera: Pair<Int, Int>, color: String) : this(0F, color){
        this.puntoCualquiera = puntoCualquiera
        this.centro = centro
    }

    fun area(): Double { return radio.pow(2) * Math.PI }

    override fun toString(): String {
        return "Circulo(radio=$radio, color='$color', centro=$centro, puntoCualquiera=$puntoCualquiera)"
    }
}