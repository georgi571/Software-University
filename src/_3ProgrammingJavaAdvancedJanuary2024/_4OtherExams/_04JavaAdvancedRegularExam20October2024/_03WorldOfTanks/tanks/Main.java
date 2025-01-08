package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._04JavaAdvancedRegularExam20October2024._03WorldOfTanks.tanks;

public class Main {
    public static void main(String[] args) {

//Initialize the repositories
        Terrain swamp = new Terrain("Swamp", 400);
        Terrain valley = new Terrain("Valley", 1400);
        Terrain gorge = new Terrain("Gorge", 800);
        Terrain desert = new Terrain("Desert", 200);
//Initialize entities
        Tank mark = new Tank("Mark", "V", 29000, 57, 12);
        Tank renault = new Tank("Renault", "FT", 6500, 37, 22);
        Tank m4 = new Tank("M4", "Sherman", 30300, 105, 177);
        Tank tiger = new Tank("Tiger", "I", 54000, 88, 120);
        Tank schneider = new Tank("Schneider", "CA", 13600, 75, 30);

        System.out.println(swamp.addTank(mark));
        //This Mark is too heavy for this terrain!
        System.out.println(swamp.addTank(renault));
        //Tank Renault FT added.
        System.out.println(swamp.getTankByBrandAndModel("Renault", "FT"));
        //Brand: Renault, Model: FT, Weight: 6500kg, Barrel caliber: 37mm, Armor: 22mm
        System.out.println(swamp.addTank(m4));
        //This M4 is too heavy for this terrain!
        System.out.println(valley.addTank(renault));
        //Tank Renault FT added.
        System.out.println(valley.addTank(tiger));
        //Tank Tiger I added.
        System.out.println(valley.addTank(m4));
        //Tank M4 Sherman added.
        System.out.println(valley.addTank(m4));
        //Tank with this brand and model already exists!
        System.out.println(valley.getCount());
        //3
        System.out.println(desert.addTank(schneider));
        //Tank Schneider CA added.
        System.out.println(desert.removeTank("Panzer", "IV"));
        //false
        System.out.println(desert.removeTank("Schneider", "CA"));
        //true
        System.out.println(valley.getTheMostArmoredTank());
        //M4 Sherman is the most armored tank with 177mm. armor thickness.
        System.out.println(valley.getTanksByBarrelCaliberMoreThan(80));
        //Tanks with caliber more than 80mm: Tiger, M4
        System.out.println(swamp.getStatistics());
        //Tanks located in the swamp:
        //-- Renault FT
        System.out.println(valley.getStatistics());
        //Tanks located in the valley:
        //-- Renault F
        //-- Tiger I
        //-- M4 Sherman
        System.out.println(gorge.getStatistics());
        //There are no tanks in the gorge.
        System.out.println(desert.getStatistics());
        //There are no tanks in the desert.
    }
}
