/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ss14n1a;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class SS14N1A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            String name = sc.next();
            System.out.println("Case #"+i+": Hello "+name+"!");
        }
        
    }
    
}
