package lv.kaskro.learning.flashcards;

import java.util.Objects;

public class FlashCard {
    private String term;
    private String definition;

    FlashCard(){}

    FlashCard(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }


    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public boolean isTerm(String term) {
        return this.term.equals(term);
    }

    public boolean isDefinition(String definition) {
        return this.definition.equals(definition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashCard)) return false;
        FlashCard flashCard = (FlashCard) o;
        return Objects.equals(term, flashCard.term) &&
                Objects.equals(definition, flashCard.definition);
    }

    @Override
    public String toString() {
        return "FlashCard{" +
                "term='" + term + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
