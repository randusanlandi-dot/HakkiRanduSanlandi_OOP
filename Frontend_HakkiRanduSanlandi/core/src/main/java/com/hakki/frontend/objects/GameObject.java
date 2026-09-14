package com.hakki.frontend.objects;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.awt.Color;

public abstract class GameObject implements Collidable {
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float speed;
    protected Color color;

    public GameObject(float x, float y, float width, float height, float speed, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }

    public void update(float delta) {
    }
    public void render(ShapeRenderer shapeRenderer) {

    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        if (width > 0) this.width = width;
    }

    public void setHeight(float height) {
        if (height > 0) this.height = height;
    }

    public void setSpeed(float speed) {
        if (speed >= 0) this.speed = speed;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getSpeed() {
        return this.speed;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public Rectangle getCoreHitbox() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public Rectangle getGrazeHitbox() {
        return new Rectangle((x - 10), (y - 10), (width + 20), (height + 20) );
    }

    @Override
    public void onCollision(Collidable other) {

    }

}
