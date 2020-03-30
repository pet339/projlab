package hu.bme.team5;

public class Iceberg extends Field {
    private boolean igloo;
    private Item frozenItem;

    public Iceberg() {
        super();
    }

    @Override
    void stepOn(Character c) {

    }

    public void setIgloo(boolean igloo) {
        System.out.println(">setIgloo()");
        this.igloo = igloo;
        System.out.println("<setIgloo()");
    }

    public Item getFrozenItem() {
        return frozenItem;
    }

    public void setFrozenItem(Item i){
        frozenItem = i;
    }


}
