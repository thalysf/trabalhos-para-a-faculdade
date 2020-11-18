#include <stdio.h>
#include <locale.h>
#include <stdlib.h>

typedef struct tipoNo {
	int key[2];
	tipoNo *pai;
	tipoNo *esq, *dir, *meio;
}TNo;
TNo *inicializaArvore();
TNo *insere(TNo **nodo, int newKey, TNo *noPai);
TNo *newPage(TNo *pai);
TNo *raiz;
TNo *localKey(TNo *atual, int newKey);
void insereKey(TNo *nodo, int newKey);
void limpaChave(TNo *nodo);
void alteraRaiz(TNo *nodo, int newKey, int pos);
int verificaOcupacaoDeChaves(TNo *nodo);
int notChildren(TNo *nodo);
void split(TNo **nodo, int intermediario, int maior);

int main(){
	setlocale(LC_ALL, "Portuguese");
	raiz = inicializaArvore();
	
    insere(&raiz, 9, raiz);
    insere(&raiz, 11, raiz);
    insere(&raiz, 18, raiz);
	insere(&raiz, 16, raiz);	
	insere(&raiz, 17, raiz);
	insere(&raiz, 10, raiz);
	insere(&raiz, 15, raiz);
	
	insere(&raiz, 20, raiz);
	insere(&raiz, 28, raiz);
    printf("\nraiz->key[0]: %d\n", raiz->key[0]);
   	printf("raiz->key[1]: %d\n", raiz->key[1]);
	printf("\n-----------------------------------------------------\n");
   	printf("Nodo->esq->key[0]: %d\n", raiz->esq->key[0]);
   	printf("Nodo->esq->key[1]: %d\n", raiz->esq->key[1]);
   	printf("\n-----------------------------------------------------\n");
   	printf("Nodo->meio->key[0]: %d\n", raiz->meio->key[0]);
   	printf("Nodo->meio->key[1]: %d\n", raiz->meio->key[1]);
   	printf("\n-----------------------------------------------------\n");
	printf("Nodo->dir->key[0]: %d\n", raiz->dir->key[0]);
	printf("Nodo->dir->key[1]: %d\n", raiz->dir->key[1]);
	printf("\n-----------------------------------------------------\n");
    //printf("nodo->meio->pai->key[0]: %d\n", raiz->meio->pai->key[0]);
    //printf("nodo->meio->pai->key[1]: %d\n\n", raiz->meio->pai->key[1]);
	
   	 /*
   	/*
   	printf("Nodo->dir->key[0]: %d\n", raiz->dir->key[0]);
   	printf("Nodo->dir->key[1]: %d\n", raiz->dir->key[1]);
   	*/
    system("PAUSE");
}
//============================================================
TNo *inicializaArvore()
{
	return NULL;
}
//============================================================
TNo *newPage(TNo *pai)
{
	TNo *novo = (TNo *)malloc(sizeof(TNo));
	novo->esq = NULL;
	novo->dir = NULL;
	novo->meio = NULL;
	novo->pai = pai;
	return novo;
}
//============================================================
TNo *localKey(TNo *atual, int newKey)
{
	TNo *encontrado = atual;
	limpaChave(atual);
	while(atual != NULL)
	{
		if(newKey < atual->key[0]) 
		atual = atual->esq; // Esquerda
		else if(newKey > atual->key[0] && atual->key[1] == 0) atual = atual->meio;  // Meio
		else if(newKey >atual->key[0] && newKey < atual->key[1]) atual = atual->meio; // Meio
		else atual = atual->dir; // Direita

		if(atual != NULL) encontrado = atual;
	}
	return encontrado;
}
//============================================================
void insereKey(TNo *nodo, int newKey)
{
	int intermedChave, maiorChave;
	nodo = localKey(nodo, newKey);
	
	if(verificaOcupacaoDeChaves(nodo)) 
	{
		if(newKey < nodo->key[0])
		{
			intermedChave = nodo->key[0];
			maiorChave = nodo->key[1];
		}
		else if(newKey < nodo->key[1])
		{
			intermedChave = newKey;
			maiorChave = nodo->key[1];
		}
		else
		{
			intermedChave = nodo->key[1];
			maiorChave = newKey;
		}
		split(&nodo, intermedChave, maiorChave);
		return;
	}

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
TNo *insere(TNo **nodo, int newKey, TNo *noPai)
{
	TNo *antPai = noPai;
	noPai = (*nodo);
	if((*nodo) == NULL){
		(*nodo) = newPage(antPai); 
	}	
	if((*nodo)->key[0] == 0 || (*nodo)->key[1] == 0)
	{
		insereKey((*nodo), newKey);
	} 
	else
	{
		if((*nodo)->pai == NULL && notChildren((*nodo)))
		{
			if(newKey > (*nodo)->key[1])
			{
				split(&(*nodo), (*nodo)->key[1], newKey);
			}
			else
			{
				
			}
		}
		if(verificaOcupacaoDeChaves(*nodo))
		{
			if(!notChildren(*nodo))
			{
				insereKey((*nodo), newKey);
			}
		}
	
		
	}
}
//============================================================
void limpaChave(TNo *nodo)
{
	if(nodo->key[0] > 100) nodo->key[0] = 0;
	if(nodo->key[1] > 100) nodo->key[1] = 0;
}
//============================================================
int verificaOcupacaoDeChaves(TNo *nodo)
{
	if(nodo == NULL) return 0;
	limpaChave(nodo);
	if(nodo->key[0] != 0 && nodo->key[1] != 0)
	{
		return 1;
	}
	return 0;
}
//============================================================
void split(TNo **nodo, int intermediario, int maior)
{
	TNo *aux = (*nodo);
	TNo *novoIntermed = NULL;
	TNo *novoMaior =  NULL;
	if((*nodo)->pai == NULL)
	{
		(*nodo) = newPage(NULL);
		insereKey((*nodo), intermediario);
		(*nodo)->esq = aux;
		(*nodo)->esq->key[1] = 0;
		(*nodo)->meio = insere(&(*nodo)->meio, maior, NULL);
		(*nodo)->meio->pai = (*nodo);
		(*nodo)->esq->pai = (*nodo);
	}
	else{
		// inserindo no pai quando há espaço
		if(!verificaOcupacaoDeChaves((*nodo)->pai))
		{
			(*nodo)->pai->key[1] = intermediario;
			
			novoMaior = newPage((*nodo)->pai);
			novoMaior->key[0] = maior;
			(*nodo)->key[1] = 0;
			(*nodo)->pai->dir = novoMaior;
		}
		else
		{
			printf("EPA maior: %d\n", maior);
			printf("EPA medio: %d\n", intermediario);
			novoMaior = newPage(NULL);
			
			novoMaior->key[0] = maior;
			(*nodo)->key[1] = 0;
			novoIntermed = insere(&(*nodo)->pai, intermediario, (*nodo)->pai);
			novoIntermed->esq = (*nodo);
			novoIntermed->meio = novoMaior;
			novoMaior->pai = novoIntermed;
			(*nodo)->pai = novoIntermed;
			printf("novoIntermedio: %d\n", novoIntermed->key[0]);
		}
		
		
	}
}
//============================================================
int notChildren(TNo *nodo)
{
	if(nodo->esq == NULL && nodo->meio == NULL && nodo->dir == NULL) return 1;
	else return 0;
}
