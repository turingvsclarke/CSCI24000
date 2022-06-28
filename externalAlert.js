/**************************************
 TITLE: externalAlert.js
 AUTHOR: Ryan Eades (RE)
 CREATE DATE: 20 August 2020
 PURPOSE: The code to make my page create a pop up
 LAST MODIFIED ON: 20 August 2020
 LAST MODIFIED BY: Ryan Eades (RE)
 ORIGINAL BUILD
***************************************/

// The $ is the jQuery object
// "document" is the document object
// ready is a method of the jQuery object
// function creates an anonymous function to contain the code that should run
// In English, when the DOM has finished loading, execute the code in the function.
// See pages 312-313 of the text for details.
$(document).ready(function(){     // Pop up a window that says "Here's a javascript test file!"

	alert("Here's a javascript test file!");

}); // end of $(document).ready()
