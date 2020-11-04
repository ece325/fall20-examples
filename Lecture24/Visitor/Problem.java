import java.util.*;

class Vertex
{
  public String name;
  public int value;
  public boolean visited;
  private List<Vertex> adjecents;

  public Vertex(String name) {
    this.name = name;
    this.value = 0;
    this.visited = false;
    adjecents = new ArrayList<Vertex>();
  }

  public void connect(Vertex v) {
    adjecents.add(v);
  }

  public List<Vertex> connectedTo() {
    return adjecents;
  }

}

class Graph
{
  private List<Vertex> nodes;

  public Graph() {
    nodes = new ArrayList<Vertex>();
  }

  public void addVertex(Vertex a) {
    nodes.add(a);
  }

  public void connect(Vertex a, Vertex b) {
    a.connect(b);
  }

  public List<Vertex> vertices() {
    return nodes;
  }

  public void reset() {
    for (Vertex v: nodes) {
      v.visited = false;
    }
  }
}


public class Problem
{

  public static void printVertex(Vertex v) {
    if (!v.visited) {
        v.visited = true;
        System.out.print(" -> ");
        System.out.print(v.name + "("+v.value+")");
        for (Vertex adjVertex: v.connectedTo()) {
          printVertex(adjVertex);
        }
    }
  }

  public static void countIncomingVertex(Vertex v) {
    if (!v.visited) {
        v.visited = true;
        for (Vertex adjVertex: v.connectedTo()) {
          adjVertex.value += 1;
          countIncomingVertex(adjVertex);
        }
    }
  }

  public static void main(String[] args) {
    Graph g = new Graph();
    
    Vertex n1 = new Vertex("One");
    Vertex n2 = new Vertex("Two");
    Vertex n3 = new Vertex("Three");
    Vertex n4 = new Vertex("Four");

    g.addVertex(n1);
    g.addVertex(n2);
    g.addVertex(n3);
    g.addVertex(n4);

    g.connect(n1,n2);
    g.connect(n1,n3);
    g.connect(n1,n4);
    g.connect(n2,n4);
    g.connect(n3,n2);
    g.connect(n4,n3);
    g.connect(n4,n2);

    /**
     *      ++--------------+
     *      |               |     
     *      |               v
     *     One --> Two <-> Four
     *      |       ^       |
     *      |       |       |
     *      +---> Three <---+
     */

    printVertex(n1);
    g.reset();

    countIncomingVertex(n1);

    System.out.println("\n------------");
    g.reset();
    printVertex(n1);
  }
}