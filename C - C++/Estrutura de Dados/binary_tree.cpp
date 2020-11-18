/*
 * Árvore Binária de Busca
 * 03/04/2020
 * (Estrutura de Dados)
*/
#include <stdio.h>
#include <stdlib.h>

typedef struct tipoNo {
	int valor;
    tipoNo *pai;
	tipoNo *esq, *dir;
}TNo;

TNo *raiz;

TNo *inicializaArvore();
TNo *criaNo(int valor);
TNo *insere(TNo **nodo, int valorNovo);
TNo *remove(TNo *nodo, int valorNovo);
void caminhamento_em_ordem(TNo *nodo);
void caminhamento_pre_ordem(TNo *nodo);
void caminhamento_pos_ordem(TNo *nodo);
void buscaValor(TNo *nodo, int procurado);
void busca(TNo *nodo, int procurado);


int main(){
	raiz = inicializaArvore();

    insere(&raiz, 9);
    insere(&raiz, 3);
    insere(&raiz, 1);
    insere(&raiz, 7);
    insere(&raiz, 35);
    insere(&raiz, 23);
    insere(&raiz, 2);
    insere(&raiz, 68);
    insere(&raiz, 81);
    insere(&raiz, 69);
    insere(&raiz, 92);
    insere(&raiz, 95);
    insere(&raiz, 97);
    insere(&raiz, 98);
    insere(&raiz, 99);
    insere(&raiz, 91);
    insere(&raiz, 5);
    
    printf("\n\n=====| EM ORDEM |=================================\n");
    caminhamento_em_ordem(raiz);
    printf("\n\n=====| POS ORDEM |================================\n");
    caminhamento_pos_ordem(raiz);
    printf("\n\n=====| PRE ORDEM |=================================\n");
    caminhamento_pre_ordem(raiz);
    
    buscaValor(raiz, 96);
    
    remove(raiz,95);
    caminhamento_em_ordem(raiz);
    
    system("PAUSE");
}
//============================================================
TNo *inicializaArvore(){
	return NULL;
}
//============================================================
TNo *criaNo(int valor){
	TNo *novo = (TNo *)malloc(sizeof(TNo));
	novo->valor= valor;
	novo->esq = NULL;
	novo->dir = NULL;
	return novo;
}
//============================================================
TNo *insere(TNo **nodo, int valorNovo){
	if((*nodo) == NULL){
		(*nodo) = criaNo(valorNovo);
	} else if(valorNovo < (*nodo)->valor){
		(*nodo)->esq = insere(&(*nodo)->esq,valorNovo);
	} else {
	    (*nodo)->dir = insere(&(*nodo)->dir, valorNovo);
	}//if
	return (*nodo);	
}
//============================================================
TNo *remove(TNo *nodo, int valorNovo){
	if(nodo == NULL){
		//interrompe
		return NULL;
	} else if (nodo->valor > valorNovo){
		//desce pela esquerda
		nodo->esq = remove(nodo->esq, valorNovo);
	} else if (nodo->valor < valorNovo){
		//desce pela direita
		nodo->dir = remove(nodo->dir, valorNovo);
	} else {
		//Encontrou N? a ser removido...
		if(nodo->dir == NULL && nodo->esq == NULL){
			//N? a ser removido N?O tem FILHOS.
			free(nodo);
			nodo = NULL;
		} else if(nodo->esq == NULL){
			//N? a ser removido tem apenas FILHO ? DIREITA.
			TNo *temporario = nodo;
			nodo = nodo->dir;
			free(temporario);
		} else if(nodo->dir == NULL){
			//N? a ser removido tem apenas FILHO ? ESQUERDA.
			TNo *temporario = nodo;
			nodo = nodo->esq;
			free(temporario);
		} else {
			//N? tem dois FILHOS.
			TNo *prov = nodo->esq;
			while (prov->dir != NULL){
				prov = prov->dir;
			}//while
			//Trocando os dados entre os nodos ...
			nodo->valor = prov->valor;
			prov->valor = valorNovo;
			
			nodo->esq = remove(nodo->esq, valorNovo);
		}
	}
	return nodo;
}
//============================================================
void caminhamento_em_ordem(TNo *nodo){
	if (nodo != NULL){
	   caminhamento_em_ordem(nodo->esq);
	   printf("\n\t(%d).", nodo->valor);
	   caminhamento_em_ordem(nodo->dir);
	}//if
}
//============================================================
void caminhamento_pre_ordem(TNo *nodo){
	if (nodo != NULL){
		printf("\n\t(%d).", nodo->valor);
		caminhamento_pre_ordem(nodo->esq);
		caminhamento_pre_ordem(nodo->dir);
	}//if
}
//==============================================================
void caminhamento_pos_ordem(TNo *nodo){
	if (nodo != NULL){
		caminhamento_pos_ordem(nodo->esq);
		caminhamento_pos_ordem(nodo->dir);
		printf("\n\t(%d).", nodo->valor);
	}//if
}
//===============================================================
void buscaValor(TNo *nodo, int procurado){
	if(nodo == NULL){
	    printf("\n\n\t?rvore VAZIA ... Imposs?vel iniciar busca de %d.\n\n", procurado)	;
	} else {
    	printf("\n\n\tIniciando BUSCA pelo valor %d",procurado);
	    printf("\n\n\tVisitando a RAIZ (%d).\n",nodo->valor);
	    busca(nodo, procurado);		
	}
	system("PAUSE");
}
//===============================================================
void busca(TNo *nodo, int procurado){
        	
    if (nodo == NULL){
    	printf("\n<<VALOR INEXISTENTE NA ARVORE>>\n\n\n");
	} else if(nodo->valor == procurado){
    	      printf("\n<<ENCONTRADO>>\n\n\n");
	} else if (nodo->valor > procurado){
		      printf("\nPROCURADO:  %d\tVISITADO: %d",procurado, nodo->valor);
		      printf("\n\n... Descendo pela Sub-Arvore ESQUERDA.");
		      busca(nodo->esq, procurado);
	} else {
		printf("\nPROCURADO:  %d\tVISITADO: %d",procurado, nodo->valor);
		printf("\n\n... Descendo pela Sub-Arvore DIREITA.");
		busca(nodo->dir, procurado);
	}
}
//===============================================================
