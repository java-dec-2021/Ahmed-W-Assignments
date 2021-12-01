import java.util.ArrayList;
import java.util.Arrays;
public class TestPuzzle {
    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);
        System.out.println(generator.getRandomLetter());
        generator.generatePassword();
        generator.generateNewPasswordSet(15);
        
    }
}
