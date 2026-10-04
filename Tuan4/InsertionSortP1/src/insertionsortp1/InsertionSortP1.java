package insertionsortp1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static void insertionSort1(int n, List<Integer> arr) {
        int i = n-1;
        int key = arr.get(i);
        int j = i-1;
        while (j >= 0 && arr.get(j)>key ){
            arr.set(j+1,arr.get(j));
            j--;
            for (int num:arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }
        arr.set(j+1, key);
        for (int num:arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class InsertionSortP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
