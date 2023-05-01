class Note(val text: String): BaseMenuElement() {

    override fun showMenu() {
        commands.add(Command(("Показать Заметку")) { openTextOfNote() })
        commands.add(Command(("Выйти в текущий Архив")) { onBack() })
        run()
    }

    private fun openTextOfNote() {
        println("Ваша заметка:\n$text")
    }
}