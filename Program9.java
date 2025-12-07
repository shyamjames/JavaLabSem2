/* 9. The 15-puzzle (also known as the sliding puzzle) consists of a 4×4 grid containing 15
numbered tiles (from 1 to 15) and one empty space. The objective is to rearrange the
tiles by sliding them horizontally or vertically into the empty space to achieve the
correct ascending order, as shown below: [Experiential Learning]
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 _

@Shyam James
Roll No: 54
30/11/25
*/

import java.util.*;

class Puzzle {
    int[] a;
    int x;
    int count;

    Puzzle() {
        count = 0;
        a = new int[16];
        
        for (int i = 0; i < 15; i++) {
            a[i] = i + 1;
        }
        a[15] = 0;
        
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            int j = r.nextInt(15);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        x = 15;
    }

    void draw() {
        for (int i = 0; i < 16; i++) {
            if (a[i] == 0) {
                System.out.printf("%-4c", '_');
            } else {
                System.out.printf("%-4d", a[i]);
            }
            
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
    }

    boolean won() {
        for (int i = 0; i < 15; i++) {
            if (a[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    void move() {
        Scanner s = new Scanner(System.in);
        char dir;
        int temp;

        while (true) {
            draw();
            System.out.println("Click [w][a][s][d] to move:");
            dir = s.next().charAt(0);
            count++;

            if (dir == 'W' || dir == 'w') {
                if ((x - 4) < 0) {
                    System.out.println("Unable to move up!!");
                } else {
                    temp = a[x];
                    a[x] = a[x - 4];
                    a[x - 4] = temp;
                    x = x - 4;
                }
            } 
            else if (dir == 'A' || dir == 'a') {
                if (x % 4 == 0) {
                    System.out.println("Unable to move left!!");
                } else {
                    temp = a[x];
                    a[x] = a[x - 1];
                    a[x - 1] = temp;
                    x = x - 1;
                }
            } 
            else if (dir == 'S' || dir == 's') {
                if ((x + 4) > 15) {
                    System.out.println("Unable to move down!!");
                } else {
                    temp = a[x];
                    a[x] = a[x + 4];
                    a[x + 4] = temp;
                    x = x + 4;
                }
            } 
            else if (dir == 'D' || dir == 'd') {
                if ((x + 1) % 4 == 0) {
                    System.out.println("Unable to move right!!");
                } else {
                    temp = a[x];
                    a[x] = a[x + 1];
                    a[x + 1] = temp;
                    x = x + 1;
                }
            }

            if (won()) {
                System.out.println("Congrats You Won in " + count + " moves");
                break;
            }
        }
    }
}

public class Program9 {
    public static void main(String[] args) {
        Puzzle obj = new Puzzle();
        obj.move();
    }
}
