jar: FinalProjectGUI.class
	jar cvfm ChromPolyGraph.jar manifest.txt *.class

runGUI: FinalProjectGUI.class
	java FinalProjectGUI
	make clean

runGraph: GraphNormal.class
	java GraphNormal
	make clean

debugGraph: GraphNormal.class
	jdb GraphNormal

FinalProjectGUI.class: FinalProjectGUI.java BasicSwing.class GraphPanel.class
	javac -g FinalProjectGUI.java

GraphPanel.class: GraphPanel.java
	javac -g GraphPanel.java

BasicSwing.class: BasicSwing.java
	javac -g BasicSwing.java

GraphNormal.class: GraphNormal.java Edge.class Polynomial.class
	javac -g GraphNormal.java

Polynomial.class: Polynomial.java
	javac -g Polynomial.java

Vertex.class: Vertex.java
	javac -g Vertex.java

Edge.class: Edge.java Vertex.class
	javac -g Edge.java

clean: 
	rm *.class
