package Study;

import java.util.Arrays;

public class Study1123_1 {
	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);

		for (int i = citations[citations.length - 1]; i >=0; i--) {
			int countUpper = 0;
			int max = -1;
			for (int j = 0; j < citations.length; j++) {
				if (citations[j] >= i) {
					countUpper++;
				} else {
					if (max < citations[j]) {
						max = citations[j];
					}
				}
			}

			if (countUpper >= i && max <= i) {
				answer = i;
				break;
			}
		}
		return answer;
	}
}

class Test1123_1 {
	public static void main(String[] args) {
		Study1123_1 test = new Study1123_1();
		int[] citations = {
			3,0,6,1,5
		};
		test.solution(citations);
	}
}