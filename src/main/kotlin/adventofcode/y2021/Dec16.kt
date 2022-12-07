package adventofcode.y2021

import java.util.*

/**
 * TODO write documentation
 */
class Dec16 {
	fun solve(scanner: Scanner): String {
		val n = scanner.next()

		return packet(n).stringify()
	}

	fun packet(inS: String): Packet {
		val s = mapStringRadix(inS)

		/*
		01100010000000001000000000000000000101100001000101010110001011001000100000000010000100011000111000110100

		 */

		return packetRadixedAlready(s)
	}

	private fun packetRadixedAlready(s: String): Packet {
		val (version, typeId) = versionAndType(s)

		return if (typeId == 4) {
			val literal = literal(s.substring(6))
			val r = literal.toLong(2)
			val lit = Literal(version, 6 + (literal.length / 4) * 5, r)
			System.err.println(lit)

			lit
		} else {
			operator(version, typeId, s.substring(6))
		}
	}

	private fun versionAndType(s: String): Pair<Int, Int> {
		val v = s.substring(0..2).toInt(2)
		val t = s.substring(3..5).toInt(2)
		return Pair(v, t)
	}

	private fun mapStringRadix(s: String): String =
		s.map {
			radix(it)
		}.joinToString("")

	fun operator(version: Int, typeId: Int, s: String): Packet {
		val lengthType = s[0]

		/*
	00000000000101100001000101010110001011001000100000000010000100011000111000110100
	ILLLLLLLLLLLLLLL
		 */
		val subPackets = if (lengthType == '0') {
			val length = s.substring(1..15).toInt(2)
			val payload = s.substring(16..(16 + length))

			val packets = mutableListOf<Packet>()

			var l = payload
			while (l.any { it == '1' }) {
				val packet = packetRadixedAlready(l)

				l = if (packet is Literal) {
					l.substring(packet.length)
				} else {
					""
				}

				packets.add(packet)
			}

			packets
		} else {
			/*
			10000000001000000000000000000101100001000101010110001011001000100000000010000100011000111000110100
			ILLLLLLLLLLL
			 */
			val noOfPackets = s.substring(1..11).toInt(2)
			var payload = s.substring(12)

			val subPackets = (0 until noOfPackets).map {
				val p = packetRadixedAlready(payload)
				payload = payload.substring(p.length)
				p
			}

			subPackets
		}

		val l = 6 + if (lengthType == '0') {
			16
		} else {
			12
		}
		val op = Operator(version, typeId, l + subPackets.sumOf { it.sumLength() }, subPackets)
		System.err.println(op)

		return op
	}

	fun literal(s: String): String {
		val more = s[0]
		val packet = s.substring(1..4)

		return packet + if (more == '1') {
			literal(s.substring(5))
		} else {
			""
		}
	}

	abstract class Packet(open val version: Int, open val typeId: Int, open val length: Int) {
		abstract fun stringify(): String
		abstract fun sumVersions(): Int
		abstract fun sumLength(): Int
	}

	data class Literal(
		override val version: Int,
		override val length: Int,
		val value: Long,
	) : Packet(version, 4, length) {
		override fun stringify(): String {
			return "$value";
		}

		override fun sumVersions(): Int = version
		override fun sumLength(): Int = length
	}

	data class Operator(
		override val version: Int,
		override val typeId: Int,
		override val length: Int,
		val packets: List<Packet>
	) : Packet(version, typeId, length) {
		override fun stringify(): String {
			TODO("Not yet implemented")
		}

		override fun sumVersions(): Int = version + packets.sumOf { it.sumVersions() }
		override fun sumLength(): Int = length
	}

	companion object {
		fun revRadix(s: String): Char =
			when (s) {
				"0000" -> '0'
				"0001" -> '1'
				"0010" -> '2'
				"0011" -> '3'
				"0100" -> '4'
				"0101" -> '5'
				"0110" -> '6'
				"0111" -> '7'
				"1000" -> '8'
				"1001" -> '9'
				"1010" -> 'A'
				"1011" -> 'B'
				"1100" -> 'C'
				"1101" -> 'D'
				"1110" -> 'E'
				"1111" -> 'F'
				else -> 'G'
			}

		fun radix(c: Char): String =
			when (c) {
				'0' -> "0000"
				'1' -> "0001"
				'2' -> "0010"
				'3' -> "0011"
				'4' -> "0100"
				'5' -> "0101"
				'6' -> "0110"
				'7' -> "0111"
				'8' -> "1000"
				'9' -> "1001"
				'A' -> "1010"
				'B' -> "1011"
				'C' -> "1100"
				'D' -> "1101"
				'E' -> "1110"
				'F' -> "1111"
				else -> ""
			}
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec16().solve(scanner))
}
