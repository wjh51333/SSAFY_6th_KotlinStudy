# &#127803; Kotlin 기본 문법 &#127803;





## 목차

[Hello World](#Hello-World)

[Variables](#Variables)

[Data Types](#Data-Types)

[When](#When)

[For Loop](#For-Loop)

[Ranges](#Ranges)

[Functions](#Functions)



------



## Hello World



```kotlin
fun main() {
	println("Hello World")
}
```



------



## Variables



데이터 타입을 지정하지 않아도 변수값에 따라 자동으로 데이터 타입이 지정된다.

데이터 타입을 직접 지정하고 싶을 때는 :를 쓰면 된다.

```kotlin
var name : String = "John" // String
var birthyear = 1998 // Int (number)
```



변수를 초기화하지 않고 선언만 할 때는 데이터 타입을 명시해주어야 한다.

```kotlin
var name : String
name = "Jennie"
println(name)
```



코틀린에서는 2가지 변수 선언 방식이 있다.

- var : 일반적인 변수. 값 변경 가능
- val : 상수. 값 변경 불가능

```kotlin
var name = "John"
name = "Stephen"

val x = 10
x = 20 // error
```



------



## Data Types



##### Numbers

|  Type  | Size (Byte) | suffix | 변환 메서드 |                         Range                          |
| :----: | :---------: | :----: | :---------: | :----------------------------------------------------: |
|  Byte  |      1      |        |  toByte()   |                       -128 ~ 127                       |
| Short  |      2      |        |  toShort()  |                    -32,768 ~ 32,767                    |
|  Int   |      4      |        |   toInt()   |             -2,147,483,648 ~ 2,147,483,647             |
|  Long  |      8      |   L    |  toLong()   | -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,808 |
| Float  |      4      |  f, F  |  toFloat()  |                                                        |
| Double |      8      |        | toDouble()  |                                                        |



##### Booleans



##### Characters

변환 메서드 : toChar()



##### Strings



##### Arrays

배열은 Array라는 별도의 타입으로 표현한다.

arrayOf() 메소드를 사용하여 배열의 생성과 초기화를 함께 수행한다.

컴파일러가 자료형을 유추할 수 있을 때는 자료형을 생략할 수 있다.

```kotlin
var numbers : Array<Int> = arrayOf(1, 2, 3, 4,5)

val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
println(cars[0])

// 값 변경
cars[0] = "Opel"
println(cars[0])

// 배열 크기
println(cars.size)

// element 확인
if ("Volvo" in cars) {
    println("It exists!")
} else {
    println("It does not exist.")
}

```





------



## When



if..else 대신에 when 조건문을 쓸 수 있다.

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

// Outputs "Thursday" (day 4)
```



------



## For Loop



코틀린에서는 for문에 in 키워드를 사용한다.

```kotlin
for (x in 1..3) {
    println(x)
}

for (i in 5 downTo 1) print(i)

for (i in 5 downTo 1 step 2) print(i)

val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")

for (x in cars) {
    println(x)
}
```



아래와 같은 방법으로 for문을 사용하면 오류가 발생한다.

```kotlin
for (int i = 0; i < 4; i++) {
    println(i);
}
```





------



## Ranges



".."으로 범위를 지정할 수 있다.

첫 번째 값과 마지막 값이 범위에 모두 포함된다.

```kotlin
for (chars in 'a'..'x') {
    println(chars)
}

for (nums in 5..15) {
    println(nums)
}

// check if a value exists
val nunms = arrayOf(2, 4, 6, 8)
if (2 in nums) {
    println("It exists!")
} else {
    println("It does not exist.")
}
```





------



## Functions



```kotlin
fun myFunction(fname: String) {
	println(fname + "Doe")
}

fun myFunction2(fname: String, age: Int) {
    println(fname + " is " + age)
}

// return type : Int
fun myFunction3(x: Int): Int {
    return (x + 5)
}

// return 대신 =을 쓸 수 있다
fun myFunction4(x: Int, y: Int) = x + y

fun main() {
    myFunction("Jane") // Jane Doe
    myFunction2("Jennie", 26) // Jennie is 26
    
    var result = myFunction3(3)
    println(result) // 8
    
    result = myFunction4(3, 5)
    println(result) // 8
}

```

