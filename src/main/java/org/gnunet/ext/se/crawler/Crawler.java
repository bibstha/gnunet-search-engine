package org.gnunet.ext.se.crawler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	URL url;
	
	public Crawler(URL url) {
		this.url = url;
	}
	
	public void process() {
		try {
			Document doc = getContent();
			List<String> urls = getUrls(doc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Document getContent() throws Exception {
		Document doc = Jsoup.connect("http://example.com/pomodoro/").get();
		System.out.println(doc.toString());
		return doc;
	}
	
	public List<String> getUrls(Document doc) {
		Elements anchors = doc.getElementsByTag("a");
		List<String> urls = new ArrayList<String>();
		for (Element anchor : anchors) {
			urls.add(anchor.attr("href"));
		}
		return urls;
	}
	
	public void fillCrawlQueue(List<String> urls) {
		if (urls != null) {
			for (String url : urls) {
				// @TODO: Check for duplicates
				Queue.getInstance().push(url);
			}
		}
	}
	
}
