import java.util.Date;

public class AlfredQuotes {

    public String basicGreeting(){
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name, String dayPeriod){
        String fname = name;
        String time = dayPeriod;
        return "Good " + time + ", " + fname;
    }

    public String dateAnnouncement(){
        Date date = new Date();
        return "Current date is: " + date;
    }

    public String respondBeforeAlexis(String conversation){

        if (conversation.indexOf("Alfred") > 0) {
            return "At your service. As you wish, naturally.";
        }
        else if (conversation.indexOf("Alexis") >= 0) {
            return "Right away, sir. She certainly isn't sophisticated enough for that."; 
        }
        else {
            return "Right. And with that I shall retire.";
        }
    }
}