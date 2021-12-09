public class BatTest {
    public static void main(String[] args) {
        Bat b = new Bat(300);
        b.fly();
        b.attackTown();
        b.eatHumans();
        b.fly();
        b.attackTown();
        b.eatHumans();
        b.attackTown();
        b.displayEnergy();
    }
}
