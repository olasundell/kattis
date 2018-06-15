import java.io.StreamTokenizer
import java.io.StreamTokenizer.*

/**
 * TODO write documentation
 */
class WordsForNumbers {
    val result = mutableListOf<MutableList<String>>()

    private fun printOrSave(lineStart: Boolean, s: String) {
        print(s)
//        if (lineStart) {
//            result.add(mutableListOf())
//        }
//
//        if (!s.equals("\n")) {
//            result[result.size - 1].add(s)
//        }
    }

    fun solve(tokenizer: StreamTokenizer) : String {
        tokenizer.eolIsSignificant(true)
        tokenizer.ordinaryChar(' '.toInt())
        tokenizer.ordinaryChar(','.toInt())
        tokenizer.ordinaryChar('.'.toInt())
        var lineStart = true

        while (true) {
            when (tokenizer.nextToken()) {
                TT_EOF ->
                    return result.joinToString(separator = "\n", transform = { l -> l.joinToString(separator = "") })
                TT_EOL -> {
                    printOrSave(lineStart, "\n")
                    lineStart = true
                }
                TT_WORD -> {
                    printOrSave (lineStart, tokenizer.sval)
                    lineStart = false
                }
                TT_NUMBER -> {
                    printOrSave(lineStart, mapNumbers(lineStart, tokenizer.nval))
                    lineStart = false
                }
                else -> {
                    printOrSave(lineStart, Character.toString(tokenizer.ttype.toChar()))
                    lineStart = false
                }
            }
        }
    }

    private fun mapNumbers(lineStart: Boolean, s: Double) : String {
        val num = number(s.toInt())
        if (lineStart) {
            return num.capitalize()
        } else {
            return num
        }
    }

    private fun number(toInt: Int): String {
        when (toInt) {
            0 -> return "zero"
            1 -> return "one"
            2 -> return "two"
            3 -> return "three"
            4 -> return "four"
            5 -> return "five"
            6 -> return "six"
            7 -> return "seven"
            8 -> return "eight"
            9 -> return "nine"
            10 -> return "ten"
            11 -> return "eleven"
            12 -> return "twelve"
            13 -> return "thirteen"
            14 -> return "fourteen"
            15 -> return "fifteen"
            16 -> return "sixteen"
            17 -> return "seventeen"
            18 -> return "eighteen"
            19 -> return "nineteen"
            20 -> return "twenty"
            30 -> return "thirty"
            40 -> return "forty"
            50 -> return "fifty"
            60 -> return "sixty"
            70 -> return "seventy"
            80 -> return "eighty"
            90 -> return "ninety"
        }

        val remainder = toInt % 10
        val tenish = toInt - remainder

        return """${number(tenish)}-${number(remainder)}"""
    }
}

fun main(args: Array<String>) {
    val tokenizer = StreamTokenizer(System.`in`.bufferedReader())
    WordsForNumbers().solve(tokenizer)
}