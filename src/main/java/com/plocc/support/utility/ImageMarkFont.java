package com.plocc.support.utility;

import java.awt.*;

/**
 * Created by Administrator on 14-5-12.
 */
public class ImageMarkFont {
    private String value;
    private String name;
    private Color color;
    private int size;
    private float x;
    private float y;
    private float alpha;
    private float rotate;
    private int style;

    public ImageMarkFont(String value, String name, Color color, int size, int style, float rotate, float x, float y, float alpha) {
        this.value = value;
        this.name = name;
        this.color = color;
        this.size = size;
        this.x = x;
        this.y = y;
        this.alpha = alpha;
        this.rotate = rotate;
        this.style = style;
    }

    public float left() {
        return x;
    }
    public float top() {
        return x;
    }

    public float getRotate() {
        return rotate;
    }

    public void setRotate(float rotate) {
        this.rotate = rotate;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
}
