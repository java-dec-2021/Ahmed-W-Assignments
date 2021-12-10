import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
    
    public ArrayList<Pokemon> myPokemons;

    public Pokedex(){
        
    }

    public void listPokemon(){
        for(Pokemon p : myPokemons){
            System.out.println(p.getName());
        }
    }

}
