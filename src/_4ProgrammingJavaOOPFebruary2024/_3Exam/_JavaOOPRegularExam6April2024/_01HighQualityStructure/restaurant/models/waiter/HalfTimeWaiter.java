package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._01HighQualityStructure.restaurant.models.waiter;

public class HalfTimeWaiter extends BaseWaiter {
    private static final int EFFICIENCY = 4;
    public HalfTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {
        if (super.getEfficiency() > 1) {
            super.setEfficiency(super.getEfficiency() - 2);
        } else {
            super.setEfficiency(0);
        }
    }
}
