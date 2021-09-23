package homework_2.traffic_light;

public class TrafficLightExtraMode extends TrafficLight {

    @Override
    protected boolean isValid(String inputString) {
        if(inputString == null) {
            return false;
        }
        if (!inputString.contains(":")) {
            return false;
        }
        String[] time = inputString.split(":");
        if (time.length != 3) {
            return false;
        }
        try {
            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);
            int seconds = Integer.parseInt(time[2]);
            if ((hours < 0)
                    || (minutes < 0 || minutes > 59)
                    || (seconds < 0 || seconds > 59)) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    protected int getSeconds(String inputString) {
        String[] time = inputString.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        return hours * 60 * 60 + minutes * 60 + seconds;
    }

    @Override
    protected void printErrorMessage() {
        System.out.println("Only input in format hh:mm:ss is allowed");
    }
}
