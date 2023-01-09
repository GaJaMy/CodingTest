package Programmers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class KaKaoBlind2023_1 {
	public int[] solution(String today, String[] terms, String[] privacies) {
		ArrayList<Integer> list = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDate todayDt = LocalDate.parse(today,formatter);

		HashMap<String,Integer> typeMap = new HashMap<>();

		for (String term : terms) {
			StringTokenizer st = new StringTokenizer(term);
			typeMap.put(st.nextToken(),Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < privacies.length; i++) {
			StringTokenizer st = new StringTokenizer(privacies[i]);
			LocalDate inputDt = LocalDate.parse(st.nextToken(),formatter);
			String inputType = st.nextToken();

			if (inputDt.plusMonths(typeMap.get(inputType).intValue()).minusDays(1).isBefore(todayDt)) {
				list.add(i+1);
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}

class Test2023_1 {
	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {
			"A 6", "B 12", "C 3"
		};
		String[] privacies = {
			"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"
		};
		KaKaoBlind2023_1 kaKaoBlind2023_1 = new KaKaoBlind2023_1();
		kaKaoBlind2023_1.solution(today,terms,privacies);
	}
}
