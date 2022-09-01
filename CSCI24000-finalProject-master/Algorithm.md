Ryan Eades
 
CSCI 24000

# Final Project Documentation


## Vertex(implements Cloneable):
### Summary: 
The vertex class is used to represent paintable nodes on a Swing component. Each vertex can also be thought of as a point in Cartesian space. Not in an abstract sense but in the sense of a fixed point ON a graph.
 
### Data Members:
* int x(primitive): The horizontal coordinate for the vertex
* int y(primitive): The vertical coordinate for the vertex 
Methods:
* Vertex(int x,int y): Constructor that returns a new Vertex object with x and y as instance variables.
* clone(): Overrides the Object.clone() method, returning a new vertex object with the same coordinates
* getX(): Returns the integer x coordinate of this vertex
* getY(): Returns the integer y coordinate of this vertex
* setCoordinates(int x,int y): Sets the coordinates of the Vertex instance to x and y.
* printCoordinates(): Prints the x and y coordinate instance variables.

## Edge(implements Cloneable): 
### Summary: 
The edge class represents the relationship of connection between two vertices on a graph. Each instance contains an unordered pair of Vertex objects, meaning that an edge is only unique up to a permutation of its vertices.


### Data Members:
* Vertex V1: One of the extremities of the edge.
* Vertex V2: One of the extremities of the edge.
(Note that the labelling is irrelevant as the edges are undirected, meaning they have no natural order)
### Methods:
* clone(): Returns a new Edge object whose vertices are those obtained from the originals using Vertex.clone().
* containsVertex(Vertex v): Returns a boolean value of true if either Vertex instance variable is equal to v. Returns false otherwise.
* Edge(Vertex a,Vertex b): Constructor that returns a new Edge object with a and b as instance variables. Throws SameVertex if both coordinates of a and b are the same.
* getV1(): Returns instance variable V1.
* getV2(): Returns instance variable V2.
### Subclasses:
* SameVertex: Child of Exception. Used by Edge constructor to ensure it isn’t passed two vertices with the same coordinates.


## GraphNormal(Implements Cloneable):
### Summary: 
The main class for graph generation and operation. It needs to take any pair of vertex/edge lists and handle all the functionality of the graph. It will be the class where the computation of the chromatic polynomial actually occurs, so needs to remove, add, collapse, and otherwise manipulate edges.

### Data Members: 
* ArrayList Edges: The list of Edge objects present in this graph.
* ArrayList Vertices: The list of Vertex objects present in this graph.

### Methods: 
* GraphNormal(): A null valued constructor that simply initializes and empty Edge list and an empty Vertex list. 
* GraphNormal(int vertexSize,int edgeSize,int xRange,int yRange): A constructor that creates a random graph. The first argument dictates the number of vertices to create. The second dictates the maximum number of edges between them. The other two values provide ranges for the coordinates of the vertices.  
* clone(): An extension of Object.clone(). It creates a new graph with copies of each vertex and edge. The end result is preservation of vertex coordinates and edge relationships with a completely new object on the heap.
* printVertices(): Prints all the vertices of the graph by iteratively calling printCoordinates() on each Vertex.
* printEdges(): Prints all the edges of the graph by iteratively printing the order of the two incident Vertex objects in the vertices instance variable. Typically used after a call to printVertices().
* addVertex(Vertex v): Adds a vertex to the list of vertices.
* removeVertex(Vertex v): Removes the Vertex from the list of vertices. Throws HasEdgeException if an edge is incident upon the vertex.
* containsVertex(Vertex v): Returns a boolean value of true if the list of vertices contains the Vertex and false if it does not.
* addEdge(Vertex v1,Vertex v2): Adds a new edge to the graph incident on the two vertices. Calls edge.containsVertex() iteratively on both edges to ensure a similar edge doesn’t already exist(ensuring each graph is simple).  
* getVertex(int i): Returns the ith Vertex of the graph.
* getEdge(int i): Returns the ith edge of the graph.
* getEdges(): Returns the Edges ArrayList.
* getVertices(): Returns the Vertices ArrayList.
* removeEdge(Edge e): Removes e from the Edges list.
* collapseEdge(Edge e): “Collapses” the edge e. Calls removeEdge(e), then iteratively transfers then removes all edges incident to one Vertex to edges incident on the other Vertex. Finally it removes the first Vertex.
* hasEdges(): Returns a boolean value of true if the Edge list is non-empty and false if empty. A relic of a previous release in which the Edge object didn’t exist and relationships between vertices were implied.
* getChromPoly(): Returns a Polynomial whose evaluation on an int t is the number of distinct ways to color the graph using t colors. Recursively calls getChromPoly() on two copies of the current graph, one with a random edge removed and one with the same edge collapsed, then subtracts the results. Recursion ends when a graph is reached whose hasEdges() value is false.
* getChromPoly(): Uses the same algorithm as [Polynomial]getChromPoly(), but returns a String. This method was made obsolete by the introduction of Polynomial objects in the package.

