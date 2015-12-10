package old_stuff;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Matthew on 10/28/2015.
 */
public class Counter extends Thread {
    public void run(){
        String character;
        long time;
        int count = Demo.characters.size();

        for(int i = 0; i < count; i++){
            character = String.valueOf(Demo.characters.get(i));
            time = Demo.timeDifference.get(i);

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Demo.displayArea.append(character);
            Demo.displayArea.repaint();
            //uiThread.append(character);
        }
    }
}

// Need a new Thread that supplies UI with the characters.
