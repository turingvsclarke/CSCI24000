Its all a function of horsepower algorithm

Ryan Eades

Overview: The main data structure is an array of five integers. Each integer is between 0 and 15. The value at index i is the place of horse i on the track.

Input:The user provides a seed number to be used for the random number generation piece of this assignment.

Output:A simulation of where the horses are with respect to each other after each lap. This is done by the print function.

Main function: Creates the horses array and calls the getseed function. The rest of it is a loop that continues as long as 14 is not in the horses array(meaning no horse has won). Within the loop are calls to the lap, print, and ended functions 

GetSeed function: Prompts the user for a random number generation seed and stores that seed.

Lap function: Loops through the horses. At the ith horse, it generates a random number of 0 or 1. The value at the horse pointer+i is advanced by this random integer. This is done by passing the local horses pointer/array and adding i to get the ith horse. 

Print function: Loops through horses array, starting with the horses pointer and moving to the next address after each iteration. At each address, it loops a print statement j times, where j is between 0 and 15. If the value at that address equals j, it prints that value, otherwise it prints a period.

Ended function: Gets passed the horses pointer and the main function while loop sentry variable. It looks at each address of the horses array and makes sure all values at those addresses are less than the lap size, meaning the race is not over. If it finds an address at the lap size, it outputs that the corresponding horse has won and changes the sentry variable so the main while loop terminates.

