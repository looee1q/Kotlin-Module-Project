class Command(private val name: String, val action: (num: Int) -> Unit){

    override fun toString(): String {
        return (if (name.length <= 40) name else name.substring(0, 40) + "..")
    }
}