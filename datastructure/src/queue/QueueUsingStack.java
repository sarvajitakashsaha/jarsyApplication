package queue;

class QueuetwoStackClass {
	StackClass s1 = new StackClass();
	StackClass s2 = new StackClass();

	public void enqueue(int x) {
		if (s2.isEmpty()) {
			// s1.push(x);
		} else {
			while (!s2.isEmpty()) {
				s1.push(s2.peek());
				s2.pop();
			}
			// s1.push(x);
		}
		s1.push(x);
	}

	public void displayQueue() {
		if (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
		}

		s2.display();
	}

	public void dequeue() {
		if (!s2.isEmpty()) {
			System.out.println("deleted item is :: " + s2.peek());
			// s2.pop();
		} else {
			while (!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
		}
		s2.pop();
	}

	public boolean isEmptyQueue() {
		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}

public class QueueUsingStack {

	public static void main(String[] args) {
		QueuetwoStackClass obj = new QueuetwoStackClass();
		obj.enqueue(10);
		obj.enqueue(20);
		obj.enqueue(30);
		obj.enqueue(40);
		obj.dequeue();
		obj.enqueue(50);
		obj.dequeue();
		obj.enqueue(60);
		obj.displayQueue();

		System.out.println("\nqueue using StackClass ");

	}

}
