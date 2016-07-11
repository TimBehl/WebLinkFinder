import java.net.URL;
import java.util.ArrayList;


public interface VisitAction {
	void action(URL URLtoVisit, ArrayList<URL> toVisit, ArrayList<URL> beenVisit);
}
