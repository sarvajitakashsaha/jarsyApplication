package heap;

public class MinHeap {
	private int[] Heap;
	private int size;
	private int maxSize;
	private static final int FRONT = 1;

	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		Heap = new int[this.maxSize + 1];
		Heap[0] = Integer.MIN_VALUE;
		// TODO Auto-generated constructor stub
	}

	public int parent(int current) {
		return current / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	public void swap(int cur, int par) {
		int temp = Heap[cur];
		Heap[cur] = Heap[par];
		Heap[par] = temp;
	}

	public void insert(int element) {
		if (size >= maxSize) {
			return;
		}
		Heap[++size] = element;

		int current = size;
		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}

	}

	public int remove() {
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);
		return popped;
	}

	public boolean isLeaf(int pos) {
		if (pos > (size / 2) && pos < size) {
			return true;
		}
		return false;
	}

	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (Heap[pos] > Heap[rightChild(pos)] || Heap[pos] > Heap[leftChild(pos)]) {
				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}

	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.println("\nParent " + Heap[i] + "Left child " + Heap[2 * i] + "Right Child " + Heap[2 * i + 1]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap(15);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		minHeap.print();
		System.out.println("The Min val is " + minHeap.remove());
		minHeap.print();
	}

}
