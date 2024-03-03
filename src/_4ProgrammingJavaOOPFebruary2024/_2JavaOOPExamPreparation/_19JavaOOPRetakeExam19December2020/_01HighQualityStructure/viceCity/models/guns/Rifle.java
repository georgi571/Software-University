package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_PER_SHOT = 5;

    public Rifle(String name) {
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
        return BULLETS_PER_SHOT;
    }
}
