package hu.bme.team5;

import java.util.Random;

public class PolarBear extends Movable {
    Field currentField;
    public Field getRandomNeighbor(){
        Random rand = new Random();

        int size = currentField.neighbors.size();

        int rnd = rand.nextInt() % size;
        return currentField.neighbors.get(rnd);
    }

    public void kill(){
        if (currentField.movables.size() > 1){
           ; //ENDGAME                                   <------- megcsinálni
        }
    }
    public void move(){
        Field nextField = getRandomNeighbor();


        currentField.removeMovable(this);
        currentField.stepOn(this);
        setCurrentField(nextField);
        kill();
    }
    public void setCurrentField(Field f){
        currentField = f;
    }
}
