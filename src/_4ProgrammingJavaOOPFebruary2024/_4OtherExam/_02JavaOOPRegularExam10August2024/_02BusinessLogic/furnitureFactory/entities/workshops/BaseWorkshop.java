package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.workshops;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.wood.Wood;

public abstract class BaseWorkshop implements Workshop {
    private int woodQuantity;
    private int producedFurnitureCount;
    private int woodQuantityReduceFactor;

    public BaseWorkshop(int woodQuantity, int woodQuantityReduceFactor) {
        this.woodQuantity = woodQuantity;
        this.producedFurnitureCount = 0;
        this.woodQuantityReduceFactor = woodQuantityReduceFactor;
    }

    public void setWoodQuantity(int woodQuantity) {
        this.woodQuantity = Math.max(woodQuantity, 0);
    }

    @Override
    public int getWoodQuantity() {
        return this.woodQuantity;
    }

    @Override
    public int getProducedFurnitureCount() {
        return this.producedFurnitureCount;
    }

    @Override
    public int getWoodQuantityReduceFactor() {
        return this.woodQuantityReduceFactor;
    }

    @Override
    public void addWood(Wood wood) {
        this.woodQuantity += 200;
    }

    @Override
    public void produce() {
        this.setWoodQuantity(this.getWoodQuantity() - this.woodQuantityReduceFactor);
        this.producedFurnitureCount++;
    }
}
