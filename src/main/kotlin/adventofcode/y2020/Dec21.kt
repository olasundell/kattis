package adventofcode.y2020;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec21 {
    fun solve(scanner: Scanner): String {
        val recipes = mutableListOf<Recipe>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            val f = line.split(" (contains ")
            val ingredients = f[0].split(" ")
            val allergens = f[1].replace(")", "").split(", ")

            recipes.add(Recipe(ingredients, allergens))
        }

        val allIngredients = recipes.fold(setOf<String>()) { acc, recipe -> acc + recipe.ingredients }
        val allAllergens = recipes.fold(setOf<String>()) { acc, recipe -> acc + recipe.allergens }

        val allergenIngredients = allAllergens.map { it to allIngredients.toSet() }.toMap().toMutableMap()

        recipes.forEach { recipe ->
            allAllergens.forEach { allergen ->
                if (recipe.allergens.contains(allergen)) {
                    allergenIngredients[allergen] = allergenIngredients[allergen]!!.intersect(recipe.ingredients)
                } else {
                    allergenIngredients[allergen] = allergenIngredients[allergen]!! - recipe.ingredients
                }
            }
        }

        return ""
    }

    data class Recipe(val ingredients: List<String>, val allergens: List<String>)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec21().solve(scanner))
}