package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int BULLETS_PER_SHOT = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (super.getBulletsPerBarrel() < BULLETS_PER_SHOT) {
            if (super.getTotalBullets() > BULLETS_PER_BARREL) {
                super.setTotalBullets(super.getTotalBullets() - (BULLETS_PER_BARREL -super.getBulletsPerBarrel()));
                super.setBulletsPerBarrel(BULLETS_PER_BARREL);
            } else {
                super.setBulletsPerBarrel(super.getTotalBullets());
                super.setTotalBullets(0);
            }
        }
        super.setBulletsPerBarrel(super.getBulletsPerBarrel() - BULLETS_PER_SHOT);
        return BULLETS_PER_SHOT;
    }
}
