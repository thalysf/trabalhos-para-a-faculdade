#include <stdio.h>
#include <stdlib.h>

typedef struct tipoNo {
	int valor;
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

int main(){
	int op;
	
	inicializa(&lista);
	
	do {
		op = menu();
		
		switch(op){
		   case 1: insere(&lista); break;
		   case 2: mostraLista(&lista); break;
		   case 3: remove(&lista); break;	
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
    printf("3 - Excluir.\n\n");
    printf("\tInforme OPCAO desejada: ");
    
    scanf("%d",&opcao);
	
	if ((opcao > 3) || (opcao < 0)){
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

void insere(TLista *L){
   TNo *novo = (TNo *)malloc(sizeof(TNo));
   int inserido = 0;
   
   printf("\n\n\n");
   printf("\t=====| INSERE NOVO NO |=====\n\n");
   printf("Informe VALOR: ");
   scanf("%d", &novo->valor);
   
   novo->prox = NULL;
   
   if(L->inicio == NULL){
   	  //Lista VAZIA: inserir o primeiro N?.
   	  L->inicio = novo;
   	  L->fim = novo;
   } else {
   	  //Lista possui pelo menos um N?: Inserir dados em
   	  //ordem crescente.
   	  TNo *atual = L->inicio;
   	  TNo *previo = NULL;
   	  
   	  while (atual != NULL){
   	  	if(atual->valor >= novo->valor){
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
	  }//if
	  
   }//if ... else
   
   L->total++;
}

void exibe(TNo *atual){
	printf("\n+-------------------+");
	printf("\n\t%d\n",atual->valor);
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
	int parametro;
	int removido = 0;
	
	if(L->inicio == NULL) proximo = NULL;
	else proximo = atual->prox;
	
	printf("\n\n\t=====| REMOVER No |=====\n\n");
	printf("\tInforme VALOR a ser REMOVIDO: ");
	scanf("%d", &parametro);
	
	while(atual != NULL){
	   if(atual->valor == parametro)	{
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
	//Procedimento com o objetivo de reordenar os n?s: ap?s sua execu??o os n?s estar?o em
	//ordem descrescente.
	
}
