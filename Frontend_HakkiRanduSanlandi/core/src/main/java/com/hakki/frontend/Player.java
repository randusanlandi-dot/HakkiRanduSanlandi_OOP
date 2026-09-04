package com.hakki.frontend;

public class Player {
    String name;
    int hp;
    int power;
    int spellCards;

    Player(String name, int hp, int power, int spellCards) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.spellCards = spellCards;
        //hi
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
        if (hp > 0) {
            System.out.println(this.name + " took " + damage + " damage! Remaining HP: " + this.hp);
        } else {
            System.out.println(this.name + " has been defeated!");
        }
    }

    public void shoot(Enemy target) {
        int damage = power + 10;
        System.out.println(this.name + " shoots " + target.name + " dealing " + damage + " DMG!");
        target.takeDamage(damage);
    }
}


