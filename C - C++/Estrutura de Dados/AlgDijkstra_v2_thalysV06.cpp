#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAMANHO 17

typedef char string[20];

typedef struct registro {
	int caminhos[TAMANHO][TAMANHO];
	string vertices[TAMANHO];
	int estimativas[TAMANHO];
	int precedentes[TAMANHO];
	int finalizado[TAMANHO];
}TRegistro;

TRegistro dados;

void inicializa(TRegistro *d);
void busca(int origem, int destino, TRegistro *d);
void exibe(TRegistro *d);
int encontreMenorEstimativa(TRegistro *d);
void geraCaminho(TRegistro *d, int origem, int destino);

int main(){
	inicializa(&dados);
	busca(14,9,&dados); //Busca do melhor caminho entre Colatina e Vitória
}
//===================\ Procedimentos e Funções |=====================================

void inicializa(TRegistro *d){
	int l, c;
	
	strcpy(d->vertices[0],"COLATINA");
	strcpy(d->vertices[1],"JOAO NEIVA");
	strcpy(d->vertices[2],"SAO ROQUE");
	strcpy(d->vertices[3],"SANTA TERESA");
	strcpy(d->vertices[4],"IBIRACU");
	strcpy(d->vertices[5],"FUNDAO");
	strcpy(d->vertices[6],"MARILANDIA");
	strcpy(d->vertices[7],"VITORIA");
	strcpy(d->vertices[8],"BAIXO GUANDU");
	strcpy(d->vertices[9],"LINHARES");
	strcpy(d->vertices[10],"SERRA");
	// Novas cidades
	strcpy(d->vertices[11],"ARACRUZ");
	strcpy(d->vertices[12],"GUARAPARI");
	strcpy(d->vertices[13],"VILA VELHA");
	strcpy(d->vertices[14],"DOMINGOS MARTINS");
	strcpy(d->vertices[15],"CARIACICA");
	strcpy(d->vertices[16],"VIANA");
	//Definição da Matriz de Adjacências
	for(l=0; l < TAMANHO; l++){
		d->estimativas[l] = -1;
		d->precedentes[l] = -1;
		d->finalizado[l] = 0;
		
		for(c=0; c < TAMANHO; c++){
			d->caminhos[l][c] = 0;
		}//for
	}//for
	
	d->caminhos[0][1] = 58; //de Colatina a João Neiva: 58 km
	d->caminhos[0][2] = 30; //de Colatina a São Roque do Canaã: 30 km
	d->caminhos[0][6] = 25; //de Colatina a Marilândia: 25 km
	d->caminhos[0][8] = 47; //de Colatina a Baixo Guandu: 47 km
	
	d->caminhos[1][0] = 58; //de João Neiva a ...
	d->caminhos[1][4] = 9;
	d->caminhos[1][9] = 59;
	
	d->caminhos[2][0] = 30; //de São Roque de Canaã a ...
	d->caminhos[2][3] = 32;

	d->caminhos[3][2] = 32;//de Santa Teresa a ...
	d->caminhos[3][5] = 27;
	
	d->caminhos[4][1] = 9;//de Ibiraçu a ...
	d->caminhos[4][5] = 17;
	
	d->caminhos[5][3] = 27;//de Fundão a ...
	d->caminhos[5][4] = 17;
	d->caminhos[5][10] = 27;
	
	d->caminhos[6][0] = 25;//de Marilândia ... 
	d->caminhos[6][9] = 71;
	
	d->caminhos[7][10] = 24; //de Vitória a ...
	
	d->caminhos[8][0] = 47;
	
	d->caminhos[9][1] = 59; //de Linhares a ...
	d->caminhos[9][6] = 71;
	
	d->caminhos[10][7] = 24;//de Serra a ...
	d->caminhos[10][5] = 27;
		
	d->caminhos[7][13] = 7;//de Vitória a V V ...
	d->caminhos[13][7] = 7;
	
	d->caminhos[7][15] = 33;//de Vitória a Cariacica ...
	d->caminhos[15][7] = 33;
	
	d->caminhos[15][13] = 39;//de Cariacica a V V ...
	d->caminhos[13][15] = 39;
	
	d->caminhos[15][16] = 16;//de Cariacica a Viana ...
	d->caminhos[16][15] = 16;
	
	d->caminhos[16][14] = 35;//de Viana a Domingos Martins ...
	d->caminhos[14][16] = 35;
	
	d->caminhos[13][12] = 52;//de V V a Guarapari ...
	d->caminhos[12][13] = 52;
}

