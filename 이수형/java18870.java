import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class java18870 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            input[i] = temp;
            arr[i] = temp;
        }
        Arrays.sort(arr);
        int cnt = 0;
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            if (temp.get(arr[i])==null) {
                temp.put(arr[i], cnt++);
            }
        }


        for (int i = 0; i < N; i++) {
            System.out.print(temp.get(input[i])+" ");
        }

    }
}
