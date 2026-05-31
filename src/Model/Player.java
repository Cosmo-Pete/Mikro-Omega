package Model;

import java.io.Serializable;

public class Player implements Serializable {



    private String name;
    public Player(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }
}