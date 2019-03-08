/*
  loriacarlos@gmail.com
*/
load('src/js/load_permutate.js');

function test_permutate_all(n){
	if (! n){
		print("Using default size: " + DEFAULT_PERMUT_SIZE);
		n = DEFAULT_PERMUT_SIZE;
	}
	test_recursive_backtracking(n);
	test_recursive_heap_sedgewick(n);
	test_permutate_lexicographically(n);
	test_permutate_naive(n);
	
}

var n = arguments[0] || DEFAULT_PERMUT_SIZE
print('\n*** Testing all permutation methods with ' + n + ' objects ***\n');
test_permutate_all(n);

print('\n *** Finished ***')