package io.github.charlie.oop.annotations.demo4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Table("t_stu")
public class Student {
    @Column(columnName = "sid", columnType = "int")
    private int id;
    @Column(columnName = "sname", columnType = "varchar(20)")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
