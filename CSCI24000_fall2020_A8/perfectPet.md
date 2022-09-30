Ryan Eades

                            #  Perfect Pet

## ATTRIBUTE CLASS:
This is an abstract class, as the platonic "Attribute" does not exist. However, its methods will be concrete, since each specific attribute will have the same functionality.

Each attribute will have a list of values. Each attribute will also have an index. Because the attributes are unknown, we choose to use an integer as a sort of pointer that tells where in the abstract list we are currently. We will make this index private, to ensure that we don't set it to an illegal value with respect to the list. We will also make the list of values private.

We would like to get the current attribute. We would also like to increase or decrease the current attribute.

Instance variables(both private): 1. String[] values  2. int attributeIndex

### Methods(all public):

1. Attribute(values): The constructor takes in the list of values and sets the index to the first value. This is the only access we allow to the values list member.
2. String getAttribute(): This method returns the value of the attribute list at the attribute index variable
3. void increaseAttribute(): This method increases the attribute index variable, thus "pointing" to the next attribute. If there is no next attribute, it does nothing.
4. void decreaseAttribute(): This method decreases the attribute index variable, thus "pointing" to the previous attribute. If there is no previous attribute, it does nothing.

## SPECIFIC ATTRIBUTES:
Each attribute subclass looks exactly the same. It has a list of values and simply passes it to the parent constructor.

The list will be declared as static final. The constructor is null valued and simply calls the parent class's constructor using its "constant" list.

## PET CLASS:
This is an abstract class, as we know we want actual species of pets, so we'll never instantiate a "pet" by itself. Many of its methods will be concrete, though some will be abstract(we aren't even going to guess how a pet should be bathed. Do not. I repeat: **DO. NOT.** put your unicorn in your bathtub or use an industrial shower on your goldfish.)

Each pet will have a name. It will also have a species. Finally, it has a list of attributes with it to give the pet some personality.
We do not know what species and names our developers will create, so we are going to create a primary constructor that takes both a name and a species. We will also create an abstract null constructor, ensuring that each subclass has some default value that can the be fed into the non-null constructor.

### Methods():

1. null-valued constructor. "Fido" is a good name for a dog, but not a cat. "Mittens" is a good name for a cat but weird for a snake. We're going to make this abstract to ensure the subclasses properly define default values for their instances.
2. Name-valued constructor. Take a pet's name, set it to that pet's name instance variable.
3. bathe(abstract). Every pet should be cleaned somehow, but as we mentioned above these processes will vary severely by class. We want each subclass to implement some way of cleaning their pet, but we won't even guess how it's done(in fact, shampooing a lizard will really harm its skin-the more you know...).
4. cleanHome(abstract) Same with bathe. We wouldn't want to try to sweep out an aquarium. Some pets may not have much in this area, such as dogs, but we want our developers to at least keep it in mind when creating their subclasses.
5. feed(abstract) Horses don't get crickets, goldfish don't get oats. End of story. But everyone's got to eat.
6. listAttributes. This will be a normal class that just lists all the attributes in the attribute array. We'll need it later when finding out what exactly we can mess with in terms of the pet.
7. listActions. This method will output an array of all the different methods you can do with your pet. We'll give it the values of the method we have, then each subclass will add on using the new methods they decide to add.
8. doStuff. For a given array index, perform that action which is in the array.

That seems pretty good for now. We'll revisit this after creating more stuff.

## SPECIFIC PETS:


## PetInterface class:

This class will be the main executable for this program. It will provide a (for now)command-line-only interface for user interaction. The user will be given a list of pets specific to this computer. There will also be options to exit or create a new pet. The only data type we have is CurrentPet and an array list of pets.
When the user selects a pet, they will be given a list of options for things that they can do with that pet, based on the listActions method. They will also be given the option to view the pet's current emotional well-being and of course an option to return to the last menu.
When creating a new object, the user will be shown a list of all the possible options for a pet's species. It will select the number of the pet and then be prompted to enter a name. Upon entering a name, it will be taken back to the main menu, which will now show the new pet.
When the user first starts and ends the game, we will read from and save to, respectively, a data file that stores our pets.

### Methods:
1. Constructor(null-valued): The constructor will invoke a loadPets() method, properly setting up the game.
2. main: We create an instance of our game and then call the setUpGame method to get everything started. The next line calls the endGame method.
3. The startInterface method: This is the method where the game actually happens. It will consist of a while loop that is only exited if the user enters "0". We welcome them to the game, give some basic instructions, then enter the while loop. We first call a printPets method and also print out a new Pets method. We then call a method to handle user input.
4. checkForExit method: This method takes an integer as a parameter, and changes the boolean runGame if that integer is 0.
5. endGame: Tell the user that the game data is being saved, then call the savePets method.
6. loadPets: This method will read from our file and store the result in a pets array.
7. savePets: This method will write our pets into a file.
8. addPet: This method will show the user a list of all possible pets(a static variable), ask for a selection, ask for a name, then save the pet.
