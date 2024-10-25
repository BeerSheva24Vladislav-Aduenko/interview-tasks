package telran.interview;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStackInt {
   LinkedList<Integer> stack = new LinkedList<>();
   LinkedList<Integer> maxStack = new LinkedList<>();

	public void push(int num) {
  		stack.push(num);
		Integer prevMax = maxStack.peek();
		if (prevMax == null || prevMax <= num) {
			maxStack.push(num);
		}
	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		if ((stack.peek().equals(maxStack.peek()))) {
			maxStack.pop();
		}
		return stack.pop();
	}

	public int peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stack.peek();
	}

	public boolean isEmpty() {
        return stack.isEmpty();
	}

	public int getMaxElement() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return maxStack.peek();
	}
}