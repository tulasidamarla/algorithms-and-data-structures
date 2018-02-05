Graphs
------
A graph G is composed of set of vertices (or nodes) and a set of edges connecting to the vertices.<br>
If set of vertices is V and set of edges are E, then graph G = (V,E).

There are no of use cases of graphs. <br>
1)Can model circuits. <br>
2)Can take a map of the city and every intersection can be modeled as vertex and roads that join them as edges.<br>
3)communication networks, transportation networks etc.

There are two types of graphs.<br>
1)Directed Graph --> A graph in which edges are directed is called Directed graph.<br>
2)Undirected Graph

Graph Terminology
-----------------
1)Adjacent Vertices: vertices connected by an edge<br>
2)Degree(of a vertex): no of adjacent vertices it has.<br>
3)Path: Path is a sequence of vertices v1,v2,...vn such that consecutive vertices vi and vi+1 are adjacent.<br>
4)Simple Path: A simple path is path with no vertex repeated.<br>
5)Cycle: Cycle is a simple path, except that the last vertex is same as the first vertex.<br>
6)Connected Graph: If any two vertices are connected by path, then it is connected graph.<br>
7)Subgraph: subset of vertices and edges forming a graph.<br>
8)Tree(Free): A tree is a connected graph without any cycles in it. This is not the tree data structure because we don't have notion of root, parent and child here.<br>
9)Complete Graph: A complete graph is a graph in which there is an edge between every pair of vertices.<br>

How many edges does a complete graph have?<br>
Ans: nc2. i.e. n(n-1)/2.

How many edges does a complete directed graph have?<br>
Ans: 2*nc2 i.e. n(n-1).
Minimum no of edges in a graph with n vertices are 0. (Need to understand this)

maximal connected subgraph: A set is called maximal if we cannot increase the size of the set while retaining property.

what is the sum of degrees of all vertices?<br>
Ans: Twice the no of edges, because adjacent vertices each count the adjoining edge, it will be counted twice.

*****
Note
----
If for two vertices A and B there is an edge e joining them, we say that A and B are adjacent.<br>
If two edges e and f have a common vertex A, the edges are called incident.<br>
If the vertex A is on edge e, the vertex A is said to be incident on e.

A connected graph with no cycle(or a Tree) of n vertices will have n-1 edges. If no of edges are less than n-1 then the graph is not connected.<br>
If a connected graph with cycle, you cannot make it unconnected just by breaking the cycle.

If a tree has n vertices and n-k edges it will have k connected components in it.

Spanning Tree
-------------
A spanning tree of G is a sub graph which is a tree and contains all vertices of G.

Multi Graph
-----------
If there is more than one edge between a pair of vertices, then it is called multi graph.

Eulerian Tour: Path that traverses every edge exactly once and returns to the first vertex.<br>
Euler's Theorm: A graph has a Eulerian Tour if and only if all vertices have even degree.

The Graph ADT
-------------
The Graph ADT is a positional container whose positions are vertices and edges of the graph.<br>
size(),isEmpty(),elements(),position(),swap(),replace(),noOfVertices(),noOfEdges(),<br>
directedEdges() //enumeration of all directed edges in G<br>
undirectedEdges(v) // enumeration of all undirected edges in G<br>
incidentEdges(v) // enumeration of all edges incident on v<br>
inIncidentEdges(v) // enumeration of all edges entering v<br>
outIncidentEdges(v) //enumeration of all edges leaving v<br>
opposite(v,e) // gives the vertex from other end of the edge e of vertex v<br>
degree(v) // the degree of v<br>
inDegree(v) // no of edges entering v<br>
outDegree(v) // no of edges leaving v<br>
adjacentVertices(v) // enumeration of vertices adjacent to v<br>
inAdjacentVertices(v) // enumeration of vertices adjacent to v along incoming edges<br>
outAdjacentVertices(v) // enumeration of vertices adjacent to v along outgoing edges<br>
areAdjacent(v,w) // weather v and w are adjacent<br>
endVertices(e) // the end vertices of e<br>
origin(e) // the end vertex from which e leaves<br>
desination(e) // the end vertex at which e arrives<br>
isDirected(e) // true if e is directed

update methods
--------------
makeUndirected(e) // Set e to be undirected edge<br>
reverseDirection(e) // switch the origin and destination vertices of e<br>
setDirectionFrom(e,v) // Sets the direction of e away from v one of its end vertices.

Mixed graph: A graph in which some edges are directed and some are not. A real time use case for this are roads.

Data structures for graphs
--------------------------

1)Edge List: The edge list structure simply stores the vertices and the edges in two unsorted sequences. This is easy to implement.

Note:Finding the edges incident on a vertex is inefficient because it requires examing the entire edge sequence.

