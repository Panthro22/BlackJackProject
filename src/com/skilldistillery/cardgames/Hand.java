package com.skilldistillery.cardgames;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	protected List<Card> hand;
	
	public Hand() {
		hand = new ArrayList<>();
	}
	
		
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void clear() {
		hand.clear();
	}
	
	public abstract int getHandValue();
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Card card: hand) {
			sb.append(card.toString() + " " );
		}
		
		return sb.toString();
	}
}
 
