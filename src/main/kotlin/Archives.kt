import java.util.*

class Archives(private val archives: MutableList<Archive?>){

    private val menu: MutableList<String> = mutableListOf("0 Создать архив", "1 Выход из приложения")

    var posOfExit: Int = menu.size - 1  // хранит в себе индекс кнопки выхода из текущего меню

    fun createNewArchive() {
        println("Введите название архива:")
        val name: String = Scanner(System.`in`).nextLine()

        val newArchive = Archive(name, mutableListOf(null))
        archives.add(newArchive)
        if (archives[0] == null) archives.removeAt(0)
        println("Архив с именем \"$name\" добавлен в список")

        menu.removeAt(menu.size - 1)
        menu.add("${menu.size} $name")
        menu.add("${menu.size} Выход из приложения")
        posOfExit = menu.size - 1

    }

    fun printMenu() {
        println("Список архивов:")
        for (element in menu) {
            println(element)
        }
    }

    fun getArchive(index: Int): Archive {
        return archives[index]!!
    }
}

class Archive(val name: String, private val notes: MutableList<Note?>) {

    private val menu: MutableList<String> = mutableListOf("0 Создать заметку", "1 Вернуться в список архивов")

    var posOfExit: Int = menu.size - 1
    fun createNewNote() {
        println("Введите заметку:")
        val text: String = Scanner(System.`in`).nextLine()

        val newNote = Note(text)
        notes.add(newNote)
        println("Добавлена новая заметка!")

        menu.removeAt(menu.size - 1)
        menu.add("${menu.size} ${if (text.length <= 10) text else text.substring(0, 10) + ".."}")
        menu.add("${menu.size} Вернуться в список архивов")
        posOfExit = menu.size - 1
    }

    fun printMenu() {
        println("Список заметок:")
        for (element in menu) {
            println(element)
        }
    }

    fun getNote(index: Int): Note {
        return notes[index]!!
    }
}

class Note(private val text: String?) {
    private val menu: MutableList<String> = mutableListOf("0 Вывести текст заметки", "1 Вернуться в текущий архив")

    fun printMenu() {
        for (element in menu) {
            println(element)
        }
    }

    fun printNote() {
        println(text)
    }
}