Performance of edge list
------------------------
size,isEmpty,replaceElement,swap - O(1)<br>
numVertices,numEdges - O(1)<br>
vertices - O(n)<br>
edges,directedEdges,undirectedEdges - O(m)<br>
elements,positions - O(m+n)<br>
endVertices,opposite,origin,destination,isDirected - O(1)<br>
incidentEdges,inIncidentEdges,outIncidentEdges,adjacentVertices,inAdjacentVertices - O(m)<br>
outAdjacentVertices,areAdjacent,degree,inDegree,outDegree - O(m)<br>
insertVertex,insertEdge,insertDirectedEdge,removeEdge,makeUndirected - O(1)<br>
reverseDirection,setDirectionFrom,setDirectionTo - O(1)<br>
removeVertex - O(m)

2)Adjacency Lists:

Adjacency list of a vertex v: sequence of vertices adjacent to v represent the graph by the adjacency lists of all the vertices.

All vertices are placed in an array. All the vertices adjacent to a given vertex is placed in a list, typically linked list. we know no of vertices adjacent to each vertex is called degree of a vertex.So, Total space occupied is (n + degree of each vertex) = n + 2m. Total space occupied is equal O(n+m).

Note: Finding out all the vertices adjacent to a given vertex is easy. It takes order of degree.

Note: In this edges are not stored. For ex, given two vertices and asked to findout if there is an edge between them, we need to traverse the entire list.

Note:Modern adjacency list implement combine edge list and adjacency list. Given an edge finding out the vertices incident to it easy in the modern implementation.

Performance of adjacency list
-----------------------------
size,isEmpty,replaceElement,swap - O(1)<br>
numVertices,numEdges - O(1)<br>
vertices - O(n)<br>
edges,directedEdges,undirectedEdges - O(m)<br>
elements,positions - O(m+n)<br>
endVertices,opposite,origin,destination,isDirected,degree,inDegree,outDegree - O(1)<br>
incidentEdges,inIncidentEdges,outIncidentEdges,adjacentVertices,inAdjacentVertices - O(degree(v))<br>
outAdjacentVertices - O(degree(v))<br>
areAdjacent - O(minDegree(u),degree(v))<br>
insertVertex,insertEdge,insertDirectedEdge,removeEdge,makeUndirected - O(1)<br>
reverseDirection,setDirectionFrom,setDirectionTo - O(1)<br>
removeVertex - O(degree(v))<br>

3)Adjacency Matrix
Matrix M(two dimensional array) with entries for all pair of vertices. <br>
M[i,j] = true means that there is an edge (i,j) in the graph.<br>
M[i,j] = false means that there is no edge (i,j) in the graph.<br>
Total space occupied is O(n^2).

Performance of Adjacency matrix
-------------------------------
size,isEmpty,replaceElement,swap - O(1)<br>
numVertices,numEdges - O(1)<br>
vertices - O(n)<br>
edges,directedEdges,undirectedEdges - O(m)<br>
elements,positions - O(m+n)<br>
endVertices,opposite,origin,destination,isDirected,degree,inDegree,outDegree - O(1)<br>
incidentEdges,inIncidentEdges,outIncidentEdges,adjacentVertices,inAdjacentVertices - O(n)<br>
outAdjacentVertices - O(n)<br>
areAdjacent - O(1)<br>
insertEdge,insertDirectedEdge,removeEdge,makeUndirected - O(1)<br>
reverseDirection,setDirectionFrom,setDirectionTo - O(1)<br>
insertVertex,removeVertex - O(n^2) (n^2 because you need to copy the entire array)<br>

Note: Adding a new vertex needs adding a new row and new column, which is not very efficient.<br>
Note:Modern Adjacency matrix keep edge information instead of true/false.

Note:Given a vertex, to findout all the vertices which are adjacent to it, it takes O(n) not degree.

Which data structure is preferred when?
Ans: when space is not an issue, Adjacency matrix is the best solution. Standard implementation used is Adjacency list.

Graph Searching Algorithms
--------------------------
Graph Searching algorithm is a mechanism for visiting all the vertices of a graph in some systematic manner. We assume adjacency list.

Breadth First Search
--------------------
A BFS traverses a connected component of a graph, and in doing so defines a spanning tree with several useful properties.

1)BFS is an undirected graph G  is like wandering in a maze field with a string(or rope).<br>
2)BFS starts with a vertex say s, which is assigned a distance 0(like anchor).<br>
3)In the first round, the string is unrolled the length of one edge, and all the vertices which are one edge away from the anchor are visited, and assigned distances of 1.<br>
4)In the second round,all the new vertices that can be reached by unrolling the string 2 edges are visited and assigned a distance of 2.<br>
5)This is continued until every vertex has been assigned a level.

Note: The label of any vertex v corresponds to the length of the shortest path from s to v.

BFS properties
--------------
1)Given an undirected graph G = (V,E),BFS discovers all vertices reachable from a source vertex s.<br>
2)For each vertex v at level i(distance from s),the path of BFS tree T between s and v has i edges, and any other path of G between s and v has atleast i edges.<br>
3)If(u,v) is an edge then the level numbers of u and v differ by atleast one.<br>
4)It computes the shortest path to all reachable vertices.
