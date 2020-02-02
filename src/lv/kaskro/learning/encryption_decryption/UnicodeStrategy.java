package lv.kaskro.learning.encryption_decryption;

class UnicodeStrategy implements EncoderStrategy {
    public String convert(String message, int offset) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            output.append((char) (message.codePointAt(i) + offset));
        }
        return output.toString();
    }
}
