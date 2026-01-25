package chargebee2;

import TokenBucket.TokenBucket;

import java.lang.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String v1 = "1.0";
        String v2 = "1.0.0";

        String [] v1List = v1.split("\\.");
        String [] v2List = v2.split("\\.");

        int maxLength = Math.max(v1List.length, v2List.length);
        int length1 = v1List.length;
        int length2 = v2List.length;
        boolean ansFound = false;

        for(int i=0;i<maxLength;i++){
            int num1 = i < length1 ? Integer.parseInt(v1List[i]) : 0;
            int num2 = i< length2 ? Integer.parseInt(v2List[i]) :0;

            if(num1 > num2){
                System.out.println(1);
                ansFound = true;
                break;
            }

            if(num1 < num2){
                ansFound = true;
                System.out.println(-1);
                break;
            }
        }
        if(!ansFound){
            System.out.println(0);
        }

























        /*

                       Given a binary tree, return the zigzag level order traversal of its nodes’ values.
                        1
                       / \
                      2   3
                     / \   \
                    4   5   6

                [
                  [1],
                  [3, 2],
                  [4, 5, 6]
                ]


         */
    }
}
