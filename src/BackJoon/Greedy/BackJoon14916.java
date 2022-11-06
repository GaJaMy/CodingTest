package BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon14916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int countFive = 0;
		int countFour = 0;
		int count = Integer.MAX_VALUE;
		while (true) {
			int tmpN = N - countFive * 5;
			countFour = 0;
			if (tmpN > 0) {
				if (tmpN % 2 == 0) {
					countFour = tmpN / 2;
				}
			} else {
				if (N % 5 == 0) {
					if (count > (countFive + countFour) && (countFive + countFour) != 0) {
						count = countFive + countFour;
					}
				}
				break;
			}
			if (count > (countFive + countFour) && countFour != 0) {
				count = countFive + countFour;
			}
			countFive++;
		}

		if (count == Integer.MAX_VALUE) {
			count = -1;
		}

		System.out.println(count);
		br.close();
	}
}
