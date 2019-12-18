package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Prerequisites {
    fun solve(scanner: Scanner): String {
        val results = mutableListOf<String>()
        while (true) {
            val s = one(scanner)
            if (s.isEmpty()) {
                break;
            } else {
                results.add(s)
            }
        }

        return results.joinToString(separator = "\n")
    }

    private fun one(scanner: Scanner): String {
        val noOfCoursesTaken = scanner.nextInt()
        if (noOfCoursesTaken == 0) {
            return ""
        }

        val noOfCategories = scanner.nextInt()
        val coursesTaken = mutableSetOf<Int>()
        val categories = mutableSetOf<Category>()

        for (i in 0 until noOfCoursesTaken) {
            coursesTaken.add(scanner.nextInt())
        }

        for (i in 0 until noOfCategories) {
            val coursesInCategory = scanner.nextInt()
            val min = scanner.nextInt()
            val c = mutableSetOf<Int>()
            for (j in 0 until coursesInCategory) {
                c.add(scanner.nextInt())
            }
            categories.add(Category(min, c.toSet()))
        }


        return if (categories.filterNot { c -> enoughInCategory(c, coursesTaken) }.count() == 0) {
            "yes"
        } else {
            "no"
        }
    }

    fun enoughInCategory(c: Category, coursesTaken: Set<Int>): Boolean {
        return countFiltered(c, coursesTaken) >= c.minimum
    }

    private fun countFiltered(c: Category, coursesTaken: Set<Int>) = filterCourses(c, coursesTaken).count()

    private fun filterCourses(c: Category, coursesTaken: Set<Int>) =
            c.courses.filter { course -> coursesTaken.contains(course) }

    data class Category(val minimum: Int, val courses: Set<Int>)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Prerequisites().solve(scanner))
}