/*
 * Árvore AVL
 * 04/08/2020
 * Thalys Fabrete Cândido V06
 * Sistemas de informação 
 * (Estrutura de Dados)
*/

#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

typedef struct tipoNo {
	int valor;
	int alt; // -> altura da sub-árvore
	tipoNo *esq, *dir;
}TNo;
TNo *raiz;

TNo *insereAVL(TNo **raiz, int novoValor);
TNo *inicializaArvore();
TNo *criaNo(int valor);
void rotacaoLL(TNo *raiz);
void rotacaoRR(TNo *raiz);
void rotacaoLR(TNo *raiz);
void rotacaoRL(TNo *raiz);
void busca(TNo *raiz, int valorBuscado);
int fatorDeBalanceamento_Nodo(TNo *nodo);
int alturaDoNo(TNo *nodo);
int maiorValor(int x, int y);
int menu();
int menuOP(int op);
int main(void)
{
	int op = 0;
	int valor = 0;
	system("COLOR F");
	setlocale(LC_ALL, "Portuguese");
	raiz = inicializaArvore();
	
	
	do
	{
		op = menu();
		switch(op)
		{
			case 0:
				system("CLS");
				printf("\n\t\t\t\t|Programa encerrado\n\t\t\t\t "); system("PAUSE");
				break;
			case 1:
				printf("\n\t\t\t\t|Digite o valor a ser inserido: ");
				scanf("%d", &valor);
				insereAVL(&raiz, valor);
				system("CLS");
				break;
			case 2:
				printf("\n\t\t\t\t|Digite o valor a ser buscado: ");
				scanf("%d", &valor);
				busca(raiz, valor);
				printf("\n\t\t\t\t"); system("PAUSE");system("CLS");
				break;
		}
	}while(op != 0);
	return 0;
}
//=========== Funções Auxiliares =============

int fatorDeBalanceamento_Nodo(TNo *nodo) // calcula fator de balancemento de um nó
{
	return labs(alturaDoNo(nodo->esq) - alturaDoNo(nodo->dir));
}
//===========================================
int alturaDoNo(TNo *nodo) // retorna altura do nó (caso ele exista, se não existe retorna -1)
{
	if(nodo == NULL) return -1;
	else return nodo->alt;
}
//===========================================
int maiorValor(int x, int y) // calcula maior valor
{
	if(x > y) return x;
	else return y;
}

//============= Rotações ====================

void rotacaoLL(TNo **raiz)
{
	TNo *auxNodo;
	auxNodo = (*raiz)->esq;
	(*raiz)->esq = auxNodo->dir;
	auxNodo->dir = (*raiz);
	
	// Recálculo das novas alturas
	(*raiz)->alt = maiorValor(alturaDoNo((*raiz)->esq), alturaDoNo((*raiz)->dir)) + 1;
	auxNodo->alt = maiorValor(alturaDoNo(auxNodo->esq), (*raiz)->alt) + 1;
	
	(*raiz) = auxNodo;
}

//===========================================
void rotacaoRR(TNo **raiz)
{
	TNo *auxNodo;
	auxNodo = (*raiz)->dir;
	(*raiz)->dir = auxNodo->esq;
	auxNodo->esq = (*raiz);
	
	// Recálculo das novas alturas
	(*raiz)->alt = maiorValor(alturaDoNo((*raiz)->esq), alturaDoNo((*raiz)->dir)) + 1;
	auxNodo->alt = maiorValor(alturaDoNo(auxNodo->dir), (*raiz)->alt) + 1;
	
	(*raiz) = auxNodo;
}
//===========================================
void rotacaoLR(TNo **raiz)
{
	rotacaoRR(&(*raiz)->esq);
	rotacaoLL(&(*raiz));
}
//===========================================
void rotacaoRL(TNo **raiz)
{
	rotacaoLL(&(*raiz)->dir);
	rotacaoRR(&(*raiz));
}

