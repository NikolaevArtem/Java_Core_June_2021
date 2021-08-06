package homework_4.singleton;

import homework_4.custom_file_reader.CustomFileReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*
    Bill Pugh Singleton Implementation
 */

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
        JButton button1 = new JButton("read file using FileInputStream and custom annotation");
        JButton button2 = new JButton("read file using InputStream");
        JButton button3 = new JButton("read file using NIO");
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);

        CustomFileReader customFileReader = new CustomFileReader();
        addButtonListener(button1, customFileReader, 1);
        addButtonListener(button2, customFileReader, 2);
        addButtonListener(button3, customFileReader, 3);

        // Adding Components to the frame
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);
    }

    private void addButtonListener(JButton button, CustomFileReader customFileReader, int methodNumber) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buttonActionPerfromed(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            private void buttonActionPerfromed(ActionEvent e) throws IOException {
                if (methodNumber == 1) {
                    customFileReader.run1();
                } else if (methodNumber == 2) {
                    customFileReader.run2();
                } else if (methodNumber == 3) {
                    customFileReader.run3();
                } else throw new IOException();
            }
        });
    }

}
