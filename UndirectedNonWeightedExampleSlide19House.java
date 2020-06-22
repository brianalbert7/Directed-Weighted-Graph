package proglab09graphssum18;

import java.util.Scanner;

/**
 * Uses the Author's Graph, implements the graph from slide 19
 * Date Written:    4/17/2012
 *                  Changed to "shell" 4/21/2015
 * Date Modified:   11/13/2016 - NetBeanafied
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 */
public class UndirectedNonWeightedExampleSlide19House
{
    public static void main(String[] args)
    {
        int currentVertex, userChoice;
        Scanner input = new Scanner(System.in);
        final int KITCHEN = 0;
        final int PANTRY = 1;
        final int DINING_ROOM = 2;
        final int BACK_FOYER = 3;
        final int FRONT_FOYER = 4;
        final int STUDY = 5;
        final int LIVING_ROOM = 6;

        // create graph using Author's Graph
        Graph myGraph = new Graph(7);

        // add labels
        myGraph.setLabel(KITCHEN,"Kitchen");
        myGraph.setLabel(PANTRY,"Pantry");
        myGraph.setLabel(DINING_ROOM,"Dining Room");
        myGraph.setLabel(BACK_FOYER,"Back Foyer");
        myGraph.setLabel(FRONT_FOYER,"Front Foyer");
        myGraph.setLabel(STUDY,"Study");
        myGraph.setLabel(LIVING_ROOM,"Living Room");

        // Add each edge (this undirected Graph has 7 edges,
        //                  so we add 14 edges)
        myGraph.addEdge(KITCHEN,PANTRY);
        myGraph.addEdge(PANTRY,KITCHEN);

        myGraph.addEdge(PANTRY,DINING_ROOM);
        myGraph.addEdge(DINING_ROOM,PANTRY);

        myGraph.addEdge(DINING_ROOM,FRONT_FOYER);
        myGraph.addEdge(FRONT_FOYER,DINING_ROOM);

        myGraph.addEdge(KITCHEN,BACK_FOYER);
        myGraph.addEdge(BACK_FOYER,KITCHEN);

        myGraph.addEdge(BACK_FOYER,FRONT_FOYER);
        myGraph.addEdge(FRONT_FOYER,BACK_FOYER);

        myGraph.addEdge(FRONT_FOYER,LIVING_ROOM);
        myGraph.addEdge(LIVING_ROOM,FRONT_FOYER);

        myGraph.addEdge(BACK_FOYER,STUDY);
        myGraph.addEdge(STUDY,BACK_FOYER);

        // let's pretend we are in FRONT_FOYER
        currentVertex = FRONT_FOYER;



        do
        {
            // display the current vertex
            System.out.println("\nYou are currently in room "
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
Sample Output (a possible sample run ):
run:

You are currently in room 4-Front Foyer
neighbors of 4 are:
 2-Dining Room
 3-Back Foyer
 6-Living Room


Where would you like to go? (-1 to exit): 2

You are currently in room 2-Dining Room
neighbors of 2 are:
 1-Pantry
 4-Front Foyer


Where would you like to go? (-1 to exit): 2

You can't go to 2-Dining Room from 2-Dining Room

You are currently in room 2-Dining Room
neighbors of 2 are:
 1-Pantry
 4-Front Foyer


Where would you like to go? (-1 to exit): 5

You can't go to 5-Study from 2-Dining Room

You are currently in room 2-Dining Room
neighbors of 2 are:
 1-Pantry
 4-Front Foyer


Where would you like to go? (-1 to exit): 8

8 is not a valid value

Where would you like to go? (-1 to exit): -2

-2 is not a valid value

Where would you like to go? (-1 to exit): 1

You are currently in room 1-Pantry
neighbors of 1 are:
 0-Kitchen
 2-Dining Room


Where would you like to go? (-1 to exit): 0

You are currently in room 0-Kitchen
neighbors of 0 are:
 1-Pantry
 3-Back Foyer


Where would you like to go? (-1 to exit): 3

You are currently in room 3-Back Foyer
neighbors of 3 are:
 0-Kitchen
 4-Front Foyer
 5-Study


Where would you like to go? (-1 to exit): 5

You are currently in room 5-Study
neighbors of 5 are:
 3-Back Foyer


Where would you like to go? (-1 to exit): 3

You are currently in room 3-Back Foyer
neighbors of 3 are:
 0-Kitchen
 4-Front Foyer
 5-Study


Where would you like to go? (-1 to exit): -1
Good bye!
BUILD SUCCESSFUL (total time: 42 seconds)


*/