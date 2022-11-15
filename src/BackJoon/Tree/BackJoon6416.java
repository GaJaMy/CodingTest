package BackJoon.Tree;

import org.omg.CORBA.MARSHAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BackJoon6416 {
    public static class Node {
        int val;
        HashSet<Integer> child;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }
    public static class Tree {
        Node root;

        Tree() {
            root = null;
        }

        Tree(int val) {
            root = new Node();
            root.val = val;
        }

        public boolean insert(Pair pair) {
            Node cur = root;


            return true;
        }
    }
    public static class Pair {
        int s;
        int e;

        Pair() {

        }

        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = 1;
        while (true) {
            String tmp = br.readLine();
            HashSet<Integer> allNodes = new HashSet<>();
            HashSet<Integer> incomeNodes = new HashSet<>();
            ArrayList<Pair> pairs = new ArrayList<>();
            int s = -1;
            int e = -1;
            while (!tmp.isEmpty()) {
                StringTokenizer st = new StringTokenizer(tmp);
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());

                allNodes.add(s);
                allNodes.add(e);
                incomeNodes.add(e);

                if ((s == 0 && e == 0)||(s == -1 && e == -1)) {
                    break;
                }
                pairs.add(new Pair(s,e));

                tmp = br.readLine();
            }

            int count = 0;
            int root = -1;
            for (Integer node : allNodes) {
                if (!incomeNodes.contains(node)) {
                    count++;
                    root = node;
                }
            }

            if (count == 0 || count > 1) {
                System.out.println("Case " + caseNum + "is not a tree");
            }



            if (s == -1 && e == -1) {
                break;
            }
            caseNum++;
        }
    }
}
