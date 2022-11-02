package Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Study1101_2 {
	public HashMap<String,Integer> map = new HashMap<>();
	public void dfs(String str, StringBuilder sb,int idx, int count, int targetCount) {
		if (count == targetCount) {
			map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
		}

		for (int i = idx; i < str.length(); i++) {
			sb.append(str.charAt(i));
			dfs(str,sb,i+1,count+1,targetCount);
			sb.delete(count,count+1);
		}
	}
	public String[] solution(String[] orders, int[] course) {
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			for (int j = 0; j < orders.length; j++) {
				char[] charArr = orders[j].toCharArray();
				Arrays.sort(charArr);
				StringBuilder sb = new StringBuilder();
				dfs(new String(charArr),sb,0,0,course[i]);
			}

			int max = 2;
			for (Map.Entry<String,Integer> entry : map.entrySet()) {
				if (entry.getValue() >= max) {
					max = entry.getValue();
				}
			}

			for (Map.Entry<String,Integer> entry : map.entrySet()) {
				if (max == entry.getValue()) {
					list.add(entry.getKey());
				}
			}
		}

		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		Arrays.sort(answer);
		return answer;
	}
}

class Test {

	public static void main(String[] args) {
		Study1101_2 study1101_2 = new Study1101_2();
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2, 3, 5};
		study1101_2.solution(orders,course);
	}
}