### Subclasses:
* HasEdgeException: Child of Exception. Used by removeVertex() to ensure vertices with edges aren’t removed.


## GraphDialog:

### Summary: An extension of JDialog for user input related to graph generation. The dialog layout is two spinners and a submit button, allowing users to enter the size of the desired graph and indicate that they’ve made a final selection.

### Data Members: 
* JSpinner vSpin: A JSpinner object for the user to input the desired number of vertices in the new graph.
* SpinnerNumberModel vModel: The spinner number model for the vSpin instance variable. It allows integer input with a minimum of zero and step size of 1.
* JSpinner eSpin: A JSpinner object for the user to input the desired number of edges in the new graph. 
* SpinnerNumberModel eModel: The spinner number model for the eSpin instance variable. It allows integer input with a minimum of zero, step size 1, and max 0.
* JButton submit: A button to link the dialog input to actual graph generation. 
* int vertexSize: The vertex size of the desired graph.
* int edgeSize: The edge size of the desired graph.
### Methods:
* GraphDialog(): Null-valued constructor. Builds a default dialog of size 400x300 without resizing ability. Spinners are instantiated on a panel along with labels for the types of input.
* setVertexSize(int vsize): Sets the vertexSize instance variable to the accepted integer.
* setEdgeSize(int esize): Sets the edgeSize instance variable to the accepted integer.
* getVertexSize(): Returns the edgeSize instance variable.
* getEdgeSize(): Returns the vertexSize instance variable.
### Subclasses:
* EchangeListener: A ChangeListener to be added to the eSpin instance variable. Upon firing, stateChanged passes the state of eModel to setEdgeSize().
* VchangeListener: A ChangeListener to be added to the vSpin instance variable. Upon firing, stateChanged passes the state of vModel to setVertexSize() and appropriately sets the maximum of eModel.


## GraphPanel:
### Summary: 
An extension of JPanel to display the graph. This paintable panel handles all communication between the GUI and GraphNormal, but visually only shows the graph, none of the controls.

### Data Members:
* GraphNormal graph: The graph being displayed and controlled by the current GraphPanel instance.
### Methods:
* GraphPanel(): Null constructor
* generateGraph(int v, int e): Calls the graph generation constructor on the graph instance variable of the current GraphPanel object. The accepted integers are used as respective sizes for the passed number of vertices and edges. The width and height of the current GraphPanel object are passed as the respective x and y ranges. 
* getVertexAtPoint(int x, int y): Returns a Vertex if there exists one “near” the given coordinates, else returns null. Iteratively checks each Vertex of the graph instance variable. Due to how paintMethod() renders vertices, “near” is defined as the x coordinate and y coordinate of the Vertex each being within 5 pixels of the accepted x and y integers. 
* addNewVertexListener(): Adds a NewVertexListener to the panel.
* addEdgeListener(): Adds a SecondVertexListener to the panel.
* addSecondVertexListener(Vertex v): Adds a SecondVertexListener to the panel with Vertex v passed as a parameter.
* paintComponent(Graphics g): Overrides the paintComponent() method of JComponent. Does the following steps to paint each graph:
1. Repaints the entire panel using its default background color(dependent on the local UI environment, but some shade of white). 
2. Iteratively paints a red circle with radius 5 centered around the coordinates of each Vertex object in the graph instance variable.
3. Iteratively draws a line between the coordinates of the Vertex objects of each edge.
* getGraph(): Returns the graph object of the current GraphPanel instance.
### Subclasses: 
* NewVertexClickListener: A child of MouseAdapter to listen for the user clicking the panel to create a new vertex. To resolve conflicts with other click listeners, it only fires once. Upon firing, a Vertex is added to the graph instance variable at the Event object’s location. The panel is then repainted.
* FirstVertexListener: A child of MouseAdapter to listen for the user clicking the panel to select the first vertex of a new edge. Upon firing, it calls getVertexAtPoint() using the Event object’s position. If null is returned, it does nothing. Otherwise, it calls addSecondVertexListener using the returned Vertex as a parameter then prevents the current FirstVertexListener from ever firing again.
* SecondVertexListener: A child of MouseAdapter to listen for the user clicking the panel to select the second vertex of a new edge. Each SecondVertexListener should be passed a Vertex as an argument. Upon firing, it calls getVertexAtPoint() using the event position. If null is returned, it does nothing. Otherwise it uses the instance variable Vertex and the returned Vertex to call addEdge() on the graph instance variable, then prevents the current SecondVertexListener from ever firing again.
* DragVertexListener: A child of MouseAdapter. Upon a press MouseEvent, it calls getVertexAtPoint() using the current Event object’s position. If a non-null Vertex is returned, it continually updates the coordinates of the Vertex for dragging and releasing Events and repaints the panel.


