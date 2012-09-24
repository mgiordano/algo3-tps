#include <fstream>
#include <string>

using namespace std;

int main(){

	FILE * testOut = fopen("dsitrUniforme.in","w");
	int tam = 10;
	int i;
	int j;
	for (int n = 0; n < 200; n++){
		fprintf(testOut,"%d\n",tam);
		int m = 0.3 * tam;
		i = (tam/2) - m;
		j = (tam/2) + m;
		while (i <= j){
			fprintf(testOut,"%d ",i);
			i = i+2;
		}
	tam = tam + 10;
	fprintf(testOut,"\n");
	}

	fclose(testOut);

	return 0;

}
