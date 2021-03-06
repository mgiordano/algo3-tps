#include <iostream>
#include <fstream>
#include <vector>
#include <stdio.h>
#include <iomanip>
#include <locale>
#include <sstream>
#include <string>
#include <stdlib.h>
#include <time.h>

using namespace std;

void imprimirVector(FILE *, vector<int>);

int main(){
	srand(time(NULL));
	int random, decision;
	int cantIter = 30;
	vector<int> nr;
	random = rand()%(500*cantIter) + 1; //primer numero
	for(int i = 1; i < cantIter+1; i++){
		string cant = static_cast<ostringstream*>( &(ostringstream() << (500*i)) )->str();
		string nom_arch = "test" + cant + ".in";
		FILE * testOut = fopen(nom_arch.c_str(),"w");
		for(int j = 1; j < 500; j++){
			vector<int>::iterator it;
			it = nr.end();
			decision = rand()%(2);
			if(decision == 0){
				//crece
				if(random < 14999) random++;
			}else{
				//decrece
				if(random > 1) random--;
			}
			nr.insert(it,random);
		}
		imprimirVector(testOut,nr);
		fclose(testOut);
	}
}

void imprimirVector(FILE * pfile, vector<int> vec){	
	vector<int>::iterator it;
	it = vec.begin();
	while (it != vec.end()){
		fprintf(pfile,"%d ",(*it));
		it++;
	}	
}
