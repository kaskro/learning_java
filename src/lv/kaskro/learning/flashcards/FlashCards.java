package lv.kaskro.learning.flashcards;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class FlashCards {

    private Map<FlashCard, Integer> flashCards = new LinkedHashMap<>();

    public void setFlashCards(Map<FlashCard, Integer> flashCards) {
        this.flashCards = flashCards;
    }

    public Map<FlashCard, Integer> getFlashCards() {
        return flashCards;
    }

    public void addCard(FlashCard flashCard) {
        flashCards.put(flashCard, 0);
    }

    public boolean removeCard(String term) {
        FlashCard card = getCardByTerm(term);
        if (isValidCardFound(card)) {
            flashCards.remove(card);
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return flashCards.size();
    }

    public FlashCard getRandomCard() {
        Random random = new Random();
        FlashCard flashCard = new FlashCard();
        int randomNumber = random.nextInt(flashCards.size());
        int count = 0;
        for (FlashCard card : flashCards.keySet()) {
            if (count == randomNumber) {
                flashCard = card;
                break;
            }
            count++;
        }
        return flashCard;
    }

    public String checkAnswer(String term, String answer) {
        String message = "";
        FlashCard flashCard = new FlashCard();
        flashCard.setTerm(term);
        flashCard.setDefinition(answer);

        for (FlashCard card : flashCards.keySet()) {
            if (card.equals(flashCard)) {
                return "Correct answer.";
            } else {
                if (card.getTerm().equals(flashCard.getTerm())) {
                    message = "Wrong answer. The correct one is \"" + card.getDefinition() + "\"";
                    if (getCardByDefinition(flashCard.getDefinition()).getTerm() != null) {
                        message = message + ", you've just written the definition of \"" + getCardByDefinition(flashCard.getDefinition()).getTerm() + "\"";
                    }
                }
            }
        }

        return message;
    }

    public FlashCard getCardByTerm(String term) {
        FlashCard flashCard = new FlashCard();
        for (FlashCard card : flashCards.keySet()) {
            if (card.isTerm(term)) {
                flashCard = card;
                return flashCard;
            }
        }
        return flashCard;
    }

    public FlashCard getCardByDefinition(String definition) {
        FlashCard flashCard = new FlashCard();
        for (FlashCard card : flashCards.keySet()) {
            if (card.isDefinition(definition)) {
                flashCard = card;
                return flashCard;
            }
        }
        return flashCard;
    }

    public void printFlashCards() {
        for (var card : flashCards.entrySet()) {
            System.out.println(card.getKey().getTerm() + " - " + card.getKey().getDefinition() + ", Mistakes: " + +card.getValue() + ";");
        }
    }

    private boolean isValidCardFound(FlashCard card) {
        return card.getTerm() != null && card.getDefinition() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashCards)) return false;
        FlashCards that = (FlashCards) o;
        return Objects.equals(flashCards, that.flashCards);
    }

    @Override
    public String toString() {
        return "FlashCards{" +
                "flashCards=" + flashCards +
                '}';
    }
}
