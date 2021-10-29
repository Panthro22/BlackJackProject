package com.skilldistillery.deck;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealing {

  public static void main(String[] args) {
    Dealing dealer = new Dealing();
    dealer.run();
  }
  
  private void run() {
    Deck deck = new Deck();
    deck.shuffle();
    deck.shuffle();

    
    Scanner keyBoard = new Scanner(System.in);
    System.out.print("How many cards: ");
    
    try {
      int numCards = keyBoard.nextInt();
      if(numCards > 52) {
        throw new InputMismatchException();
      }
      
      List<Card> hand = new ArrayList<>(numCards);
      int totalValue = 0;
      for(int i = 0; i < numCards; i++) {
        Card card = deck.dealCard();
        totalValue += card.getValue();
        hand.add(card);
      }
      printHandAndValue(hand, totalValue);
    }
    catch (InputMismatchException e) {
      System.out.println("That is not a valid number of cards.");
    }
    finally {
    	keyBoard.close();
    }
  }
  
  private void printHandAndValue(List<Card> hand, int value) {
    for (Card card : hand) {
      System.out.println(card);
    }
    System.out.println("Total value: " + value);
  }

}
