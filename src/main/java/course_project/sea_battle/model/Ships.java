package course_project.sea_battle.model;

public interface Ships {

    boolean getOrientation();
    int getSize();
    boolean isDead();
    boolean shot(int a, int b);

}

