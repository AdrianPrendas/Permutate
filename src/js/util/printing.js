/*
  loricarlos@gmail.com
*/

/*
  Utility for printing with some margin
*/
var margin = 0,
    increment = 3,
    marginChar = ' ',
	verbose = false
;
function resetMargin(){
	margin = 0;
	increment = 3,
    marginChar = ' '
}
function incMargin(){
	margin += increment;
}

function decMargin(){
	margin -= increment;
}
function printMargin(s){
	if (! verbose ) return;
	for (var i = 1; i <= margin; i++) 
		write(marginChar);
	print(s);
}

function printPlain(s){
	if (! verbose ) return;
	print(s);
}