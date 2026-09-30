import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        StringBuilder s = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            int type = Integer.parseInt(input[0]);

            if (type == 1) {
                history.push(s.toString());
                s.append(input[1]);
            } else if (type == 2) {
                history.push(s.toString());
                int k = Integer.parseInt(input[1]);
                s.delete(s.length() - k, s.length());
            } else if (type == 3) {
                int k = Integer.parseInt(input[1]);
                System.out.println(s.charAt(k - 1));
            } else if (type == 4) {
                if (!history.isEmpty()) {
                    s = new StringBuilder(history.pop());
                }
            }
        }
    }
}