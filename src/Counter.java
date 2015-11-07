import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Matthew on 10/28/2015.
 */
public class Counter implements Runnable {
    private ArrayList<Character> characters;
    private ArrayList<Long> timeDifference;
    private JTextArea displayArea;
    private static final String nl = System.getProperty("line.separator");

    public Counter(ArrayList<Character> characters, ArrayList<Long> timeDifference, JTextArea displayArea){
        this.characters = characters;
        this.timeDifference = timeDifference;
        this.displayArea = displayArea;
    }

    public void run(){
        String character;
        long time;
        int count = characters.size();

        for(int i = 0; i < count; i++){
            character = String.valueOf(characters.get(i));
            time = timeDifference.get(i);

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            displayArea.append(character);
            displayArea.revalidate();
        }
        displayArea.append(nl);
    }
}

// Need a new Thread that supplies UI with the characters.
