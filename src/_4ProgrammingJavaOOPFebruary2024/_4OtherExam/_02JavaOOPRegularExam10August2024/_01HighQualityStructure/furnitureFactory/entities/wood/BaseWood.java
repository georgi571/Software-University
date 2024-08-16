package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._01HighQualityStructure.furnitureFactory.entities.wood;

public abstract class BaseWood implements Wood {
    private int woodQuantity;

    public BaseWood(int wood) {
        this.woodQuantity = wood;
    }

    @Override
    public int getWoodQuantity() {
        return this.woodQuantity;
    }
}
