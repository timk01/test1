package sept16_oop.java.ru.otus.lesson_30.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public InputStream readFile(String path) {
        return this.getClass().getClassLoader().getResourceAsStream(path);
    }

    public String[] readAllFileLines(String path) {
        InputStream stream = readFile(path);
        List<String> result = new ArrayList<>();
        try (InputStreamReader ir = new InputStreamReader(stream); BufferedReader reader = new BufferedReader(ir)) {

            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result.toArray(new String[0]);
    }
}
