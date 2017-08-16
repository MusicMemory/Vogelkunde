package gui.start

import domain.BirdRepository
import domain.Config
import domain.Game
import domain.ImageRepository
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class GameVC(val stage: Stage, val difficulty: Int) {

    val game = Game(BirdRepository.noBirds(), Config.noQuestions, Config.noAnswers, difficulty);
    var qCnt = 0

    init {
        GameView.answerBtns.forEach { it.setOnAction(AnswerButtonEventHandler()) }
        setAnswers(qCnt)
        setImage(qCnt)
    }

    inner class AnswerButtonEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            require(qCnt < Config.noQuestions) { "qCnt must be less than $Config.noQuestions" }
            val bntIdx = GameView.answerBtns.indexOf(event.source)

            val isCcorrect = game.isCorrect(qCnt, bntIdx);
            if (isCcorrect) game.addPoints(difficulty)
            GameView.showCorrectness(isCcorrect)

            if (++qCnt >= Config.noQuestions) {
                ResultVC(stage, game.points).show()
            }
            else {
                setAnswers(qCnt)
                setImage(qCnt)
            }
        }
    }

    /**
     * Setzt das Bild zur q-ten Frage in die Image-View
     */
    private fun setImage(q: Int) {
        val birdId = game.questions[q]
        val bird = BirdRepository.birdWithId(birdId)
        val image = ImageRepository.imageWithFileName(bird.filename)
        GameView.setImage(image)
    }

    /**
     * Setzt die Antwort-Möglichkeiten zur q-ten Frage in die Antwort-Buttons
     */
    private fun setAnswers(q: Int) {
        for (a in 0..GameView.answerBtns.size - 1) {
            val birdId = game.answers[q][a]
            val bird = BirdRepository.birdWithId(birdId)
            GameView.answerBtns[a].text = bird.name
        }
    }


    fun show() {
        GameView.show(stage)
    }

}