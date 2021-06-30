package com.dfedorino.rtasks.third_level;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DrunkardGameObjectOriented implements DrunkardGame {
    @Override
    public String play(int[] firstPlayerCards, int[] secondPlayerCards) {
        Player firstPlayer = new Player(firstPlayerCards, "first");
        Player secondPlayer = new Player(secondPlayerCards, "second");
        int rounds = 0;
        while (firstPlayer.hasCards() && secondPlayer.hasCards()) {
            if (rounds == 1_000_000) {
                return "botva";
            }
            Card firstPlayerCard = firstPlayer.getFirstCard();
            Card secondPlayerCard = secondPlayer.getFirstCard();
            Player roundWinner = firstPlayerCard.beatsCard(secondPlayerCard) ? firstPlayer : secondPlayer;
            roundWinner.takeCard(firstPlayerCard);
            roundWinner.takeCard(secondPlayerCard);
            rounds++;
        }
        Player winner = firstPlayer.hasCards() ? firstPlayer : secondPlayer;
        return winner.getOrdinal() + " " + rounds;
    }

    private static class Player {
        private final Queue<Card> deck;
        private final String ordinal;

        public Player(int[] cards, String ordinal) {
            this.ordinal = ordinal;
            deck = Arrays.stream(cards)
                    .mapToObj(Card::new)
                    .collect(() -> new ArrayDeque<>(cards.length), ArrayDeque::offer, ArrayDeque::addAll);
        }

        public boolean hasCards() {
            return !deck.isEmpty();
        }

        public Card getFirstCard() {
            return deck.poll();
        }

        public void takeCard(Card card) {
            deck.offer(card);
        }

        public String getOrdinal() {
            return ordinal;
        }
    }

    private static class Card {
        private final int value;

        public Card(int value) {
            this.value = value;
        }

        public boolean beatsCard(Card other) {
            if (this.value == 0 & other.value == 9) {
                return true;
            } else if (this.value == 9 & other.value == 0) {
                return false;
            } else {
                return this.value > other.value;
            }
        }
    }
}
