package com.hakki.frontend.objects.items;
import com.hakki.frontend.objects.GameObject;
import com.hakki.frontend.objects.Player;
import com.hakki.frontend.objects.Collidable;

import java.awt.*;

public class Item extends GameObject {
    private String itemType;
    private long scoreValue;
    private ItemType itemTypeEnum;

    public Item(float x, float y, String itemType) {
        super(x, y, 16, 16, 100f, Color.WHITE);
        this.itemType = itemType;
        this.scoreValue = 1000L;
    }

    public Item(float x, float y, float width, float height, float speed, String itemType) {
        super(x, y, width, height, speed, Color.WHITE);
        this.itemType = itemType;
        this.scoreValue = 1000L;
    }

    public Item(float x, float y, float width, float height, float speed, String itemType, long scoreValue) {
        super(x, y, width, height, speed, Color.WHITE);
        this.itemType = itemType;
        this.scoreValue = scoreValue;
    }

    public Item(float x, float y, ItemType itemTypeEnum) {
        super(x, y, 16, 16, 100f, Color.WHITE);
        this.scoreValue = itemTypeEnum.getScoreValue();
        this.itemType = itemTypeEnum.name();
    }

    public Item(float x, float y, float width, float height, float speed, ItemType itemTypeEnum, long scoreValue) {
        super(x, y, width, height, speed, Color.WHITE);
        this.scoreValue = itemTypeEnum.getScoreValue();
        this.itemType = itemTypeEnum.name();
    }

    public ItemType getItemTypeEnum() {
        return this.itemTypeEnum;
    }

    public long getScoreValue() {
        return this.scoreValue;
    }

    public String getItemType() {
        return this.itemType;
    }

    @Override
    public void update(float delta) {
        this.y -= speed*delta;
    }

    @Override
    public void onCollision(Collidable other) {
        if (other.getClass() == Player.class) {
        }
        // TODO: Cek apakah other yang diterima method ini adalah Player
        // Item pickup is handled on the Player side via collectItem()
    }


}
