package Study;

public class Study1123_2 {
	public int solution(int n) {
		int answer = 1;
		int start = 1;
		while (start + start+1 <= n) {
			int sum = start;
			int target = start + 1;
			while (sum + target <= n) {
				if (sum+target == n) {
					answer++;
					break;
				}
				sum += target;
				target++;
			}
			start++;
		}

		String teste ="test";
		return answer;

	}

}

class Test1123_2 {

	public static void main(String[] args) {
		Study1123_2 test = new Study1123_2();
		int n = 15;
		test.solution(n);
	}
}