/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss14n1c;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author user
 */
public class SS14N1C {

    /**
     * @param args the command line arguments
     */
    static public int[] x;
    static public int[] y;
    static public int[] z;

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            x = new int[n];
            y = new int[n];
            z = new int[n];
            for (int l = 0; l < n; l++) {
                x[l] = sc.nextInt();
                y[l] = sc.nextInt();
                z[l] = sc.nextInt();
            }
            /*
             int[][] wAdj = new int[n][n];
             for (int r = 0; r < n; r++) {
             for (int s = 0; s < n; s++) {
             wAdj[r][s] = abs(x[r] - x[s]) + abs(y[r] - y[s]) + abs(z[r] - z[s]);
             }
             }
             */
            //System.out.println(Arrays.deepToString(wAdj));
            PriorityQueue<Edge> pq = new PriorityQueue<>(n);
            for (int j = 1; j < n; j++) {
                pq.add(new Edge(wAdj(0, j), 0, j));
            }
            Edge[] greetings = new Edge[n - 1];
            int[] greeted = new int[n];
            greeted[0] = 0;
            for (int j = 0; j < n - 1; j++) {
                greetings[j] = pq.poll();
                int newT = greetings[j].target;
                greeted[j + 1] = newT;
                for (int k = 0; k < n; k++) {
                    if (k != newT && !elem(k, greeted)) {
                        int w = wAdj(newT, k);
                        ArrayList<Edge> toRem = new ArrayList<>();
                        ArrayList<Edge> toAdd = new ArrayList<>();
                        for( Edge e : pq){
                            if (w >= e.weight) {
                                break;
                            }
                            if (e.target == k) {
                                toRem.add(e);
                                toAdd.add(new Edge(w, newT, k));
                            }
                        }
                        pq.removeIf( Filter<Edge> );
                        
                        pq.removeAll(toRem);
                        pq.addAll(toAdd);
                    }
                }
            }
            /*
             ArrayDeque<Edge> tmp;
             tmp = new ArrayDeque<>(n * n);
             for (Edge e : pq) {
             if (elem(e.target, greeted)) {
             tmp.push(e);
             }
             }
             pq.removeAll(tmp);*/
            /*
             if (tmp.empty())
             continue;
             Edge poptmp = tmp.pop();
             while ( poptmp != null ){
             pq.remove(poptmp);
             if (tmp.empty())
             break;
             poptmp = tmp.pop();
             }*/
        int sum = 0;
        for (Edge e : greetings) {
            sum += e.weight;
        }
        System.out.println("Case #" + (i + 1) + ": " + sum);
        }

    }
static class Filter<Edge> implements Predicate<Edge>{
    test
}

private static boolean elem(int i, int[] greeted) {
        for (int j : greeted) {
            if (j == i) {
                return true;
            }
        }
        return false;
    }

    private static int wAdj(int r, int s) {
        return abs(x[r] - x[s]) + abs(y[r] - y[s]) + abs(z[r] - z[s]);
    }

}
