import java.util.*

/**
 * Problem : https://leetcode.com/problems/simplify-path/
 * Submission : https://leetcode.com/problems/simplify-path/submissions/1906539623
 */

class Solution71 {
    fun simplifyPath(path: String): String {
        val canonical = Stack<String>()

        var temp: String = ""
        for (c in path) {
            when (c) {
                '/' -> {
                    if (!temp.isEmpty()) {
                        if (temp == "..") {
                            if (!canonical.isEmpty()) canonical.pop()
                        } else if (temp != ".") {
                            canonical.add(temp)
                        }
                        temp = ""
                    }
                }

                else -> {
                    temp += c
                }
            }
        }

        if (temp == "..") {
            if (!canonical.isEmpty()) canonical.pop()
        } else if (!temp.isEmpty() && temp != ".") canonical.push(temp)

        return serialize(canonical)
    }

    fun serialize(paths: List<String>): String {
        if (paths.isEmpty()) return "/"
        var pathStr = ""
        paths.forEach { pathStr += "/" + it }
        return pathStr
    }
}

fun main() {
    val solution = Solution71()
    check(solution.simplifyPath("/home/") == "/home")
    check(solution.simplifyPath("/home//foo/") == "/home/foo")
    check(solution.simplifyPath("/home/user/Documents/../Pictures") == "/home/user/Pictures")
    check(solution.simplifyPath("/../") == "/")
    check(solution.simplifyPath("/.../a/../b/c/../d/./") == "/.../b/d")
}
