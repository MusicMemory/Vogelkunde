import javafx.application.Application
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ButtonType
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*

class Sample02TornadoFXApp : App(MyView::class)

class MyView : View() {
    override val root = VBox()

    init {
        root += Button("Press Me")
        root += Label("Waiting")
    }

}

fun nextTwo(num1: Int, num2: Int) = Pair(num1 +1, num2 + 1)

fun fact1(x : Int): Int {
    return if (x <= 1) 1 else x * fact1(x-1)
}

fun fact(x : Int): Int {
    tailrec fun factTail(y: Int, z: Int): Int {
        return if (y == 0) z else factTail(y - 1, y*z)
    }
    return factTail(x, 1)
}


fun main(args: Array<String>) {
    val myArr1 = arrayOf("seor", 2, 4.3)
    val myArr2 = arrayOf("seor", 2, 4.3)
    val (x, y) = nextTwo(1,2)
    println("" + Pair(x, y) + ";  " + arrayOf(1,2,3,4).sum())
    println(fact(3))
    val numList = 1..20
    println(numList.reduce {x, y -> x + y})
    println(numList.fold(5) {x, y -> x + y})
    println(numList.any { it % 2 == 0})
    println(numList.all { it % 2 == 0})

    val mutableList = mutableListOf(1,2,4,7,2,2,2)
    mutableList.add(3)
    mutableList[2] = 12
    do while (mutableList.remove(2))
    println("Hallo: " + mutableList)
    val myList = listOf(1,2,3,4,5)
    require(true) {"Hallo"}
    println(myList[4])

    // Application.launch(Sample02TornadoFXApp::class.java, *args)
}