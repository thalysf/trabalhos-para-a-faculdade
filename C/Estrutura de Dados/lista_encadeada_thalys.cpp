#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <locale.h>
#include <string.h>

#define MAX 50
/**
  *-----------------------------------------*
  *	Aluno: Thalys Fabrete Cândido			*
  * Turma: Sistemas de Informação V06		*
  *	Disciplina: Estrutura de Dados			*
  *-----------------------------------------*
  */
typedef struct tipoNo {
	char nome[MAX];
	char sexo;
	tipoNo *prox;
}TNo;

typedef struct tipoLista {
	int total;
	tipoNo *inicio;
	tipoNo *fim;
}TLista;

TLista lista;

void inicializa(TLista *L);
int menu();
void insere(TLista *L);
void exibe(TNo *atual);
void mostraLista(TLista *L);
void remove(TLista *L);
void reordenar(TLista *L);
void ordenarPorSelecao(TLista *L, int crescenteOuDecrescente);


int main(){
	setlocale(LC_ALL, "Portuguese");
	int op;
	
	inicializa(&lista);
	
	do {
		op = menu();
		
		switch(op){
		   case 1: insere(&lista); ordenarPorSelecao(&lista, 1); break;
		   case 2: mostraLista(&lista); break;
		   case 3: remove(&lista); break;	
		   case 4: reordenar(&lista); break;
		}//switch
		
	} while(op != 0);
	
}

void inicializa(TLista *L){
	L->inicio = NULL;
	L->fim = NULL;
	L->total = 0;
}

int menu(){
	int opcao;
	system("CLS"); //Limpa a Tela e posiciona o 
	               //CURSOR no canto esquerdo superior da mesma
    printf("\n\n\n\t     =====| MENU |=====\n\n");
    printf("0 - SAIR (Encerrar Programa).\n\n");
    printf("1 - Inserir.\n");
    printf("2 - Exibir Lista Completa.\n");
    printf("3 - Excluir.\n");
    printf("4 - Reordenar.\n\n");
    printf("\tInforme OPCAO desejada: ");
    
    scanf("%d",&opcao);
	
	if ((opcao > 5) || (opcao < 0)){
		printf("\n\n\n");
		printf("\t+-------------------------------------------------+");
		printf("\t|   ERRO:                                         |");
		printf("\t|                                                 |");
		printf("\t|   OPCAO INVALIDA!!!                             |");
		printf("\t|                                                 |");
		printf("\t|   Tente outra vez.                              |");
		printf("\t+-------------------------------------------------+\n\n");
		system("PAUSE");
	}
	return opcao;
}
void ordenarPorSelecao(TLista * L, int crescenteOuDecrescente)
{
	int cont = 0;
	char sexo = 'M';
	char auxN[MAX];
	char auxS;
	TNo *i = L->inicio;
	TNo *j = NULL;
	TNo *menor = NULL;
	TNo *lastPos = NULL;
	// ordenar mulheres e depois homens
	// -> na primeira iteração as mulheres serão ordenada, na segunda será a vez dos homens
	while(cont < 2)
	{
			if(L->inicio != NULL)
		{
				
				for(i; i->prox != NULL; i = i->prox)
			{
				
				menor = i;
				
				for(j = i->prox; j != NULL; j = j->prox)
				{
					// -> nesta verificação é definido se a ordenação será crescente ou decrescente
					if(crescenteOuDecrescente == 1)
					{
							// -> Procurando sempre o o nome que vem alfabeticamente primeiro...
							// -> ...E sendo atribuído ao ponteiro "menor" a posição deste
							if(strcmp(j->nome, menor->nome) < 0 && j->sexo != sexo)
						{
							menor = j;
						}
						if(j->prox != NULL)
						{
							if(j->sexo == 'F' && j->prox->sexo == 'M') lastPos = j->prox;
						}
						// -> Pegando a posição da última mulher e do primeiro homem pra saber de onde começar...
						// -> ...na próxima iteração
					}
					else
					{
						if(strcmp(j->nome, menor->nome) > 0 && j->sexo != sexo)
						{
							menor = j;
						}
						if(j->prox != NULL)
						{
							if(j->sexo == 'F' && j->prox->sexo == 'M') lastPos = j->prox;
						}
								
					}
				
				}
				// -> Colocando o nome na sua devida posição
				strcpy(auxN, i->nome);
				auxS = i->sexo;
					
				strcpy(i->nome, menor->nome);
				i->sexo = menor->sexo;
			
				strcpy(menor->nome, auxN);
				menor->sexo = auxS;
			}
		}
		
		if(lastPos != NULL)i = lastPos;
		else i = L->inicio;
		cont++;
		sexo = 'F';
	}
}
	

