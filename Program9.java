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

class Field{
    public void printGrid(int a[][]){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.println(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
