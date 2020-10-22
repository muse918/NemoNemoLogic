import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;

public class Bot {
    public static void main() {
        int[][] r = new int[15][];
        int[][] c = new int[15][];
        {
            r[0] = new int[]{2, 2};
            r[1] = new int[]{3, 4};
            r[2] = new int[]{4, 4};
            r[3] = new int[]{3, 3, 3};
            r[4] = new int[]{5, 3, 2};
            r[5] = new int[]{2, 4, 4};
            r[6] = new int[]{2, 3, 3};
            r[7] = new int[]{8, 2};
            r[8] = new int[]{2, 3, 4};
            r[9] = new int[]{2, 5, 4};
            r[10] = new int[]{5, 3, 2};
            r[11] = new int[]{4, 2, 3};
            r[12] = new int[]{3, 4};
            r[13] = new int[]{3, 4};
            r[14] = new int[]{2, 2};

            c[0] = new int[]{5};
            c[1] = new int[]{7};
            c[2] = new int[]{2, 1, 2};
            c[3] = new int[]{2, 1, 2};
            c[4] = new int[]{9};
            c[5] = new int[]{2, 8};
            c[6] = new int[]{3, 5, 2};
            c[7] = new int[]{4, 1, 1, 1, 3};
            c[8] = new int[]{3, 5};
            c[9] = new int[]{4, 4};
            c[10] = new int[]{6};
            c[11] = new int[]{2, 6, 2};
            c[12] = new int[]{6, 7};
            c[13] = new int[]{5, 6};
            c[14] = new int[]{3, 3};
        }//boardsetup
        int[][] board = new int[r.length][c.length];
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();

        //기본체크
        {
            //세로 체크
            for (int i = 0; i < r.length; i++) {
                int sum = 0;
                for (int k:r[i]) {
                    sum += k;
                }
                for (int j = 0; j < r[i].length; j++) {
                    if(r[i].length-1+sum+r[i][j]>c.length){
                        int sum1 = 0, sum2 = 0;
                        for (int k = 0; k < j; k++) {
                            sum1 += r[i][k];
                        }
                        for (int k = j+1; k < r[i].length; k++) {
                            sum2 += r[i][k];
                        }
                        for (int k = c.length-sum2-r[i].length+j-r[i][j]+1; k < sum1+j+r[i][j]; k++) {
                            if (!rQueue.contains(k)){
                                rQueue.add(k);
                            }
                            board[i][k] = 1;
                        }
                    }
                }
            }

            //가로 체크

            for (int i = 0; i < c.length; i++) {
                int sum = 0;
                for (int k:c[i]) {
                    sum += k;
                }
                for (int j = 0; j < c[i].length; j++) {
                    if(c[i].length-1+sum+c[i][j]>r.length){
                        int sum1 = 0, sum2 = 0;
                        for (int k = 0; k < j; k++) {
                            sum1 += c[i][k];
                        }
                        for (int k = j+1; k < c[i].length; k++) {
                            sum2 += c[i][k];
                        }
                        for (int k = r.length-sum2-c[i].length+j-c[i][j]+1; k < sum1+j+c[i][j]; k++) {
                            board[k][i] = 1;
                            if (!cQueue.contains(k)){
                                cQueue.add(k);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("========기본체크========");
        print(board);



    }
    private static void print(int[][] board){
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[j][i]+" ");
            }
            System.out.println();
        }
    }
}
