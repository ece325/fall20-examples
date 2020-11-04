import java.util.HashSet;

import java.util.*;

interface Visitor
{
  void visit(Vertex e);
}


interface Element 
{
  void accept(Visitor v);
}


class Vertex implements Element
{
  public String name;
  public int value;
  private List<Vertex> adjecents;

  public Vertex(String name) {
    this.name = name;
    this.value = 0;
    adjecents = new ArrayList<Vertex>();
  }

  public void connect(Vertex v) {
    adjecents.add(v);
  }

  public List<Vertex> connectedTo() {
    return adjecents;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
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
      v.value = 0;
    }
  }
}

class PrintVertex implements Visitor
{
  private HashSet<String> visited = new HashSet<>();

  public void visit(Vertex e) {
    if (!visited.contains(e.name)) {
      visited.add(e.name);
      System.out.print(" -> ");
      System.out.print(e.name + "("+e.value+")");
      for (Vertex adjVertex: e.connectedTo()) {
        adjVertex.accept(this);
      }
    }
  }
}

class CountIncomingVertex implements Visitor
{
  private HashSet<String> visited = new HashSet<>();

  public void visit(Vertex e) {
    if (!visited.contains(e.name)) {
      visited.add(e.name);
      for (Vertex adjVertex: e.connectedTo()) {
        adjVertex.value += 1;
        adjVertex.accept(this);
      }
    }
  }
}


public class Solution
{

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

    PrintVertex pv = new PrintVertex();
    n1.accept(pv);

    CountIncomingVertex cInVert = new CountIncomingVertex();
    n1.accept(cInVert);

    System.out.println("\n------------");
    PrintVertex pv2 = new PrintVertex();
    n3.accept(pv2);
  }
}