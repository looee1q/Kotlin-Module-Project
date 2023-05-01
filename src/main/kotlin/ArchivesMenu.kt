class ArchivesMenu: BaseMenuElement() {

    private val archives = mutableListOf<Archive>()

    override fun showMenu() {
        commands.apply {
            add(Command(("Создать Архив")) { createArchive() })
            for (archive in archives) {
                add(Command(archive.name) { openArchive(archives.indexOf(archive)) })
            }
            add(Command(("Выйти из приложения")) { onBack() })
        }
        run()
        println("Выход из консольного приложения \"Заметки\" произошел успешно.")
    }

    private fun openArchive(num: Int) {
        val archive = archives[num]
        //println("Вы находитесь в Архиве \"${archive.name}\".")
        archive.showMenu()
    }

    private fun createArchive() {
        println("Введите название Архива:")
        val name: String = scanner.nextLine()
        val archive =  Archive(name)
        archives.add(archive)
        commands.add(commands.size-1, Command(name) { openArchive(archives.indexOf(archive)) })
        println("Архив \"$name\" добавлен в список.")
    }
}