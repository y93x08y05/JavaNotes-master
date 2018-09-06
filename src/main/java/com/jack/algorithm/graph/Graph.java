package com.jack.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Jack
 * @Date: 2018/9/6 22:29
 * 图、邻接表、深度优先遍历、广度优先遍历、最短路径
 */
public class Graph {
    private List<Vertex> vertices;
    private int edgeCount;
    private List<Vertex> depthFirstResult;
    private List<Vertex> breadthFirstResult;
    public void breadthFirstVisit(char beginLabel) {
        Vertex origin=this.getVertexByChar(beginLabel);
        if (origin==null)
            return;
        List<Vertex> queue=new LinkedList<>();
        origin.setVisited(true);
        queue.add(origin);
        breadthFirstResult.add(origin);
        Vertex currentVertex;
        while (!queue.isEmpty()) {
            currentVertex=queue.remove(0);
            while (currentVertex.getFirstUnvisitedNeighbor()!=null) {
                Vertex tempVertex=currentVertex.getFirstUnvisitedNeighbor();
                tempVertex.setVisited(true);
                queue.add(tempVertex);
                breadthFirstResult.add(tempVertex);
            }
        }
        printVertexList(breadthFirstResult);
    }
    public void depthFirstVisit(char beginLabel) {
        Vertex origin=this.getVertexByChar(beginLabel);
        if (origin==null)
            return;
        Stack<Vertex> stack=new Stack<>();
        origin.setVisited(true);
        stack.push(origin);
        depthFirstResult.add(origin);
        Vertex currentVertex;
        while (!stack.isEmpty()) {
            currentVertex=stack.peek();
            Vertex tempVertex=currentVertex.getFirstUnvisitedNeighbor();
            if (tempVertex!=null) {
                tempVertex.setVisited(true);
                depthFirstResult.add(tempVertex);
                stack.push(tempVertex);
            } else {
                stack.pop();
            }
        }
        printVertexList(depthFirstResult);
    }
    public double getShortestPath(char beginLabel,char endLabel,Stack<Vertex> stack) {
        resetVertices();
        Vertex begin=this.getVertexByChar(beginLabel);
        Vertex end=this.getVertexByChar(endLabel);
        begin.setVisited(true);
        List<Vertex> queue=new LinkedList<>();
        queue.add(begin);
        boolean done=false;
        while (!done&&!queue.isEmpty()) {
            Vertex currentVertex=queue.remove(0);
            while (!done&&currentVertex.getFirstUnvisitedNeighbor()!=null) {
                Vertex tempVertex=currentVertex.getFirstUnvisitedNeighbor();
                tempVertex.setVisited(true);
                double tempCost=currentVertex.getCost()+1;
                tempVertex.setPreviousVertex(currentVertex);
                tempVertex.setCost(tempCost);
                queue.add(tempVertex);
                if (tempVertex.equals(end))
                    done=true;
            }
        }
        double pathLength=end.getCost();
        while (end!=null) {
            stack.push(end);
            end=end.getPreviousVertex();
        }
        return pathLength;
    }
    public boolean addEdge(char beginLabel,char endLabel) {
        return addEdge(beginLabel,endLabel,0);
    }
    public boolean addEdge(char beginLabel,char endLabel,double weight) {
        int beginIndex=vertices.indexOf(new Vertex(beginLabel));
        int endIndex=vertices.indexOf(new Vertex(endLabel));
        Vertex beginVertex=vertices.get(beginIndex);
        Vertex endVertex=vertices.get(endIndex);
        boolean result=beginVertex.connect(endVertex,weight);
        edgeCount++;
        return result;
    }
    public boolean addVertex(char label) {
        boolean result=false;
        Vertex newVertex=new Vertex(label);
        if (!vertices.contains(newVertex)) {
            vertices.add(newVertex);
            result=true;
        }
        return result;
    }
    public void printVertexList(List<Vertex> list) {
        for (int i=0,len=list.size();i<len;i++) {
            Vertex vertex=list.get(i);
            System.out.print(vertex.getLabel()+" ");
        }
        System.out.println();
    }
    public void resetVertices() {
        for (int i=0,len=vertices.size();i<len;i++) {
            Vertex vertex=vertices.get(i);
            vertex.setPreviousVertex(null);
            vertex.setVisited(false);
            vertex.setCost(0);
        }
    }
    public Vertex getVertexByChar(char target) {
        Vertex vertex=null;
        for (int i=0,len=vertices.size();i<len;i++) {
            vertex=vertices.get(i);
            Character c=vertex.getLabel();
            if (c.charValue()==target)
                return vertex;
        }
        return vertex;
    }
    public Graph() {
        vertices=new ArrayList<>();
        edgeCount=0;
        depthFirstResult=new ArrayList<>();
        breadthFirstResult=new ArrayList<>();
    }
    public static void main(String[] args) {
        Graph graph=createGraph();
        graph.depthFirstVisit('7');
        graph.resetVertices();
        graph.breadthFirstVisit('0');
        Stack<Vertex> pathStack=new Stack<>();
        double pathLength=graph.getShortestPath('0','7',pathStack);
//        double pathLength=graph.getShortestPath('1','4',pathStack);
        System.out.println("图的最短路径为："+pathLength);
        while (!pathStack.isEmpty()) {
            Vertex vertex=pathStack.pop();
            System.out.print(vertex.getLabel()+" ");
        }
    }
    public static Graph createGraph() {
        /**
         0----1---2
         | \  |   |
         |  \ |   |
         |   \|   |
         3    4   5
         |   /
         |  /
         | /
         6---7
         邻接表如下
         0-->4--3--1
         1-->4--2--0
         2-->5--1
         3-->6--0
         4-->6--1--0
         5-->2
         6-->7--4--3
         7-->6
         */
        Graph graph=new Graph();
        graph.addVertex('1');
        graph.addVertex('2');
        graph.addVertex('3');
        graph.addVertex('4');
        graph.addEdge('1','2');
        graph.addEdge('1','3');
        graph.addEdge('3','4');
        graph.addVertex('0');
        graph.addVertex('1');
        graph.addVertex('2');
        graph.addVertex('3');
        graph.addVertex('4');
        graph.addVertex('5');
        graph.addVertex('6');
        graph.addVertex('7');

        graph.addEdge('0','4');
        graph.addEdge('0','3');
        graph.addEdge('0','1');

        graph.addEdge('1','4');
        graph.addEdge('1','2');
        graph.addEdge('1','0');

        graph.addEdge('2','5');
        graph.addEdge('2','1');

        graph.addEdge('3','6');
        graph.addEdge('3','0');

        graph.addEdge('4','6');
        graph.addEdge('4','1');
        graph.addEdge('4','0');

        graph.addEdge('5','2');

        graph.addEdge('6','7');
        graph.addEdge('6','4');
        graph.addEdge('6','3');

        graph.addEdge('7','6');

        return graph;
    }
}
class Vertex {
    private char label;
    private List<Edge> edgeList;
    private boolean isVisited;
    private Vertex previousVertex;
    private double cost;
    public Vertex(char label) {
        this.label=label;
        edgeList=new ArrayList<>();
        isVisited=false;
        previousVertex=null;
        cost=0;
    }
    public boolean isVisited() {
        return isVisited;
    }
    public void visit() {
        System.out.println(this.label);
        this.isVisited=true;
    }
    public void setPreviousVertex(Vertex vertex) {
        this.previousVertex=vertex;
    }
    public void setVisited(Boolean isVisited) {
        this.isVisited=isVisited;
    }
    public void setCost(double cost) {
        this.cost=cost;
    }
    public Vertex getFirstNeighbor() {
        Vertex neighbor=this.edgeList.get(0).endVertex;
        return neighbor;
    }
    public char getLabel() {
        return this.label;
    }

