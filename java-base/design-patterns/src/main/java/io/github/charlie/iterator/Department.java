package io.github.charlie.iterator;

import lombok.Data;

@Data
public class Department {

    private String name;
    private String desc;

    public Department(String name, String desc) {
        super();
        this.name = name;
        this.desc = desc;
    }

}