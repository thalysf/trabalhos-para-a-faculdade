#include <stdio.h>
#include <string.h>
typedef struct tipoElemento{
	int idade;
	int id;
	char nome[50];
	struct tipoElemento *prox;
	struct tipoElemento *ant;
}TElemento;

typedef struct tipoLista{
	TElemento *inicio;
	TElemento *fim;
	int total;
}TLista;

void inicializa(TLista *lista);
void inserir(TLista *lista, int idade, int id, char *nome);
void exibir(TLista *lista);
void menu(TLista *lista);
int remover(TLista *lista, int id);
int busca(TLista *lista, int id);