    public double getCost() {
        return this.cost;
    }
    public Vertex getPreviousVertex() {
        return this.previousVertex;
    }
    public Vertex getFirstUnvisitedNeighbor() {
        Vertex unVisitedNeighbor=null;
        for (int i=0,len=edgeList.size();i<len;i++) {
            Vertex vertex=edgeList.get(i).endVertex;
            if (!vertex.isVisited) {
                unVisitedNeighbor=vertex;
                break;
            }
        }
        return unVisitedNeighbor;
    }
    public boolean equals(Object o) {
        boolean result=false;
        if (this==o)
            return true;
        if (o instanceof Vertex) {
            Vertex otherVertex= (Vertex) o;
            result=this.label==otherVertex.label;
        }
        return result;
    }
    public boolean connect(Vertex endVertex,double weight) {
        boolean result=false;
        if (!this.equals(endVertex)) {
            boolean isDuplicateEdge=false;
            List<Edge> edgeList=this.edgeList;
            if (edgeList.contains(endVertex)) {
                isDuplicateEdge=true;
            }
            if (!isDuplicateEdge) {
                edgeList.add(new Edge(endVertex,weight));
                result=true;
            }
        }
        return result;
    }
    public boolean hasNeighbor() {
        return !edgeList.isEmpty();
    }
    protected class Edge {
        private Vertex endVertex;
        private double weight;
        protected Edge(Vertex endVertex,double weight) {
            this.endVertex=endVertex;
            this.weight=weight;
        }
        protected Vertex getEndVertex() {
            return endVertex;
        }
        protected double getWeight() {
            return weight;
        }
    }
}