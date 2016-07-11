import java.net.MalformedURLException;
import java.net.URL;


public class WebFinder {
	public static void main(String[] args) throws MalformedURLException {
		CrawlAction actor = new CrawlAction();
		Crawler crawler = new Crawler(new URL("http://shalladay-iis1.student.neumont.edu/"), actor);
		crawler.crawl();
		crawler.showVisited();
	}
}