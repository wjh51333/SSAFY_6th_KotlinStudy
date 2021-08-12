## study 2nd
   
📅기간 : 2021-08-09 ~ 2021-08-13  

🌱목표
  - Kotlin으로 기본 자료구조 구현
  - kotlin의 다양한 함수 공부

📃숙제
|문제|
|:--:|
|[토마토](https://www.acmicpc.net/problem/7576)|
|[유기농 배추](https://www.acmicpc.net/problem/1012)|
|[보물섬](https://www.acmicpc.net/problem/2589)|
   
<br /><br />
   
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
