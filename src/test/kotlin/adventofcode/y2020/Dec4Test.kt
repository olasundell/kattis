package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec4Test : AbstractKotlinTest() {
    @Test
    fun simple1() {
        val input = """ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:183cm

iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
hcl:#cfa07d byr:1929

hcl:#ae17e1 iyr:2013
eyr:2024
ecl:brn pid:760753108 byr:1931
hgt:179cm

hcl:#cfa07d eyr:2025 pid:166559648
iyr:2011 ecl:brn hgt:59in"""

        val result = Dec4().solve(Scanner(input))

        assertEquals("2", result)
    }

    @Test
    fun one() {
        runTest(1, Dec4()::solve)
    }

    @Test
    fun two() {
        runTest(1, Dec4()::solve2)
    }

    @Test
    fun validate() {
        val pp = """pid:827837505 byr:1976
hgt:187cm
iyr:2016
hcl:#fffffd
eyr:2024"""

        val d = Dec4()

        val result = d.isValidPassport(d.readNextPassport(Scanner(pp)))

        assertFalse(result)

    }

    @Test
    fun validate2() {
        val pp = """hgt:189cm byr:1987 pid:572028668 iyr:2014 hcl:#623a2f
eyr:2028 ecl:amb"""

        val d = Dec4()

        val result = d.isValidPassport(d.readNextPassport(Scanner(pp)))

        assertFalse(result)
    }

    @Test
    fun simple2() {
        val input = """ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:183cm

iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
hcl:#cfa07d byr:1929

hcl:#ae17e1 iyr:2013
eyr:2024
ecl:brn pid:760753108 byr:1931
hgt:179cm

hcl:#cfa07d eyr:2025 pid:166559648
iyr:2011 ecl:brn hgt:59in"""

        val result = Dec4().solve2(Scanner(input))

        assertEquals("2", result)
    }
}