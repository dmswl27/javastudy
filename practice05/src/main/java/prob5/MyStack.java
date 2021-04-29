package prob5;

import java.awt.Component.BaselineResizeBehavior;

public class MyStack {
	private String[] data;
	private int top = -1;
	
	public MyStack(int size) {
		data = new String[size];
	}
	
	public MyStack(int size) {
		// TODO Auto-generated constructor stub
	}

	public void push(String data) {
		if(data.length() == top) {
			resize();
		}
		top++;
	}

	// public String pop 
	private void resize() {
		// TODO Auto-generated method stub
		
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public String pop() {
		// TODO Auto-generated method stub
		return null;
	}
}