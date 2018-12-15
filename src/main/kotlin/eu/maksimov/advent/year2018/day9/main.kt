package eu.maksimov.advent.year2018.day9

fun main() {
    // part 1
    val marbleGame1 = MarbleGame(playersNum = 465, lastMarble = 71_498)
    marbleGame1.play()

    println("What is the winning Elf's score?")
    println(marbleGame1.getWinner().getScore())

    // part 2
    val marbleGame2 = MarbleGame(playersNum = 465, lastMarble = 7_149_800)
    marbleGame2.play()
    println("What would the new winning Elf's score be if the number of the last marble were 100 times larger?")
    println(marbleGame2.getWinner().getScore())
}