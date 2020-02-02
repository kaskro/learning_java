package lv.kaskro.learning.encryption_decryption;

public class Encoder {
    private final EncoderStrategy strategy;

    public Encoder(EncoderStrategy strategy) {
        this.strategy = strategy;
    }

    public String encode(String message, int offset) {
        return strategy.convert(message, offset);
    }

    public String decode(String message, int offset) {
        return strategy.convert(message, (offset * (-1)));
    }
}
