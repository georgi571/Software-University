package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._02JavaAdvancedRegularExam22June2024._03VintageLocos.vintageLocos;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Initialize the repositories (Train station)
        TrainStation deptford = new TrainStation("Deptford Train station", 5, 1435);
        TrainStation euston = new TrainStation("Euston", 2, 1524);

//Initialize entities (Locomotive)
        Locomotive puffingBilly = new Locomotive("Puffing Billy", "Jonathan Forster", LocalDate.of(1814, 1, 1), 1524, 8250, 8);

        Locomotive flyingScotsman = new Locomotive("Flying Scotsman", "Doncaster Works", LocalDate.of(1923, 2, 14), 1435, 96250, 161);

        Locomotive cityOfTruro = new Locomotive("City of Truro", "GWR Swindon Works", LocalDate.of(1903, 4, 1), 1435, 56200, 160);

        deptford.addLocomotive(flyingScotsman);
//The rail gauge of this station does not match the locomotive gauge! Difference: 89 mm.
        deptford.addLocomotive(puffingBilly);
        deptford.addLocomotive(cityOfTruro);
        euston.addLocomotive(puffingBilly);

        System.out.println(euston.removeLocomotive("Puffing Billy")); //true
        System.out.println(euston.removeLocomotive("Silver Star"));   //false

        System.out.println(deptford.getFastestLocomotive());
//Flying Scotsman is the fastest locomotive with a maximum speed of 161 km/h.

        System.out.println(euston.getFastestLocomotive());   //There are no locomotives.
        System.out.println(euston.getOldestLocomotive());    //There are no locomotives.

        System.out.println(deptford.getLocomotive("Flying Scotsman"));
//This Flying Scotsman is made by Doncaster Works at 14.02.1923.

        System.out.println(deptford.getOldestLocomotive());   //City of Truro
        System.out.println(deptford.getCount());   //2
        System.out.println(deptford.getStatistics());
//Locomotives departed from Deptford Train station:
//1. Flying Scotsman
//2. City of Truro

        System.out.println(euston.getStatistics());
//There are no locomotives departing from Euston station.

    }
}