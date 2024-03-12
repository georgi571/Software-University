package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.models.magics;

public class BlackMagic extends MagicImpl {
    private static final int BULLETS = 10;
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() >= 10) {
            super.setBulletsCount(super.getBulletsCount() - BULLETS);
            return BULLETS;
        }
        super.setBulletsCount(0);
        return 0;
    }
}
