Vehicle.class: Vehicle.java
	javac Vehicle.java

Brand.class: Brand.java
	javac Brand.java

Car.class: Vehicle.class Brand.class Car.java
	javac Car.java

runVehicle: Vehicle.class
	javaVehicle

runCar: Car.class
	java Car

clean:
	rm *.class
