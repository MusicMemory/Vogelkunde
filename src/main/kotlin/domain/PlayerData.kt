package domain

object PlayerData {
    var difficulty = 1
    var points = 0

    fun addPoints() {
        this.points += difficulty
        println("Points: $points")
    }

    fun assignDifficulty(difficulty: Int) {
        this.difficulty = difficulty
        println("Difficulty: $difficulty")
    }

}

