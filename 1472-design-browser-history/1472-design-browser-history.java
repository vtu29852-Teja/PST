import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    private List<String> history;
    private int currentIndex;
    private int maxIndex;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
        maxIndex = 0;
    }
    
    public void visit(String url) {
        currentIndex++;
        if (currentIndex < history.size()) {
            history.set(currentIndex, url);
        } else {
            history.add(url);
        }
        // Visiting clears all forward history
        maxIndex = currentIndex;
    }
    
    public String back(int steps) {
        // Move back at most steps or to index 0
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }
    
    public String forward(int steps) {
        // Move forward at most steps or to maxIndex
        currentIndex = Math.min(maxIndex, currentIndex + steps);
        return history.get(currentIndex);
    }
}