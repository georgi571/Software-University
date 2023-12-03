package _2ProgrammingFundamentalsWithJavaSeptember2023._4FinalExam._2OtherExam;

import java.util.*;

public class _03Followers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> followers = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Log out")) {
            String[] commandParts = command.split(":\\s+");
            String currentCommand = commandParts[0];
            String name =commandParts[1];
            if (currentCommand.equals("New follower")) {
                if (!followers.containsKey(name)) {
                    List<Integer> counters= new ArrayList<>();
                    counters.add(0);
                    counters.add(0);
                    followers.put(name,counters);
                }
            } else if (currentCommand.equals("Like")) {
                int like = Integer.parseInt(commandParts[2]);
                if (!followers.containsKey(name)) {
                    List<Integer> counters= new ArrayList<>();
                    counters.add(like);
                    counters.add(0);
                    followers.put(name, counters);
                }else {
                    int likes = followers.get(name).get(0);
                    followers.get(name).set(0, likes + like);
                }
            } else if (currentCommand.equals("Comment")) {
                if (!followers.containsKey(name)) {
                    List<Integer> counters= new ArrayList<>();
                    counters.add(0);
                    counters.add(1);
                    followers.put(name, counters);
                }else {
                    int comments = followers.get(name).get(1);
                    followers.get(name).set(1, comments + 1);
                }
            } else if (currentCommand.equals("Blocked")) {
                if (followers.containsKey(name))
                {
                    followers.remove(name);
                }else {
                    System.out.printf("%s doesn't exist.%n",name);
                }
            }
            command=scanner.nextLine();
        }
        int count = followers.size();
        System.out.println(count+ " " + "followers");
        followers.entrySet().forEach(entry -> {
            int counter = entry.getValue().get(0) + entry.getValue().get(1);
            System.out.printf("%s: %d%n",entry.getKey(), counter);
        });
    }
}
