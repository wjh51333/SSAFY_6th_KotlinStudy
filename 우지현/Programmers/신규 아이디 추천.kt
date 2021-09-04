class Solution {
    fun solution(new_id: String): String {
        var answer: String = new_id.toLowerCase()
        answer = answer.replace(("[^-_.a-z0-9]").toRegex(), "")
        answer = answer.replace(("[.]{2,}").toRegex(), ".")
        answer = answer.replace(("^[.]|[.]$").toRegex(), "")

        if (answer.isEmpty()) {
            answer = "a"
        }

        if (answer.length >= 16) {
            answer = answer.substring(0, 15)
            answer = answer.replace(("[.]$").toRegex(), "")
        }

        while (answer.length < 3) {
            answer += answer.last()
        }

        return answer
    }
}