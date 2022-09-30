// glitterCritter.h

#ifndef GLITTER_CRITTER_EXISTS
#define GLITTER_CRITTER_EXISTS

#include "critter.h"

// Glitter critter is going to be a critter at its base, but with extra glittery features
class GlitterCritter: public Critter {
	public:
		// new constructor
		GlitterCritter();

		// new method to spice up critters
		void shimmer();
		void sayHi();
};

#endif
