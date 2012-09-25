#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

int main(){	
	int cantIter, p, q;
	cin >> cantIter;
	p = 1;
	cout << p << " ";
	q = cantIter;
	cout << q << endl;
	for(int i = 1; i < cantIter; i++){
		for (int j = i+1; j <= cantIter; j++){
			cout << i << " " << j << ";";
		}
	}
	cout << endl;
}