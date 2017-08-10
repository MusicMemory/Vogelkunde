package ninja.javafx.smartcsv.fx.converter

import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.stage.FileChooser
import tornadofx.*

class ConverterFX : App() {
    override val primaryView = FileInputView::class
}

class FileInput {
    var name by property<String>()
    fun nameProperty() = getProperty(FileInput::name)
}

class FileInputView : View("SmartCSV.fx Converter") {
    override val root = GridPane()
    private val fileinput = FileInput()
    private val fileChooser = FileChooser()
    private val state = Label()

    val controller: FileInputController by inject()


    init {
        primaryStage.width = 600.0
        primaryStage.height = 120.0

        fileChooser.title = "Open old config file"
        fileChooser.extensionFilters.addAll(FileChooser.ExtensionFilter("JSON Files", "*.json"))

        with(root) {

            padding = Insets(8.0, 8.0, 8.0, 8.0)

            root.vgap = 8.0
            root.hgap = 8.0

            textfield() {
                isEditable = false
                isDisable = false
                isMouseTransparent = true
                isFocusTraversable = false
                useMaxWidth = true
                bind(fileinput.nameProperty())
                gridpaneConstraints {
                    columnRowIndex(0, 0)
                    hGrow = Priority.ALWAYS
                }
            }

            button("Select File") {
                gridpaneConstraints {
                    columnRowIndex(1, 0)
                }
                setOnAction {
                    state.text = null
                    val selectedFile = fileChooser.showOpenDialog(primaryStage)
                    if (selectedFile != null) {
                        fileinput.name = selectedFile.absolutePath
                    }
                }

            }

            this += state
            state.gridpaneConstraints {
                columnRowIndex(0, 1)
            }


            button("Convert") {
                gridpaneConstraints {
                    columnRowIndex(1, 1)
                }
                setOnAction {
                    controller.convert(fileinput.name)
                    state.text = "converted ${fileinput.name}"
                    fileinput.name = null
                }
                disableProperty().bind(fileinput.nameProperty().isNull)
            }


        }
    }
}

class FileInputController : Controller() {

    fun convert(inputValue: String) {
//        Converter(inputValue).convert()
        println("Converted $inputValue!")
    }
}