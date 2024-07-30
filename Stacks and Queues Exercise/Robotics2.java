package Demo;

import java.util.*;

public class Robotics2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ROB-15;SS2-10;NX8000-3
        String[] inputRobots = scanner.nextLine().split(";");
        LinkedHashMap<String, Integer> robots = getLinkedHashMap(inputRobots);

        //8:00:00
        String time = scanner.next();
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);

        long totalTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();  // queue
        int[] workingTime = new int[robots.size()];

        String product = scanner.next();
        while (!"End".equals(product)) {
            products.offer(product);
            product = scanner.next();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            totalTimeInSeconds++;
            boolean isAssigned = false;

            // ROB-15 -> "ROB 14"
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] > 0) {
                    workingTime[i]--;
                }
            }

            //robot will working
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] == 0) {

                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                        if (count == i) {
                            workingTime[i] = robot.getValue();
                            long takenHour = totalTimeInSeconds / 3600 % 24;
                            long takenMinute = totalTimeInSeconds % 3600 / 60;
                            long takenSeconds = totalTimeInSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), currentProduct,
                                    takenHour, takenMinute, takenSeconds);
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }
                    break;

                }
            }
            if (!isAssigned) {
            products.offer(currentProduct);
            }

        }

    }


    private static LinkedHashMap<String, Integer> getLinkedHashMap(String[] inputRobots) {
        //ROB-15;SS2-10;NX8000-3
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < inputRobots.length; i++) {
            String name = inputRobots[i].split("-")[0];
            int time = Integer.parseInt(inputRobots[i].split("-")[1]);
            // map
            robots.put(name, time);
        }
        return robots;
    }
}