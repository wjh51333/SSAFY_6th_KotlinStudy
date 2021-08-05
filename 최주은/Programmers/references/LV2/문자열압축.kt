import java.util.*
class Solution {
    data class Word(
        val word : String,
        var count : Int = 1
    )
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE
        for(space in 1..s.length) {
            val compressedWordList = LinkedList<Word>()
            var startIndex = 0
            var endIndex = 0
            while(endIndex != s.length) {
                endIndex = (startIndex + space).let {
                    if(it > s.length) s.length
                    else it
                }
                val currentWord = s.substring(startIndex, endIndex)
                if(compressedWordList.isEmpty() || compressedWordList.peekLast().word != currentWord) compressedWordList.add(Word(currentWord))
                else compressedWordList.peekLast().count++
                startIndex = endIndex
            }
            val length = compressedWordList.fold(0) {
                acc, word ->
                acc + word.word.length + if(word.count == 1) 0 else {
                    word.count.toString().length
                }
            }
            if(length < answer) answer = length
        }
        return answer
    }
}
