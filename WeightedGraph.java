package proglab09graphssum18;

/**
 * a minimal number of stubs have been provided 
 * to get the starting point file to run
 * 
 * @author Brian Albert
 * 
 */
public class WeightedGraph 
{
    private int edges[][];
    private Object[] labels;
    
    public WeightedGraph(int n)
    {
        edges = new int[n][n];
        labels = new Object[n];
    }
       
    public void addEdge(int source, int target, int weight)
    {
        edges[source][target] = weight;
    }
    
    public Object getLabel(int vertex)
    {
        return labels[vertex];
    }
    
    public boolean isEdge(int source, int target)
    {
        if (edges[source][target] > 0)
            return true;
        else
            return false;
    }
    
    public int[ ] neighbors(int vertex)
    {
        int i;
        int count;
        int [ ] answer = { };
        
        count = 0;
        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i] > 0)
                count++;
        }
        
        answer = new int[count];
        
        count = 0;
        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i] > 0)
                answer[count++] = i;
        }
        
        return answer;
    }
    
    public void removeEdge(int source, int target)
    {
        edges[source][target] = 0;
    }
    public void setLabel(int vertex, Object newLabel)
    {
        labels[vertex] = newLabel;
    }
    
    public int size( )
    {
        return labels.length;
    }

    public int getWeight(int source, int target)
    {
        return edges[source][target];
    }
    
    public void setWeight(int source, int target, int weight)
    {
        edges[source][target] = weight;
    }
    
    
}
