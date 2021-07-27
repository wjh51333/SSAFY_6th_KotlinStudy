import java.util.Scanner

class `7568` {
}

class people{
    var height:Int = 0
    var weight:Int = 0
    var rankCount:Int = 0
}

fun main() = with(Scanner(System.`in`)) {
    val memberCount:Int = nextInt()

    val member:Array<people> = Array<people>(memberCount) {people()}

    for (i in 0 until memberCount){
        member[i].weight = nextInt()
        member[i].height = nextInt()
    }

    for (i in 0 until memberCount){
        for (j in 0 until memberCount){
            if(member[i].height < member[j].height && member[i].weight < member[j].weight) member[i].rankCount++
        }
    }

    for (i in 0 until memberCount)
        println(member[i].rankCount+1)
}
