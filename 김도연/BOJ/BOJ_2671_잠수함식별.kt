// https://panty.run/boj2671/

fun main() {
    val input = readLine()!!.toCharArray()

    var state = 'S'
    var i = 0
    while (i < input.size) {
        when (state) {
            'S' -> {
                if (input[i] == '0') {
                    if (i+1 < input.size && input[i+1] == '1') {
                        i += 2
                        state = 'A'
                    } else {
                        break
                    }
                } else {
                    i++
                    state = 'B'
                }
            }
            'A' -> {
                if (input[i] == '0') {
                    if (i+1 < input.size && input[i+1] == '1') {
                        i += 2
                    } else {
                        state = 'K'
                        break
                    }
                } else {
                    i++
                    state ='B'
                }
            }
            'B' -> {
                if (input[i] == '0') {
                    i++
                    state = 'C'
                } else {
                    break
                }
            }
            'C' -> {
                if (input[i] == '0') {
                    i++
                    state = 'D'
                } else {
                    break
                }
            }
            'D' -> {
                if (input[i] == '0') {
                    i++
                } else {
                    i++
                    state = 'E'
                }
            }
            'E' -> {
                if (input[i] == '0') {
                    if (i+1 < input.size && input[i+1] == '1') {
                        state = 'A'
                        i += 2
                    } else if(input[i-2] == '1' && input[i-1] == '1') {
                        i++
                        state = 'C'
                    } else {
                        state = 'K'
                        break
                    }
                } else {
                    i++
                }
            }
        }
    }

    val result = if (i == input.size && (state == 'A' || state == 'E')) "SUBMARINE" else "NOISE"
    println(result)
}

/*
refactoring (큰 차이 없음)
fun main() {
    val input = readLine()!!.toCharArray()

    var state = 'S'
    var i = 0
    while (i < input.size) {
        when (state) {
            'S' -> {
                if (input[i] == '0') {
                    if (i+1 < input.size && input[i+1] == '1') {
                        i += 2
                        state = 'A'
                    } else {
                        break
                    }
                } else {
                    i++
                    state = 'B'
                }
            }
            'A' -> {
                if (input[i] == '0') {
                    if (i+1 < input.size && input[i+1] == '1') {
                        i += 2
                    } else {
                        state = 'K'
                        break
                    }
                } else {
                    i++
                    state ='B'
                }
            }
            'B' -> {
                if (input[i] == '0') {
                    i++
                    state = 'C'
                } else {
                    break
                }
            }
            'C' -> {
                if (input[i] == '0') {
                    i++
                    state = 'D'
                } else {
                    break
                }
            }
            'D' -> {
                if (input[i] == '1') {
                    state = 'E'
                }
                i++
            }
            'E' -> {
                if (input[i] == '0') {
                    if (i+1 < input.size && input[i+1] == '1') {
                        state = 'A'
                        i += 2
                    } else if(input[i-2] == '1' && input[i-1] == '1') {
                        i++
                        state = 'C'
                    } else {
                        state = 'K'
                        break
                    }
                } else {
                    i++
                }
            }
        }
    }

    val result = if (i == input.size && (state == 'A' || state == 'E')) "SUBMARINE" else "NOISE"
    println(result)
}
*/

fun main1() {
    val input = readLine()!!
    val result = if(input.matches(Regex("(100+1+|01)+"))) "SUBMARINE" else "NOISE"
    println(result)
}