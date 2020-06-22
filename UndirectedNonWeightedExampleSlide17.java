package proglab09graphssum18;

import java.util.Scanner;

/**
 * Uses the Author's Graph, implements the graph from slide 17
 * Date Written:    4/17/2012
 * Date Modified:   11/26/2012 - changed reference to Graph to not be in package
 *                  08/01/2013 - changed comments at bottom of method to "match" lab sheet
 *                  04/21/2015 - added vertex labels
 *                  11/13/2016 - NetBeanafied
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 * updated by  Linda Yang
 */

public class UndirectedNonWeightedExampleSlide17
{
    public static void main(String[] args)
    {
        int currentVertex, userChoice;
        Scanner input = new Scanner(System.in);

        // create graph using Author's Graph
        Graph myGraph = new Graph(4);

        // add labels
        myGraph.setLabel(0,"Spot zero");
        myGraph.setLabel(1,"Spot one");
        myGraph.setLabel(2,"Spot two");
        myGraph.setLabel(3,"Spot three");

        // Add each edge (this undirected Graph has 5 edges,
        //                  so we add 10 edges)
        myGraph.addEdge(0,1);
        myGraph.addEdge(1,0);

        myGraph.addEdge(0,2);
        myGraph.addEdge(2,0);

        myGraph.addEdge(0,3);
        myGraph.addEdge(3,0);

        myGraph.addEdge(1,3);
        myGraph.addEdge(3,1);

        myGraph.addEdge(2,3);
        myGraph.addEdge(3,2);

        // let's pretend we are on v2
        currentVertex = 2;

        
        do
        {
            // display the current vertex
            System.out.println("\nYou are currently at node "
                            + currentVertex + "-" + myGraph.getLabel(currentVertex));

            // display our neighbors
            System.out.println("neighbors of " + currentVertex + " are:");

            for (int neighbor : myGraph.neighbors(currentVertex))
                System.out.printf("%2d-%s\n",neighbor,myGraph.getLabel(neighbor));
            System.out.println();

            // suppose I was interacting with user, (hey, I am)
            // I will ask for their choice
            System.out.print("\nWhere would you like to go? (-1 to exit): ");
            userChoice = input.nextInt();

            // make sure not too small nor too big
            while (userChoice < -1 || userChoice >= myGraph.size())
            {
                System.out.println("\n" + userChoice + " is not a valid value");
                System.out.print("\nWhere would you like to go? (-1 to exit): ");
                userChoice = input.nextInt();
            }

            // if their choice is -1 then exit
            if (userChoice == -1)
                System.out.println("Good bye!");
            else
            {
                // if their choice is a valid neighbor
                if (myGraph.isEdge(currentVertex,userChoice))
                    currentVertex=userChoice; // then move to new vertex....
                else
                    // report the vertex they entered is unreachable
                    System.out.println("\nYou can't go to " + userChoice
                                        + "-" + myGraph.getLabel(userChoice)
                                        + " from " + currentVertex
                                        + "-" + myGraph.getLabel(currentVertex));
            }
        } while (userChoice != -1);
    }
}
/* 
Sample Output:
run:

You are currently at node 2-Spot two
neighbors of 2 are:
 0-Spot zero
 3-Spot three


Where would you like to go? (-1 to exit): 3

You are currently at node 3-Spot three
neighbors of 3 are:
 0-Spot zero
 1-Spot one
 2-Spot two


Where would you like to go? (-1 to exit): 1

You are currently at node 1-Spot one
neighbors of 1 are:
 0-Spot zero
 3-Spot three


Where would you like to go? (-1 to exit): 2

You can't go to 2-Spot two from 1-Spot one

You are currently at node 1-Spot one
neighbors of 1 are:
 0-Spot zero
 3-Spot three


Where would you like to go? (-1 to exit): 0

You are currently at node 0-Spot zero
neighbors of 0 are:
 1-Spot one
 2-Spot two
 3-Spot three


Where would you like to go? (-1 to exit): 2

You are currently at node 2-Spot two
neighbors of 2 are:
 0-Spot zero
 3-Spot three


Where would you like to go? (-1 to exit): 6

6 is not a valid value

Where would you like to go? (-1 to exit): -2

-2 is not a valid value

Where would you like to go? (-1 to exit): -1
Good bye!
BUILD SUCCESSFUL (total time: 26 seconds)


*/