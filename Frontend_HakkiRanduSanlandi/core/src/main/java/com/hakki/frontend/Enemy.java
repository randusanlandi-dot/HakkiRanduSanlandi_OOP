package com.hakki.frontend;

public class Enemy {
    String name;
    int hp;
    int maxHp;

    Enemy(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;

        System.out.println(this.name + " took " + damage + " damage! HP: " + this.hp + "/" + this.maxHp);

        if (hp < 0) {
            hp = 0;
            System.out.println(this.name + " has been defeated!");
        }
    }

    public void attack(Player player, int damage) {
        System.out.println();
    }
}
