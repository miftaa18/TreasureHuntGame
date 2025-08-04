
import java.util.Scanner;
public class TreasureHunt2D{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int [][] arr2D = {{0, 0, 10, 0, -1},
                      {0, -1, 0, 0, -1},
                      {-1, 0, -1, 0, 0},
                      {0, -1, 7, 0, -1},
                      {0, -1, 0, -1, 0}
    };
    System.out.println("Initial Map:");
    printMap(arr2D);
    int row = arr2D.length;
    int col = arr2D[0].length;
    int row_pos = -1, col_pos = -1;
    for(int i =0;i<row;i++){
      for(int j =0;j<col;j++){
        if(arr2D[i][j]==7){
          row_pos=i;
          col_pos=j;
          break;
        }
      }
    }
    int turns = 5;
    while (turns > 0) {
      int new_row = row_pos, new_col = col_pos;
      System.out.printf("Enter move %d: ",(6-turns));
      String inp = sc.nextLine();
      if (inp.equals("UP")) {
       new_row = row_pos - 1;
     }
      else if (inp.equals("DOWN")) {
      new_row = row_pos + 1;
     }
      else if (inp.equals("LEFT")) {
        new_col = col_pos - 1;
       } 
  else if (inp.equals("RIGHT")) {
            new_col = col_pos + 1;
        } 
            else {
  System.out.println("Invalid input. Please enter UP, DOWN, LEFT, or RIGHT.");
        continue; 
       }
   if (new_row < 0 || new_row >= row || new_col < 0 || new_col >= col) {
       System.out.println("Player fell outside the playing area. Game over!");
                return;
            }
    if (arr2D[new_row][new_col] == -1) {
       System.out.println("Player stepped on mine. Game Over!");
                return;
            }
   if (arr2D[new_row][new_col] == 10) {
       arr2D[row_pos][col_pos] = 0;
     arr2D[new_row][new_col] = 7;
     System.out.println("Treasure found. You win!");
     System.out.println("Final state:");
    printMap(arr2D);
      return;
    }         
   arr2D[row_pos][col_pos] = 0;
    arr2D[new_row][new_col] = 7;
      row_pos = new_row;
      col_pos = new_col;
      System.out.println("Current state:");
      printMap(arr2D);
      turns--;
    }
    if (turns == 0) {
      System.out.println("Failed to find the treasure.");
    }
  }
  public static void printMap(int[][] arr) { 
    for(int i=0; i<arr.length;i++){
      for(int j =0;j<arr[0].length;j++){
        System.out.print(arr[i][j]+" " );
  }
      System.out.println();
    }
  }
}
