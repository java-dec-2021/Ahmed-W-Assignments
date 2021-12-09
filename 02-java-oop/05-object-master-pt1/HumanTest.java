public class HumanTest {
    public static void main(String[] args) {
        Human playerOne = new Human();
        Human playerTwo = new Human();
        playerOne.attack(playerTwo);
        playerOne.attack(playerTwo);
        playerTwo.attack(playerOne);
        playerOne.displayHealth();
        playerTwo.displayHealth();


    }
}
