package telran.interview;

import java.util.HashMap;

public class MyArray<T> {
	T defaultValue = null;
	HashMap<Integer, T> arr;
	int size;
	

	public void setAll(T value) {
		this.defaultValue = value;
		arr = new HashMap<>();
	}

	public void set(int index, T value) {
		validateIndex(index);
		arr.put(index, value);
	}
	
	public T get(int index) {
		validateIndex(index);
		return arr.getOrDefault(index, defaultValue);
		
	}
	public MyArray(int size) {
		this.size = size;
		arr = new HashMap<>();
	}

	private void validateIndex(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
}