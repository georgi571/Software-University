package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._01HighQualityStructure.vehicleShop.models.worker;

public class SecondShift extends BaseWorker {
    private static final int STRENGTH = 70;

    public SecondShift(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void working() {
        if (super.getStrength() >= 5) {
            super.setStrength(super.getStrength() - 5);
        }
        super.working();
    }
}
