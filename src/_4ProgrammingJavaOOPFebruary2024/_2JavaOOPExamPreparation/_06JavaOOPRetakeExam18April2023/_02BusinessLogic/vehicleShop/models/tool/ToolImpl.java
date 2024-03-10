package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.tool;


import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.common.ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO;

public class ToolImpl implements Tool {

    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public void decreasesPower() {
        this.power -= 5;
        if (this.power < 0) {
            this.power = 0;
        }
    }

    @Override
    public boolean isUnfit() {
        return this.power == 0;
    }
}
