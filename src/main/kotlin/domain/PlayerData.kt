package domain

object PlayerData {
    var difficulty = 1
    var points = 0

    open fun addPoints() {
        this.points += difficulty
        println("Points: $points")
    }

}

