// normal_distribution
#include <iostream>
#include <random>
#include <algorithm>
#include <vector>
#include <set>

using namespace std;

int main() {

	FILE * testOut = fopen("distrNormal.in","w");

	for (int tam = 100; tam < 1250; tam = tam+10){
		fprintf(testOut,"%d\n",tam);

		const int m = 0.25 * tam;  // número de experimentos

		default_random_engine generator;
		normal_distribution<double> distribution(tam/2,0.1*tam);
		set<int> cortes_tmp;
		
		while(cortes_tmp.size() < m) {
			double number = distribution(generator);
			cortes_tmp.insert((int) number);
		}

		vector<int> cortes(cortes_tmp.begin(), cortes_tmp.end()); 
		sort(cortes.begin(), cortes.end() );
		
		vector<int>::iterator it = cortes.begin();
		while (it != cortes.end()){
			fprintf(testOut,"%d ",*it);
			it++;
		}
		
		fprintf(testOut,"\n");
	}

	fclose(testOut);

  return 0;
}
