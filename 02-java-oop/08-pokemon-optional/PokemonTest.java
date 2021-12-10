public class PokemonTest {
    public static void main(String[] args) {
        Pokemon p1 = new Pokemon("Charizard", 100, "Fire");
        Pokemon p2 = new Pokemon("Blastoise", 125, "Water");
        Pokemon p3 = new Pokemon("Gengar", 90, "Ghost");
        Pokemon p4 = new Pokemon();
        p1.attackPokemon(p2);
        System.out.println("P1 Pokemon name: " + p1.getName());      
        System.out.println("P2 Pokemon health: " + p2.getHealth());     
        System.out.println("P3 Pokemon type: " + p3.getType());
        System.out.println(Pokemon.getCount());
    }
}
