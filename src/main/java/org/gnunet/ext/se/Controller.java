package org.gnunet.ext.se;

import java.net.MalformedURLException;
import java.net.URL;

import org.gnunet.ext.se.extractor.Crawler;

public class Controller {
	public void crawl() {
		try {
			URL url = new URL("http://www.adyota.org");
			Crawler crawler = new Crawler(url);
			crawler.process();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
