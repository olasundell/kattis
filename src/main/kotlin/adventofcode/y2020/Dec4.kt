package adventofcode.y2020;

import java.util.Scanner;

/**
 * byr (Birth Year)
 * iyr (Issue Year)
 * eyr (Expiration Year)
 * hgt (Height)
 * hcl (Hair Color)
 * ecl (Eye Color)
 * pid (Passport ID)
 * cid (Country ID)
 */
class Dec4 {
    fun solve(scanner: Scanner): String {
        var validPassports = 0

        while (scanner.hasNextLine()) {
            val pp = readNextPassport(scanner)

            if (isValidPassport(pp)) {
                validPassports++
            }

        }

        return "$validPassports"
    }

    fun solve2(scanner: Scanner): String {
        var validPassports = 0

        while (scanner.hasNextLine()) {
            val pp = readNextPassport(scanner)

            if (isValidPassport2(pp)) {
                validPassports++
            }

        }

        return "$validPassports"
    }

    fun readNextPassport(scanner: Scanner): String {
        var pp = ""
        var s = scanner.nextLine()
        while (scanner.hasNextLine() && s.isNotEmpty()) {
            pp += " $s"
            s = scanner.nextLine()
        }

        return pp.trimStart()
    }

    fun isValidPassport(pp: String): Boolean {
        return pp.contains("byr:") && pp.contains("iyr:") && pp.contains("eyr:") &&
            pp.contains("hgt:") && pp.contains("hcl:") && pp.contains("ecl:") &&
            pp.contains("pid:")
    }

    /**
     * byr (Birth Year) - four digits; at least 1920 and at most 2002.
     * iyr (Issue Year) - four digits; at least 2010 and at most 2020.
     * eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
     * hgt (Height) - a number followed by either cm or in:
     * If cm, the number must be at least 150 and at most 193.
     * If in, the number must be at least 59 and at most 76.
     * hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
     * ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
     * pid (Passport ID) - a nine-digit number, including leading zeroes.
     */
    fun isValidPassport2(pp: String): Boolean {
        if (!isValidPassport(pp)) {
            return false
        }

        val split = pp.split(" ").sorted()

        val filtered = split.filter {
            print("$it ")
            when (it.subSequence(0, 3)) {
                "byr" -> !byr(it)
                "iyr" -> !iyr(it)
                "eyr" -> !eyr(it)
                "hgt" -> !hgt(it)
                "hcl" -> !hcl(it)
                "ecl" -> !ecl(it)
                "pid" -> !pid(it)
                "cid" -> false // ignore
                else -> true
            }
        }

        println()

        return filtered.isEmpty()
    }

    fun byr(year: String) = year(year, 1920, 2002)
    fun iyr(year: String) = year(year, 2010, 2020)
    fun eyr(year: String) = year(year, 2020, 2030)

    fun year(year: String, min: Int, max: Int):Boolean {
        val b2 = year.split(":")[1].toIntOrNull() ?: return false

        return b2 in (min..max)
    }

    fun hgt(hgt: String): Boolean {
        val h = hgt.split(":")[1]
        if (h.endsWith("cm")) {
            return (h.split("cm")[0].toIntOrNull() ?: return false) in (150..193)
        } else if (h.endsWith("in")) {
            return (h.split("in")[0].toIntOrNull() ?: return false) in (59..76)
        }

        return false
    }

    fun hcl(hcl: String): Boolean = hcl.matches("^hcl:#[0-9a-f]{6}$".toRegex())

    fun ecl(ecl: String): Boolean = ecl.matches("^ecl:(amb|blu|brn|gry|grn|hzl|oth)$".toRegex())
    fun pid(pid: String): Boolean = pid.matches("pid:\\d{9}".toRegex())
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec4().solve(scanner))
}