package com.cmj.examen

fun main(){
    val listaJuegos = listOf(
        Videojuego("Dragon Ball: Sparking ZERO", "PC", 2024),
        Videojuego("Minecraft", "PC", 2013),
        Videojuego("Knightmare", "MSX", 1986)
    )

    println(filtraJuegos(listaJuegos, 2024))

    println(mapaJuegos(listaJuegos))

    println(plataformas(listaJuegos))

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

    championsLeague(listaEquipos)
}

fun filtraJuegos(lista: List<Videojuego>, anio: Int): List<Videojuego>{
    return lista.filter { it.anioSalida == anio }
}

fun mapaJuegos(lista: List<Videojuego>): MutableMap<String, MutableMap<Int, MutableList<String>>> {
    val mapa = mutableMapOf<String, MutableMap<Int, MutableList<String>>>()

    for(juego in lista){
        if(!mapa.containsKey(juego.plataforma)){
            mapa[juego.plataforma] = mutableMapOf()
        }
    }

    var plataformaValue: MutableMap<Int, MutableList<String>>
    for(juego in lista){
        plataformaValue = mapa[juego.plataforma]!!

        if(!plataformaValue.containsKey(juego.anioSalida)){
            plataformaValue[juego.anioSalida] = mutableListOf()
        }

        plataformaValue[juego.anioSalida]?.add(juego.nombre)
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

fun championsLeague(lista: List<EquipoFutbol>){
    val sorteoOctavos = mutableMapOf<EquipoFutbol, EquipoFutbol>()
    val equiposRestantes = lista.toMutableList()

    var equipo1: EquipoFutbol
    var equipo2: EquipoFutbol
    var equipoValido = false

    while(sorteoOctavos.size < 8){
        equipo1 = equiposRestantes.random()

        while(!equipoValido){
            if(!sorteoOctavos.containsKey(equipo1) && !sorteoOctavos.containsValue(equipo1)){
                equipoValido = true
            }else equipo1 = equiposRestantes.random()
        }

        equipoValido = false
        equipo2 = equiposRestantes.random()

        while(!equipoValido){
            if(!sorteoOctavos.containsKey(equipo2) && !sorteoOctavos.containsValue(equipo2)){
                equipoValido = true
            }else equipo2 = equiposRestantes.random()
        }

        sorteoOctavos[equipo1] = equipo2

        equiposRestantes.remove(equipo1)
        equiposRestantes.remove(equipo2)
    }

    sorteoOctavos.forEach{ (eq1, eq2) ->
        println("${eq1.nombre}  - ${eq2.nombre}")
    }
}