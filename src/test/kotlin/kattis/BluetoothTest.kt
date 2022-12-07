package kattis

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
internal class BluetoothTest : AbstractKotlinTest() {
    @Test
    fun jawShouldHaveLeftAndRightBlueFalseDefault() {
        val jaw = Bluetooth.defaultJaw()

        assertEquals(false, jaw.isLeftSideBlue())
        assertEquals(false, jaw.isRightSideBlue())
    }

    @Test
    fun jawShouldHaveLeftTrue() {
        val jaw = Bluetooth.defaultJaw()
        val leftSideBlue = jaw + ("+1" to Bluetooth.Toothy.BLUE)

        assertEquals(true, leftSideBlue.isLeftSideBlue())
        assertEquals(false, leftSideBlue.isRightSideBlue())
    }

    @Test
    fun jawShouldHaveRightTrue() {
        val jaw = Bluetooth.defaultJaw()
        val rightSideBlue = jaw + ("1+" to Bluetooth.Toothy.BLUE)

        assertEquals(false, rightSideBlue.isLeftSideBlue())
        assertEquals(true, rightSideBlue.isRightSideBlue())
    }

    @Test
    fun jawCanChewRight() {
        val jaw = Bluetooth.defaultJaw()

        assertEquals(true, jaw.canChewRight())
    }

    @Test
    fun jawCanChewLeft() {
        val jaw = Bluetooth.defaultJaw()

        assertEquals(true, jaw.canChewLeft())
    }

    @Test
    fun one() {
        runTest(1, Bluetooth()::solve)
    }

    @Test
    fun two() {
        runTest(2, Bluetooth()::solve)
    }

    @Test
    fun three() {
        runTest(3, Bluetooth()::solve)
    }

    @Test
    fun four() {
        runTest(4, Bluetooth()::solve)
    }
}