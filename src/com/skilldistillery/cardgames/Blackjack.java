package com.skilldistillery.cardgames;

import java.util.Scanner;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Blackjack {

	private BlackjackHand playerHand;
	private BlackjackHand dealerHand;
	private Deck blackjackDeck;
	private Scanner keyBoard = new Scanner(System.in);

	public Blackjack() {
		playerHand = new BlackjackHand();
		dealerHand = new BlackjackHand();
	}

	public static void main(String[] args) {
		Blackjack gameBlackjack = new Blackjack();
		gameBlackjack.play();
	}

	private void play() {
		boolean continueGame = true;
		while (continueGame) {
			blackjackDeck = new Deck();
			blackjackDeck.shuffle();
			blackjackDeck.shuffle();
			blackjackDeck.shuffle();
			playerHand.clear();
			dealerHand.clear();
			blackjackDeck.shuffle();

			playerHand.addCard(blackjackDeck.dealCard());
			dealerHand.addCard(blackjackDeck.dealCard());
			playerHand.addCard(blackjackDeck.dealCard());
			dealerHand.addCard(blackjackDeck.dealCard());
			if (playerHand.getHandValue() == 21) {
				System.out.println("Player wins with Blackjack!!!");
			} else if (dealerHand.getHandValue() == 21) {
				System.out.println("House wins with Blackjack!!!!");
			} else {
				System.out.println("Player value = " + playerHand.getHandValue() + ", Cards are: " + playerHand.get(0)
						+ " and " + playerHand.get(1));
				System.out.println("Dealer: " + dealerHand.get(1));
				while (playerHand.getHandValue() < 21 ) {
					System.out.println("Hit or Stay? (h/s)");
					String userInput = keyBoard.nextLine();
					if (userInput.equals("h")) {
						playerHand.addCard(blackjackDeck.dealCard());
						for (int i = 0; i < playerHand.size(); i++) {
							System.out.println(playerHand.get(i));
						}
						System.out.println("Player value = " + playerHand.getHandValue());
					} else if (userInput.equals("s")) {
						break;
					} else {
						System.out.println("Invalid input");
					}
				}
				if (playerHand.isBust()) {
					System.out.println("Bust!");
				} else {
					System.out.println("Player value = " + playerHand.getHandValue());

					while (dealerHand.isSoft() || dealerHand.getHandValue() < 17) {
						dealerHand.addCard(blackjackDeck.dealCard());
						System.out.println("Dealer: " + dealerHand.get(1));
					}
					if (dealerHand.isBust()) {
						System.out.println("Dealer Bust!");
					} else {
						System.out.println("Dealer value = " + dealerHand.getHandValue());
						if (playerHand.getHandValue() > dealerHand.getHandValue()) {
							System.out.println("Player wins!");
						} else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
							System.out.println("Dealer wins!");
						} else {
							System.out.println("Push!");
						}
					}
				}
			}
			System.out.println("Play again? (y/n)");
			String userInput = keyBoard.nextLine();
			if (userInput.equals("y")) {
				continueGame = true;
			} else if (userInput.equals("n")) {
				continueGame = false;
				System.out.println("Hope you come to play Blackjack again!");
			} else {
				System.out.println("Invalid input");
			}
		}
	}
}