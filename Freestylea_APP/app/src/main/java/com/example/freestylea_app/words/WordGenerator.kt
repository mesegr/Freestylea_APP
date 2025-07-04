package com.example.freestylea_app.words

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class WordGenerator {

   val base_palabras = arrayOf(
    "sol", "mar", "pan", "voz", "rap", "rey", "luz", "fin", "club", "cruz", "gris", "son", "top", "bar",
    "lago", "río", "nube", "pato", "caja", "duro", "alto", "bajo", "verde", "corto", "grueso", "rojo", "dulce",
    "papel", "lápiz", "ratón", "foca", "llama", "salto", "broma", "lente", "pluma", "plano", "puerta", "rueda",
    "ventana", "camisa", "carro", "árbol", "piedra", "cuerda", "fuego", "sombra", "palma", "monte", "silla",
    "reloj", "tierra", "nieve", "campo", "pueblo", "paso", "pico", "pez", "golpe", "sueño", "corte", "pelo",
    "cara", "boca", "nariz", "pierna", "brazo", "huevo", "fruta", "dedo", "ojo", "lenteja", "gato", "perro",
    "loma", "vela", "cuna", "nido", "pino", "lluvia", "trapo", "dedal", "saco", "libro", "hoja", "roca", "mina",
    "plato", "copa", "vino", "dulce", "sal", "panal", "colmena", "abeja", "mosca", "rata", "cielo", "calle",
    "camino", "pasillo", "punta", "punzón", "lomo", "gorra", "sombrero", "nariz", "parque", "isla", "marzo",
    "abril", "junio", "julio", "otoño", "invierno", "verano", "lunes", "martes", "viernes", "domingo",
    "silla", "mesa", "puente", "banco", "bote", "soga", "cuerda", "calor", "frío", "lento", "rápido", "humo",
    "agua", "tigre", "león", "nube", "sol", "luz", "rayo", "trueno", "noche", "día", "hora", "minuto", "pasado",
    "presente", "futuro", "sello", "carne", "pasto", "grano", "hilo", "toque", "llave", "campo", "cerro",
    "fondo", "altura", "media", "punta", "mitad", "tela", "piedra", "techo", "pared", "suelo", "flor", "rosa",
    "clavo", "sello", "pico", "loma", "zanja", "riego", "pala", "azada", "motor", "cable", "radio", "pulso",
    "brazo", "ojo", "nariz", "cuello", "pecho", "pulgar", "codo", "muslo", "hueso", "hombro", "barro", "arena",
    "viento", "pasto", "hierba", "tronco", "raíz", "nuez", "lente", "tallo", "tapa", "frasco", "jugo", "leche",
    "miel", "manteca", "queso", "pan", "galleta", "pasta", "sopa", "sal", "pimienta","abeja", "abril", "abrila",
    "agua", "alto", "altura", "arena", "azada", "bajo", "banco", "bar", "barro", "boca", "bote", "brazo", "broma",
    "cable", "caja","calle", "calor", "camino","alba", "ámbar", "ancla", "ángel", "ardilla", "astilla", "atlas", "avena",
    "bambú", "banana", "batería", "bebé", "bicicleta", "bikini", "bisagra", "blusa", "búho", "burro",
    "cactus", "café", "canguro", "caracol", "carbón", "carnaval", "carpeta", "cascada", "cepillo", "cerdo",
    "chicle", "chocolate", "ciervo", "cigarra", "cobre", "cohete", "colchón", "cometa", "corazón", "cristal",
    "dados", "delfín", "diamante", "dinosaurio", "diosa", "dragón", "edificio", "elefante", "espejo", "espuma",
    "fábrica", "fantasma", "faro", "fénix", "flauta", "fresa", "gacela", "galaxia", "gamba", "girasol",
    "globo", "guitarra", "hacha", "hámster", "helicóptero", "hielo", "hipopótamo", "hormiga", "horno", "hueso",
    "iglesia", "imán", "isla", "jabalí", "jardín", "jirafa", "joya", "koala", "laberinto", "lágrima",
    "lavanda", "león", "limón", "loro", "maleta", "manzana", "máquina", "mariposa", "máscara", "melón",
    "metralleta", "microscopio", "molino", "montaña", "moto", "naranja", "oceáno", "orquídea", "oso", "pájaro",
    "palacio", "pantalla", "paraguas", "pelícano", "piano", "pingüino", "pirata", "planeta", "plástico", "poción",
    "pulpo", "puma", "queso", "rana", "robot", "sandía", "satélite", "serpiente", "telescopio", "tigre",
    "tortuga", "tren", "unicornio", "vampiro", "violín", "volcán", "yate", "zapato", "zorro", "árbol",
    "fe", "flor", "pez", "rey", "sal", "red", "jaz", "ver", "cru", "nube", "caos", "bíceps", "robot",
    "láser", "púlsar", "clímax", "cóndor", "tíbet", "néctar", "desindustrialización", "avión", "azúcar",
    "héroe", "pánico", "último", "ámbar", "péndulo", "cósmico", "déficit", "ráfaga", "séptimo", "túnel",
    "murciélago", "estrépito", "paréntesis", "catástrofe", "caleidoscopio", "arquetipo", "espiral", "laberinto", "fulgor", "pulsar",
    "electricidad", "automóvil", "paralelepípedo", "asterisco", "hipopótamo", "caleidoscopio", "arqueología", "melodía", "utopía", "fantasía",
    "desoxirribonucleico", "electrodoméstico", "circunferencia", "inconstitucional", "otorrinolaringólogo", "espectacular", "metamorfosis",
    "kaleidoscopio", "arqueológico", "fantasmagórico", "electroencefalograma", "inconstitucionalidad", "otorrinolaringología",
    "interdisciplinariedad", "contrarrevolucionario", "esternocleidomastoideo", "anticonstitucional", "macroeconomicamente", "ultrarrápido",
    "nébula", "tornado", "tsunami", "eclipse", "big bang", "galaxia", "astronauta", "satélite", "robot", "holograma",
    "papiro", "jeroglífico", "pirámide", "legado", "mitología", "leyenda", "oráculo", "profecía", "misterio", "enigma",
    "diamante", "esmeralda", "reliquia", "tesoro", "brillante", "joyero", "alquimia", "hechizo", "dragón", "unicornio",
    "cómic", "superhéroe", "villano", "guerrero", "espada", "escudo", "armadura", "batalla", "victoria", "derrota",
    "sombra", "reflejo", "espejismo", "ilusión", "laberinto", "puerta", "abismo", "vacío", "infinito", "éter",
    "silencio", "eco", "ritual", "grito", "susurro", "sonido", "melodía", "armonía", "discordia", "ruido",
    "fractal", "geometría", "espiral", "caos", "orden", "universo", "átomo", "molécula", "energía", "materia",
    "poesía", "metáfora", "verso", "estrofa", "rima", "ritmo", "cadencia", "improvisación", "creatividad", "inspiración",
    "skate", "blues", "punk", "click", "boom", "flash", "crash", "glam", "trap", "grunge",
    "sprint", "twist", "ghost", "chef", "byte", "pixel", "match", "smash", "clan", "bling",
    "títere", "bólido", "cápsula", "déspota", "fénix", "gólem", "híbrido", "júbilo", "kárate", "líder",
    "máscara", "náufrago", "óxido", "pánico", "quásar", "rápido", "séptimo", "túnel", "último", "vórtice",
    "yóquey", "zócalo", "álbum", "éxtasis", "ícono", "ósmosis", "útero", "bíceps", "cóndor", "dúplex",
    "fósforo", "glúteo", "júpiter", "láser", "máster", "nórdico", "póster", "récord", "sándwich", "tánger",
    "vándalo", "wéstern", "xénero", "yóguin", "zénit", "póker", "rúter", "súper", "tráiler", "cácher",
    "acróbata", "brócoli", "cínico", "dóberman", "esófago", "fórmula", "glándula", "hélice", "íntegro", "júpiter",
    "kárdex", "látex", "médium", "núcleo", "ópera", "párroco", "quórum", "rábano", "séptico", "tímpano",
    "úrsula", "válvula", "wáter", "xénon", "yérsey", "zódiaco", "ángulo", "ébola", "índice", "órgano",
    "ábaco", "éxtasis", "último", "pánico", "ráfaga", "séptimo", "tándem", "vórtice", "círculo", "máscara",
    "pócima", "búmeran", "algoritmo", "psíquico", "tándem", "vórtice", "círculo", "máscara", "pócima", "búmeran",
    "algoritmo", "psíquico", "tándem", "vórtice", "círculo", "máscara", "pócima", "búmeran", "algoritmo", "psíquico",
    "anaconda", "barítono", "caleidoscopio", "dodecaedro", "escarabajo", "farmacia", "gargantilla", "helicóptero", "iconoclasta", "jacarandá",
    "kaleidoscopio", "luminiscencia", "metamorfosis", "nebulizador", "obstinado", "paralelepípedo", "quimerical", "revolucionario", "serendipia", "terremoto",
    "ultimátum", "ventriloquia", "washingtoniano", "xenofobia", "yugoslavo", "zoología", "aristócrata", "biblioteca", "cacofonía", "democracia",
    "espectacular", "fotografía", "geometría", "hipocresía", "idiosincrasia", "jeroglífico", "kafkiano", "laboratorio", "melancolía", "nostalgia",
    "obstinado", "paralelepípedo", "quimerical", "revolucionario", "serendipia", "terremoto", "ultimátum", "ventriloquia", "washingtoniano", "xenofobia",
    "electrocardiograma", "hiperrealidad", "intercontinental", "magnanimidad", "neoliberalismo", "parapsicología", "quintessential", "revolucionarismo", "socioeconómico", "transoceánico",
    "ultrasonografía", "xenotransplante", "electroencefalografía", "inconstitucionalmente", "otorrinolaringología", "desindustrialización", "interdisciplinariedad", "contrarrevolucionario", "macroeconomicamente", "ultrarrápido",
    "fuego rápido", "metal frío", "cristal roto", "eco lejano", "robot sabio", "grito fuerte", "virus letal", "luz brillante", "sombra alargada", "rap sincero",
    "hielo duro", "pluma ligera", "trap callejero", "diamante puro", "labio grueso", "alma noble", "nube oscura", "tinta fresca", "gemelo idéntico", "piel suave",
    "error grave", "caos total", "sello falso", "verbo directo", "pulso firme", "drone veloz", "grito ahogado", "fiebre alta", "sirena hermosa", "lluvia intensa",
    "dolor agudo", "risa falsa", "sangre caliente", "rey justo", "reina cruel", "ángel caído", "demonio astuto", "fantasma solitario", "poeta loco", "mago listo",
    "ninja silencioso", "vaquero valiente", "samurái honorable", "grito desesperado", "susurro dulce", "taco", "brisa", "chapa", "droga", "fango", "grito", "hacha", "jaula", "koala", "lince",
    "mango", "nieve", "olla", "puma", "queso", "rojo", "sable", "tigre", "uva", "vino", "yate", "zorro", "aspa", "bicho", "chino", "dardo", "ficha", "gallo", "horno", "jadeo",
    "kilo", "lujo", "miedo", "nido", "olla", "palo", "queso", "ruso", "sello", "torno", "uña", "vaso", "woke", "yoga", "zurdo", "arco", "balsa", "chivo", "dosis", "firma",
    "lince","asilo","brújula","corteza","tijera","murmullo","esquina","ladrillo","tránsito","grada", "núcleo","baranda","mochila","calceta","campana","patín","alfiler","cuadro","vidrio","mosquitero",
    "carretilla","pizarra","zanco","almohada","sombrilla","moño","estanque","tornillo","tapiz","madriguera","bastón","estribo","linterna","anzuelo","navaja","cascabel","pegamento","esmalte","cepillo","cinturón",
    "pantalla","bandera","chamarra","estante","barrera","bisel","biselado","reja","ventilador","cubo","bocina","carpeta","manija","bisagra","mecedora","brocha","alambre","celda","candado","carcaj",
    "teclado","lienzo","caracol","escotilla","grillete","tijeretazo","esponja","rejilla","gárgara","puñal","cuerda","espátula","manopla","candil","horqueta","balanza","remo","péndulo","aljibe","túnica",
    "cubierta","engranaje","ruiseñor","trinchera","tijeretazo","cortina","zapatilla","galpón","maroma","góndola","pértiga","escoba","carretón","asidero","andamio","guardapolvo","palanquilla","paleta","grapa","gancho",
    "collar","caravana","cintilla","mirilla","cerradura","tapadera","compás","relojero","pizarra","palanca","azotea","andén","pliegue","pasamanos","bisagra","charola","tarima","cloaca","perilla","tablón",
    "chapa","bisel","cortafuegos","mechero","mechón","hendidura","ranura","abrazadera","disfraz","estribillo","ménsula","cuña","barrote","tornillo","roldana","sujeción","manguera","rejilla","retenedor","arnés",
    "fuelle","batuta","pértiga","tapa","clavija","cristalera","alforja","mampara","estribo","pegote","cabestrillo","tendal","ménsula","balcón","gatera","tirador","lupa","embudo","colador","engrapadora",
    "borrador","cubilete","pergamino","manecilla","manija","desarmador","torniquete","gancho","rodillo","palanca","escalón","portón","garrucha","nicho","rejilla","cortapicos","rompeolas","tornapunta","jaladera","ventosa",
    "picaporte","pomo","cabilla","almohadilla","canasto","escotilla","bombilla","palillero","claxon","rejón","tranca","timón","abrelatas","ménsula","clip","estribera","marquesina","felpudo","gatera","cerradura"

   )

   private var job: Job? = null

   private var delay = 10_000L // 10 seconds

    public fun getDelay(): Long {
      return delay
    }

    public fun setDelay(newDelay: Long) {
      delay = newDelay
    }

   fun startWordStream(onWord: (String) -> Unit) {
     job = CoroutineScope(Dispatchers.Main).launch {
       while (true) {
        val word = base_palabras.random()
        onWord(word)
        delay(delay)
       }
     }
   }
}