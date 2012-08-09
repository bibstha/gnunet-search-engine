package org.gnunet.ext.se;

import java.util.ArrayList;
import java.util.List;

public class CrawlQueue {
	
	List<String> queue = new ArrayList<String>();
	
	static CrawlQueue instance;
	
	private CrawlQueue() {}
	
	public static CrawlQueue getInstance() {
		if (null == instance) {
			instance = new CrawlQueue();
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
