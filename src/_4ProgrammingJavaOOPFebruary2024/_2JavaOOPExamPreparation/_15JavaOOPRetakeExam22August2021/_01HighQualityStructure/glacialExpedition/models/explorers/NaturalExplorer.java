package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021._01HighQualityStructure.glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    private static final double ENERGY = 60;
    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        if (super.getEnergy() > 7) {
            super.setEnergy(super.getEnergy() - 7);
        } else {
            super.setEnergy(0);
        }
    }
}
