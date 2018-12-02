package eu.maksimov.advent.year2018.day2

class CorrectBoxesFinder(private val boxes: List<Box>) {

    fun getCommonLetters(): String {
        boxes.forEach { a->
            boxes.forEach { b ->
                if (a.distance(b) == 1) {
                    return a.commonLetters(b)
                }
            }
        }
        return ""
    }

}