// race.h

#ifndef RACE_H_EXISTS
#define RACE_H_EXISTS

#include <string>
#include "horse.h"

class Race {
        private:
                Horse horses[5];
                int length;
        public:
                Race();
                Race(int length);
                void printLane(int horseID);
		void start();
}; // end class definition

#endif
