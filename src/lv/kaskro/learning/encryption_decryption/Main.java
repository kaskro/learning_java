package lv.kaskro.learning.encryption_decryption;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static boolean hasArg(String[] arr, String name) {
        boolean hasArg = false;
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 2 == 0) {
                if (arr[i - 1].equals(name)) {
                    hasArg = true;
                    break;
                }
            }
        }
        return hasArg;
    }

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String fileOut = "";
        String alg = "shift";
        Encoder encoder;
        for (int i = 0; i < args.length; i++) {
            if ((i + 1) % 2 == 0) {
                switch (args[i - 1]) {
                    case "-mode":
                        mode = args[i];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i]);
                        break;
                    case "-data":
                        data = args[i];
                        break;
                    case "-in":
                        if (!hasArg(args, "-data")) {
                            try {
                                data = readFileAsString(args[i]);
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        break;
                    case "-out":
                        fileOut = args[i];
                        break;
                    case "-alg":
                        alg = args[i];
                        break;
                }
            }
        }

        if (alg.equals("unicode")) {
            encoder = new Encoder(new UnicodeStrategy());
        } else {
            encoder = new Encoder(new ShiftStrategy());
        }

        if (fileOut.equals("")) {
            if (mode.equals("dec")) {
                System.out.println(encoder.decode(data, key));
            } else {
                System.out.println(encoder.encode(data, key));
            }
        } else {
            File file = new File(fileOut);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(mode.equals("dec") ? encoder.decode(data, key) : encoder.encode(data, key));
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
