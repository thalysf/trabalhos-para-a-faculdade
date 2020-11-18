#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

// Aluno: Thalys Fabrete Cândido, V06, Estrutura de Dados.

typedef int tipoChave;

typedef struct tipoRegistro {
	tipoChave chave;
	tipoRegistro *ante, *prox;
}TRegistro;

typedef struct tipoDeque {
	TRegistro *cabeca;
}TDeque;

TDeque deque;

void inicializa(TDeque *d);
int tamanho(TDeque *d);
void exibeDequeFim(TDeque *d);
void insereDequeFim(TDeque *d, int valor);
void insereDequeInicio(TDeque *d, int valor);
void excluiDequeInicio(TDeque *d);
void excluiDequeFim(TDeque *d);
void exibeDequeInicio(TDeque *d);

int main(){
	setlocale(LC_ALL, "Portuguese");
	inicializa(&deque);
	insereDequeFim(&deque, 35);
	insereDequeFim(&deque, 67);
	insereDequeInicio(&deque,73);
	insereDequeInicio(&deque,76);
	exibeDequeFim(&deque);
	
	excluiDequeFim(&deque);
	
	exibeDequeFim(&deque);
    exibeDequeInicio(&deque);
    printf("\n\n...Excluindo no INICIO do DEQUE\n\n");
	excluiDequeInicio(&deque);
	printf("\n\n...Total de Registros: %d\n\n",tamanho(&deque));
	system("PAUSE");
	return 0;
}
//============================================================================
void inicializa(TDeque *d){
	d->cabeca = (TRegistro *)malloc(sizeof(TRegistro));
	d->cabeca->ante = d->cabeca;
	d->cabeca->prox = d->cabeca;
}
//============================================================================
int tamanho(TDeque *d){
	TRegistro *atual = d->cabeca->prox;
	int tam = 0;
	while(atual != d->cabeca){
	   tam++;
	   atual = atual->prox;	
	}//while
	return tam;
}
//=============================================================================
void exibeDequeFim(TDeque *d){
    TRegistro *atual = d->cabeca->ante;
    printf("\n\n\t\t=====| IMPRESSAO do DEQUE a partir do FIM |=====\n\n");
	while(atual != d->cabeca){
		printf("\t%d\n", atual->chave);
		atual = atual->ante;
	}//while
	printf("\n\n");
	system("PAUSE");
}
//=============================================================================
void insereDequeFim(TDeque *d, int valor){
	TRegistro *novo = (TRegistro *)malloc(sizeof(TRegistro));
	novo->chave = valor;
	novo->prox = d->cabeca;
	novo->ante = d->cabeca->ante;
	d->cabeca->ante = novo;
	novo->ante->prox = novo;
}
//==============================================================================
void insereDequeInicio(TDeque *d, int valor){
	TRegistro *novo = (TRegistro *)malloc(sizeof(TRegistro));
	novo->chave = valor;
	novo->ante = d->cabeca;
	novo->prox = d->cabeca->prox;
	d->cabeca->prox = novo;
	novo->prox->ante = novo;
}
//==============================================================================
void excluiDequeInicio(TDeque *d){
    if(d->cabeca->prox != d->cabeca){
       	TRegistro *atual = d->cabeca->prox;
       	d->cabeca->prox = atual->prox;
       	atual->prox->ante = d->cabeca;
       	free(atual);
	}//if
}
//==============================================================================
void excluiDequeFim(TDeque *d){
	if(d->cabeca->ante != d->cabeca){
       	TRegistro *atual = d->cabeca->ante;
       	d->cabeca->ante = atual->ante;
       	atual->ante->prox = d->cabeca;
       	free(atual);
	}//if
}
//==============================================================================
void exibeDequeInicio(TDeque *d){
	TRegistro *atual = d->cabeca->prox;
    printf("\n\n\t\t=====| IMPRESSAO do DEQUE a partir do INÍCIO |=====\n\n");
	while(atual != d->cabeca){
		printf("\t%d\n", atual->chave);
		atual = atual->prox;
	}//while
	printf("\n\n");
	system("PAUSE");
}
//==============================================================================
