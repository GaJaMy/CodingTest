package BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuffer sb = new StringBuffer();

        int idx = 0;
        int count = 0;
        while (idx < str.length()) {
            if (str.charAt(idx) == 'X') {
                count++;
            } else {
                sb.append(".");
                if (count % 2 != 0) break;
                else count = 0;
            }

            if (count == 4) {
                sb.delete(sb.length()-2,sb.length());
                sb.append("AAAA");
                count = 0;
            } else if (count == 2) {
                sb.append("BB");
            }

            idx++;
        }

        if (count % 2 == 1) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }
        br.close();
    }
}
