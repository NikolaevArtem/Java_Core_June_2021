package homework_4.singleton;

import homework_4.custom_file_reader.CustomFileReader;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Bill Pugh Singleton Implementation
public class SingletonMenu {

    private SingletonMenu() {
        guiGenerator();
    }

    private static class SingletonHelper {
        private static final SingletonMenu INSTANCE = new SingletonMenu();
    }

    public static SingletonMenu getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private void guiGenerator() {
        JFrame frame = new JFrame("Singleton Menu for CustomFileReader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);

        JPanel mainPanel = new JPanel();
        JButton button1 = new JButton("read file using Scanner");
        JButton button2 = new JButton("read file using BufferedReader");
        JButton button3 = new JButton("read file using NIO");
        JButton button4 = new JButton("read file using InputStreamReader");
        JButton button5 = new JButton("show files in directory");
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button4);
        mainPanel.add(button5);

        CustomFileReader customFileReader = new CustomFileReader();
        addButtonListener(button1, customFileReader, 1);
        addButtonListener(button2, customFileReader, 2);
        addButtonListener(button3, customFileReader, 3);
        addButtonListener(button4, customFileReader, 4);
        addButtonListener(button5, customFileReader, 10);

        // Adding Components to the frame
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);
    }

    private void addButtonListener(@NotNull JButton button, CustomFileReader customFileReader, int methodNumber) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonActionPerformed();
            }

            private void buttonActionPerformed() {
                if (methodNumber == 1) {
                    customFileReader.run1();
                } else if (methodNumber == 2) {
                    customFileReader.run2();
                } else if (methodNumber == 3) {
                    customFileReader.run3();
                } else if (methodNumber == 4) {
                    customFileReader.run4();
                } else if (methodNumber == 10) {
                    customFileReader.showDir();
                } else throw new IllegalArgumentException();
            }
        });
    }

}
