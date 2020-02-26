package lv.kaskro.learning.flashcards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlashCardTest {

    @Test
    void getTerm() {

        FlashCard flashCard = new FlashCard();

        assertNull(flashCard.getTerm());
    }

    @Test
    void setTerm() {

        String term = "Demo";
        FlashCard flashCard = new FlashCard();
        flashCard.setTerm(term);

        assertEquals(term, flashCard.getTerm());
    }

    @Test
    void getDefinition() {

        FlashCard flashCard = new FlashCard();

        assertNull(flashCard.getDefinition());
    }

    @Test
    void setDefinition() {

        String definition = "Demo";
        FlashCard flashCard = new FlashCard();
        flashCard.setDefinition(definition);

        assertEquals(definition, flashCard.getDefinition());
    }
}