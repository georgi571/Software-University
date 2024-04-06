package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._01HighQualityStructure.restaurant.models.waiter;

public class FullTimeWaiter extends BaseWaiter {
    private static final int EFFICIENCY = 8;
    public FullTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {
        if (super.getEfficiency() > 0) {
            super.setEfficiency(super.getEfficiency() - 1);
        } else {
            super.setEfficiency(0);
        }
    }
}
