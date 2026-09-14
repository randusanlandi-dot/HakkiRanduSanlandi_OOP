package com.hakki.frontend.objects;

import com.hakki.frontend.objects.enemies.Enemy;
import com.hakki.frontend.objects.items.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.hakki.frontend.objects.items.ItemType;

import java.awt.*;

public class Player extends GameObject {
    private String name;
    private int hp;
    private int power;
    private int spellCards;
    private long score;

    public Player(String name, int hp, int power, int spellCards) {
        super(280, 40, 32,32, 0, Color.RED);
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.spellCards = spellCards;
        this.score = 0;
    }

    public Player(int x, int y, String name, int hp, int power, int spellCards) {
        super(x, y, 32,32, 0, Color.RED);
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.spellCards = spellCards;
        this.score = 0;
    }

    public void takeDamage(int damage) {
        setHp(getHp() - power);
        if (hp > 0) {
            System.out.println(this.name + " took " + damage + " damage! Remaining HP: " + this.hp);
        } else {
            System.out.println(this.name + " has been defeated!");
        }
    }

    public void shoot(Enemy target) {
        int damage = 10 + getPower();
        System.out.println(getName() + " shoots " + target.getName() + " dealing " + damage + " DMG!");
        if (target.takeDamage(damage)) {
            addScore(target.getScoreValue());
        }
    }

    public void addScore(long points) {
        if (points > 0) {
            this.score += points;
            System.out.println(getName() + " gained " + points + " pts! Total Score: " + this.score);
        }
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setSpellCards(int spellCards) {
        this.spellCards = spellCards;
    }

    public int getHp() {
        return this.hp;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public int getSpellCards() {
        return this.spellCards;
    }

    public long getScore() {
        return this.score;
    }

    public void collectItem(Item item) {
        ItemType type = item.getItemTypeEnum();
        if (type != null) {
            switch (type) {
                case POWER -> {
                    this.power += type.getPowerBonus();
                    addScore(item.getScoreValue());
                    System.out.print(this.name + " collected POWER item! Power increased to" + this.power);
                }
                case POINT -> {
                    addScore(item.getScoreValue());
                    System.out.print(this.name + " collected POINT item!");
                }
                case BOMB -> {
                    this.spellCards += 1;
                    addScore(item.getScoreValue());
                    System.out.print(this.name + " collected BOMB item! SpellCards: " + this.spellCards);
                }
                case LIFE -> {
                    this.hp += 20;
                    addScore(item.getScoreValue());
                    System.out.print(this.name + " collected LIFE item! HP: " + this.hp);
                }
            }
        } else {
            addScore(item.getScoreValue());
            System.out.println(name + " collected " + item.getItemType() + "!");
        }
    }


    @Override
    public void update(float delta) {
        if (Gdx.input != null) {
            // TODO: Cek input W / UP   → y += speed * delta
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                y += speed * delta;
            }
            // TODO: Cek input S / DOWN → y -= speed * delta
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                y -= speed * delta;
            }
            // TODO: Cek input A / LEFT → x -= speed * delta
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                x -= speed * delta;
            }
            // TODO: Cek input D / RIGHT → x += speed * delta
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                x += speed * delta;
            }
        }
    }

    @Override
    public void onCollision(Collidable other) {
        if (other.getClass() == Item.class) {
            System.out.print("Player touches items");
            collectItem((Item) other);
        }
    }
}


