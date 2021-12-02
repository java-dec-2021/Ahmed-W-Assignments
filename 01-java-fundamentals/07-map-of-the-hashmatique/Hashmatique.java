import java.util.HashMap;


public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Forever Young", "I want to be forever young");
        trackList.put("Intergalactic", "Another dimension, new galaxy");
        trackList.put("I Know the End", "The end is near");
        trackList.put("Welcome to Horrorwood", "The tabloids say, there goes the neighborhood");

        System.out.println(trackList.get("Intergalactic"));
        for (String key : trackList.keySet()) {
            System.out.println("Track: " + key + " Lyrics - " + trackList.get(key));
        }

    }
    
    
}
