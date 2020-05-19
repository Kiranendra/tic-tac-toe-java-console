import static java.lang.System.out;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;

public class TTTGame {
  private static ArrayList<String> board = new ArrayList<String>(9);
  private static ArrayList<Integer> available_positions = new ArrayList<Integer>(9);
  private final static String p1 = "X";
  private final static String p2 = "O";
  public static void main(String[] args) {
    Scanner input = new Scanner(in);

    for (int i = 0; i < 9; i++) {
      board.add("-");
    }

    int count = 0;
    for (String item: board) {
      out.print(" " + item + " |");
      count++;
      if (count == 3) {
        out.println();
        out.println(" -------------");
        count = 0;
      }
    }
    out.print(" Press 'ENTER' to start the game");
    String enter = input.nextLine();
    if (enter.isEmpty()) {
      out.println(" Game has started");
      startGame();
    }
    else {
      out.println(" Invalid input");
      System.exit(0);
    }
  }

  public static void startGame() {
    int turn = 1;
    boolean play_game = true;
    Scanner input = new Scanner(in);

    for (int i = 1; i < 10; i++) {
      available_positions.add(i);
    }
    
    while (play_game) {
      if (turn == 1) {
        out.println("\n Player " + turn + " turn");
        out.print(" Where do you want to insert '" + p1 + "' in " + available_positions + " ");
        int pos = input.nextInt();
        insertInBoard(pos, p1);
        int count = 0;
        for (String item: board) {
          out.print(" " + item + " |");
          count++;
          if (count == 3) {
            out.println();
            out.println(" -------------");
            count = 0;
          }
        }
        if (checkWin() != "NA"  && checkWin() != "-") {
          out.println(" Player " + turn + " won the game");
          play_game = false;
          if (check() == "Y") {
            reInitialize();
            play_game = true;
            continue;
          }
          else {
            System.exit(0);
          }
        }
        if (positionsAvailability()) {
          out.println("\n DRAW");
          play_game = false;
          if (check() == "Y") {
            reInitialize();
            play_game = true;
            continue;
          }
          else {
            System.exit(0);
          }
        }
        turn = 2;
      }
      else {
        out.println(" Player " + turn + " turn");
        out.print(" Where do you want to insert '" + p2 + "' in " + available_positions + " ");
        int pos = input.nextInt();
        insertInBoard(pos, p2);
        int count = 0;
        for (String item: board) {
          out.print(" " + item + " |");
          count++;
          if (count == 3) {
            out.println();
            out.println(" -------------");
            count = 0;
          }
        }
        if (checkWin() != "NA" && checkWin() != "-") {
          out.println(" Player " + turn + " won the game");
          play_game = false;
          if (check() == "Y") {
            reInitialize();
            play_game = true;
            continue;
          }
          else {
            System.exit(0);
          }
        }
        if (positionsAvailability()) {
          out.println("\n DRAW");
          play_game = false;
          if (check() == "Y") {
            reInitialize();
            play_game = true;
            continue;
          }
          else {
            System.exit(0);
          }
        }
        turn = 1;
      }
    }
  }

  public static void insertInBoard(int pos, String p) {
    switch (pos) {
      case 1:
        board.set(pos-1, p);
        available_positions.remove(new Integer(pos));
        break;
      case 2:
        board.set(pos-1, p);
        available_positions.remove(new Integer(pos));
        break;
      case 3:
        board.set(pos-1, p);
        available_positions.remove(new Integer(pos));
        break;
      case 4:
        board.set(pos-1, p);
        available_positions.remove(new Integer(pos));
        break;
      case 5:
        board.set(pos-1, p);
        available_positions.remove(new Integer(pos));
        break;
      case 6:
        board.set(pos-1, p);
        available_positions.remove(new Integer(pos));
        break;
      case 7:
        board.set(pos-1, p);
        available_positions.remove(new Integer(pos));
        break;
      case 8:
        board.set(pos-1, p);
        available_positions.remove(new Integer(pos));
        break;
      case 9:
        board.set(pos-1, p);
        available_positions.remove(new Integer(pos));
        break;
      default:
        out.println(" Invalid position");
        break;
    }
  }

  public static String checkWin() {
    if (board.get(0) == board.get(1) && board.get(1) == board.get(2)) {
      return board.get(0);
    }
    else if (board.get(3) == board.get(4) && board.get(4) == board.get(5)) {
      return board.get(3);
    }
    else if (board.get(6) == board.get(7) && board.get(7) == board.get(8)) {
      return board.get(6);
    }
    else if (board.get(0) == board.get(4) && board.get(4) == board.get(8)) {
      return board.get(0);
    }
    else if (board.get(2) == board.get(4) && board.get(4) == board.get(6)) {
      return board.get(2);
    }
    else {
      return "NA";
    }
  }

  public static boolean positionsAvailability() {
    int len = available_positions.size();
    if (len == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  public static String check() {
    Scanner inp = new Scanner(in);
    out.print(" Do you want to play again?[y/n] : ");
    String s = inp.next();
    if (s.equalsIgnoreCase("y")) {
      return "Y";
    }
    else {
      return "N";
    }
  }

  public static void reInitialize() {
    board.clear();
    available_positions.clear();
    
    for (int i = 0; i < 9; i++) {
      board.add("-");
    }

    for (int i = 1; i < 10; i++) {
      available_positions.add(i);
    }
  }
}