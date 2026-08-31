package com.hakki.frontend;

public class Player {
    String name;
    int hp;
    int power;
    int spellCards;

    Player (String name, int hp, int power, int spellCards) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.spellCards = spellCards;
    }
}

class Lol {
    public static void main(String[] args) {
        Player player1 = new Player("Reimu Hakurei", 100, 15, 3);
    }
    }
