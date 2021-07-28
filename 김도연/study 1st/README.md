## study 1st
   
📅기간 : 2021-07-26 ~ 2021-07-30
🌱목표
  - kotlin 기본 공부
  - 단계별 문제 풀이 20단계까지 1문제씩풀기

   
|날짜|문제|
|:--:|:---|
|[**07/26(월)**](#0726월) | 1단계([10869](https://www.acmicpc.net/problem/10869)), 2단계([2884](https://www.acmicpc.net/problem/2884)), 3단계([2439](https://www.acmicpc.net/problem/2439))|
|[**07/27(화)**](#0727화)| 4단계([1110](https://www.acmicpc.net/problem/1110)), 5단계([4344](https://www.acmicpc.net/problem/4344))|
|[**07/28(수)**]()|6단계([4673](https://www.acmicpc.net/problem/4673)), 7단계([1157](https://www.acmicpc.net/problem/1157)), 8단계([2839](https://www.acmicpc.net/problem/2839))|
|[**07/29(목)**]()||
|[**07/30(금)**]()||

   *   *   *
   
### 07/26(월)

#### 🎈변수 타입
  + var : 수정 가능한 변수
  + val : 수정 불가능한 변수

kotlin은 변수의 타입을 이해할 정도로 충분히 똑똑하나 개발자가 의도적으로 타입을 구체화하는 것도 가능.
```kotlin
var name = "John"      // String (text)
val birthyear = 1975   // Int (number)

println(name)          // Print the value of name
println(birthyear)     // Print the value of birthyear
```
```kotlin
var name: String = "John" // String
val birthyear: Int = 1975 // Int

println(name)
println(birthyear)
```
타입을 명시할 경우에만 초기화 없이 선언 가능
```kotlin
var name: String
name = "John"
println(name)		// (o)
```
```kotlin
var name
name = "John"
println(name)		// (x)
```

#### 🎈kotlin변수의 일반적인 규칙들은
1. 변수명들은 문자, 숫자, \_, $를 포함할 수 있다.
2. 변수명들은 문자로 시작해야한다.
3. 변수명들은 또한 $와 \_로 시작할 수 있다.(그러나 이것들만 쓸 수는 없다.)
4. 변수명들은 대소문자를 구분한다. (myVar != myvar)
5. 변수명들은 소문자로 시작하는 것이 좋으며, 공백을 포함할 수 없다.
6. 예약어(var, String 등)는 변수명으로 사용할 수 없다.

#### 🎈데이터 타입
  - Numbers
    + Integer types : Byte, Short, Int, Long
    + Floating point types : Float, Double
  - Booleans
    + Boolean (true, false)
  - Characters
    + Char
      >(** java와 다르게 ASCII 값으로 특정 문자를 사용할 수 없다. **)
      > > ```kotlin
      > >val myLetter: Char = 66
      > >println(myLetter) // Error
      > >```
  - Strings
    + String

#### 🎈타입 변환
 - var는 값은 변경할 수 있지만 다른 타입 값은 넣을 수 없다. 굳이 타입을 바꾸고 싶다면, 강제 형변환(coerce)을 통해 가능하다.
 - 자바와 다르게 자동형변환이 불가능하다.
```kotlin
val x: Int = 5
val y: Long = x
println(y) // Error: Type mismatch
```
 - 반드시 다음의 함수들을 사용하여 변환해야한다.   
    : toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble() or toChar()
```kotlin
val x: Int = 5
val y: Long = x.toLong()
println(y)
```

#### 🎈Kotlin은 다음의 그룹으로 연산자들을 나눈다.
 - 산수 연산자
 - 할당 연산자
 - 비교 연산자
 - 논리 연산자

#### 🎈String Concatenation
```kotlin
var firstName = "John"
var lastName = "Doe"
println(firstName + " " + lastName)
```
```kotlin
var firstName = "John "
var lastName = "Doe"
println(firstName.plus(lastName))
```

#### 🎈String Templates/Interpolation
```kotlin
var firstName = "John"
var lastName = "Doe"
println("My name is $firstName $lastName")
```

#### 🎈Kothlin if .. else expressions
if .. else 명령문을 표현식으로 사용 가능하다.
```kotlin
fun main() {
  val time = 20
  val greeting = if (time < 18) {
    "Good day."
  } else {
    "Good evening."
  }
  println(greeting)
}
```
명령문이 한줄이면 {}생략가능
```kotlin
fun main() {
  val time = 20
  val greeting = if (time < 18) "Good day." else "Good evening."
  println(greeting)
}
```

#### 🎈Kothlin when
자바의 switch문과 유사하다. 단, case마다 break할 필요 없다.
```kotlin
val day = 4

val result = when (day) {
  1 -> "Monday"
  2 -> "Tuesday"
  3 -> "Wednesday"
  4 -> "Thursday"
  5 -> "Friday"
  6 -> "Saturday"
  7 -> "Sunday"
  else -> "Invalid day."
}
println(result)
```

#### 🎈kotlin 함수
```kotlin
fun myFunction(fname: String, age: Int) {
  println(fname + " is " + age)
}

fun main() {
  myFunction("John", 35)
  myFunction("Jane", 32)
  myFunction("George", 15)
}

// John is 35
// Jane is 32
// George is 15
```

#### 🎈return values
```kotlin
fun myFunction(x: Int, y: Int): Int {
  return (x + y)
}

fun main() {
  var result = myFunction(3, 5)
  println(result)
}

// 8 (3 + 5)
```
```kotlin
fun myFunction(x: Int, y: Int) = x + y

fun main() {
  var result = myFunction(3, 5)
  println(result)
}

// 8 (3 + 5)
```

   *   *   *
   
### 07/27(화)
   
   
#### 🎈Kotlin Arrays
 1. 라이브러리 함수를 사용하는 방법
   >|함수|설명|
   >|:---:|:----|
   >|arrayOf(value...)|선언과 동시에 값들을 초기화|
   >|arrayOfNulls(size)|크기만 지정하고 값은 나중에 저장, 지정된 크기만큼 null값 세팅|
   > ```kotlin
   > val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")    // ["Volvo", "BMW", "Ford", "Mazda"]
   > val nums = arrayOfNulls<Int>(3)      // [null, null, null]
   > ```
 2. 생성자를 사용하는 방법
   > |생성자|예시|설명|
   > |:----:|:--:|:---|
   > |Array(size, 람다식)|Array(5, {i -> i}|[0, 1, 2, 3, 4]로 초기화|
   > |xxxArray(size)|IntArray(3)|[0, 0, 0] 로 초기화 된 Int 형 배열|
   > ```kotlin
   > val array: Array<Int> = Array(5, {i -> 0})    // [0, 0, 0, 0]
   > val array2: Array<Int> = Array(5) { i -> sc.nextInt() }   // Scanner 사용, 입력받은 순서대로 배열에 초기화
   > val array3 = IntArray(5)    // [0, 0, 0, 0, 0]
   > ```
 3. Boxing을 발생시키지 않는 배열 생성
    Primitive type의 배열을 생성할 때, 위와 같이 Array 클래스로 생성하게 되면 Wrapping으로 인한 Boxing 발생
    코틀린에서는 Primitive type에 한해서 각각의 특수 클래스를 제공
   > |클래스|
   > |:----:|
   > |xxxArrayOf(value...)|
   > ```kotlin
   > val array: IntArray = intArrayOf(1, 2, 3)    // [1, 2, 3]
   > val array2: DoubleArray = doubleArrayOf(0.5, 0.2)   // [0.5, 0.2]
   > val array3: BooleanArray = booleanArrayOf(true, false)    // [true, false]
   > ```
 + val은 변경이 불가능한 것이 맞다. 하지만, 참조가 가리키는 객체의 내부값은 변경이 가능하다.

#### 🎈요소 유무 체크
```kotlin
val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
if ("Volvo" in cars) {
  println("It exists!")
} else {
  println("It does not exist.")
}
```

#### 🎈Kotlin for문 : in
```kotlin
for ( x in cars) {
  println(x)
}
```

#### 🎈Kotlin Ranges
```kotlin
for (chars in 'a'..'x') {
  println(chars)     // a, b, c, d, ... , x
}

for (ints in 1..10) {
  println(ints)      // 1, 2, 3, ..., 9, 10
}
   
for (ints in 1..10 step 2) {
   println(ints)     // 1, 3, 5, 7, 9
}
```

감소는 downTo
```kotlin
for (chars in 'x' downTo 'a') {
  println(chars)
}

for (ints in 10 downTo 1) {
  println(ints)      // 10, 9, 8, ... , 2, 1
}

for (ints in 10 downTo 1 step 2) {
  println(ints)      // 10, 8, 6, 4, 2
}
```
until
```kotlin
   for (ints in 1 until 10) {
  println(ints)      // 1, 2, ..., 8, 9
}
```
   
#### 🎈 Input
 1. java의 Input들 사용
   >```kotlin
   > val sc = Scanner(System.`in`)
   >```
 2. readLine
   >```kotlin
   > val s = readLine()
   > var n = readLine()!!.toInt()      // !! null값이 아니다. null값을 받을 수 없다
   > var tmp = readLine()?.toString()  // ? null값일 수도 있다.
   >```
