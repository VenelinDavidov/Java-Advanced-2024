package Exercises_DefiningClasses.Google7;

public class Pokemon {
    private String namePokemon;
    private String pokemonType;

    public Pokemon(String namePokemon, String pokemonType) {
        this.namePokemon = namePokemon;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return namePokemon + " " + pokemonType;
    }
}
