package lv.kaskro.learning.flashcards;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class FlashCards {
    private Map<String, String> flashCards = new LinkedHashMap<>();

    public void addCard(FlashCard flashCard) {
        flashCards.put(flashCard.getTerm(), flashCard.getDefinition());
    }

    public Map<String, String> getCards() {
        return flashCards;
    }

    public boolean removeCard(String term) {
        if (hasTerm(term)) {
            flashCards.remove(term);
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return flashCards.size();
    }

    public FlashCard ask() {
        Random random = new Random();
        FlashCard flashCard = new FlashCard();
        int randomNumber = random.nextInt(flashCards.size());
        int count = 0;
        for (var card : flashCards.entrySet()) {
            if (count == randomNumber) {
                flashCard.setTerm(card.getKey());
                flashCard.setDefinition(card.getValue());
                break;
            }
            count++;
        }
        return flashCard;
    }

    public boolean hasTerm(String term) {
        return flashCards.containsKey(term);
    }

    public boolean hasDefinition(String definition) {
        return flashCards.containsValue(definition);
    }

    public void checkAnswer(String term, String answer) {
        if (!flashCards.get(term).equals(answer)) {
            System.out.print("Wrong answer. The correct one is \"" + flashCards.get(term) + "\"");
            for (var card : flashCards.entrySet()) {
                if (card.getValue().equals(answer)) {
                    System.out.print(", you've just written the definition of \"" + card.getKey() + "\"");
                }
            }
            System.out.println(".");
        } else {
            System.out.println("Correct answer.");
        }
    }

    public void printFlashCards() {
        for (var card : flashCards.entrySet()) {
            System.out.println(card.getKey() + " - " + card.getValue() + ";");
        }
    }
}
