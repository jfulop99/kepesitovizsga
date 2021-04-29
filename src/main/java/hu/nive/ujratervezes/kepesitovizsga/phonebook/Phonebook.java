package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(output))){
            writeLines(contacts, writer);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file!");
        }
    }

    private void writeLines(Map<String, String> contacts, BufferedWriter writer) throws IOException {
        for (Map.Entry<String, String > entry: contacts.entrySet()) {
            String line = String.format("%s: %s%n",entry.getKey(), entry.getValue());
            writer.write(line);
        }
    }
}
