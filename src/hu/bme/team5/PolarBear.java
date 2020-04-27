package hu.bme.team5;

import java.util.Random;

public class PolarBear {
    Field currentField;
    public Field getRandomNeighbor(){
        Random rand = new Random();

        int size = currentField.neighbors.size();

        int rnd = rand.nextInt() % size;
        return currentField.neighbors.get(rnd);
    }

    public void kill(){
        if (currentField.characters.size() > 1){
           if(!currentField.igloo){
               ;
           }
            
        }
    }
    public void move(){
        Field nextField = getRandomNeighbor();

         //remove polarbear
        currentField.polarBear = false;
        setCurrentField(nextField);
        currentField.polarBear = true;
        kill();
    }
    public void setCurrentField(Field f){
        currentField = f;
    }
}
