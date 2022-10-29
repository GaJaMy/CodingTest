package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BackJoon10866 {
	public static class Node {
		int val;
		Node next;

		Node() {

		}

		Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
	public static class MyDeque {
		int size;
		Node front;
		Node back;

		MyDeque() {
			this.size = 0;
			this.front = null;
			this.back = null;
		}

		public void push_front(int val) {
			if (size == 0) {
				this.front = this.back = new Node(val);
				size++;
				return;
			}
			Node newNode = new Node(val);
			newNode.next = this.front;
			this.front = newNode;
			size++;
		}

		public void push_back(int val) {
			if(size == 0){
				this.front = this.back = new Node(val);
				size++;
				return;
			}
			Node newNode = new Node(val);
			this.back.next = newNode;
			this.back = newNode;
			size++;
		}

		public int pop_front() {
			if (size == 0) {
				return -1;
			}
			int result = this.front.val;
			this.front = this.front.next;
			size--;
			return result;
		}

		public int pop_back() {
			if (size == 0) {
				return -1;
			} else if (size == 1) {
				int result = this.back.val;
				this.front = null;
				this.back = null;
				size--;
				return result;
			}
			int result = this.back.val;

			Node cur = this.front;

			while (cur.next.next != null) {
				cur = cur.next;
			}

			this.back = cur;
			cur.next = null;
			size--;

			return result;
		}

		public int size() {
			return this.size;
		}

		public int empty(){
			if (this.size == 0) {
				return 1;
			}
			return 0;
		}

		public int front() {
			if (size == 0) {
				return -1;
			}
			return this.front.val;
		}

		public int back() {
			if (size == 0) {
				return -1;
			}
			return this.back.val;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		MyDeque myDeque = new MyDeque();
		StringTokenizer cmd;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			cmd = new StringTokenizer(br.readLine(), " ");

			switch (cmd.nextToken()) {
				case "push_back": {
					int val = Integer.parseInt(cmd.nextToken());
					myDeque.push_back(val);
					break;
				}
				case "push_front": {
					int val = Integer.parseInt(cmd.nextToken());
					myDeque.push_front(val);
					break;
				}
				case "pop_front": {
					list.add(myDeque.pop_front());
					break;
				}
				case "pop_back": {
					list.add(myDeque.pop_back());
					break;
				}
				case "size": {
					list.add(myDeque.size());
					break;
				}
				case "empty": {
					list.add(myDeque.empty());
					break;
				}
				case "front": {
					list.add(myDeque.front());
					break;
				}
				case "back": {
					list.add(myDeque.back());
					break;
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		br.close();
	}
}
