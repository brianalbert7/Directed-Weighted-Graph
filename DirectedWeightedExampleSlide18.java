package proglab09graphssum18;

import java.util.Scanner;

/**
 * Date Written:    4/17/2012
 * Date Modified:   11/26/2012 - changed reference to Graph to not be in package
 *                  11/26/2012 - loop for Lab 12
 *                  8/1/2013 - changed name to Lab11Honors
 *                  4/15/2014 - removed logic and made into "sample" for honors
 *                  04/21/2015 - added vertex labels
 *                  11/13/2016 - NetBeanafied
 *                  7/30/2018 - augmented for Summer 2018
 * originated by: Stephen T. Brower<stephen.brower@raritanval.edu>
 * updated by Linda Yang
 * 
 * @author Brian Albert
 * 
 */

public class DirectedWeightedExampleSlide18
{
    public static void main(String[] args)
    {
        int currentVertex, userChoice, previous, totalCost;
        Scanner input = new Scanner(System.in);

        // create graph using your WeightedGraph based on author's Graph
        WeightedGraph myGraph = new WeightedGraph(4);

        // add labels
        myGraph.setLabel(0,"Spot zero");
        myGraph.setLabel(1,"Spot one");
        myGraph.setLabel(2,"Spot two");
        myGraph.setLabel(3,"Spot three");

        // Add each edge (this directed Graph has 5 edges,
        //                  so we add 5 edges)
        myGraph.addEdge(0,2,9);

        myGraph.addEdge(1,0,7);

        myGraph.addEdge(2,3,12);

        myGraph.addEdge(3,0,15);
        myGraph.addEdge(3,1,6);

        // let's pretend we are on v2
        currentVertex = 2;
        previous = 2;
        totalCost = 0;
        
        // do - this is a good place for the top of the loop
        do
        {
            totalCost += myGraph.getWeight(previous, currentVertex);
            System.out.println("\nso far you have accrued " + totalCost + " cost");
            
            // display the current vertex

            System.out.println("\nYou are currently at vertex " + currentVertex + 
                                "-" + myGraph.getLabel(currentVertex));

            // who are our neighbors?
            System.out.println("neighbors of " + currentVertex + " are:\n");

            System.out.printf("%3s %-10s %4s\n","#","Neighbor","Cost");
            System.out.printf("%3s %-10s %4s\n","===","==========","====");

            if (myGraph.neighbors(currentVertex).length == 0)
                System.out.println("No Neighbors");
            else
            {
                for (int neighbor : myGraph.neighbors(currentVertex))
                {
                    System.out.printf("%3d %-10s %4d\n",
                                        neighbor,
                                        myGraph.getLabel(neighbor),
                                        myGraph.getWeight(currentVertex,neighbor));
                }
                System.out.println();
            }

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
                {
                    previous = currentVertex;
                    currentVertex=userChoice; // then move to new vertex....
                }
                else
                    // report the vertex they entered is unreachable
                    System.out.println("\nYou can't go to " + userChoice
                                        + " from " + currentVertex);
            }
        } while (userChoice != -1);
    }
}