//============= Inserção ====================
TNo *inicializaArvore()
{
	return NULL;
}
//===========================================
TNo *criaNo(int valor)
{
	TNo *novo = (TNo *)malloc(sizeof(TNo));
	novo->valor= valor;
	novo->alt = 0;
	novo->esq = NULL;
	novo->dir = NULL;

	return novo;
}
//===========================================
TNo *insereAVL(TNo **raiz, int novoValor)
{
	if((*raiz) == NULL)
	{
		(*raiz) = criaNo(novoValor);
	} 

	TNo *atual =  (*raiz);
	if(novoValor < atual->valor)
	{
		insereAVL(&(*raiz)->esq, novoValor);
		if(fatorDeBalanceamento_Nodo(atual) >= 2)
		{
			if(novoValor < (*raiz)->esq->valor)
			{
				rotacaoLL(&(*raiz));
			}
			else
			{
				rotacaoLR(&(*raiz));
			}
		}	
	}
	else if(novoValor > atual->valor)
	{
		insereAVL(&(*raiz)->dir, novoValor);
		if(fatorDeBalanceamento_Nodo(atual) >= 2)
		{
			if((*raiz)->dir->valor < novoValor)
			{
				rotacaoRR(&(*raiz));
			}
			else
			{
				rotacaoRL(&(*raiz));
			}
		}
	}
	else{
		return 0;
	}
	atual->alt = maiorValor(alturaDoNo(atual->esq), alturaDoNo(atual->dir)) + 1;
}
//===========================================
void busca(TNo *raiz, int valorBuscado)
{
	system("CLS");
	if(raiz == NULL)
	{
		printf("\t\t\t\t|Árvore vazia!\n");
		return;
	}
	else
	{
		if(valorBuscado == raiz->valor)
		{
			system("COLOR 2");
			printf("\n\t\t\t\t|Valor encontrado na raiz: %d\n", raiz->valor);
			return;
		}
		else
		{
			printf("\t\t\t\t|Saindo da raiz[%d] ...\n", raiz->valor);
			TNo *atual = raiz;
			while(atual != NULL)
			{
				if(valorBuscado < atual->valor)
				{
					if(atual->esq == NULL) break;
					printf("\t\t\t\t|Descendo pela sub-árvore da esquerda[%d] ...\n", atual->esq->valor);
					if(valorBuscado == atual->esq->valor)
					{
						system("COLOR 2");
						printf("\n\t\t\t\t|Valor encontrado: %d", atual->esq->valor);
						return;
					}
					
					else atual = atual->esq;
				
				}
				else
				{	
					if(atual->dir == NULL) break;
					printf("\t\t\t\t|Descendo pela sub-árvore da direita[%d] ...\n", atual->dir->valor);
					if(valorBuscado == atual->dir->valor)
					{
						system("COLOR 2");
						printf("\n\t\t\t\t|Valor encontrado: %d", atual->dir->valor);
						return;
					}
					else atual = atual->dir;
				}
			}
		}
	}
	system("COLOR 4");
	printf("\t\t\t\t|VALOR %d NÃO ESTÁ NA ÁRVORE!\n", valorBuscado);
}
//============= Menu ====================
int menu()
{
	system("COLOR F");
	int op, autoriza = 0;
	do{
		printf("\t\t\t\t|--------- Àrvore AVL ---------|\n");
		printf("\t\t\t\t|Opções:\n");
		printf("\t\t\t\t|Inserir [1]\n");
		printf("\t\t\t\t|Buscar [2]\n");
		printf("\t\t\t\t|Sair [0]\n");
		printf("\t\t\t\t|Digite sua Opção: ");
		scanf("%d", &op);
		autoriza = menuOP(op);
	}while(!autoriza);
	
	return op;
}
//===========================================
int menuOP(int op)
{
	if(op < 0 || op > 2) {
		system("CLS"); system("COLOR 4");
		printf("\n\t\t\t\t|Opção Inválida, por favor digite um opção válida!\n\t\t\t\t ");
		system("PAUSE");
		system("CLS"); system("COLOR F");
		return 0;
	}
	return 1;
}
//===========================================
