package com.alevel.hometask.collections;

public abstract class Animal {
    private int age;
    private String name;
    private String color;

    Animal(int age, String name, String oolor) {
        this.age = age;
        this.name = name;
        this.color = oolor;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("The name is");
        sb.append(" ").append(name);
        sb.append(", age is ").append(age);
        sb.append(", color is ").append(color);
        sb.append('!');
        return sb.toString();
    }
}