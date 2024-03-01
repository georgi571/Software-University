package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._01HighQualityStructure.magicGame.models.magics;

public class RedMagic extends MagicImpl {
    private static final int BULLETS = 1;
    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() >= 1) {
            super.setBulletsCount(super.getBulletsCount() - BULLETS);
            return BULLETS;
        }
        return 0;
    }
}
