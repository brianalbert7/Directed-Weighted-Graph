package proglab09graphssum18;

import java.util.Scanner;

/**
 * Date Written:    7/30/2018
 * 
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 */
public class ProgLab09GraphsSum18 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String userChoice;
        Scanner input = new Scanner(System.in);
        
        do
        {
            System.out.println("\nThese use Graph.java (provided)");
            System.out.println("A - UndirectedNonWeightedExampleSlide17.java");
            System.out.println("B - UndirectedNonWeightedExampleSlide19House.java");
            System.out.println("\nThis uses WeightedGraph.java (<--you need to modify)");
            System.out.println("C - DirectedWeightedExampleSlide18.java (<--you need to modify)");
            System.out.println("\nX - Exit");
            System.out.print("\nEnter selection: ");
            
            userChoice = input.nextLine();
            switch (userChoice.toLowerCase())
            {
                case "a": 
                    UndirectedNonWeightedExampleSlide17.main(args);
                    break;
                case "b": 
                    UndirectedNonWeightedExampleSlide19House.main(args);
                    break;
                case "c": 
                    DirectedWeightedExampleSlide18.main(args);
                    break;
                case "x":
                    System.out.println("\nBye bye!");
                    break;
                default:
                    System.out.println("\nhuh?");
                    
            }
        } while (!(userChoice.equalsIgnoreCase("X")));
        
        
    }
    
}