void busca(int origem, int destino, TRegistro *d){
	int ultimo = origem, col, menor, menorVert;
	
	printf("\n\n\n\tBUSCA do MELHOR CAMINHO\n");
	printf("\t=======================\n\n");
	printf("\tORIGEM: %s\n\n",d->vertices[origem]);
	printf("\tDESTINO: %s\n\n",d->vertices[destino]);

	d->precedentes[origem] = -1;
	d->estimativas[origem] = 0;
	d->finalizado[origem] = 1;
	
	while (ultimo != destino){
		printf("\n\tVisitando: %s (%d km)",d->vertices[ultimo], d->estimativas[ultimo]);
		
		for(col = 0; col < TAMANHO; col++){

		  if(d->finalizado[col] == 0){
			if(d->caminhos[ultimo][col] > 0){
				
    		 	if(origem == d->precedentes[col]){
    		 	   d->estimativas[col] = d->caminhos[ultimo][col];	
    		 	} else {
				   d->estimativas[col] = d->caminhos[ultimo][col] + d->estimativas[ultimo];	
				 }//if
    		 	d->precedentes[col] = ultimo;
			}//if
			
	      }//if
		}//for

        menorVert = encontreMenorEstimativa(d);
        
		ultimo = menorVert;
		d->finalizado[ultimo] = 1;
        
        exibe(d);
	}//while
	
	geraCaminho(d, origem, destino);
}

void exibe(TRegistro *d){
	int pos;
	
	printf("\n\n");
	printf("+==============| INICIO |=====================================================+\n");
	
	for(pos = 0; pos < TAMANHO; pos++){
		printf("INDICE: (%d) NOME: %s\t", pos, d->vertices[pos]);
		printf("ESTIMATIVA: %d\tPRECEDENTE: %d",d->estimativas[pos],d->precedentes[pos]);
		printf("\tFINALIZADO: %d\n",d->finalizado[pos]);
		printf("\n----------------------------------------------------------------------------\n");
	}//for
	
	printf("+==============| FIM |=====================================================+\n\n");
    system("PAUSE");
}

int encontreMenorEstimativa(TRegistro *d){
	int menorVert = -1, menor, col, flag = 0;
	
	
    for(col = 0; col < TAMANHO; col++){
	   if(d->finalizado[col] == 0){
				
		  if(d->estimativas[col] > -1){
		  	
		  	 if((flag == 0) || (d->estimativas[col] < menor)){
		  	 	menor = d->estimativas[col];
		  	 	menorVert = col;
		  	 	flag = 1;
		  	 } //if
		  }//if
	   }//if
	}//for
    return menorVert;
}

void geraCaminho(TRegistro *d, int origem, int destino){
	int atual;
	
	printf("\n\n\n\t\t>>> RESULTADO FINAL <<<\n\n");
	printf("\t\t   (CAMINHO ENCONTRADO)\n\n");
	
	atual = destino;
	do{
		printf("\t%s",d->vertices[atual]);
		if(atual == destino){
			printf("   (%d)\n", d->estimativas[atual]);
		} else {
			printf("\n");
		}
		atual = d->precedentes[atual];
	}while(atual > -1);
	
    printf("\n\n\n");
    system("PAUSE");    
}
