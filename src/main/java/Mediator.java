import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mediator {
    private HashMap<String, List<PropertyChangeListener>> colleagues;

    public Mediator() {
        colleagues = new HashMap<String, List<PropertyChangeListener>>();

    }

    public void mediate(String key, PropertyChangeListener talkingColleague) {
        List<PropertyChangeListener> colleagueList = colleagues.get(key);
        for(PropertyChangeListener colleague : colleagueList) {

            PropertyChangeEvent evt = new PropertyChangeEvent(talkingColleague, null, null, null);
            colleague.propertyChange(evt);
        }
    }

    public void addColleague(String key, PropertyChangeListener colleague) {

        if(colleagues.get(key) == null) {
            colleagues.put(key, new ArrayList<PropertyChangeListener>());
        }
        colleagues.get(key).add(colleague);
    }

    public void removeColleague(String key) {
        colleagues.get(key).clear();
    }
}
