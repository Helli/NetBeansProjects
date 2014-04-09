/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ss14n1b;

//import java.util.function.Predicate;

/**
 *
 * @author user
 */
public class Edge
implements Comparable<Edge>
{

    @Override
    public String toString() {
        return (sw+1)+" "+(lw+1);
    }
    final int weight;
    final int source;
    final int target;
    final int sw;
    final int lw;

    public Edge(int weight, int source, int target) {
        this.weight = weight;
        this.source = source;
        this.target = target;
        sw = (source < target)? source : target;
        lw = (source < target)? target : source;
    }
    
    @Override
    public int compareTo(Edge t) {
        return  weight - t.weight;
    }
}
