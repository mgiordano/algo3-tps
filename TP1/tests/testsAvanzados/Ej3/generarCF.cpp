#include <fstream>
#include <string>

using namespace std;

int main(){

	FILE * testOut = fopen("cortesFijo.in","w");

	for (int tam = 500; tam < 10500; tam = tam + 10){
		int i;
		int j;
		fprintf(testOut,"%d\n",tam);
		int m = 100;
		i = (tam/2) - m;
		j = (tam/2) + m;
		while (i <= j){
			fprintf(testOut,"%d ",i);
			i = i+2;
			}
		fprintf(testOut,"\n");
	}
	fclose(testOut);

	return 0;

}