## BasicSwing:
### Summary: 
Extension of JFrame giving frames an automatic size of 1200x600, visibility value of true, and default close operation of exit. The ContentPane is given as an instance variable for easy access. Default title of “This app is super sexy” unless a title string is passed in the constructor. Extends ActionListener for convenience, but actionPerformed() should still be overwritten for proper functionality.
### Data Members:
* Container contentArea
### Methods: 
* BasicSwing(): Null-valued constructor.
* BasicSwing(String title): Creates a BasicSwing instance with the accepted String parameter as its title.

## FinalProjectGUI:
### Summary: 
A child of BasicSwing that provides the frame and functionality to connect  and present the GraphPanel and GraphDialog object.
### Data Members:
* GraphPanel gpanel: The GraphPanel object to be used with this instance of the GUI.
* JButton addVertex: JButton for the user to indicate they want to add a vertex to the graph.
* JButton addEdge: JButton for the user to indicate they want to add an edge to the graph.
* JButton getPoly: JButton for the user to indicate they want to see the chromatic polynomial for the current graph.
* JButton generateGraph: JButton for the user to indicate they want to generate a new graph.
* JButton clear: JButton for the user to clear the screen of the gpanel instance variable.
* JLabel polyDisplay: JLabel to hold the text representation of the chromatic polynomial.
* JLabel solution: JLabel to hold the solution of evaluating the polynomial for the given number.
* SpinnerNumberModel sModel: A SpinnerNumberModel for user input regarding solving the polynomial.
* GraphDialog d: An instance of GraphDialog for graph generation.
* SolveDialog s: An instance of SolveDialog to allow users to solve the polynomial.
### Methods:
* FinalProjectGUI(): Constructor. Adds a GraphPanel, ButtonPanel, and PolyPanel to the frame using a BorderLayout layout manager.
### Subclasses:
* ButtonPanel: Panel for the controlling buttons. Constructor adds addEdge, generateGraph, clearGraph, solvePolyNomial buttons to the current instance and adds the corresponding listener(newEdgeListener, randomGraphGeneration, graphEraseListener, makeSolveDialog) to each button.
* PolyPanel: Panel for displaying the chromatic polynomial. Constructor adds the getPoly button to the current instance as well as a label for displaying the polynomial. Adds a GetPolyListener instance to getPoly.
* SolveDialog: Dialog for evaluating the chromatic polynomial for a given number. Constructor adds a JSpinner for input and a JButton for the user to indicate the value of the spinner is the value to be evaluated. Adds a SolvePolynomialListener to the JButton.
* newVertexListener: An ActionListener to listen for a user wanting to add a new Vertex. Calls addNewVertexListener() on the gpanel instance variable when fired.
* newEdgeListener: An ActionListener that listens for the user wanting to add a new edge. Calls addEdgeListener() on the gpanel instance variable when fired.
* randomGraphListener: An ActionListener to listen for a user wanting to generate a new graph. Upon firing, adds a randomGraphGeneration instance to the submit instance variable of the d GraphDialog instance variable then sets the visibility of d to true.
* randomGraphGeneration: An ActionListener to listen for the user deciding how big the desired new graph will be. Upon firing, it performs the following steps:
1. Calls getVertexSize() and getEdgeSize() on the d GraphDialog instance variable.
2. Uses the returned values to call generateGraph() on the gpanel GraphPanel instance variable.
3. Sets the visibility of the d GraphDialog instance variable to false.
* graphEraseListener: An ActionListener to listen for the user wanting to clear the current graph. Upon firing, it calls generateGraph() on the gpanel GraphPanel instance variable with 0, 0 as arguments.
* GetPolyListener: An ActionListener to listen for the user wanting the chromatic polynomial of the given graph to be displayed. Upon firing, it performs the following steps:
1. Calls getChromPoly() on the gpanel GraphPanel instance variable.
2. Calls getPolyString() on the returned Polynomial object.
3. Sets the text of the polyDisplay JLabel instance variable to the returned String object.
* makeSolveDialog: An ActionListener to listen for the user wanting to evaluate the chromatic polynomial for a given value. Upon firing, it sets the visibility of the s SolveDialog instance variable to true.
* SolvePolynomialListener: An ActionListener to listen for the user indicating they’ve inputted a value for the evaluation of the chromatic polynomial. Upon firing, it performs the following steps:
1. Calls getChromPoly() on the gpanel GraphPanel instance variable.
2. Gets the current integer value of the sModel instance variable.
3. Calls solvePoly() on the returned Polynomial with the returned integer as an argument.
4. Sets the text of the solution JLabel instance variable to display the returned solution.

