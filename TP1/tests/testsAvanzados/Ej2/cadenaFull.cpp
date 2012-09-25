#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

using namespace std;

int main(){	
	srand(time(NULL));
	int cantIter, p, q;
	cin >> cantIter;
	p = 1;
	cout << p << " ";
	q = cantIter;
	cout << q << endl;
	int j = 0;
	for(int i = 1; i < cantIter; i++){
		j = i+1;
		cout << i << " " << j << ";";
	}
	cout << endl;
}