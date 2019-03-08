/*
  loriacarlos@gmail.com
  Demo
  Very expensive recursive permutations generation
  All permutations are first genearted
*/

function permutate_naively(p){
	if (p.length == 0) return [[]];
	if (p.length == 1) return [p];
	var first = p[0];
	var withoutFirst = permutate_naively(p.slice(1));
	return insertFirstIntoAll(first, withoutFirst);
	
}

function insertFirstIntoAll(first, withoutFirst){
	var res = [];
	for(var i = 0; i < withoutFirst.length; i++){
		var allWithFirst = insertFirstIntoOne(first, withoutFirst[i]);
		res = res.concat(allWithFirst);
	}
	return res;
	
}

function insertFirstIntoOne(first, p){ // p = [p[0], p[1], ..., p[n]]
	var res = [];
	for(var i = 0; i <= p.length; i++){
		var s = insertAt(p, i, first)
		res.push(s);
	}
	return res;
}


