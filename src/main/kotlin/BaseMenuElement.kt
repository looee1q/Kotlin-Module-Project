import java.util.*

abstract class BaseMenuElement {

    protected val commands = mutableListOf<Command>()
    protected val scanner = Scanner(System.`in`)
    private var isRunning: Boolean = true

    abstract fun showMenu()

    protected fun run() {
        while (isRunning) {
            commands.forEachIndexed { index, command ->
                println("$index. $command")
            }
            val input: String = scanner.nextLine()
            if (checkInput(input, commands.size - 1)) {
                val num = input.toInt()
                commands[num].action.invoke(num)
            }
        }
    }

    protected fun onBack() {
        isRunning = false
    }

    private fun checkInput(input: String, maxNum: Int): Boolean {
        for (i in input.toCharArray()) {
            if (i < '0' || i > '9') {
                println("Кажется, в Вашем вводе есть символы помимо цифр. \n" +
                        "Повторите ввод.")
                return false
            }
        }
        if (input.toInt() > maxNum || input.toInt() < 0) {
            println("Вы ввели число выходящее за рамки нумерации списка.\n" +
                    "Введите число от 0 до $maxNum.")
            return false
        }
        return true
    }
}