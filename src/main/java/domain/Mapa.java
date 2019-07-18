package domain;

public class Mapa {

    private Nodo node;

    public Nodo getNode() {
        return node;
    }

    public void setNode(Nodo node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Soy el Mapa";
    }
}
