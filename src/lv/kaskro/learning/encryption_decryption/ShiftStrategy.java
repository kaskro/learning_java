package lv.kaskro.learning.encryption_decryption;

class ShiftStrategy implements EncoderStrategy {
    public String convert(String message, int offset) {
        int convertedChar;
        int maxRange;
        int minRange;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.codePointAt(i) >= 65 && message.codePointAt(i) <= 90 || message.codePointAt(i) >= 97 && message.codePointAt(i) <= 122) {
                maxRange = Character.isUpperCase(message.charAt(i)) ? 90 : 122;
                minRange = Character.isUpperCase(message.charAt(i)) ? 65 : 97;
                if (offset < 0) {
                    if (message.codePointAt(i) + offset < minRange) {
                        convertedChar = maxRange - (minRange - (message.codePointAt(i) + offset)) + 1;
                    } else {
                        convertedChar = message.codePointAt(i) + offset;
                    }
                } else {
                    if (message.codePointAt(i) + offset >= maxRange) {
                        convertedChar = minRange + (offset - (maxRange - message.codePointAt(i)) - 1);
                    } else {
                        convertedChar = message.codePointAt(i) + offset;
                    }
                }
                output.append((char) convertedChar);
            } else {
                output.append(message.charAt(i));
            }
        }
        System.out.println("Output: " + output);
        return output.toString();
    }
}
