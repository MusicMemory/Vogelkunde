package domain

class Game(noBirds: Int, noQuestions: Int, noAnswers: Int, difficulty: Int) {

    val MAX_ITERATIONS = 222;
    val questions = IntArray(noQuestions)
    val answers = Array<IntArray>(noQuestions, {IntArray(0)})

    init {
        for (q in 0..noQuestions-1) {
            var counter = 0;
            while (counter++ < MAX_ITERATIONS) {
                val birdIdCandidate = randInt(noBirds)
                val birdCandidate = BirdRepository.birdWithId(birdIdCandidate)
                // Alle Vögel sollen die Schwierigkeit difficulty haben
                if (!(birdIdCandidate in questions) && birdCandidate.difficulty == difficulty) {
                    questions[q] = birdIdCandidate
                    break
                }
            }
            // Wenn weniger Vögel vorhanden sind als gebraucht, würde das hier zu einer Exception führen:
            if (counter >= MAX_ITERATIONS) {
                throw Exception("Probably, there are not enough birds present with difficulty $difficulty.")
            }

            // Liste answers mit Zahlen (ID) füllen ohne Wiederholung ohne gleichen Namen
            val answerList = mutableListOf<Int>()
            counter = 0
            while (answerList.size < noAnswers && counter++ < MAX_ITERATIONS) {
                val birdIdCandidate = randInt(noBirds)
                // Der zu ratende Vogel soll erst mal nicht in den möglichen Antwortkandidaten vorkommen:
                // Später wird dann einer durch die richtige Antwort ersetzt
                val birdCandidate = BirdRepository.birdWithId(birdIdCandidate)
                val birdQuestion = BirdRepository.birdWithId(questions[q])

                val birdNameQuestion = BirdRepository.birdWithId(questions[q]).name
                if (birdCandidate.name == birdNameQuestion) continue
                if (birdCandidate.difficulty != birdQuestion.difficulty) continue
                if (birdCandidate.order !== birdQuestion.order && counter < MAX_ITERATIONS/2) continue

                val isCandidateDuplicate = answerList.any { a ->
                    val birdNameAnswer = BirdRepository.birdWithId(a).name
                    birdCandidate.name == birdNameAnswer
                }
                if (!isCandidateDuplicate) {
                    answerList += birdIdCandidate
                    // println("Difficulty ${birdCandidate.difficulty}, Order ${birdCandidate.order}, Name ${birdCandidate.filename}")
                }
            }
            // println("==================================================")
            if (counter >= MAX_ITERATIONS) {
                throw Exception("Probably, there are not enough ($noBirds) birds present.")
            }
            // richtige Antwort zufällig unter den bisherigen Antworten platzieren (überschreiben)
            val posRightAnswer = randInt(noAnswers)
            answerList[posRightAnswer] = questions[q]
            answers[q] = answerList.toIntArray()
        }
        // Debug-Ausgabe der gewählten zu erratenden Bilder und der möglichen Antworten
        var imageCnt = 0
        for (answerSet in answers) {
            println("${imageCnt + 1}. Image ${questions[imageCnt++]} -> Answers ${answerSet.toList()}")
        }
    }// init

    fun randInt(upperBound: Int) : Int {
        return (Math.random() * upperBound).toInt()
    }

    fun isCorrect(q: Int, a: Int): Boolean {
        val correct = questions[q] == answers[q][a]
        println("Answer: $a, correct: $correct")
        return correct
    }

}

fun main(args: Array<String>) {
    Game(200, 10, 4, 3)
}