package hu.bme.team5;

import java.util.Random;

public class PolarBear {
    Field currentField;
    public Field getRandomNeighbor(){
        Random rand = new Random();

        int size = currentField.neighbors.size();

        int rnd = rand.nextInt(size);
        return currentField.neighbors.get(rnd);
    }

    public void kill(){
        if (currentField.characters.size() > 0){
           if(!currentField.igloo){
              currentField.gameEnded(false);
           }
            
        }
    }
    public void move(){
        Field nextField = getRandomNeighbor();
        System.out.print("bear moves, new positon: ");
         //remove polarbear
        currentField.polarBear = false;
        setCurrentField(nextField);
        currentField.polarBear = true;

        int newField = currentField.map.fields.indexOf(currentField) + 1;
        System.out.println(newField);
        kill();
    }
    public void setCurrentField(Field f){
        currentField = f;
    }

    public String draw(){
        return "bin/img/pix_polar.png";
    }
}
