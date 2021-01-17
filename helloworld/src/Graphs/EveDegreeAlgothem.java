package Graphs;

public class EveDegreeAlgothem extends GraphAlgorithm {

    public EveDegreeAlgothem(Graph input) {
        super(input);
    }

    @Override
    public Object runAlgorithm() {
        for (int i = 0; i < input.numberOfVertices(); i++) {
            if (input.degree(i) % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
