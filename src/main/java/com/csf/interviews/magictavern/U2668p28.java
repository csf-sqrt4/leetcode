package com.csf.interviews.magictavern;

import java.io.*;

public class U2668p28 {
    public static void main(String[] args) throws Exception {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder command = new StringBuilder();
            for (char c : br.readLine().trim().toCharArray()) {
                if (Character.isDigit(c)) {
                    continue;
                }
                command.append(c);
            }

            if (!command.toString().contains("S")) {
                System.out.println("no");
                return;
            }
            String direction = "N";
            for (char c : command.toString().toCharArray()) {
                switch (direction) {
                    case "N":
                        if (c == 'L') {
                            direction = "W";
                        } else if (c == 'R') {
                            direction = "E";
                        }
                        break;
                    case "S":
                        if (c == 'L') {
                            direction = "E";
                        } else if (c == 'R') {
                            direction = "W";
                        }
                        break;
                    case "W":
                        if (c == 'L') {
                            direction = "S";
                        } else if (c == 'R') {
                            direction = "N";
                        }
                        break;
                    case "E":
                        if (c == 'L') {
                            direction = "N";
                        } else if (c == 'R') {
                            direction = "S";
                        }
                        break;
                }
            }
            System.out.println(direction.equals("N") ? "yes" : "no");
        }
    }

}
