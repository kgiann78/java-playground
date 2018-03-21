package playground.parser;

public class Game {
    String name;
    int level;

    public Game() {
    }

    public Game(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