void insere(TLista *L){
   	TNo *novo = (TNo *)malloc(sizeof(TNo));
   	int inserido = 0;
   	printf("\n\n\n");
   	printf("\t=====| INSERE NOVO NO |=====\n\n");
	printf("Digite o nome: ");
	scanf("%s", &novo->nome);
	fflush(stdin); // UTILIZE OUTRO LIMPADOR DE BUFFER SE NECESSÁRIO
	do
	{
		printf("Digite o sexo[F/M]: ");
		scanf("%c", &novo->sexo);
		novo->sexo = toupper(novo->sexo);
	}while(novo->sexo != 'M' && novo->sexo != 'F');
   	
  	 novo->prox = NULL;
   
  
   if(L->inicio == NULL){
   	  //Lista VAZIA: inserir o primeiro N?.
   	  L->inicio = novo;
   	  L->fim = novo;
   } 
   else {
   	  //Lista possui pelo menos um N?: Inserir dados em
   	  //ordem crescente.
   	  TNo *atual = L->inicio;
   	  TNo *previo = NULL;
   	  
   	  while (atual != NULL){
   	  	
   	  	
   	  	if(atual->sexo == 'M'){ 
			inserido = 1;
			novo->prox = atual;
			
			if(previo == NULL){
				//Inserir novo no in?cio da Lista
				L->inicio = novo;
			} else {
				//Inserir novo em algum ponto no meio da Lista
				previo->prox = novo;
			}//if else
			break;
		}//if
		previo = atual;
		atual = atual->prox; //movimenta ponteiro ATUAL para 
		                     //o N? SEGUINTE.
	  }//while
	  
	  if (!inserido){
	     //Inserir novo no final da Lista
		 L->fim->prox = novo;
		 L->fim = novo;		
    	 L->total++;
	  }//if
	  
   }//if ... else
   
}

void exibe(TNo *atual){
	printf("\n+-------------------+");
	printf("\n\tNome: [%s] ",atual->nome); printf(" | Sexo: [%c] \n",atual->sexo);
}

void mostraLista(TLista *L){
   TNo *atual = L->inicio;
   
   printf("\n\n\n");
   printf("\t=====| EXIBE LISTA COMPLETA |=====\n\n");
   
   while(atual != NULL){
   	   exibe(atual);
   	   atual = atual->prox;
   }//while
   printf("\n\n");
   system("PAUSE");
}

void remove(TLista *L){
	TNo *atual = L->inicio, *previo = NULL, *proximo;
	char parametro[MAX];
	int removido = 0;
	
	if(L->inicio == NULL) proximo = NULL;
	else proximo = atual->prox;
	
	printf("\n\n\t=====| REMOVER No |=====\n\n");
	printf("\tInforme o NOME a ser REMOVIDO: ");
	scanf("%s", &parametro);
	
	while(atual != NULL){
		
	   if(!strcmp(atual->nome, parametro))	{
	   	  proximo = atual->prox;
	   	  if(previo == NULL) L->inicio = proximo;
	   	  else previo->prox = proximo;
		  
		  free(atual);
		  L->total--;
		  removido = 1;
		  break;
	   }//if
	   previo = atual;
	   atual = atual->prox;
	   if(atual != NULL) proximo = atual->prox;
	   else proximo = NULL;
	}//while
	
	if(removido){
		printf("\n\n\n");
		printf("+--------------------------------------+\n");
		printf("|  AVISO:                              |\n");
		printf("|                                      |\n");
		printf("|  No REMOVIDO com SUCESSO !!!         |\n");
		printf("|                                      |\n");
		printf("+--------------------------------------+\n\n\n");
		system("PAUSE");
	} else {
		printf("\n\n\n");
		printf("+--------------------------------------+\n");
		printf("|  ALERTA:                             |\n");
		printf("|                                      |\n");
		printf("|  No NAO ENCONTRADO e nem REMOVIDO!!! |\n");
		printf("|                                      |\n");
		printf("+--------------------------------------+\n\n\n");
		system("PAUSE");		
	}
}

void reordenar(TLista *L){
	// chamando a função de reordenar e passando como parâmetro um valor != de 1 para que a ordenação seja inversa
	ordenarPorSelecao(L, 2);
}
