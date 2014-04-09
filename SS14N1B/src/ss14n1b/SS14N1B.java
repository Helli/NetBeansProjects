/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ss14n1b;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class SS14N1B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[][] wAdj = new int[n][n];
            for (int[] a : wAdj){
                //int[a] = new int[];
                for (int b = 0; b < n; b++){
                    a[b] = sc.nextInt();
                }
            }
            //System.out.println(Arrays.deepToString(wAdj));
            PriorityQueue<Edge> pq = new PriorityQueue<>(n*n);
            for (int j = 1; j < n; j++){
                pq.add (new Edge(wAdj[0][j], 0, j));
            }
            //System.out.println(Arrays.deepToString(pq.toArray()));
            Edge[] greetings = new Edge[n-1];
            int[] greeted = new int[n];
            greeted [0] = 0;
            for (int j = 0; j < n-1; j++){
                greetings[j] = pq.poll();
                int newT = greetings[j].target;
                greeted[j+1] = newT;
                for (int k = 0; k < n; k++){
                    if (k != newT && !elem(k,greeted) )
                        pq.add (new Edge (wAdj[newT][k], newT, k));
                }
                ArrayDeque<Edge> tmp;
                tmp = new ArrayDeque<>(n*n) ;
                for (Edge e : pq) {
                    if (elem ( e.target, greeted) )
                        tmp.push(e);
                }
                pq.removeAll(tmp);
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
                
            }
            Arrays.sort (greetings,new Moep());
            System.out.println("Case #"+(i+1)+":");
            for (int p = 0; p < n-1; p++){
                System.out.println(greetings[p].toString());
            }
            System.out.print("\n");
        }

    }
    private static boolean elem (int i, int[] l){
        for (int j : l){
            if (j == i)
                return true;
        }
        return false;
    }
    // test: 1 3 0 1 3 1 0 2 3 2 0
    static class Moep implements Comparator<Edge> {

        @Override
        public int compare(Edge e1, Edge e2) {
            int c = e1.sw - e2.sw;
            if (c == 0) {
                return e1.lw - e2.lw;
            }
            return c;
        }
    }

}
