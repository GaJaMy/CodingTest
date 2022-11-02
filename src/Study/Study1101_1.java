package Study;

import java.util.Arrays;

public class Study1101_1 {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int idx = 0;
		for (int i = 0; i < people.length; i++) {
			if (people[i] > limit - 40) {
				idx = i;
				break;
			}
		}

		answer+=people.length - idx;

		int p1 = 0;
		int p2 = idx - 1;
		while (p1 <= p2){
			if (people[p1] + people[p2] <= limit) {
				answer++;
				p1++;
				p2--;
			} else if (people[p1] + people[p2] > limit){
				p2--;
				answer++;
			}
		}
		return answer;
	}
}

class Test1101_1{
	public static void main(String[] args) {
		int[] people = {70,80,50};
		Study1101_1 study1101_1 = new Study1101_1();
		study1101_1.solution(people,100);
	}
}
