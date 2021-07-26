## study 1th
   
📅기간 : 2021-07-26 ~ 2021-07-30
🌱목표
  - kotlin 기본 공부
  - 단계별 문제 풀이 20단계까지 1문제씩풀기

   
|날짜|문제|
|:--:|:---|
|[**07/26(월)**](#07/26(월))||
|[**07/27(화)**]()||
|[**07/28(수)**]()||
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

#### 🎈Kotlin Arrays
 + array를 만들기 위해 arrayOF() 함수를 사용해야 한다.
 + 배열을 만들고 싶지만 지금 당장 데이터를 넣을 필요가 없다면 arrayOfNulls()를 이용해 미리 자료형과 배열의 크기를 알려주고 만들 수도 있다.
```kotlin
val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
```
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

Kothlin for문 : in
for ( x in cars) {
  println(x)
}

Kothlin Ranges
for (chars in 'a'..'x') {
  println(chars)
}

kothlin 함수
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


return values

fun myFunction(x: Int, y: Int): Int {
  return (x + y)
}

fun main() {
  var result = myFunction(3, 5)
  println(result)
}

// 8 (3 + 5)
======================
fun myFunction(x: Int, y: Int) = x + y

fun main() {
  var result = myFunction(3, 5)
  println(result)
}

// 8 (3 + 5)
