package homework_2.bufferReaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReader {

    public int bufferReaderConsole() throws IOException {
        System.out.print("Please, enter number of seconds...");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            try {
                int i = Integer.parseInt(reader.readLine());
                if(i < 0){
                    System.err.println("Error, negative numbers are not valid");
                    return bufferReaderConsole();
                } else if( i >= 86400){
                    System.err.println("it's a new day...");
                    return bufferReaderConsole();
                }
                return i;
            }catch (NumberFormatException ex){
                System.err.println ("Text isn't allowed");
                return bufferReaderConsole();
            }
        }
    }

    public String bufferReaderConsoleForRandom() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader (System.in))) {
            return reader.readLine();
        }
    }

    public int bufferReaderForPyramid() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader (System.in))){
            try {
                int i = Integer.parseInt(reader.readLine());
                if(i < 0){
                    System.err.println("Error, negative numbers are not valid");
                    return bufferReaderForPyramid();
                }
                return i;
            }catch (NumberFormatException ex){
                System.err.println ("Text isn't allowed");
                return bufferReaderForPyramid ();
            }
        }
    }

}
