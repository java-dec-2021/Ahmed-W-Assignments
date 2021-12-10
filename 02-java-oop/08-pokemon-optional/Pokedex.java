import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
    
    private ArrayList<String> myPokemons = Pokemon.pokelist;

    public void listPokemon(){
        for(Pokemon p : myPokemons){
            System.out.println(p.getName());
        }
    }

}
