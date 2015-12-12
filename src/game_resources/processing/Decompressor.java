package game_resources.processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Decompressor {

    private String filePath;

    public Object[] process(String filePath) {

        Object[] array;

        this.filePath = filePath;
        array = readFile();

        return array;

    }

    private Object[] readFile() {

        List<Object> tempArray = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            while (reader.ready()) {

                line = reader.readLine();
                for (String object: line.split(" ")) {

                    tempArray.add(object);

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        Object[] array =  tempArray.toArray(new Object[tempArray.size()]);

        return array;

    }

}

//String[] stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);
