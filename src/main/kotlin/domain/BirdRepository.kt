package domain

import org.apache.commons.csv.CSVFormat
import java.io.InputStreamReader
import java.io.Reader


object BirdRepository {

    val birds = mutableListOf<Bird>()

    init {
        // lesen aus der CSV-Datei
        var reader: Reader? = null
        try {
            val stream = javaClass.getResourceAsStream("/birds.csv")
            reader = InputStreamReader(stream)
            val records = CSVFormat.EXCEL.withDelimiter(';').withHeader().parse(reader)
            for (r in records) {
                val bird = Bird(r["filename"], r["name"], r["order"], r["difficulty"].toInt())
                birds.add(bird)
                println(bird)
            }
        } catch (e: Exception) {
            if (reader != null) reader.close()
        }
    }

    fun saveBird(id: Int, bird: Bird): Unit {
        birds[id] = bird
    }

    fun birdWithId(id: Int): Bird {
        return birds[id]
    }

    fun noBirds(): Int {
        return birds.size;
    }

}

fun main(args: Array<String>) {
    BirdRepository
}