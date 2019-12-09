import java.lang.System.err
import java.util.Scanner

/**
 * TODO write documentation
 */
class CountingStars {
    fun solve(scanner: Scanner): String {
        val results = mutableListOf<Int>()
        while (scanner.hasNextLine()) {
            val ySize = scanner.nextInt()
            val xSize = scanner.nextInt()
            scanner.nextLine()

            val s = ""
            val lines: List<List<Char>> = (1..ySize).map { scanner.nextLine() }.map { it.chunked(1).map { str -> str[0] } }

//            results.add(stars(lines))
            results.add(twoPass(lines))
        }
        return results.mapIndexed { index, i -> "Case ${index + 1}: $i" }.joinToString(separator = "\n")
    }

    fun stars(lines: List<List<Char>>): Int {
        val starPoints = mutableSetOf<Point>()

        for (y in lines.indices) {
            for (x in lines[y].indices) {
                if (lines[y][x] == '-') {
                    starPoints.add(Point(x, y))
                }
            }
        }

        var stars = 0

        while (starPoints.isNotEmpty()) {
            val visited = visit(starPoints, starPoints.first())
            starPoints.removeAll(visited)
            stars++
        }

        return stars
    }

    fun visit(points: Set<Point>, p: Point): Set<Point> {
        val neigh = points.neighbours(p)
        val disjoin = points.filterNot { it in neigh || it == p }.toSet()
        val ret = neigh.flatMap { visit(disjoin, it) }.toSet().plus(p)
        return ret
    }

    data class Point(val x: Int, val y: Int) {
        fun up(): Point = Point(this.x, this.y - 1)
        fun left(): Point = Point(this.x - 1, this.y)
        fun down(): Point = Point(this.x, this.y + 1)
        fun right(): Point = Point(this.x + 1, this.y)
        fun neighs(): Set<Point> = setOf(up(), left(), down(), right())
        fun inside(x: Int, y: Int): Boolean = this.x in 0 until x && this.y in 0 until y
    }

    fun Set<Point>.neighbours(p: Point): Set<Point> = this.filter { it in p.neighs() }.toSet()

    fun Set<Point>.hasNeighbour(p: Point): Boolean = this.contains(p.up()) || this.contains(p.down()) || this.contains(p.left()) || this.contains(p.right())

    /*
    fun hoshenKopelman(lines: List<List<Char>>) {
//        Raster Scan and Labeling on the Grid
        val result = Array(lines.size) { IntArray(lines[0].size) }

//        val labels = mutableMapOf<

        var largestLabel = 0
        for (y in lines.indices) {
            for (x in lines[y].indices) {
                if (lines[y][x] == '-') {
                    val left = lines[y][x - 1]
                    val above = lines[x][y - 1]
                    if (left == '#' && above == '#') { /* Neither a label above nor to the left. */
                        largestLabel += 1; /* Make a new, as-yet-unused cluster label. */
                        result[y][x] = largestLabel
                    } else if (left != '#' && above == '#') { /* One neighbor, to the left. */
                        result[y][x] = find(left)
                    } else if (left == '#' && above != '#') { /* One neighbor, above. */
                        result[x, y] = find(above)
                    } else { /* Neighbors BOTH to the left and above. */
                        union(left, above); /* Link the left and above clusters. */
                        result[y][x] = find(left);
                    }
                }
            }
        }
    }

    fun union(x: Int, y: Int, labels)  {
        labels[find(x)] = find(y);
    }
    fun find(int x): Int  {
        int y = x;
        while (labels[y] != y)
            y = labels[y];
        while (labels[x] != x)  {
            int z = labels[x];
            labels[x] = y;
            x = z;
        }
        return y;
    }
*/
    fun twoPass(lines: List<List<Char>>): Int {
        val linked = mutableMapOf<Int, Set<Point>>()
        val reverse = mutableMapOf<Point, Int>()
        var label = 0
        // first pass
        for (y in lines.indices) {
            for (x in lines[y].indices) {
                if (lines[y][x] == '-') {
                    val point = Point(x, y)
                    val neighs = setOf(point.up(), point.left()).filter { it.inside(lines[y].size, lines.size) }.filter { lines[it.y][it.x] == '-' }.toSet()
                    
                    if (neighs.isEmpty()) {
                        linked.compute(label) { _: Int, u: Set<Point>? -> u?.plus(point) ?: setOf(point) }
                        reverse[point] = label
                        label++
                    } else {
                        val l = neighs.filter{ reverse.containsKey(it) } .map { reverse[it]!! }.toSortedSet().firstOrNull() ?: label
                        linked.compute(l) { _: Int, u: Set<Point>? -> u?.plus(point) ?: setOf(point) }
                        reverse[point] = l
                    }
                }
            }
        }

        // second pass

//        for row in data
        for (y in lines.indices) {
//        for column in row
            for (x in lines[y].indices) {
//        if data[row][column] is not Background
//                labels[row][column] = find(labels[row][column])
                if (lines[y][x] == '-') {
//                    labels
                }
            }
        }


        err.println(lines.mapIndexed{ y, list -> list.mapIndexed { x, c -> if (c == '-') reverse[Point(x, y)] else c }.joinToString(separator = "") }.joinToString(separator="\n") + "\n")
//            { it.map { if (it == '-') reverse } }
//
        return label
    }
    /*
    algorithm TwoPass(data)
   linked = []
   labels = structure with dimensions of data, initialized with the value of Background

   First pass

   for row in data:
       for column in row:
           if data[row][column] is not Background

               neighbors = connected elements with the current element's value

               if neighbors is empty
                   linked[NextLabel] = set containing NextLabel
                   labels[row][column] = NextLabel
                   NextLabel += 1

               else

                   Find the smallest label

                   L = neighbors labels
                   labels[row][column] = min(L)
                   for label in L
                       linked[label] = union(linked[label], L)

   Second pass

   for row in data
       for column in row
           if data[row][column] is not Background
               labels[row][column] = find(labels[row][column])

   return labels
     */
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(CountingStars().solve(scanner))
}