## Polynomial:
### Summary: 
A mostly static class used to create a representation for polynomials and provide static methods that represent common arithmetic operations on polynomials. Polynomials are represented as array lists of coefficients, with the ith coefficient(starting at 0) representing the ith order term of that polynomial.
### Methods:
* Polynomial(): Null-value constructors. Calls the ArrayList() constructor.
* Polynomial(int order): Creates a new Polynomial object with 0th entry 1. Calls increaseOrder() on this object using the accepted integer as an argument.
* Polynomial(int[] coeff): Creates a Polynomial object with the same entries as coeff. 
* clone(): Returns a new Polynomial object with the same integer entries at the same indices as the current Polynomial object.
* addPolys(Polynomial a, Polynomial b): Static method that returns a Polynomial object representing the addition of Polynomial a and Polynomial b. It iteratively adds corresponding entries of the Polynomial objects. If one Polynomial is larger than the other, it simply appends the leftover entries to the returned Polynomial object.
* polyByInt(Polynomial p, int x): Iteratively multiplies each element of Polynomial p by int x, then returns the result.
* intByPoly(int x, Polynomial p): Static method that returns the result of a call on polyByInt() with Polynomial p and int x as parameters.
* subtractPolys(Polynomial a, Polynomial b): A static method to return a Polynomial object representing Polynomial b subtracted from Polynomial a. Simply calls polyByInt() with Polynomial b and -1 as parameters to represent Polynomial “-b”. Returns the value of addPolys() using Polynomial a and Polynomial -b as parameters.
* multiplyPolys(Polynomial a, Polynomial b): Iteratively multiplies terms of Polynomial a by Polynomial b using the following process for the ith element of Polynomial a:
1. Increases the order of Polynomial b by i.
2. Multiplies the resultant Polynomial by the ith element of Polynomial a.
3. Adds the resultant Polynomial to the result from the i-1 elements.
4. After the size of a has been reached, returns the resultant Polynomial.
* getPolyString(String variable): Returns a string representation of the polynomial in terms of the passed string. This is done by printing the ith element concatenated with “variable”^n, where variable is the string passed.
* increaseOrder(int n): Returns a polynomial representation of the current Polynomial instance with every term increased by degree n. Adds n zeroes to the end of the Polynomial, then iteratively pushes each element down n places.
* solvePoly(int x): Returns an integer representing the current Polynomial object evaluated at the value of the accepted integer. Iteratively multiplies the ith element of the Polynomial object by x and adds this to an accumulating result, which it eventually returns once the size of the Polynomial has been reached.
