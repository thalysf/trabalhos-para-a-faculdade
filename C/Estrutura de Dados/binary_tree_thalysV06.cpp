/*
 * Árvore Binária de Busca
 * 21/07/2020
 * Thalys Fabrete Cândido V06
 * Sistemas de informação 
 * (Estrutura de Dados)
*/
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
typedef struct tipoNo {
	int valor;
    tipoNo *pai;
	tipoNo *esq, *dir;
}TNo;

TNo *raiz;

TNo *inicializaArvore();
TNo *criaNo(int valor, TNo *pai);
TNo *insere(TNo **nodo, int valorNovo, TNo *noPai);
TNo *remove(TNo *nodo, int valorNovo);
void caminhamento_em_ordem(TNo *nodo);
void caminhamento_pre_ordem(TNo *nodo);
void caminhamento_pos_ordem(TNo *nodo);
void buscaValor(TNo *nodo, int procurado);
void busca(TNo *nodo, int procurado);
void creditos();
void buscaMaior(TNo *nodo);
int totalFolhas(TNo *nodo);
int noCom1Filho(TNo *nodo);
int main(){
	// O algoritmo pode ser utilizado com qualquer organização de árvore (diferentes ordens e valores inseridos).
	system("COLOR F");
	setlocale(LC_ALL, "Portuguese");
	raiz = inicializaArvore();
	int totalDeFolhas = 0;
	int qtdNosCom1Filho = 0;
	/*
	Árvore original 
    insere(&raiz, 9, raiz);
    insere(&raiz, 3, raiz);
    insere(&raiz, 1, raiz);
    insere(&raiz, 7, raiz);
	insere(&raiz, 35, raiz);
    insere(&raiz, 23, raiz);
    insere(&raiz, 2, raiz);
    insere(&raiz, 68, raiz);
    insere(&raiz, 81, raiz);
    insere(&raiz, 69, raiz);
    insere(&raiz, 92, raiz);
    insere(&raiz, 95, raiz);
    insere(&raiz, 97, raiz);
    insere(&raiz, 98, raiz);
    insere(&raiz, 99, raiz);
    insere(&raiz, 91, raiz);
    insere(&raiz, 5, raiz);
    */
    insere(&raiz, 30, raiz);
    insere(&raiz, 25, raiz);
    insere(&raiz, 50, raiz);
    insere(&raiz, 41, raiz);
	insere(&raiz, 58, raiz);
	insere(&raiz, 16, raiz);
	insere(&raiz, 15, raiz);
	insere(&raiz, 17, raiz);
	insere(&raiz, 18, raiz);
	insere(&raiz, 39, raiz);
	insere(&raiz, 59, raiz);
	insere(&raiz, 60, raiz);
	insere(&raiz, 55, raiz);
	insere(&raiz, 54, raiz);
	insere(&raiz, 56, raiz);
    /*
    printf("\n\n=====| EM ORDEM |=================================\n");
    caminhamento_em_ordem(raiz);
    printf("\n\n=====| POS ORDEM |================================\n");
    caminhamento_pos_ordem(raiz);
    printf("\n\n=====| PRE ORDEM |=================================\n");
    caminhamento_pre_ordem(raiz);
    
    buscaValor(raiz, 96);
    
    remove(raiz, 95);
    caminhamento_em_ordem(raiz);
    */
    creditos();
    printf("\n\t\t\t\t|---------------------------------|\n");
	printf("\t\t\t\t\t     Folhas: \n\n");
    totalDeFolhas = totalFolhas(raiz);
    printf("\n\t\t\t\t|---------------------------------|\n");
    qtdNosCom1Filho = noCom1Filho(raiz);
    buscaMaior(raiz);
    printf("\n\t\t\t\t \\|/ \\|/ \\|/ \\|/ \\|/ \\|/ \\|/ \\|/\n");
    printf("\t\t\t\t \\|/   Total de Folhas: %d    \\|/\n", totalDeFolhas);
    printf("\t\t\t\t \\|/ \\|/ \\|/ \\|/ \\|/ \\|/ \\|/ \\|/\n");
    printf("\n\t\t\t\t|---------------------------------|\n");
    printf("\t\t\t\t    Total de nós com apenas\n\t\t\t\t\t UM filho: %d", qtdNosCom1Filho);
    printf("\n\t\t\t\t|---------------------------------|\n\n");
    printf("\t\t\t    ");system("PAUSE");
}
//============================================================
TNo *inicializaArvore(){
	return NULL;
}
//============================================================
TNo *criaNo(int valor, TNo *pai){
	TNo *novo = (TNo *)malloc(sizeof(TNo));
	novo->valor= valor;
	novo->esq = NULL;
	novo->dir = NULL;
	novo->pai = pai;
	return novo;
}
//============================================================
TNo *insere(TNo **nodo, int valorNovo, TNo *noPai){
	// Salvo a raiz atual para que ela possa ser o pai do próximo nó
	TNo *ant = noPai;
	noPai = (*nodo);
	
	if((*nodo) == NULL){
		(*nodo) = criaNo(valorNovo, ant);
	} else if(valorNovo < (*nodo)->valor){
		(*nodo)->esq = insere(&(*nodo)->esq,valorNovo, noPai);
	} else {
	    (*nodo)->dir = insere(&(*nodo)->dir, valorNovo, noPai);
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
void buscaMaior(TNo *nodo){
	TNo *noAtual = nodo;
	printf("\n\t\t\t\t>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	if(nodo == NULL)
	{
		printf("\n\n\t\t\t\t<<ÁRVORE VAZIA>>\n\n\n");
	}
	else if(nodo->esq == NULL && nodo->dir == NULL) // Se existe apenas um nó na árvore, logo ele é o maior.
	{
		printf("\n\n\t\t\t\tMAIOR VALOR CONTIDO NA ÁRVORE: %d\n\n\n", nodo->valor);
	}
	else if(nodo->dir != NULL){ // Aqui partimos do princípio que o nó maior sempre será o nó mais à direita da árvore.
		while(noAtual->dir != NULL){
			noAtual = noAtual->dir;
		}
	}
	printf("\n\n\t\t\t\tMAIOR VALOR CONTIDO NA ÁRVORE: %d\n\n", noAtual->valor);
	printf("\t\t\t\t<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
}
//===============================================================
int totalFolhas(TNo *nodo)
{
	// Percorre a árvore em pré-ordem e incrementa o retorno a cada folha encontrada.
	
	if(nodo != NULL)
	{
		if(nodo->esq == NULL && nodo->dir == NULL)
		{
			
			printf("\t\t\t\t\t    \\|/ %d \\|/\n", nodo->valor);
			return (1 + totalFolhas(nodo->esq) + totalFolhas(nodo->dir));
		}
		else
		{
			return (totalFolhas(nodo->esq) + totalFolhas(nodo->dir));
		}
	}
	else{
		return 0;
	}
}
//===============================================================
int noCom1Filho(TNo *nodo)
{
	// Percorre a árvore em pré-ordem e incrementa o retorno a cada nó com apenas 1 filho encontrado.
	if(nodo != NULL)
	{
		if((nodo->esq != NULL && nodo->dir == NULL) || (nodo->esq == NULL && nodo->dir != NULL))
		{
			printf("\n\n\t\t\t\t---------------------------------");
			printf("\n\t\t\t\t Pai: %d", nodo->valor);
			if(nodo->esq != NULL) printf(" |filho na esquerda: %d", nodo->esq->valor);
			if(nodo->dir != NULL ) printf(" |filho na direita: %d", nodo->dir->valor);
			printf("\n\t\t\t\t---------------------------------\n");
			return (1 + noCom1Filho(nodo->esq) + noCom1Filho(nodo->dir));
		}
		else
		{
			return (noCom1Filho(nodo->esq) + noCom1Filho(nodo->dir));
		}
	}
	else{
		return 0;
	}
}
//===============================================================
void creditos()
{
	printf("\n\t\t\t  Desenvolvido por: Vanderson José Idelfonso Silva\n");
	printf("\t\t\t\tAdaptado por: Thalys Fabrete Cândido\n");
	printf("\n\t         <------------------------ Árvore Binária ------------------------>\n");
}
//===============================================================
