package gui.start

import domain.BirdRepository
import domain.Config
import domain.Game
import domain.ImageRepository
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.stage.Stage

class GameVC(val stage: Stage, val difficulty: Int) {

    val game = Game(BirdRepository.noBirds(), Config.noQuestions, Config.noAnswers, difficulty);
    var q = 0

    init {
        GameView.answerBtns.forEach { it.setOnAction(AnswerButtonEventHandler()) }
        GameView.scene.addEventFilter(KeyEvent.KEY_PRESSED, AnswerKeyEventHandler())
        setAnswerTexts(q)
        setImage(q)
    }

    inner class AnswerButtonEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            val bntIdx = GameView.answerBtns.indexOf(event.source)
            handleAnswer(bntIdx)
        }
    }

    inner class AnswerKeyEventHandler : EventHandler<KeyEvent> {
        override fun handle(event: KeyEvent) {
            handleAnswer(when (event.code) {
                KeyCode.DIGIT1 -> 0
                KeyCode.DIGIT2 -> 1
                KeyCode.DIGIT3 -> 2
                KeyCode.DIGIT4 -> 3
                KeyCode.DIGIT5 -> 4
                KeyCode.DIGIT6 -> 5
                KeyCode.DIGIT7 -> 6
                KeyCode.DIGIT8 -> 7
                KeyCode.DIGIT9 -> 8
                else -> return
            })
        }
    }

    /**
     * Behandelt eine Antwort mit dem Wert <code>a</code>
     */
    private fun handleAnswer(a: Int) {
        require(q < Config.noQuestions) { "q=$q must be less than ${Config.noQuestions}" }
        if (a >= Config.noAnswers) return

        val isCcorrect = game.isCorrect(q, a);
        if (isCcorrect) game.addPoints(difficulty)
        GameView.showCorrectness(isCcorrect)

        if (++q >= Config.noQuestions) {
            q = 0; // Wichtig, aber schaebbig
            ResultVC(stage, game.points).show()
        }
        else {
            setAnswerTexts(q)
            setImage(q)
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
    private fun setAnswerTexts(q: Int) {
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