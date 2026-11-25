package findTheRunningMedian;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    private static class Entry implements Comparable<Entry> {
        final int val;
        final int idx;

        Entry(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Entry other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.idx, other.idx);
        }
    }
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        TreeSet<Entry> lst = new TreeSet<>();
        List<Double> result = new ArrayList<>();
        Entry median = null;
        for (int i =0; i<a.size();i++){
            Entry cur = new Entry(a.get(i), i);
            int oldSize = lst.size();
            lst.add(cur);
            if(oldSize == 0){
                median = cur;
            } else if (oldSize % 2 ==0) {
                if(cur.compareTo(median)>0){
                    median = lst.higher(median);
                }
            } else{
                if(cur.compareTo(median)<0){
                    median =lst.lower(median);
                }
            }
            double Medval;
            if (lst.size() % 2 == 0){
                Medval = (median.val + lst.higher(median).val) / 2.0;
            } else {
                Medval = median.val;
            }
            result.add(Medval);
        }
        return result;

    }


}



public class findTheRunningMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
