package BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BackJoon2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, Collections.reverseOrder());
        int max = Integer.MIN_VALUE;
        int minRope = ropes[0];
        for (int i = 0; i < N; i++) {
            if (minRope > ropes[i]) {
                minRope = ropes[i];
            }
            max = Math.max(max,minRope*(i+1));
        }
        System.out.println(max);
        br.close();
    }
}
