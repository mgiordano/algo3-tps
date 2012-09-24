#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

using namespace std;

int main(){	
	srand(time(NULL));
	int cantIter, random1, random2 = 0;
//	cout << "Ingrese la cantidad de numeros random que desea generar:" << endl;
	cin >> cantIter;
	random1 = rand()%cantIter + 1;
	cout << random1 << " ";
	do{
		random2 = rand()%cantIter + 1;
	}while (random1 == random2);
	cout << random2 << endl;
	int j = 0;
	for(int i = 1; i < cantIter; i++){
		j = i+1;
		cout << i << " " << j << ";";
	}
	cout << endl;
}