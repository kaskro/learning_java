package lv.kaskro.learning.flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CardFileManager {

    public int loadCardsFromFile(File file, FlashCards flashCards) {
        boolean isTerm = true;
        boolean isCardFinished = false;
        int cardCount = 0;
        FlashCard flashCard = new FlashCard();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if (!isCardFinished) {
                    if (isTerm) {
                        flashCard.setTerm(scanner.nextLine());
                        isTerm = false;
                    } else {
                        flashCard.setDefinition(scanner.nextLine());
                        isTerm = true;
                        isCardFinished = true;
                    }
                } else {
                    flashCards.addCard(flashCard);
                    cardCount++;
                    isCardFinished = false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file.getAbsolutePath());
        }
        return cardCount;
    }

    public int saveCardsToFile(File file, FlashCards flashCards) {
        int cardCount = 0;
        try (FileWriter fileWriter = new FileWriter(file)){
            for (var card : flashCards.getCards().entrySet()) {
                fileWriter.write(card.getKey() + "\n");
                fileWriter.write(card.getValue() + "\n");
                cardCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
        return cardCount;
    }
}
