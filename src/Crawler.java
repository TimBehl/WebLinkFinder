import java.net.URL;
import java.util.ArrayList;


public class Crawler {
	
	ArrayList<URL> toVisit = new ArrayList<URL>();
	ArrayList<URL> beenVisit = new ArrayList<URL>();
	VisitAction visitMethodHolder;
	URL currentURL;

	public Crawler(URL startURL, VisitAction visitAction){
		toVisit.add(startURL);
		this.visitMethodHolder = visitAction;
	}
	
	public void crawl(){
		while(!toVisit.isEmpty()){
			currentURL = toVisit.get(0);
			toVisit.remove(currentURL);
			beenVisit.add(currentURL);
			visitMethodHolder.action(currentURL);
		}
	}
}