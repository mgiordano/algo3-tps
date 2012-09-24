#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

using namespace std;

int main(){
	srand(time(NULL));
	int cantNodos, random1, random2 = 0;
	cin >> cantNodos;
	random1 = rand()%cantNodos + 1;
	cout << random1 << " ";
	do{
		random2 = rand()%cantNodos + 1;
	}while (random1 == random2);
	cout << random2 << endl;
	for(int i = 1; i <= cantNodos; i++){
		//random1 = rand()%cantNodos + 1;
		cout << i << " ";
		do{
			random2 = rand()%cantNodos + 1;
		}while (i == random2);
		cout << random2 << ";";
	}
/*	int cantNodosCuad = cantNodos*cantNodos;
	for(int i = 0; i < cantNodosCuad; i++){
		random1 = rand()%cantNodos + 1;
		cout << random1 << " ";
		do{
			random2 = rand()%cantNodos + 1;
		}while (random1 == random2);
		cout << random2 << ";";
	}*/
	cout << endl;
}