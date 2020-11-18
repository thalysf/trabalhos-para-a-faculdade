#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct tipoElemento {
	float altura;
	float peso;
	float sexo; //0 = homem e 1 = mulher
	char classe[40];
	tipoElemento *ante, *prox;
	int grupo;
	float distancia;
}TElemento;

typedef struct tipoGrupo {
	int grupo;
	TElemento *centroide;
	TElemento *inicio;
	tipoGrupo *ante, *prox;
}TGrupo;

typedef struct tipoLista {
	TGrupo *inicio;
	TGrupo *fim;
	int k;
}TLista;

TLista lista;

void inicializa(TLista *L);
void insereElemento(TLista **L, float alt, float pes, float sx);
void exibeElementosNaoAgrupados(TLista *L);
void exibeGrupos(TLista *L);
void agrupaInstancias(TLista *L);
void sobre();
void selecaoDeCentroides(TLista *L);
void avaliacao(TLista *L);

//=================================================================================

int main(){
   inicializa(&lista);
   exibeElementosNaoAgrupados(&lista);
   exibeGrupos(&lista);
   
   agrupaInstancias(&lista);
}

//=================================================================================
void inicializa(TLista *L){
	int k;
	TGrupo *novo = (TGrupo *)malloc(sizeof(TGrupo));
	
	printf("\n\n\t\t=====| CONFIGURACAO INICIAL |=====\n\n\tInforme Total de Classes (K): ");
	scanf("%d",&k);
	
	L->inicio = novo;
	L->fim = novo;
	L->k = k;
	
	novo->ante = NULL;
	novo->prox = NULL;
	novo->centroide = NULL;
	novo->grupo = 0;
	novo->inicio = NULL;
	
	TGrupo *atual = novo;
	
	int i = 0;
	for(i = 0; i < k; i++){
	   //Cria??o dos Grupos (Clusters):
	   novo = (TGrupo *)malloc(sizeof(TGrupo));
	   novo->grupo = atual->grupo + 1;
	   novo->ante = atual;
	   atual->prox = novo;
	   novo->prox = NULL;
	   L->fim = novo;
	   novo->centroide = NULL;
	   novo->inicio = NULL;
	   
	   atual = novo;
	}//for

    insereElemento(&L,1.77,98.0,0.0);
    insereElemento(&L,1.72,72.0,0.0);
    insereElemento(&L,1.85,96.0,0.0);
    insereElemento(&L,1.82,106.0,0.0);
    insereElemento(&L,1.70,59.5,1.0);
    insereElemento(&L,1.69,46.3, 1.0);
    insereElemento(&L,1.57,89.0, 1.0);
    insereElemento(&L,1.70,69.2, 0.0);
    insereElemento(&L,1.94,99.7, 0.0);
    insereElemento(&L,1.56,51.0, 1.0);
	insereElemento(&L,1.65,120.0, 0.0);	
}
//=================================================================================
void insereElemento(TLista **L, float alt, float pes, float sx){
	float imc;
	
	TElemento *novo = (TElemento *)malloc(sizeof(TElemento));
	
	novo->altura = alt;
	novo->peso = pes;
	novo->sexo = sx;
	novo->ante = NULL;
	novo->prox = NULL;
	
	novo->grupo = 0;
	novo->distancia = -1.0;
	
	imc = (pes / (alt * alt));
	
	if (imc < 18.5){
		strcpy(novo->classe,"MAGREZA");
	} else if((imc >= 18.5) &&(imc <= 24.9)){
		strcpy(novo->classe,"NORMAL");
	} else if((imc >= 25) && (imc <= 29.9)){
		strcpy(novo->classe,"SOBREPESO");
	} else if ((imc >= 30.0) && (imc <= 39.9)){
		strcpy(novo->classe,"OBESIDADE");
	} else {
		strcpy(novo->classe,"OBESIDADE GRAVE");
	}
	
	if((*L)->inicio->inicio == NULL){
		(*L)->inicio->inicio = novo;
	} else {
		TElemento *atual = (*L)->inicio->inicio;
		
		while(atual->prox != NULL){
			atual = atual->prox;
		}//while
		atual->prox = novo;
		novo->ante = atual;
	}//if
	
}
//=================================================================================
void exibeElementosNaoAgrupados(TLista *L){
	int cont = 1;
	TElemento *atual = L->inicio->inicio;
	printf("\n\n\n\t\t=====| ELEMENTOS NAO AGRUPADOS |=====\n\n");
	
	while(atual != NULL){
	 printf("\n(%d)\nALTURA: %.2f\tPESO: %.2f", cont, atual->altura, atual->peso);
	 printf("\tSEXO: %.0f\n",  atual->sexo);
	 printf("%s\n",atual->classe);
	 printf("+------------------------------------------------------------------+\n");
	 atual = atual->prox;
	 cont++;
	}//while
	printf("\n\n");
	system("PAUSE");
}
//=================================================================================
void exibeGrupos(TLista *L){
	TGrupo *atualG = L->inicio;
	char sx;
	int cont = 0;
	
	printf("\n\n\t\t=====| EXIBE GRUPOS |=====\n\n");
	
	while(atualG != NULL){
	   printf("GRUPO: (%d)\n\tCENTROIDE: ",atualG->grupo);
	   TElemento *atualE = atualG->centroide;
	   
	   if(atualE == NULL){
	   	  printf("***** NENHUM *****\n");
	   } else {
          if (atualE->sexo == 0){
          	  sx = 'M';
		  } else {
		  	  sx = 'F';
		  }//if ... else
	   	  printf("[%c] - %.2f m - %.2f kg - ", sx,atualE->altura,atualE->peso);
	   	  printf("%s\n", atualE->classe);
	   }//if ... else
	   
	   printf("\tINSTANCIAS:\n");
	   atualE = atualG->inicio;
	   if(atualE == NULL){
	   	   printf("\t\t***** NENHUMA INSTANCIA *****\n");
	   }//if
	   
	   while (atualE != NULL){
          if (atualE->sexo == 0){
          	  sx = 'M';
		  } else {
		  	  sx = 'F';
		  }//if ... else
	   	  printf("\t\t%d [%c] - %.2f m - %.2f kg", ++cont,sx,atualE->altura,atualE->peso);
	   	  printf(" - %s\n", atualE->classe);
		  atualE = atualE->prox;	 	   	
	   }//while
	   printf("+-------------------------------------------------------------+\n");
	   atualG = atualG->prox;
	}//while
	
	printf("\n\n");
	system("PAUSE");
}
//=================================================================================
void agrupaInstancias(TLista *L){
   sobre();	
   selecaoDeCentroides(L);
   
   avaliacao(L);
   
   //Temporario
   exibeElementosNaoAgrupados(L);
   exibeGrupos(L);
   //Fim-Temporario
   
}
//=================================================================================
void sobre(){
	printf("\n\n\t\t\t======| SOBRE |======\n\n");
	printf("Este programa executa o ALGORITMO K-MEANS com o intuito de AGRUPAR dados de\n");
	printf("PESSOAS (PESO, ALTURA e SEXO).\n\n");
	printf("O USUARIO deve escolher previamente a quantidade de GRUPOS(k) em que cada\n");
	printf("PESSOA podera ser encaixada.\n\n");
	printf("Para cada GRUPO existente sera escolhido aleatoriamente um CENTROIDE dentre\n");
	printf("as INSTANCIAS de PESSOAS disponibilizadas. Posteriormente tais CENTROIDES\n");
	printf("poderao ser reajustados (substituidos por outras INSTANCIAS).\n\n");
	printf("Em seguida, o PROGRAMA calculara a DISTANCIA EUCLIDIANA entre cada INSTANCIA\n");
	printf("e o CENTROIDE de cada GRUPO. A MENOR distancia VENCE. Ou seja, a INSTANCIA\n");
	printf("sera REALOCADA para o GRUPO cujo CENTROIDE tiver a MENOR DISTANCIA em relacao\n");
	printf("a ela.\n\n\n");
	system("PAUSE");
}
//===================================================================================
void selecaoDeCentroides(TLista *L){
	printf("\n\n\nEXECUTANDO SELECAO DE CENTROIDES ...\n");
	int i, r, pos, total = 0, grupo = 1;
	TElemento *atual = L->inicio->inicio;
	
	while(atual != NULL){
		total++;
		atual = atual->prox;
	}//while
	
	for(i=0; i <= L->k; i++){
       r = rand(); //A fun??o rand() est? na biblioteca stdlib.h		
       r = r % total;
       
	   atual = L->inicio->inicio;
	   pos = 0;
	   while (atual != NULL){
	       if(pos == r)    {
	       	  //Selecionado ELEMENTO para CENTROIDE
	       	  TElemento *anterior = atual->ante;
	       	  TElemento *posterior = atual->prox;
	       	  
	       	  if(anterior != NULL){
	       	    anterior->prox = posterior;	
			  } else {
			  	L->inicio->inicio = posterior;
			  }//if... else
			  
			  if(posterior != NULL){
			  	posterior->ante = anterior;
			  } //if
			  
			  atual->ante = NULL;
			  atual->prox = NULL;
	       	  
	       	  //atual foi desconectado da LISTA ORIGINAL
	       	  TGrupo *atualGrupo = L->inicio;
			  while (atualGrupo != NULL){
			  	//buscando GRUPO para encaixar atual como CENTROIDE
			  	if(atualGrupo->grupo == grupo){
			  	   //Encontrou o Grupo
				   atualGrupo->centroide = atual;	
				}//if
				atualGrupo = atualGrupo->prox;
			  }//while
	       	  
	       	  grupo++;
	       	  break;
		   }//if
		   atual = atual->prox;
		   pos++;
       }//while
		
	}//for
}
//===================================================================================
void avaliacao(TLista *L){
	TElemento *atual = L->inicio->inicio;
	TElemento *centroide;
	TGrupo *g;
	float dis, grupo;
	
	while(atual != NULL){
	   g = L->inicio->prox;
	   while(g != NULL)	{
	   	 centroide = g->centroide;
	   	 dis = pow((atual->altura - centroide->altura), 2);
	   	 dis = dis + pow((atual->peso - centroide->peso), 2);
	   	 dis = dis + pow((atual->sexo - centroide->sexo), 2);
	   	 dis = sqrt(dis);
	   	 
	   	 if(atual->distancia == -1){
	   	 	atual->distancia = dis;
	   	 	atual->grupo = g->grupo;
		 } else if(atual->distancia > dis){
		 	atual->distancia = dis;
		 	atual->grupo = g->grupo;
		 }//if...else
		 
		 g = g->prox;
	   }//while
	   atual = atual->prox;
	}//while
	
	//==redistribuindo instancias para grupos
	TElemento *posterior, *removido, *corrente;
	
	atual = L->inicio->inicio;
	while(atual != NULL){
	   posterior = atual->prox;
	   removido = atual;
	   
	   removido->ante = NULL;
	   removido->prox = NULL;
	      
	   if(posterior != NULL){
	   	  posterior->ante = NULL;
	   }//if
	   L->inicio->inicio = posterior;
	   
	   //==Inserindo REMOVIDO no GRUPO a que pertence
	   g = L->inicio->prox;
	   while(g != NULL){
	   	  if(g->grupo == removido->grupo){
	   	      corrente = g->inicio;
			  if(corrente == NULL){
			  	 g->inicio = removido;
			  } else {
			     while(corrente->prox != NULL){
			     	corrente = corrente->prox;
				 }//while
				 corrente->prox = removido;
				 removido->ante = corrente;
			  }//if
		  }//if
		  g= g->prox;
	   }//while
	   
	   //==Movendo para a pr?xima inst?ncia.
	   
       atual = posterior;
	}//while
}
//===================================================================================

