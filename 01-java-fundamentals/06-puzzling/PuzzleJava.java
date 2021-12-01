import java.util.Random;
import java.util.ArrayList;
public class PuzzleJava {
    
    public static ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> v = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++){
            int rnum = rand.nextInt(11) +10;
            v.add(rnum);
        }
        return v;
    }

    public static char getRandomLetter(){
        
        Random rand = new Random();
        char[] alphabet = new char[26]; //looked on stackoverflow for an easier solution than manually coding an array of the alphabet
        for(int i = 0; i < 26; i++){
            alphabet[i] = (char)(97 + i);
        }
        int rnum = rand.nextInt(26);
        char x = alphabet[rnum];
        return x;

    }

    public static void generatePassword(){
        String v = new String();
        v = "";
        for (int i = 0; i < 8; i++){
            v = v + String.valueOf(getRandomLetter());
        }
        System.out.println(v);
    }

    public static void generateNewPasswordSet(int num){
        String v = new String();
        v = "";
        for (int i = 0; i < num; i++){
            v = v + String.valueOf(getRandomLetter());
        }
        System.out.println(v);
    }

}
