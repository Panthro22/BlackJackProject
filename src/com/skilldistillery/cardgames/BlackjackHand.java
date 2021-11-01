package com.skilldistillery.cardgames;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Rank;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		super();
	}
	
	
	public Card get(int index) {
	
		return hand.get(index);
	}
	
	
	@Override
	public int getHandValue() {
		int handValue = 0;
		for(int iteration = 0; iteration < hand.size(); iteration++){
			handValue += hand.get(iteration).getValue();
		}
		return handValue;
	}
	
    public boolean isBlackjack() {
        if (hand.size() == 2) {
            if (hand.get(0).getValue() == 1 && hand.get(1).getValue() == 10) {
                return true;
            }
        }
        
        return false;
    }
    
    public int size() {
    	return hand.size();
    }
    
    
    public boolean isBust() {
        if (this.getHandValue() > 21) {
            return true;
        }
        return false;
    }

    public boolean isHard() {
        if (this.getHandValue() <= 21 && this.getHandValue() >16) {
            return true;
        }
        return false;
    }

    
	public boolean isSoft() {
    	if (hand.contains(Rank.ACE)){
    		System.out.println("Soft");
    	
    		if (this.getHandValue() == 17) {
            	return true;
        	}
    	}
        return false;
    }

}