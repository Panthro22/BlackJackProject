package com.skilldistillery.cards;

public enum Suit {
  HEARTS("Hearts","\u2665\uFE0F"), SPADES("Spades","\u2660\uFE0F"), CLUBS("Clubs","\u2663\uFE0F"), DIAMONDS("Diamonds","\u2666\uFE0F");
  private String name;
  private String image;
  
  Suit(String name, String image) {
    this.name =name;
    this.image = image;
    
  }

  @Override
  public String toString() {
    return name + " " + image;
  }
}