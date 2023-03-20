import java.util.ArrayList;
import java.util.Random;

public class TASK03 {
    public static void main(String[] args) {
        int queens = 0;
        char[][] clear = new char[8][8];
        char[][] desk = new char[8][8];
        Random rnd = new Random();
        int place_the_queen;

        while (queens < 8){
            ArrayList<Integer> queen_arr = new ArrayList<>();

            for (int c = 0; c < 8; c++){
                if (desk[queens][c] != 'n'){
                    queen_arr.add(c);
                }
            }

            if (queen_arr.size() == 0){
                queens = 0;
                for (int i = 0; i < desk.length; i ++){
                    System.arraycopy(clear[i], 0, desk[i], 0, desk.length);
                }
                for (int c = 0; c < 8; c++){
                    if (desk[queens][c] != 'n'){
                        queen_arr.add(c);
                    }
                }
            }

            place_the_queen = rnd.nextInt(0, queen_arr.size());

            desk[queens][queen_arr.get(place_the_queen)] = 'x';

            int shift = 1;
            for (int k = queens + 1; k < desk.length; k ++){
                for (int m = 0 ; m < desk.length; m ++){
                    if (m == queen_arr.get(place_the_queen) && k != queens) {
                        desk[k][m] = 'n';
                    }
                    if (m != queen_arr.get(place_the_queen) && k == queens) {
                        desk[k][m] = 'n';
                    }
                    if ((m == queen_arr.get(place_the_queen) + shift && k == queens + shift) ||
                            (m == queen_arr.get(place_the_queen) - shift && k == queens + shift)) {
                        desk[k][m] = 'n';
                    }
                }
                shift ++;
            }

            queens ++;

        }

        for (char[] chars : desk) {
            for (int j = 0; j < desk.length; j++) {
                if (chars[j] != 'x') {
                    System.out.print("|" + ' ');
                } else System.out.print("|" + chars[j]);
                if (j == desk.length - 1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }

    }
}
