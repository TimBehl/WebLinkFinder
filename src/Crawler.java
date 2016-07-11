import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Crawler{
	
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
			beenVisit.add(currentURL);
			visitMethodHolder.action(currentURL, toVisit, beenVisit);
			toVisit.remove(currentURL);
		}
	}
	
	public void showVisited(){
		int urlCount = 0;
		Iterator<URL> visitIter = beenVisit.iterator();
		while(visitIter.hasNext()){
			urlCount++;
			System.out.println("URL #" + urlCount + ": " + visitIter.next().toString());
		}
	}
}