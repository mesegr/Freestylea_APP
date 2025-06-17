package com.example.freestylea_app.themes

class ThemeGenerator {

    val Tematicas = arrayOf("películas", "animales", "frutas", "colores", "países", "objetos", "personajes", "lugares", "profesiones", "tecnología",
        "deportes", "videojuegos", "música", "danza", "vehículos", "comida", "instrumentos", "planetas", "universo", "mitología",
        "monstruos", "fantasía", "superhéroes", "villanos", "robots", "hadas", "dragones", "caballeros", "piratas", "ninjas",
        "samuráis", "castillos", "reinos", "ciudades", "islas", "mares", "ríos", "montañas", "bosques", "desiertos",
        "selvas", "océanos", "volcanes", "cuevas", "animales marinos", "aves", "insectos", "reptiles", "anfibios", "mamíferos",
        "peces", "dinosaurios", "criaturas mágicas", "fantasmas", "zombies", "vampiros", "hombres lobo", "extraterrestres", "planetas lejanos", "galaxias",
        "estrellas", "constelaciones", "cohetes", "astronautas", "exploradores", "arqueología", "historia", "prehistoria", "edad media", "futuro",
        "steampunk", "cyberpunk", "época victoriana", "far west", "época romana", "antiguo egipto", "china antigua", "japón feudal", "grecia antigua", "ciencia ficción",
        "terror", "comedia", "romance", "aventura", "misterio", "crimen", "espionaje", "superpoderes", "magia", "hechiceros",
        "brujas", "alquimia", "literatura", "cómics", "anime", "manga", "series", "documentales", "pintura", "fotografía",
        "cine", "teatro", "circo", "parques", "museos", "playas", "lagos", "puertos", "carreteras", "puentes",
        "edificios", "rascacielos", "casas", "barrios", "aldeas", "granjos", "plantas", "flores", "árboles", "gemas",
        "joyas", "ropa", "accesorios", "herramientas", "armas", "espadas", "escudos", "arcos", "lanzas", "pistolas",
        "tanques", "aviones", "barcos", "submarinos", "trenes", "bicicletas", "coches clásicos", "coches deportivos", "camiones", "globos aerostáticos",
        "drones", "ordenadores", "inteligencia artificial", "realidad virtual", "biotecnología", "medicina", "salud", "química", "física", "biología",
        "astronomía", "ecología", "medio ambiente", "reciclaje", "energías renovables", "clima", "terremotos", "huracanes", "tormentas", "arcoíris",
        "amanecer", "atardecer", "nocturno", "espiritualidad", "religión", "valores", "amistad", "amor", "familia", "infancia",
        "festividades", "navidad", "halloween", "carnaval", "pascua", "san valentín", "día de muertos", "año nuevo", "viajes", "camping", "laberintos",
        "espejos", "sombras", "ruinas", "cementerios", "grafitis","drogas", "adicciones", "salud mental", "autoayuda",)


    fun getRandomTheme(onWord: (String) -> Unit) {
        val word = Tematicas.random()
        onWord(word)
    }


}