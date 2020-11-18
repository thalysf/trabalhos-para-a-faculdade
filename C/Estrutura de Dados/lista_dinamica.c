#include<stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>



// Structs :
typedef struct elemento{
	
	char palavra[50];
	int prioridade;
	struct elemento * prox;	
}Elemento;


typedef struct fila{
	
	int *inic;	
	int *fim;	
	int qtd;	
}Fila;
Fila p; // 
////////////////////////////////////////////////////////
void inicializarFila(Fila * p){
	/*Cria uma fila vazia. Deve ser usado antes de qualquer
	outra operação*/
	p->inic = NULL;
	p->fim = NULL;
}
int filaVazia(Fila * p)
{
	printf("p: %d", p->inic);
	if (p->inic == NULL)
	{
		return 0;
	} 
	else
	{
		return 1;
	 } 
}
void inserir(int prio, char * nome, Fila * p)
{
	Elemento * novoElemento;
	novoElemento = (Elemento *) malloc( sizeof(Elemento));
	
	novoElemento->prox = NULL;

	if(novoElemento == NULL)
	{
		printf("Memória insuficiente!\n");
		exit(1);
	}
	if(filaVazia(&p) == 0)
	{
		strcpy(novoElemento->palavra, nome);
		novoElemento -> prioridade = prio;
	}

	
	printf("Nome: %s\n Prio: %d\n", novoElemento->palavra, novoElemento->prioridade);
	free(novoElemento);
}


int main()
{
	setlocale(LC_ALL, "Portuguese");
	int op, prio;
	char nome[50];
	setbuf(stdin, NULL); // Limpeza de buffer teclado
	inicializarFila(&p);
	printf("Digite uma opção: ");
	scanf("%d", &op);
	switch (op)
	{
		case 1:
		{
			printf("Digite a prioridade: ");
			scanf("%d", &prio);
			printf("Digite o nome: ");
			scanf("%s", &nome);
			setbuf(stdin, NULL);
			inserir(prio, nome, &p);	
			break;
		}
	}
	return 0;
}
