/*
 * Árvore Binária de Busca
 * 03/04/2020
 * (Estrutura de Dados)
*/
#include <stdio.h>
#include <locale.h>
#include <stdlib.h>

typedef struct tipoNo {
	int key[2];
	tipoNo *esq, *dir, *meio;
}TNo;
TNo *inicializaArvore();
TNo *insere(TNo **nodo, int newKey);
TNo *newPage(int newKey);
TNo *raiz;
void insereKey(TNo *nodo, int newKey);
void limpaChave(TNo *nodo);
int main(){
	raiz = inicializaArvore();

    insere(&raiz, 20);
    insere(&raiz, 10);
    insere(&raiz, 9);
    //insere(&raiz, 12);
    printf("Nodo->key[0]: %d\n", raiz->key[0]);
   	printf("Nodo->key[1]: %d\n", raiz->key[1]);
   	printf("Nodo->esq->key[0]: %d\n", raiz->esq->key[0]);
   	printf("Nodo->meio->key[0]: %d\n", raiz->meio->key[0]);
    system("PAUSE");
}
//============================================================
TNo *inicializaArvore()
{
	return NULL;
}
//============================================================
TNo *newPage(int newKey)
{
	TNo *novo = (TNo *)malloc(sizeof(TNo));
	novo->esq = NULL;
	novo->dir = NULL;
	novo->meio = NULL;
	return novo;
}
//============================================================
void insereKey(TNo *nodo, int newKey)
{
	int i = 0;
	int maior = 0;
	limpaChave(nodo);

	for(i; i < 2; i++)
	{
		if(newKey < nodo->key[i])
		{
			maior =  nodo->key[i];
			nodo->key[i] = newKey;
			nodo->key[i+1] = maior;
			break;
		}
		else if(nodo->key[i] == 0){
			nodo->key[i] = newKey;
			break;
		}
	}
}
//============================================================
TNo *insere(TNo **nodo, int newKey)
{
	int copy;
	if((*nodo) == NULL){
		(*nodo) = newPage(newKey);
	}
	if((*nodo)->key[0] == 0 ||(*nodo)->key[1] == 0)
	{
		insereKey((*nodo), newKey);
	}
	
	else if((*nodo)->key[0] != 0 && (*nodo)->key[1] != 0)
	{
		limpaChave((*nodo));
		if(newKey < (*nodo)->key[0])
		{
			copy = (*nodo)->key[1];
			(*nodo)->key[1] = 0;
			(*nodo)->meio = insere(&(*nodo)->meio, copy);
			(*nodo)->esq = insere(&(*nodo)->esq, newKey);
		}
		else if(newKey < (*nodo)->key[1])
		{
			(*nodo)->meio = insere(&(*nodo)->meio , newKey);
		}
		else
		{
			(*nodo)->dir = insere(&(*nodo)->dir , newKey);
		}
	}
	return (*nodo);
	
}
//============================================================
void limpaChave(TNo *nodo)
{
	if(nodo->key[0] > 100) nodo->key[0] = 0;
	if(nodo->key[1] > 100) nodo->key[1] = 0;
}
