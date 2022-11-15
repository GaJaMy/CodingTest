package Study;

public class Study1115_1 {
    int zeroCount = 0;
    int recurseCount = 0;
    public int[] solution(String s) {
        int[] answer = new int[2];

        recursion(s);

        answer[0] = recurseCount;
        answer[1] = zeroCount;
        return answer;
    }

    public void recursion(String s) {
        if (s.equals("1")) {
            return;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        zeroCount += count;
        recurseCount++;
        String newS = Integer.toBinaryString(s.length()-count);
        recursion(newS);

    }
}

class Test1115 {
    public static void main(String[] args) {
        Study1115_1 test = new Study1115_1();
        test.solution("110010101001");
    }
}