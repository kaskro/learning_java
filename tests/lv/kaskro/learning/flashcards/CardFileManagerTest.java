package lv.kaskro.learning.flashcards;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardFileManagerTest {

    @Test
    void shouldLoadCardsFromFileWhenFileIsFound() {

        int count = 195;
        String pathToFile = "files/capitals.txt";
        FlashCards flashCards = new FlashCards();
        File file = new File(pathToFile);
        CardFileManager cardFileManager = new CardFileManager();


        cardFileManager.loadCardsFromFile(file, flashCards);

        assertEquals(count, flashCards.size());
    }

    @Test
    void shouldNotLoadWhenFileNotFound() {

        int count = 0;
        String pathToFile = "files";
        FlashCards flashCards = new FlashCards();
        File file = new File(pathToFile);
        CardFileManager cardFileManager = new CardFileManager();


        cardFileManager.loadCardsFromFile(file, flashCards);

        assertEquals(count, flashCards.size());
    }

    @Test
    void shouldSaveCardsToFile() {
//
//        String term = "Demo";
//        String definition = "Test";
//        String resultInFile = term + "\n" + definition + "\n";
//        int charCount = resultInFile.length();
//        String pathToFile = "files/demo.txt";
//
//        FlashCard flashCard = new FlashCard();
//        FlashCards flashCards = new FlashCards();
//        File file = new File(pathToFile);
//        CardFileManager cardFileManager = new CardFileManager();
//
//        flashCard.setTerm("Demo");
//        flashCard.setDefinition("none");
//
//        flashCards.addCard(flashCard);
//
//        cardFileManager.saveCardsToFile(file, flashCards);
//        assertEquals(charCount, file.length());
    }
}