package old_stuff;

import old_stuff.Demo;

import javax.swing.*;
/**
 * Created by Matthew on 11/11/2015.
 */
public class UIThread{
    private JTextArea displayArea = Demo.displayArea;
    String character;

    public void append(String character){
        this.character = character;
        Thread updateDisplayThread = new Thread(){
            public  void run() {
                try {
                    SwingUtilities.invokeAndWait(updateDisplay);
                }catch (Exception e){}
            }
        };
        updateDisplayThread.start();
    }

    final Runnable updateDisplay = new Runnable() {
        public void run() {
            displayArea.append(character);
        }
    };
}
