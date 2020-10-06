package world.ucode.model;

public enum CharacterType {
    SPONGEBOB("SpongeBob"),
    SQUIDWARD("Squidward"),
    PATRICK("Patrick");

    private final String name;
    CharacterType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
