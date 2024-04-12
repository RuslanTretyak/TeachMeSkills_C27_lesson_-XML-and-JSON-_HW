package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportFileWriter {
    public static void writeToFile(String parser, String firstName,
                                   String lastName, String title, StringBuilder lines) throws IOException {
        String fileName = firstName + "_" + lastName + "_" + title + ".txt";
        File file = new File(fileName);
        file.createNewFile();
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write("used parser - " + parser + "\n" + lines.toString());
        }
    }
}
