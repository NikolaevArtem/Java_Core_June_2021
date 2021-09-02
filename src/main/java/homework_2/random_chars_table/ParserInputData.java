package homework_2.random_chars_table;

public class ParserInputData {

    public InputData parserInputRandomData(String input) throws ParserError {

        String[] arrayWithInputData = input.trim().split(" ");
        try {
            int row = Integer.parseInt(arrayWithInputData[0]);
            int column = Integer.parseInt(arrayWithInputData[1]);

            String typeOfParity = arrayWithInputData[2];

            if(arrayWithInputData.length != 3) {
                throw new ParserError("Should be typed 3 parameters (e.g. 3 3 odd)");
            }

            if(row < 0 || column < 0) {
                throw new ParserError("negative isn't allowed");
            }

            if(!typeOfParity.equals("even") && !typeOfParity.equals("odd")) {
                throw new ParserError("Wrong type parameter");
            }

            return new InputData(row, column, typeOfParity);

        } catch(NumberFormatException ex) {
            throw new ParserError("Invalid data");
        }
    }
}
