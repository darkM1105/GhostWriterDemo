import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/*
* Code based off source code from:
* https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/
* examples/events/KeyEventDemoProject/src/events/KeyEventDemo.java
*/
public class Demo extends JFrame implements KeyListener, ActionListener{

    JTextField typingArea;
    JTextArea displayArea;
    static final String nl = System.getProperty("line.separator");
    long firstPressed = 0;
    long lastKeyTypedAt = 0;
    ArrayList<Character> characters = new ArrayList<>();
    ArrayList<Long> timeDifference = new ArrayList<>();
    Thread t;


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        UIManager.put("swing.boldMetal", Boolean.FALSE);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {

        Demo frame = new Demo("Ghost Writer Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addComponentsToPane();

        frame.pack();
        frame.setVisible(true);
    }

    private void addComponentsToPane() {

        JButton button = new JButton("Play & Clear");
        button.addActionListener(this);

        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);
        //typingArea.setFocusTraversalKeysEnabled(false);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(375, 125));

        getContentPane().add(typingArea, BorderLayout.PAGE_START);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.PAGE_END);
    }

    public Demo(String name) {
        super(name);
    }

    public void keyTyped(KeyEvent e) {
        recordInfo(e);
    }

    //Used to get a starting time stamp. Using a 'long' in this case.
    public void keyPressed(KeyEvent e) {
        if(firstPressed == 0) {
            firstPressed = e.getWhen();
        }
    }

    public void keyReleased(KeyEvent e) {}

    /** Handle the button click. */
    public void actionPerformed(ActionEvent e) {
        playBack();
    }

    public void recordInfo(KeyEvent e) {
        long timeDif;

        if (lastKeyTypedAt == 0) {
            lastKeyTypedAt = firstPressed;
        }

        timeDif = e.getWhen() - lastKeyTypedAt;

        lastKeyTypedAt = e.getWhen();
        characters.add(e.getKeyChar());
        timeDifference.add(timeDif);
    }

    public void playBack() {
        t = new Thread(new Counter(characters, timeDifference, displayArea));
        t.run();
        cleanUp();
        t = null;
    }

    public void cleanUp(){
        firstPressed = 0;
        lastKeyTypedAt = 0;
        characters.clear();
        timeDifference.clear();
        typingArea.setText("");

        //Reset focus to the typing area.
        typingArea.requestFocusInWindow();
    }

}
