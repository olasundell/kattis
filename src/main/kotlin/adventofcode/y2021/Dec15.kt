package adventofcode.y2021;

import kattis.FlyingSafely
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec15 {
	fun solve(scanner: Scanner): String {
		val nodes = mutableListOf<List<Node>>()

		while (scanner.hasNextLine()) {
			val element = scanner.nextLine().map { c -> Node(c.digitToInt()) }
			nodes.add(element)
		}

		val edges = mutableMapOf<Node, Set<Node>>()

		nodes.forEachIndexed { y, list ->
			list.forEachIndexed { x, node ->
				val es = mutableSetOf<Node>()
				if (y > 0) {
					es.add(nodes[y-1][x])
				}

				if (y < nodes.size - 1) {
					es.add(nodes[y+1][x])
				}

				if (x > 0) {
					es.add(nodes[y][x-1])
				}

				if (x < list.size - 1) {
					es.add(nodes[y][x+1])
				}

				edges[nodes[y][x]] = es
			}
		}

		val graph = FlyingSafely.Graph(nodes.flatMap { it.toSet() }.toSet(), edges)
		val path = FlyingSafely.dijkstra(graph, nodes[0][0])

		val s = path.map { it.key.n }.sum()

		return "$s"
	}

	data class Node(val n: Int)

	/*
 function Dijkstra(Graph, source):

     for each vertex v in Graph.Vertices:
         dist[v] ← INFINITY
         prev[v] ← UNDEFINED
         add v to Q
     dist[source] ← 0

     while Q is not empty:
          u ← vertex in Q with min dist[u]
          remove u from Q

          for each neighbor v of u still in Q:
              alt ← dist[u] + Graph.Edges(u, v)
              if alt < dist[v]:
                  dist[v] ← alt
                  prev[v] ← u

      return dist[], prev[]

	 */
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec15().solve(scanner))
}