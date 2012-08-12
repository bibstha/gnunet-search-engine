package org.gnunet.ext.se.crawler;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	List<String> queue = new ArrayList<String>();
	
	static Queue instance;
	
	private Queue() {}
	
	public static Queue getInstance() {
		if (null == instance) {
			instance = new Queue();
		}
		return instance;
	}
	
	public void push(String url) {
		queue.add(url);
	}
	
	public String pop() {
		String value = null;
		if (null != queue && !queue.isEmpty()) {
			value = queue.get(0);
			queue.remove(0);
		}
		return value;
	}
}
