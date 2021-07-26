 fun main() = with(System.`in`.bufferedReader()) {
      val input = readLine().toInt()
      
      for (i in 0 until input) {
          val bag = input - 3 * i

          if (bag < 0) {
              println(-1)
              break
          }
          if (bag.rem(5) == 0) {
              println(i + bag / 5)
              break
          }
      }
  }
