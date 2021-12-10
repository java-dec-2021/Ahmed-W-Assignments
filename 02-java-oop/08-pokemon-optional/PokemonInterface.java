public interface PokemonInterface extends Pokemon {
    
    Pokemon createPokemon(String name, int health, String type);
    String pokemonInfo(Pokemon pokemon);
    void listPokemon();
}
