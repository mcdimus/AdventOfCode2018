package eu.maksimov.advent.year2018.day8

import java.util.*

class Node(values: Deque<Int>) {

    constructor(values: List<Int>) : this(ArrayDeque(values))
    constructor(vararg values: Int) : this(ArrayDeque(values.toList()))

    val childrenN: Int = values.poll()
    val metadataN: Int = values.poll()
    val children = mutableListOf<Node>()
    val metadata = mutableListOf<Int>()

    init {
        (1..childrenN).mapTo(children) { Node(values) }
        (1..metadataN).mapTo(metadata) { values.poll() }
    }

    fun checksum(): Int = metadata.sum() + children.sumBy { it.checksum() }

    fun value(): Int = if (childrenN > 0) {
        metadata.map { it - 1 }.map { children.getOrNull(it)?.value() ?: 0 }.sum()
    } else metadata.sum()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (childrenN != other.childrenN) return false
        if (metadataN != other.metadataN) return false
        if (children != other.children) return false
        if (metadata != other.metadata) return false

        return true
    }

    override fun hashCode(): Int {
        var result = childrenN
        result = 31 * result + metadataN
        result = 31 * result + children.hashCode()
        result = 31 * result + metadata.hashCode()
        return result
    }

}