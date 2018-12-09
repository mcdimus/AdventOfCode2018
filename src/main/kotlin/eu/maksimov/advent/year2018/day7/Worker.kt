package eu.maksimov.advent.year2018.day7

data class Worker(val id: Int) {

    private var workProgress = 0

    var task: Step? = null
        set(value) {
            field = value
            workProgress = 0
        }

    fun doWork() {
        workProgress++
    }

    fun isReady(): Boolean {
        return workProgress == task?.timeToComplete
    }

    override fun toString(): String {
        return "Worker(id=$id, workProgress=$workProgress, task=${task?.name})"
    }

}