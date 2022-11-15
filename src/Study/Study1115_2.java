package Study;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Study1115_2 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
            if (queue.contains(cities[i])) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    if (queue.peek().equals(cities[i])) {
                        queue.poll();
                    } else {
                        queue.add(queue.poll());
                    }
                }
                queue.add(cities[i]);
                answer++;
            } else {
                answer += 5;
                if (queue.size() < cacheSize) {
                    queue.add(cities[i]);
                } else {
                    if (cacheSize != 0) {
                        queue.poll();
                        queue.add(cities[i]);
                    }
                }
            }
        }
        return answer;
    }
}

class Test1115_2 {
    public static void main(String[] args) {
        Study1115_2 test = new Study1115_2();

        int cacheSize = 0;
        String[] cities =
                {
                        "A", "A"
                };
        test.solution(cacheSize,cities);
    }
}