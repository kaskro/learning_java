package lv.kaskro.learning.encryption_decryption;

public interface EncoderStrategy {
    String convert(String message, int offset);
}
