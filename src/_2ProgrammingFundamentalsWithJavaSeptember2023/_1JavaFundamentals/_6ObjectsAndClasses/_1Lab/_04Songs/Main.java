package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._1Lab._04Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("_");
            String typeList = data[0];
            String name = data[1];
            String time = data[2];
            Song song = new Song(typeList, name, time);
            songList.add(song);
        }
        String printTypeList = scanner.nextLine();
        if (printTypeList.equals("all")) {
            for (Song song : songList) {
                System.out.printf("%s%n", song.getName());
            }
        } else {
            for (Song song : songList) {
                if (song.getTypeList().equals(printTypeList)) {
                    System.out.printf("%s%n", song.getName());
                }
            }
        }
    }
}
