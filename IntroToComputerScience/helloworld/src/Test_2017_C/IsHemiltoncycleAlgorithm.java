package Test_2017_C;
import Graphs.*;
import Interfaces.*;

public class IsHemiltoncycleAlgorithm extends GraphAlgorithm {
    private List<Integer> vertices;

    public IsHemiltoncycleAlgorithm(Graph input, List<Integer> vertices) {
        super(input);
        this.vertices = vertices;
    }

    @Override
    public Object runAlgorithm() {
        GraphAlgorithm isValidPath = new IsValidPathAlgorithm(input,vertices);
        boolean isNVertices = Q4.containsNVertices(vertices, input.numberOfVertices());
        if (isNVertices){
            if ((boolean)isValidPath.runAlgorithm() && input.containsEdge(vertices.get(0),vertices.get(vertices.size()-1)));
            return true;
            
        }
        return false;
    }
}
