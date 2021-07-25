import java.util.Scanner

fun main(args: Array<String>){
    val sc:Scanner = Scanner(System.`in`)
    val count = sc.nextInt()
    val nums = IntArray(count)

    for(i in 0 until count){
        nums[i] = sc.nextInt()
    }

    bubbleSort(nums, count)

    print(nums[0].toString() + " " +  nums[count-1].toString())
}

fun bubbleSort(nums:IntArray, count:Int){
    for(i in 0 until count){
        for (j in 0 until count-i-1){
            if (nums[j] > nums[j+1]){
                val temp:Int = nums[j+1]
                nums[j+1] = nums[j]
                nums[j] = temp
            }
        }
    }
}
