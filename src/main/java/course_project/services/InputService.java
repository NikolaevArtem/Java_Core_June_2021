package course_project.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputService {

    BufferedReader br;

    public InputService() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getInput() {
        try {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public void closeBuffer() throws IOException {
        br.close();
    }
}
