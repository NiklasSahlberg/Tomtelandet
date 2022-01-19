


/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"
Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)
Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydandesom en given person har
Expempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"
För att bli godkänd på uppgiften måste du använda rekursion.
 */

class Tomteland {

    //TODO: skapa en datastruktur för att lagra tomtarna och deras relationer i


    val map = hashMapOf<String, List<String>>()
    val tomtenList = mutableListOf("Glader", "Butter")
    val gladerList = mutableListOf("Tröger", "Trötter", "Blyger")
    val butterList = mutableListOf("Rådjuret", "Nyckelpigan", "Haren","Räven")
    val trötterList = mutableListOf("Skumtomten")
    val skumtomtenList = mutableListOf("Dammråttan")
    val rävenList = mutableListOf("Gråsuggan", "Myran")
    val myranList = mutableListOf("Bladlusen")
    init {
        map.put("Tomten", tomtenList)
        map.put("Glader", gladerList)
        map.put("Butter", butterList)
        map.put("Trötter", trötterList)
        map.put("Skumtomten", skumtomtenList)
        map.put("Räven", rävenList)
        map.put("Myran", myranList)

    }




    // current namn är den tomte vars underlydande ni vill ta fram
    //res är listan som håller alla underlydande
    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        //TODO, skriv denna metod, glöm inte att den ska vara rekursiv!


        if (map.containsKey(currentName)) {
            map[currentName]?.forEach { i ->
                res.add(i)
                res += getUnderlings(i, arrayListOf()) //Rekursion
            }
        }

        return res

    }

    fun main() {

        //Exempel på anrop till den rekursiva funktionen getUnderlings,
        // här är tanken att hitta Gladers underlydande
        //listan fylls på successivt när vi rekurserar
        val tomteland = Tomteland()

        var list: MutableList<String> = mutableListOf()
        println(tomteland.getUnderlings("Glader", list))

    }
}