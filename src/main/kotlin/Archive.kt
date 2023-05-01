class Archive(val name: String): BaseMenuElement() {

    private val notes = mutableListOf<Note>()

    override fun showMenu() {
        commands.apply {
            add(Command(("Добавить заметку в Архив \"${name}\"")) { createNote() })
            for (note in notes) {
                add(Command(note.text) { openNote(notes.indexOf(note)) })
            }
            add(Command(("Выйти из текущего Архива")) { onBack() })
        }
        run()
    }

    private fun openNote(num: Int) {
        val note = notes[num]
        note.showMenu()
    }

    private fun createNote() {
        println("Введите Заметку:")
        val noteText: String = scanner.nextLine()
        val note = Note(noteText)
        notes.add(note)
        commands.add(commands.size-1, Command(noteText) { openNote(notes.indexOf(note)) })
        //println("Note $noteText added to the Archive")
    }
}