
#include <fstream>
#include <string>

using namespace std;

int main(){

	FILE * testOut = fopen("testsNormal.in","w");

	for (int i = 10; i < 1000; i = i + 10){
		fprintf(testOut,"%d\n",i);
		int j = 2;
		for (int n = 0; n < (i*0.4); n++){
			fprintf(testOut,"%d ",j);
			j = j+2;
		}
		fprintf(testOut,"\n");
	}	

	fclose(testOut);

	return 0;

}
