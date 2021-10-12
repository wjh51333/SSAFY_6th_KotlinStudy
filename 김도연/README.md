### 💡 Study Diary 도연

<br/><br/>

<details>
  <summary>1st study</summary>
  📅기간 : 2021-07-26 ~ 2021-07-30   
     
  🌱목표
  * kotlin 기본 공부
  * 단계별 문제 풀이 20단계까지 1문제씩풀기
  
  
  |날짜|문제|
  |:--:|:---|
  |**07/26(월)** | 1단계([10869](https://www.acmicpc.net/problem/10869)), 2단계([2884](https://www.acmicpc.net/problem/2884)), 3단계([2439](https://www.acmicpc.net/problem/2439))|
  |**07/27(화)** | 4단계([1110](https://www.acmicpc.net/problem/1110)), 5단계([4344](https://www.acmicpc.net/problem/4344))|
  |**07/28(수)** |6단계([4673](https://www.acmicpc.net/problem/4673)), 7단계([1157](https://www.acmicpc.net/problem/1157)), 8단계([2839](https://www.acmicpc.net/problem/2839))|
  |[**07/29(목)**](#0729목) |9단계([11653](https://www.acmicpc.net/problem/11653)), 10단계([11729](https://www.acmicpc.net/problem/11729)), 11단계([7568](https://www.acmicpc.net/problem/7568)), 12단계([2750](https://www.acmicpc.net/problem/2750)), 18단계([10773](https://www.acmicpc.net/problem/10773)), 15단계([1003](https://www.acmicpc.net/problem/1003)), 16단계([11047](https://www.acmicpc.net/problem/11047))|
  |[**07/30(금)**](#0730금) ||
  
  *   *   *

  #### 07/29(목)

  11 단계 Brute-Force : 문제를 이해하고 정의하는 것을 우선할 것.   
  12 단계 정렬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 카운팅 정렬의 실패   
  17 단계 DP&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 상향식으로 풀이, 하향식은 아직 어려움

  *   *   *

  #### 07/30(금)

  2750 수 정렬하기 : 삽입정렬 잘못 풀음, 다시 풀어야 한다.
</details>

<details>
  <summary>2nd study</summary>
  📅기간 : 2021-08-02 ~ 2021-08-06   

  🌱목표
  * Kotlin으로 기본 자료구조 구현

  📃숙제
  |문제|문제유형|
  |:--:|:------|
  |[네트워크](https://programmers.co.kr/learn/courses/30/lessons/43162)|DFS/BFS|
  |[순위검색](https://programmers.co.kr/learn/courses/30/lessons/72412)||
  |[문자열 압축](https://programmers.co.kr/learn/courses/30/lessons/60057)||
  
   *   *   *
  
  네트워크 빼고 풀지 못함.

</details>


<details>
  <summary>3th study</summary>
  📅기간 : 2021-08-09 ~ 2021-08-13   
  
  🌱목표
  * Kotlin으로 기본 자료구조 구현
  * kotlin의 다양한 함수 공부

  📃숙제
  |문제|문제유형|
  |:--:|:-------|
  |[토마토](https://www.acmicpc.net/problem/7576)|BFS|
  |[유기농 배추](https://www.acmicpc.net/problem/1012)|DFS/BFS|
  |[보물섬](https://www.acmicpc.net/problem/2589)|BFS|

  <br />

  |날짜|문제|
  |:--:|:---|
  |**08/09(월)**| X |
  |[**08/10(화)**](#0810화)|BOJ_7576_토마토|
  |**08/11(수)**| X |
  |[**08/12(목)**](#0812목)|BOJ_1012_유기농배추, BOJ_2589_보물섬|
  |[**08/13(금)**]()||
  
   *   *   *
  
  ### 08/10(화)
  kotlin for문 범위의 다양한 표현
  ```kotlin
  fun forLoop(){
      println("[for] 반복문")
      val items = listOf("apple", "banana", "kiwi")

      // A
      for(item in items) {
          println(item)
      }
      // B
      for(index in 0..(items.size-1)) {
          println("이건 item at $index is ${items[index]}")
      }
      // C
      for(index in 0 until items.size) {
          println("이건 item at $index is ${items[index]}")
      }
      // D
      for(index in items.indices) { //indices -> 0..2
          println("item at $index is ${items[index]}")
      }
  }
  ```

   *   *   *

  ### 08/12(목)
  <br />
  chunked   

  ```kotlin
  s:String.chunked(size:Int)    // return List<String>
  ```
  size는 자를 크기이다.
  ex. size가 2 이면, 2문자씩 문자열을 자르겠다는 의미
  <br />
  Pair   

  ```kotlin
  Pair<T, T> = Pair(value: T, value: T)
  ```
  bfs에서 Pair는 매우 유용

  나의 문제점 : BFS나 DFS의 변수나 범위에서 실수가 잦다.
</details>

<details>
  <summary>4th study</summary>
  📅기간 : 2021-08-16 ~ 2021-08-20   
  
  🌱목표
  * Kotlin으로 기본 자료구조 구현
  * kotlin의 다양한 함수 공부

  📃숙제
  |문제|
  |:--:|
  |[괄호제거](https://www.acmicpc.net/problem/2800)|
  |[최대 힙](https://www.acmicpc.net/problem/11279)|
  |[트리](https://www.acmicpc.net/problem/4256)|
  
   *   *   *
  
  4주차는 한문제도 풀지 못함.
</details>

<details>
  <summary>5th study</summary>
  📅기간 : 2021-08-23 ~ 2021-08-27   
  
  🌱목표
  * Kotlin으로 기본 자료구조 구현
  * kotlin의 다양한 함수 공부
  * kotlin의 기본구조 공부

  📃숙제
  |문제|유형|
  |:--:|:---|
  |[폰_호석만](https://www.acmicpc.net/problem/21275)|수학|
  |[최소 회의실 개수](https://www.acmicpc.net/problem/19598)|그리디|
  |[징검다리 건너기](https://www.acmicpc.net/problem/21317)|DP|

  <br />
  
  |날짜|문제|
  |:--:|:---|
  |**08/23(월)**|X|
  |[**08/24(화)**](#0824화)|폰_호석만|
  |[**08/25(수)**](#0825수)|오답고침|
  |[**08/26(목)**]()||
  |[**08/27(금)**]()||

   *   *   *

  ### 08/24(화)
  폰_호석만 부분 성공 : 22/24   
  부루트 포스 등 알고리즘에 의존하지 않는 문제들을 푸는 것에 익숙해질 필요가 있다.

  ### 08/25(수)
  폰_호석만 성공 : 24/24   
  실패 원인 : for문에서 until을 사용하고 전체크기-1을 해주는 실수를 함.

</details>

<details>
  <summary>6th study</summary>
  📅기간 : 2021-08-30 ~ 2021-09-03   

  🌱목표
  * Kotlin으로 기본 자료구조 구현
  * kotlin의 다양한 함수 공부

  📃숙제
  |문제|문제 유형|
  |:--:|:-------|
  |[상어 초등학교](https://www.acmicpc.net/problem/21608)|시뮬레이션, 구현|
  |[겹치는 건 싫어](https://www.acmicpc.net/problem/20922)|투 포인터|
  |[가장 큰 정사각형](https://www.acmicpc.net/problem/1915)|DP|
</details>

<details>
<summary>7th study</summary>
📅기간 : 2021-09-06 ~ 2021-09-11   

  🌱목표
  * Kotlin으로 기본 자료구조 구현
  * kotlin의 다양한 함수 공부

📃숙제
  |문제|문제 유형|해결|
  |:----:|:----------|:----:|
  |[](https://www.acmicpc.net/problem/)|  |X|
  |[](https://www.acmicpc.net/problem/)|  |X|
  |[](https://www.acmicpc.net/problem/)|  |X|
</details>

<details>
<summary>8th study</summary>
📅기간 : 2021-09-13 ~ 2021-09-17

  🌱목표
  * Kotlin으로 기본 자료구조 구현
  * kotlin의 다양한 함수 공부

📃숙제
  |문제|문제 유형|해결|
  |:----:|:----------|:----:|
  |[구간 나누기 2](https://www.acmicpc.net/problem/13397)|이분 탐색|O|
  |[스도쿠](https://www.acmicpc.net/problem/2580)|백트래킹|O|
  |[같은 수로 만들기](https://www.acmicpc.net/problem/2374)|분할 정복|X|
</details>

<details>
<summary>9th study</summary>
📅기간 : 2021-09-20 ~ 2021-09- 24

  🌱목표
  * Kotlin으로 기본 자료구조 구현
  * kotlin의 다양한 함수 공부

📃숙제
  |문제|문제 유형|해결|
  |:----:|:----------|:----:|
  |[부분 문자열](https://www.acmicpc.net/problem/16916)|문자열, kmp|X|
  |[후위 표기식](https://www.acmicpc.net/problem/1918)|스택|O|
  |[이중 우선순위 큐](https://www.acmicpc.net/problem/7662)|큐, 맵|O|
</details>

<summary>10th study</summary>
📅기간 : 2021-09-27 ~ 2021-09- 30

  🌱목표
  * Kotlin으로 기본 자료구조 구현
  * kotlin의 다양한 함수 공부

📃숙제
  |문제|문제 유형|해결|
  |:----:|:----------|:----:|
  |[트리의 순회](https://www.acmicpc.net/problem/2263)|트리|O|
  |[소수 & 팰린드롬](https://www.acmicpc.net/problem/1747)|수학|O|
</details>

<summary>11th study</summary>
📅기간 : 2021-09-30 ~ 2021-10- 07

  🌱목표
  * Kotlin으로 기본 자료구조 구현
  * kotlin의 다양한 함수 공부

📃숙제
  |문제|문제 유형|해결|
  |:----:|:----------|:----:|
  |[징검다리 건너기](https://www.acmicpc.net/problem/21317)|DP|O|
  |[카드 정렬하기](https://www.acmicpc.net/problem/1715)|그리드, 우선순위큐|O|
  |[팰린드롬?](https://www.acmicpc.net/problem/10942)|DP|O|
</details>