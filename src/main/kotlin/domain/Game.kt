package domain

class Game(noBirds: Int, noQuestions: Int, noAnswers: Int, difficulty: Int) {

    val MAX_ITERATIONS = 100;
    var points = 0
    var questions = IntArray(noQuestions)
    var answers = Array<IntArray>(noQuestions, {t -> IntArray(0)})

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
                throw Exception("Probably there are not enough birds present with difficulty " + difficulty)
            }

            // Liste answers mit Zahlen (ID) füllen ohne Wiederholung ohne gleichen Namen
            var answerList = mutableListOf<Int>()
            counter = 0
            while (answerList.size < noAnswers && counter++ < MAX_ITERATIONS) {
                val birdIdCandidate = randInt(noBirds)
                // Der zu ratende Vogel soll erst mal nicht in den möglichen Antwortkandidaten vorkommen:
                // Später wird dann einer durch die richtige Antwort ersetzt
                val birdNameCandidate = BirdRepository.birdWithId(birdIdCandidate).name
                val birdNameQuestion = BirdRepository.birdWithId(questions[q]).name
                if (birdNameCandidate.equals(birdNameQuestion)) continue

                val isCandidateDuplicate = answerList.any { a ->
                    val birdNameAnswer = BirdRepository.birdWithId(a).name
                    birdNameCandidate.equals(birdNameAnswer)
                }
                if (!isCandidateDuplicate) answerList.add(birdIdCandidate)
            }
            if (counter >= MAX_ITERATIONS) {
                throw Exception("Probably there are not enough birds present: " + noBirds)
            }
            // richtige Antwort zufällig unter den bisherigen Antworten platzieren (überschreiben)
            val posRightAnswer = randInt(noAnswers)
            answerList[posRightAnswer] = questions[q]
            answers[q] = answerList.toIntArray()
        }
        // Debug-Ausgabe der gewählen zu erratenden Bilder und der möglichen Antworten
        var imageCnt = 0
        for (answerSet in answers) {
            println("${imageCnt + 1}. Image ${questions[imageCnt++]} -> Answers ${answerSet.toList()}")
        }
    }// init

    fun randInt(upperBound: Int) : Int {
        return (Math.random() * upperBound).toInt()
    }

    open fun getQuestion(q: Int): Pair<Int, IntArray> {
        return Pair(questions[q], answers[q])
    }

    open fun isCorrect(q: Int, a: Int): Boolean {
        val correct = questions[q] == answers[q][a]
        println("Answer: $a, correct: $correct")
        return correct
    }

    open fun addPoints(points: Int) {
        this.points += points
        println("Points: $points")
    }
}

fun main(args: Array<String>) {
    Game(200, 10, 4, 3)
}