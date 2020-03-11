package lv.kaskro.learning.flashcards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlashCardsTest {

    private FlashCards flashCards;

    @BeforeEach
    void setUp() {
        flashCards = new FlashCards();
    }

    @Test
    void shouldAddCard() {

        addThreeFlashCards();

        assertEquals(3, flashCards.size());
    }

    @Test
    void shouldGetAllCards() {

        addThreeFlashCards();

        FlashCards recievedCards = new FlashCards();

        recievedCards.setFlashCards(flashCards.getFlashCards());

        assertTrue(flashCards.equals(recievedCards));
    }

    @Test
    void shouldRemoveCard() {

        addThreeFlashCards();

        assertTrue(flashCards.removeCard("Demo"));
    }

    @Test
    void shouldNotRemoveCard() {

        addThreeFlashCards();

        assertFalse(flashCards.removeCard("Demoed"));
    }


    @Test
    void shouldGetSize() {

        addThreeFlashCards();

        assertEquals(3, flashCards.size());
    }

    @Test
    void getRandomCard() {

        addThreeFlashCards();

        FlashCard flashCard;

        flashCard = flashCards.getRandomCard();

        assertNotNull(flashCard.getTerm());
    }

    @Test
    void shouldCheckForRightAnswer() {

        addTestDemoCard();

        assertEquals("Correct answer.", flashCards.checkAnswer("Test", "Demo"));
    }

    @Test
    void shouldCheckForWrongAnswer() {

        addTestDemoCard();

        assertEquals("Wrong answer. The correct one is \"Demo\"", flashCards.checkAnswer("Test", "Lego"));
    }

    @Test
    void shouldCheckForRightAnswerToWrongTerm() {

        addThreeFlashCards();

        String testMessage = "Wrong answer. The correct one is \"Demo\"" +
                ", you've just written the definition of \"New\"";

        assertEquals(testMessage, flashCards.checkAnswer("Test", "Card"));
    }


    @Test
    void shouldGetCardByExistingTerm() {

        addTestDemoCard();

        assertEquals("Test", flashCards.getCardByTerm("Test").getTerm());
    }

    @Test
    void shouldNotGetCardByNotExistingTerm() {

        addTestDemoCard();

        assertNull(flashCards.getCardByTerm("Demo").getTerm());
    }

    @Test
    void shouldGetCardByExistingDefinition() {

        addTestDemoCard();

        assertEquals("Demo", flashCards.getCardByDefinition("Demo").getDefinition());
    }

    @Test
    void shouldNotGetCardByExistingDefinition() {

        addTestDemoCard();

        assertNull(flashCards.getCardByDefinition("Test").getDefinition());
    }

    private void addTestDemoCard() {
        FlashCard flashCard = new FlashCard("Test", "Demo");
        flashCards.addCard(flashCard);
    }

    private void addThreeFlashCards() {
        FlashCard firstCard = new FlashCard("Test", "Demo");
        FlashCard secondCard = new FlashCard("Demo", "None");
        FlashCard thirdCard = new FlashCard("New", "Card");

        flashCards.addCard(firstCard);
        flashCards.addCard(secondCard);
        flashCards.addCard(thirdCard);
    }

}