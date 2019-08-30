package com.hfad.bitsandpizzas;

public class Pizza {
    String name;
    int imageResourceId;

    public static final Pizza[] pizzas ={
      new Pizza("Diavolo",R.drawable.diavolo),
      new Pizza("Fiunghi", R.drawable.funghi)
    };

    public Pizza(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
