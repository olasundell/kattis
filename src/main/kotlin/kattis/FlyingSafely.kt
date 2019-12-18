package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class FlyingSafely {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        return (1..n).map { testCase(scanner) }.joinToString(separator = "\n") { it.toString() }
    }

    private fun testCase(scanner: Scanner): Int {
        val cities = scanner.nextInt()
        val pilots = scanner.nextInt()

        val edges = mutableMapOf<Int, Set<Int>>()
        val vertices = mutableSetOf<Int>()

        val arr: Array<IntArray> = Array(cities) { IntArray(cities) { -1 } }

        repeat(pilots) {
            val key = scanner.nextInt()
            val value = scanner.nextInt()
            vertices.add(key)
            vertices.add(value)

            arr[key][value] = 1
            arr[value][key] = 1

            edges.compute(key) { _: Int, u: Set<Int>? -> u?.plus(value) ?: setOf(value) }
            edges.compute(value) { _: Int, u: Set<Int>? -> u?.plus(key) ?: setOf(key) }
        }

        val result = dijkstra(Graph(vertices, edges), 1)
//        shortestPath<Int>(edges.toMap(), 1, cities)

        return result.size - 1
    }

    data class Graph<T>(
            val vertices: Set<T>,
            val edges: Map<T, Set<T>>
//            ,
//            val weights: Map<Pair<T, T>, Int>
    )

    fun <T> dijkstra(graph: Graph<T>, start: T): Map<T, T?> {
        val S: MutableSet<T> = mutableSetOf() // a subset of vertices, for which we know the true distance
        val delta = graph.vertices.map { it to Int.MAX_VALUE }.toMap().toMutableMap()
        delta[start] = 0
        val previous: MutableMap<T, T?> = graph.vertices.map { it to null }.toMap().toMutableMap()
        while (S != graph.vertices) {
            val v: T = delta
                    .filter { !S.contains(it.key) }
                    .minBy { it.value }!!
                    .key
            graph.edges.getValue(v).minus(S).forEach { neighbor ->
                val newPath = delta.getValue(v) // + graph.weights.getValue(Pair(v, neighbor))
                if (newPath < delta.getValue(neighbor)) {
                    delta[neighbor] = newPath
                    previous[neighbor] = v
                }
            }
            S.add(v)
        }
        return previous.toMap()
    }

    fun floydWarshall(weights: Array<IntArray>, nVertices: Int) {
        val dist = Array(nVertices) { DoubleArray(nVertices) { Double.POSITIVE_INFINITY } }
        for (w in weights) dist[w[0] - 1][w[1] - 1] = w[2].toDouble()
        val next = Array(nVertices) { IntArray(nVertices) }
        for (i in 0 until next.size) {
            for (j in 0 until next.size) {
                if (i != j) next[i][j] = j + 1
            }
        }
        for (k in 0 until nVertices) {
            for (i in 0 until nVertices) {
                for (j in 0 until nVertices) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]
                        next[i][j] = next[i][k]
                    }
                }
            }
        }
    }

    fun <T> shortestPath(shortestPathTree: Map<T, T?>, start: T, end: T): List<T> {
        fun pathTo(start: T, end: T): List<T> {
            if (shortestPathTree[end] == null) return listOf(end)
            return listOf(pathTo(start, shortestPathTree[end]!!), listOf(end)).flatten()
        }
        return pathTo(start, end)
    }
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(FlyingSafely().solve(scanner))
}