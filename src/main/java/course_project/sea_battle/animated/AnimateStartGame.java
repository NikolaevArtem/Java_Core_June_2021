package course_project.sea_battle.animated;

public class AnimateStartGame extends Thread {
    @Override
    public void run() {
        System.out.println("*****************************");
        String str = "\u001B[31m" + " WELCOME TO BATTLESHIPS GAME" + "\u001B[0m";

        try {
            Thread.sleep(2000);
            for (Character character : str.toCharArray()) {
                System.out.print(character);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n*****************************");
    }
}
