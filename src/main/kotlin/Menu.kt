import java.util.*

class Menu {
    private val archives = Archives(mutableListOf(null))

    fun workInArchivesMenu(archives: Archives = this.archives) {
        while (true) {
            archives.printMenu()
            val num: String = Scanner(System.`in`).nextLine()
            checkInput(num, archives.posOfExit)
            if (num == "0") archives.createNewArchive()
            else if (num == "${archives.posOfExit}") {
                println("Выход из консольного приложения \"Заметки\" произошел успешно")
                return}
            else {
                for (i in 1..archives.posOfExit - 1) {
                    if (num == "$i") {
                        val archive = archives.getArchive(num.toInt() - 1)
                        workInArchiveMenu(archive)
                        break
                    }
                }
            }
        }
    }

    fun workInArchiveMenu(archive: Archive) {
        while (true) {
            archive.printMenu()
            val num: String = Scanner(System.`in`).nextLine()
            checkInput(num, archive.posOfExit)
            if (num == "0") archive.createNewNote()
            else if (num == "${archive.posOfExit}") break
            else {
                for (i in 1..archive.posOfExit - 1) {
                    if (num == "$i") {
                        val note = archive.getNote(num.toInt())
                        workInNoteMenu(note)
                        break
                    }
                }
            }
        }
    }

    fun workInNoteMenu(note: Note) {
        while (true) {
            note.printMenu()
            val num: String = Scanner(System.`in`).nextLine()
            if (num == "0") note.printNote()
            else if (num == "1") break
        }
    }
}


fun checkInput(input: String, maxNum: Int) {
    for (i in input.toCharArray()) {
        if (i < '0' || i > '9') {
            println("Кажется, в Вашем вводе есть символы помимо цифр. \n" +
                    "Повторите ввод.")
            return
        }
    }
    if (input.toInt() > maxNum || input.toInt() < 0) {
        println("Вы ввели число выходящее за рамки нумерации списка.\n" +
                "Введите число от 0 до $maxNum.")
    }
}