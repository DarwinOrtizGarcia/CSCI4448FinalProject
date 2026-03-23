package com.character;
public class Character {
    private String name;
    private Double health;
    private Double strength;
    private Double magic;
    private Double defense;
    private Double resistance;

    public Character(String name, Double health, Double strength, Double magic, Double defense, Double resistance) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.magic = magic;
        this.defense = defense;
        this.resistance = resistance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getHealth() {
        return health;
    }
    public void setHealth(Double health) {
        this.health = health;
    }
    public Double getStrength() {
        return strength;
    }
    public void setStrength(Double strength) {
        this.strength = strength;
    }
    public Double getMagic() {
        return magic;
    }
    public void setMagic(Double magic) {
        this.magic = magic;
    }
    public Double getDefense() {
        return defense;
    }
    public void setDefense(Double defense) {
        this.defense = defense;
    }
    public Double getResistance() {
        return resistance;
    }
    public void setResistance(Double resistance) {
        this.resistance = resistance;
    }

}