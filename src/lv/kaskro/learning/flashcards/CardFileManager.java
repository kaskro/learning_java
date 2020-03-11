package lv.kaskro.learning.flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CardFileManager {

    public int loadCardsFromFile(File file, FlashCards flashCards) {
        boolean isTerm = true;
        int cardCount = 0;
        String line;
        FlashCard flashCard = new FlashCard();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                if (isTerm) {
                    flashCard.setTerm(line);
                    isTerm = false;
                } else {
                    flashCard.setDefinition(line);
                    isTerm = true;
                    flashCards.addCard(flashCard);
                    cardCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return -1;
        }
        return cardCount;
    }

//    public int saveCardsToFile(File file, FlashCards flashCards) {
//        int cardCount = 0;
//        try (FileWriter fileWriter = new FileWriter(file)) {
//            for (var card : flashCards.getCards().entrySet()) {
//                fileWriter.write(card.getKey() + "\n");
//                fileWriter.write(card.getValue() + "\n");
//                cardCount++;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//            return -1;
//        } catch (IOException e) {
//            System.out.printf("An exception occurs %s", e.getMessage());
//            return -1;
//        }
//        return cardCount;
//    }
}
