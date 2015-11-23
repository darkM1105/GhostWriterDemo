import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Matthew on 10/28/2015.
 */
public class Counter extends Thread {
    private ArrayList<Character> characters;
    private ArrayList<Long> timeDifference;
    private JTextArea displayArea;
    //private UIThread uiThread;

    public Counter(){
        this.characters = Demo.characters;
        this.timeDifference = Demo.timeDifference;
        this.displayArea = Demo.displayArea;
    }

    public void run(){
        //uiThread = new UIThread();
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
            displayArea.repaint();
            //uiThread.append(character);
        }
    }
}

// Need a new Thread that supplies UI with the characters.
