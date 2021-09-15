package course_project.sea_battle.model;

public class Ship implements Ships {

    private final boolean orientation;
    private final int startPositionA;
    private final int startPositionB;
    private final int size;
    private int damage;

    public Ship(boolean orientation, int startPositionA, int startPositionB, int size) {
        this.orientation = orientation;
        this.startPositionA = startPositionA;
        this.startPositionB = startPositionB;
        this.size = size;
        this.damage = 0;
    }

    public int getStartPositionA() {
        return startPositionA;
    }
    public int getStartPositionB() {
        return startPositionB;
    }

    @Override
    public boolean isDead() {
        return size==damage;
    }

    @Override
    public boolean getOrientation() {
        return orientation;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean shot(int pointA, int pointB) {
        boolean damageThis = false;
        if(getOrientation()){
            for(int i = startPositionA; i<startPositionA+size; i++){
                if(i==pointA&&pointB==startPositionB){
                    damageThis = true;
                }
            }
        } else {
            for(int i = startPositionB; i<startPositionB+size; i++){
                if(pointA==startPositionA&&(i==pointB)){
                    damageThis = true;
                }
            }
        }
        if(damageThis){
            takeDamage();
        }
        return damageThis;
    }

    @Override
    public void takeDamage() {
        this.damage++;
    }
}
