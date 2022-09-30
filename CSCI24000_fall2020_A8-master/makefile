run: PetInterface.class
	java PetInterface

jar: PetInterface.class
	jar cvfm PerfectPet.jar manifest.txt *.class

PetInterface.class: PetInterface.java Lizard.class Unicorn.class Dog.class Duck.class Cat.class Horsey.class
	javac PetInterface.java

Lizard.class: Pet.class Lizard.java
	javac Lizard.java

Unicorn.class: Pet.class Unicorn.java
	javac Unicorn.java

Dog.class: Pet.class Dog.java
	javac Dog.java

Duck.class: Pet.class Duck.java
	javac Duck.java

Cat.class: Pet.class Cat.java
	javac Cat.java

Horsey.class: Pet.class Horsey.java
	javac Horsey.java

Pet.class:  Happy.class Clean.class Hunger.class 
	javac Pet.java

Happy.class: Attribute.class Happy.java
	javac Happy.java

Clean.class: Attribute.class Clean.java
	javac Clean.java

Hunger.class: Attribute.class Hunger.java
	javac Hunger.java

Attribute.class: Attribute.java
	javac Attribute.java

clean: 
	rm *.class
	
