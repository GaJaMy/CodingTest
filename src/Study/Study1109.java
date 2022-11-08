package Study;

import java.util.Stack;

public class Study1109 {
	public boolean checkRight(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (s.charAt(i) == ')' && stack.peek() == '(') {
					stack.pop();
				} else if (s.charAt(i) == ']' && stack.peek() == '[') {
					stack.pop();
				} else if ((s.charAt(i) == '}') && stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		}

		return false;
	}
	public int solution(String s) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(s);

		for (int i = 0; i < s.length(); i++) {
			if (checkRight(sb.toString())) {
				answer++;
			}

			char first = sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(first);
		}

		return answer;
	}
}

class Test1109 {

	public static void main(String[] args) {
		Study1109 test = new Study1109();
		String s = "[][]";
		System.out.println(test.solution(s));
	}
}