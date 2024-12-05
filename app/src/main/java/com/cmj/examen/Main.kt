package com.cmj.examen

fun main(){
    val listaJuegos = listOf(
        Videojuego("Dragon Ball: Sparking ZERO", "PC", 2024),
        Videojuego("Minecraft", "PC", 2013),
        Videojuego("Knightmare", "MSX", 1986)
    )

    //println(filtraJuegos(listaJuegos, 2024))

    //mapaJuegos(listaJuegos)

    //print(plataformas(listaJuegos))

    val listaEquipos = listOf(
        EquipoFutbol("Equipo1", "Pais1"),
        EquipoFutbol("Equipo2", "Pais1"),
        EquipoFutbol("Equipo3", "Pais1"),
        EquipoFutbol("Equipo4", "Pais1"),
        EquipoFutbol("Equipo5", "Pais2"),
        EquipoFutbol("Equipo6", "Pais2"),
        EquipoFutbol("Equipo7", "Pais2"),
        EquipoFutbol("Equipo8", "Pais2"),
        EquipoFutbol("Equipo9", "Pais3"),
        EquipoFutbol("Equipo10", "Pais3"),
        EquipoFutbol("Equipo11", "Pais3"),
        EquipoFutbol("Equipo12", "Pais3"),
        EquipoFutbol("Equipo13", "Pais4"),
        EquipoFutbol("Equipo14", "Pais4"),
        EquipoFutbol("Equipo15", "Pais4"),
        EquipoFutbol("Equipo16", "Pais4")
    )
}

fun filtraJuegos(lista: List<Videojuego>, anio: Int): List<Videojuego>{
    return lista.filter { it.anioSalida == anio }
}

fun mapaJuegos(lista: List<Videojuego>): MutableMap<String, MutableList<String>> {
    val mapa = mutableMapOf<String, MutableList<String>>()

    for(juego in lista){
        if(!mapa.containsKey(juego.plataforma)){
            mapa[juego.plataforma] = mutableListOf()
        }

        mapa[juego.plataforma]?.add(juego.nombre)
    }

    return mapa
}

fun plataformas(lista: List<Videojuego>): MutableList<String> {
    val plataformas = mutableListOf<String>()

    var plataforma: String
    for(juego in lista){
        plataforma = juego.plataforma

        if(!plataformas.contains(plataforma)){ plataformas.add(plataforma) }
    }

    return plataformas
}