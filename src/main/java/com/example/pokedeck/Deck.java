package com.example.pokedeck;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private int id; //Deck number
    private String name;
    private double total;
    private List<Card> cards;
    private boolean isNext;

    public Deck(int id, String name, boolean isNext) {
        this.id = id;
        this.name = name;
        this.isNext = isNext;
        total = 0;
        cards = new ArrayList<>();
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setID(int i) {
        id = i;
    }

    public void setName(String s) {
        name = s;
    }

    public void setTotal(double d) {
        total = d;
    }

    public void addCard(Card c) {
        cards.add(c);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public boolean isNext() {
        return isNext;
    }

    public void setIsNext(boolean b) {
        isNext = b;

    }
}
