/*
  loricarlos@gmail.com
  Testing different algorithms
  One test for each algorithm
*/

function test_recursive_backtracking(n){
	print('\n*** Testing recursive_backtracking ***');
	reset();
	var a = genArray(n);
	method = BACKTRACKING;
	permTester = new PermTester(method, n);
	var before = cTM();
	recursive_backtracking(a, a.length - 1, showPermutation);
	var after = cTM();
	print('\n*** Count of recursive_backtracking swaps = ' + swaps + " (" + (after - before) + " ms)");
	permTester.ensureComplete();
	
}

function test_recursive_heap_sedgewick(n){
	print('\n*** Testing recursive_heap_sedgewick ***');
	reset();
	var a = genArray(n);
	method = HEAP_SEDGEWICK;
	permTester = new PermTester(method, n);
	var before = cTM();
	recursive_heap_sedgewick(a, a.length - 1, showPermutation);
	var after = cTM();
	print('\n*** Count of recursive_heap_sedgewick swaps = ' + swaps + " (" + (after - before) + " ms)");
	permTester.ensureComplete();
}

function test_permutate_lexicographically(n){
	print('\n*** Testing lexicographically ***');
	reset();
	var a = genArray(n);
	method = LEXIC;
	permTester = new PermTester(method, n);
	var before = cTM();
	permutate_lexicographically(a, showPermutation);
	var after = cTM();
	print('\n*** Count of lexicographically swaps = ' + swaps + " (" + (after - before) + " ms)");
	permTester.ensureComplete();
}

function test_permutate_naive(n){
	print('\n*** Testing naive all_permutations ***');
	reset();
	var a = genArray(n);
	method = NAIVE;
	permTester = new PermTester(method, n);
	var before = cTM();
	var perms = permutate_naively(a);
	for (var i = 0; i < perms.length; i++){
		showPermutation(perms[i]);
    }
	var after = cTM();
	print('\n*** Count of naive all insertions = ' + insertions + " (" + (after - before) + " ms)");
	permTester.ensureComplete();
	
}

