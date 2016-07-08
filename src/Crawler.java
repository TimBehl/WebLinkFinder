import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Crawler implements VisitAction {
	
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

	@Override
	public void action(URL URLtoVisit) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(URLtoVisit.openStream()));
			String strLine;
			while((strLine = in.readLine()) != null){
				String pattern = ".*[Aa]\\s+[Hh][Rr][Ee][Ff]\\s*=\\s*\"(.*?)\".*";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(strLine);
				if(m.matches()){
					toVisit.add(new URL(URLtoVisit.getProtocol() + "://" + URLtoVisit.getHost() 
							+ strLine));
				}
			}
		} catch (IOException e) {
			System.out.println("IO Exception.");
			e.printStackTrace();
		}
	}
}