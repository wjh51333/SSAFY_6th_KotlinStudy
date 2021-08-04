class Solution {
    fun solution(s: String): Int {
        var min = s.length

        for(i in 1..s.length/2) {
            var count = 1
            var compress = ""
            var pattern = ""
            for(j in 0..(s.length + i) step(i)) {
                var now :String

                if(j >= s.length) {
                    now = ""
                } else  if(s.length < j + i) {
                    now = s.substring(j);
                } else {
                    now = s.substring(j, j + i)
                }
                if(j != 0) {
                    if(now.equals(pattern)) {
                        count++
                    } else if(count >= 2) {
                        compress += (count.toString() + pattern)
                        count = 1
                    } else {
                        compress += pattern
                    }
                }
                pattern = now
            }
        
            if(min > compress.length)
                min = compress.length
        }
        return min
    }
}