package io.github.charlie.flyweight;

import lombok.Data;

@Data
public class User {

    private String name;

    public User(String name) {
        super();
        this.name = name;
    }

}
