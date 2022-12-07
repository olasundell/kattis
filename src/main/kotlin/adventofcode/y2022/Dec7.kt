package adventofcode.y2022;

import java.util.*

class Dec7 {
	private val cdCmdRxp = """[$] cd (.*)""".toRegex()
	private val lsCmdRxp = """[$] ls""".toRegex()
	private val fileRxp = """(\d+) (.*)""".toRegex()
	private val dirRxp = """dir (.*)""".toRegex()
	fun solve(scanner: Scanner): String {
		val root = createTree(scanner)
		val dirs = findDirs(root, 100_000)

		return "${dirs.sumOf { it.totalSize() }}"
	}

	fun solve2(scanner: Scanner): String {
		val root = createTree(scanner)
		val dirs = findDirs(root, 70_000_000).sortedByDescending { it.totalSize() }

		val remainingSpace = 70_000_000 - root.totalSize()
		val spaceNeeded = 30_000_000 - remainingSpace

		val i = dirs.indexOfFirst { it.totalSize() <= spaceNeeded }

		return "${dirs[i - 1].totalSize()}"
	}

	private fun createTree(scanner: Scanner): Dir {
		var line = scanner.nextLine()
		val root = Dir(name = "/", parent = null)
		var currentDir = root

		while (scanner.hasNextLine()) {
			if (line.matches(cdCmdRxp)) {
				val (dirName) = cdCmdRxp.matchEntire(line)!!.destructured
				currentDir = if (dirName == "..") {
					currentDir.parent!!
				} else if (dirName == "/") {
					root
				} else {
					currentDir.subDirs.find { it.name == dirName } ?: Dir(parent = currentDir, name = dirName)
				}

				if (scanner.hasNextLine()) {
					line = scanner.nextLine()
				}
			} else if (line.matches(lsCmdRxp)) {
				while (scanner.hasNextLine()) {
					line = scanner.nextLine()
					if (fileRxp.matches(line)) {
						val (size, name) = fileRxp.matchEntire(line)!!.destructured
						currentDir.add(File(size.toLong(), name))
					} else if (dirRxp.matches(line)) {
						val (name) = dirRxp.matchEntire(line)!!.destructured
						currentDir.add(Dir(parent = currentDir, name = name))
					} else {
						break
					}
				}
			}
		}
		return root
	}

	private fun findDirs(dir: Dir, maxSize: Long): List<Dir> {
		val dirs = dir.subDirs
			.flatMap { findDirs(it, maxSize) }
			.filter { it.totalSize() <= maxSize }

		if (dir.totalSize() <= maxSize) {
			return dirs + dir
		} else {
			return dirs
		}
	}

	data class Dir(
		val name: String,
		val parent: Dir?,
		val subDirs: MutableList<Dir> = mutableListOf(),
		val files: MutableList<File> = mutableListOf()
	) {
		fun totalSize(): Long {
			val tSize = subDirs.sumOf { it.totalSize() }
			val fSize = files.sumOf { it.size }

			return tSize + fSize
		}

		fun add(file: File) {
			this.files.add(file)
		}

		fun add(dir: Dir) {
			this.subDirs.add(dir)
		}

		operator fun plus(more: List<Any>): Dir {
			if (more.isEmpty()) {
				return this
			}

			if (more[0] is File) {
				this.files.addAll(more as List<File>)
			} else {
				this.subDirs.addAll(more as List<Dir>)
			}

			return this
		}

		override fun toString(): String {
			return "Dir(name='$name', parent='${parent?.name ?: "null"}', subDirs=$subDirs, files=$files)"
		}
	}

	data class File(val size: Long, val name: String)
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec7().solve(scanner))
}