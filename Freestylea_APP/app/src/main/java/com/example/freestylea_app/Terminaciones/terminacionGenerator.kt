package com.example.freestylea_app.Terminaciones

class terminacionGenerator {

    val Terminaciones = arrayOf("-ar","-er","-ir","-or","-ur",
        "-al","-el","-il","-ol","-ul",
        "-an","-en","-in","-on","-un",
        "-as","-es","-is","-os","-us",
        "-am","-em","-im","-om","-um",
        "-at","-et","-it","-ot","-ut",
        "-ap","-ep","-ip","-op","-up",
        "-ab","-eb","-ib","-ob","-ub",
        "-ad","-ed","-id","-od","-ud",
        "-ac","-ec","-ic","-oc","-uc",
        "-af","-ef","-if","-of","-uf",
        "-ag","-eg","-ig","-og","-ug",
        "-aj","-ej","-oj","-az","-ez","-iz","-oz","-uz",
        "-av","-ev","-iv","-ov","-uv",
        "-ado","-ido","-edo","-udo","-ando","-iendo","-endo",
        "-ente","-ante","-iente","-mente","-cente","-sente",
        "-oso","-osa","-uoso","-uosa","-eso","-esa",
        "-ino","-ina","-ano","-ana","-eno","-ena","-uno","-una",
        "-illo","-illa","-ello","-ella","-ullo","-ulla",
        "-ote","-ota","-ete","-eta","-ito","-ita",
        "-azo","-aza","-eño","-eña","-izo","-iza",
        "-ario","-aria","-orio","-oria","-ivo","-iva","-evo","-eva",
        "-able","-ible","-uble",
        "-ón","-ona","-ún","-una","-ín","-ina",
        "-ucho","-ucha")


    fun getRandomTerminacion(onWord: (String) -> Unit) {
        val word = Terminaciones.random()
        onWord(word)
    }


}