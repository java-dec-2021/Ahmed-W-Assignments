public abstract class AbstractPokemon implements PokemonInterface {
    public Pokemon createPokemon(String name, int health, String type){
        return new Pokemon(name, health, type);
    }
    public String pokemonInfo(Pokemon pokemon){
        String info = "Pokemon name:" + pokemon.getName() + ", health:" + pokemon.getHealth() + ", type:" + pokemon.getType();
        return info;
    }
}
