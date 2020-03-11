package lv.kaskro.learning.flashcards;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String action;
        boolean canExit = false;

        FlashCards flashCards = new FlashCards();
        Scanner scanner = new Scanner(System.in);

        while (!canExit) {
            System.out.println("Input the action (add, remove, import, export, ask, exit)");
            action = scanner.nextLine();
            switch (action) {
                case "add":
                    addCard(flashCards);
                    break;
                case "remove":
                    removeCard(flashCards);
                    break;
//                case "import":
//                    loadCards(flashCards);
//                    break;
//                case "export":
//                    saveCards(flashCards);
//                    break;
//                case "ask":
//                    askRandomCards(flashCards);
//                    break;
                case "p":
                    flashCards.printFlashCards();
                    break;
                case "exit":
                    System.out.println("Bye bye!");
                    canExit = true;
                    break;
            }
        }
    }

    private static void addCard(FlashCards flashCards) {

        FlashCard flashCard = new FlashCard();
        Scanner scanner = new Scanner(System.in);

        System.out.println("The card:");
        flashCard.setTerm(scanner.nextLine());
//        if (flashCards.hasTerm(flashCard.getTerm())) {
//            System.out.println("The card \"" + flashCard.getTerm() + "\" already exists.");
//            return;
//        }
        System.out.println("The definition of the card");
        flashCard.setDefinition(scanner.nextLine());
//        if (flashCards.hasDefinition(flashCard.getDefinition())) {
//            System.out.println("The definition \"" + flashCard.getDefinition() + "\" already exists.");
//            return;
//        }
        flashCards.addCard(flashCard);
        System.out.println("The pair (\"" + flashCard.getTerm() + "\":\"" + flashCard.getDefinition() + "\") has been added.");
    }

    private static void removeCard(FlashCards flashCards) {
        String term;
        Scanner scanner = new Scanner(System.in);

        System.out.println("The card:");
        term = scanner.nextLine();
        if (flashCards.removeCard(term)) {
            System.out.println("The card has been removed");
        } else {
            System.out.println("Can't remove \"" + term + "\": there is no such card.");
        }
    }

//    private static void loadCards(FlashCards flashCards) {
//
//        String pathToImportFile;
//        int cardCount;
//        CardFileManager cardFileManager = new CardFileManager();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("File name:");
//        pathToImportFile = scanner.nextLine();
//
//        File importFile = new File(pathToImportFile);
//        cardCount = cardFileManager.loadCardsFromFile(importFile, flashCards);
////        System.out.println(cardCount + ((cardCount == 1) ? " card " : " cards ") + "have been loaded.");
//        System.out.println(cardCount + " cards have been loaded.");
//    }

//    private static void saveCards(FlashCards flashCards) {
//
//        String pathToExportFile;
//        int cardCount;
//        CardFileManager cardFileManager = new CardFileManager();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("File name:");
//        pathToExportFile = scanner.nextLine();
//
//        File exportFile = new File(pathToExportFile);
//        cardCount = cardFileManager.saveCardsToFile(exportFile, flashCards);
////        System.out.println(cardCount + ((cardCount == 1) ? " card " : " cards ") + "have been saved.");
//        System.out.println(cardCount + " cards have been saved.");
//    }

//    private static void askRandomCards(FlashCards flashCards) {
//        int timesToAsk;
//        new FlashCard();
//        FlashCard flashCard;
//        Scanner scanner = new Scanner(System.in);
//        if (flashCards.size() > 0) {
//            System.out.println("How many times to ask?");
//            timesToAsk = Integer.parseInt(scanner.nextLine());
//            for (int i = 0; i < timesToAsk; i++) {
//                flashCard = flashCards.getRandomCard();
//                System.out.println("Print the definition of \"" + flashCard.getTerm() + "\"");
//                flashCards.checkAnswer(flashCard.getTerm(), scanner.nextLine());
//            }
//        } else {
//            System.out.println("Sorry, nothing to ask!");
//        }
//    }
}
