package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class BackJoon1935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<>();
		HashMap<String,Integer> map = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		String expression = br.readLine();
		for (int i = 0; i < N; i++) {
			String tmp = Character.toString((char)(65 + i));
			map.put(tmp,Integer.parseInt(br.readLine()));
		}

		double secondVal = 0;
		double firstVal = 0;
		double res = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '*') {
				secondVal = stack.pop();
				firstVal = stack.pop();
				res = firstVal * secondVal;
				stack.push(res);
			} else if (expression.charAt(i) == '+'){
				secondVal = stack.pop();
				firstVal = stack.pop();
				res = firstVal + secondVal;
				stack.push(res);
			} else if (expression.charAt(i) == '-') {
				secondVal = stack.pop();
				firstVal = stack.pop();
				res = firstVal - secondVal;
				stack.push(res);
			} else if (expression.charAt(i) == '/') {
				secondVal =stack.pop();
				firstVal = stack.pop();
				res = firstVal / secondVal;
				stack.push(res);
			} else {
				String tmp = Character.toString(expression.charAt(i));
				stack.push((double)map.get(tmp));
			}
		}
		System.out.printf("%.2f",stack.pop());
		br.close();
	}

}
