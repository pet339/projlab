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

    public Item getFrozenItem() {
        return frozenItem;
    }

    public void setFrozenItem(Item i){
        frozenItem = i;
    }


}
