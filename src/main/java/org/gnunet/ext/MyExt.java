package org.gnunet.ext;

import org.gnunet.ext.se.Controller;
import org.gnunet.ext.se.extractor.Crawler;
import org.gnunet.util.*;

public class MyExt {
    public static void main(String[] args) {
            new Program(args) {
                public void run() {
                	Controller controller = new Controller();
                	controller.crawl();
                }
		}.start();
	}
}
