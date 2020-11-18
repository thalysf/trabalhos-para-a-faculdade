#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <locale.h>

#define MAX 40
/**
  *-----------------------------------------*
  *	Aluno: Thalys Fabrete Cândido			*
  * Turma: Sistemas de Informação V06		*
  *	Disciplina: Estrutura de Dados			*
  *-----------------------------------------*
  */
typedef struct tipoNo {
	int matricula;
	char nome[MAX];
	char sexo;	
	tipoNo *ante, *prox;
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
void mostraListaInversa(TLista *L);
void remove(TLista *L);
void reordenarPorNome(TLista * L, TNo *parametro);
void reordenarPorSexoENome(TLista * L);
void printarMsg(int tipoMsg);
int main(){
	setlocale(LC_ALL, "Portuguese");
	int op;
	inicializa(&lista);
	system("COLOR 7");
	do {
		op = menu();
		
		switch(op){
		   case 1: insere(&lista); break;
		   case 2: mostraLista(&lista); break;
		   case 3: mostraListaInversa(&lista); break;
		   case 4: 
		   			if(lista.total > 1)
		   			{
		   				reordenarPorNome(&lista, NULL); 
		   				printarMsg(1); 
					}
					else printarMsg(2); 
					break;	
		   case 5: 
		   			if(lista.total > 1)
		   			{
		   				reordenarPorSexoENome(&lista); 
		   				printarMsg(0); 
					}
					else printarMsg(2); 
					break;	
		   case 6: remove(&lista); break;
		}//switch
		system("COLOR 7");
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
    printf("3 - Exibir Lista Completa Invertida.\n");
    printf("4 - Reordenar por nome.\n");
    printf("5 - Reordenar por sexo e nome.\n");
     printf("6 - Excluir.\n\n");
    printf("\tInforme OPCAO desejada: ");
    
    scanf("%d",&opcao);
	
	if ((opcao > 6) || (opcao < 0)){
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
   printf("\t|Informe a MATRÍCULA: ");
   scanf("%d", &novo->matricula); 
   printf("\t|Informe o NOME: ");
   scanf(" %s", &novo->nome);
   setbuf(stdin, NULL); 
   do
	{
		printf("\t|Informe o SEXO [F/M]: ");
		scanf(" %c", &novo->sexo);
		novo->sexo = toupper(novo->sexo);
	}while(novo->sexo != 'M' && novo->sexo != 'F');
   novo->ante = NULL;
   novo->prox = NULL;
   
   if(L->inicio == NULL){
   	  //Lista VAZIA: inserir o primeiro N?.
   	  *L->inicio = novo;
   	  L->fim = novo;
   } else {
   	  //Lista possui pelo menos um N?: Inserir dados em
   	  //ordem crescente.
   	  TNo *atual = L->inicio;
   	  TNo *previo = NULL;
   	  
   	  while (atual != NULL){
   	  	if(atual->matricula >= novo->matricula){
			inserido = 1;
			novo->prox = atual;
			novo->ante = atual->ante;
			
			if(novo->ante == NULL){
				//Inserir novo no in?cio da Lista
				L->inicio = novo;
				atual->ante = novo;
			} else {
				//Inserir novo em algum ponto no meio da Lista
				previo = atual->ante;
				previo->prox = novo;
				
				atual->ante = novo;
			}//if else
			break;
		}//if
		
		atual = atual->prox; //movimenta ponteiro ATUAL para 
		                     //o N? SEGUINTE.
	  }//while
	  
	  if (!inserido){
	     //Inserir novo no final da Lista
		 L->fim->prox = novo;
		 novo->ante = L->fim;
		 L->fim = novo;	
	  }//if
	  
   }//if ... else
   
   L->total++;
}

void exibe(TNo *atual){
	printf("\n+-------------------+");
	printf("\n\tMatrícula: %d | ",atual->matricula);
	printf("Nome: %s | ",atual->nome);
	printf("Sexo: %c | \n",atual->sexo);
}

void mostraLista(TLista *L){
   TNo *atual = L->inicio;
   
   printf("\n\n\n");
   printf("\t=====| EXIBE LISTA COMPLETA |=====\n\n");
   
   while(atual != NULL){
   	   exibe(atual);
   	   atual = atual->prox;
   }//while
   printf("\n\nTotal de Nos: %d\n\n",L->total);
   system("PAUSE");
}

void mostraListaInversa(TLista *L){
   TNo *atual = L->fim;
   
   printf("\n\n\n");
   printf("\t=====| EXIBE LISTA INVERTIDA |=====\n\n");
   
   while(atual != NULL){
   	   exibe(atual);
   	   atual = atual->ante;
   }//while
   printf("\n\nTotal de Nos: %d\n\n",L->total);
   system("PAUSE");
}

void remove(TLista *L){
	TNo *atual = L->inicio, *previo = NULL, *proximo = NULL;
	int parametro;
	int removido = 0;
	
	printf("\n\n\t=====| REMOVER No |=====\n\n");
	printf("\tInforme a MATRÍCULA a ser REMOVIDA: ");
	scanf("%d", &parametro);
	
	while(atual != NULL){
	   if(atual->matricula == parametro)	{
	   	  proximo = atual->prox;
	   	  previo = atual->ante;
	   	  
	   	  if(previo == NULL) {
	   	  	  L->inicio = proximo;
	   	  	  if(proximo != NULL) proximo->ante = NULL; 
			  if(atual == L->fim)L->fim = NULL;  
		  } else {
		      previo->prox = proximo;
			  if(proximo != NULL) {
				 proximo->ante = previo;	
			  } else {
			  	 L->fim = previo;
			  }
		  }
		  
		  free(atual);
		  L->total--;
		  removido = 1;
		  break;
	   }//if
	   
	   atual = atual->prox;
	   
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
// -> Função de inverter lista caso exista a necessidade de inverter a sequência das posições
void inverterLista(TLista *L)
{
	TNo *atual = L->fim;
	TNo * auxAnt = NULL;
	int aux = 0;
	while(atual != NULL)
	{
		if(aux == 0)
		
		{
			L->inicio = atual;
		
			atual->prox = atual->ante;
			atual->ante = NULL;
		
			
			aux = 1;
		}
		if(atual->prox == NULL)
		{
			L->fim = atual;
			break;
		} 
		
		auxAnt = atual;
		
		atual = atual->prox;
		atual->prox = atual->ante;
		atual->ante = auxAnt;
		
	}
}
void reordenarPorNome(TLista *L, TNo *parametro){

	int auxMatricula;
	char auxNome[MAX];
	char auxSexo;
	// -> Caso não necessitarmos de uma ordenação especial, começaremos sempre do início da fila 
	if(parametro == NULL) parametro = L->inicio;
	TNo *i = parametro;
	TNo *j = NULL;
	TNo *menor = NULL;
	if(L->inicio != NULL)
		{
				
				for(i; i->prox != NULL; i = i->prox)
			{
				menor = i;
				
				for(j = i->prox; j != NULL; j = j->prox)
				{
					
						if(strcmp(j->nome, menor->nome) < 0)
						{
							menor = j;		
						}
				}
				strcpy(auxNome, i->nome);
				auxMatricula = i->matricula;
				auxSexo = i->sexo;
					
				strcpy(i->nome, menor->nome);
				i->matricula = menor->matricula;
				i->sexo = menor->sexo;
				
				strcpy(menor->nome, auxNome);
				menor->matricula = auxMatricula;
				menor->sexo = auxSexo;		
			}	
			
		}
}


void reordenarPorSexoENome(TLista *L){
	//  -> Reaproveitando a função de reordenar para combiná-la, com essa função
	reordenarPorNome(L, NULL);
	
	int aux = 0;
	int count  = 0;
	int auxMatricula;
	
	char auxNome[MAX];
	char auxSexo;
	char sexo = 'F';
	TNo *parametro = NULL;
	TNo *i = L->inicio;
	TNo *j = NULL;
	TNo *menor = NULL;
		if(L->inicio != NULL)
		{
				
				for(i; i->prox != NULL; i = i->prox)
			{
					menor = i;
					if(menor->sexo!= 'F')
					{
						for(j = i->prox; j != NULL; j = j->prox)
						{
							
							if(j->sexo == sexo)
							{
								menor = j;	
								aux = 1;
								break;
							}
						}
					}
				// -> apenas iremos trocar os valores quando houver uma mulher para ocupar a posição	
				if(aux)
				{
					strcpy(auxNome, i->nome);
					auxMatricula = i->matricula;
					auxSexo = i->sexo;
						
					strcpy(i->nome, menor->nome);
					i->matricula = menor->matricula;
					i->sexo = menor->sexo;
					
					strcpy(menor->nome, auxNome);
					menor->matricula = auxMatricula;
					menor->sexo = auxSexo;	
					
					// As mulheres são trazidas para o início e como já estão ordenadas...
					// .. Não há necessidade de ordena-las novamente... entretanto os homens como são trazidos para o fim
					// .. Perdem a sua ordem e, por conta disso a partir do primeiro homem a ordenação é refeita
					parametro = i->prox;	
				}
				
				aux = 0;
			}	
		}
		// -> Reordenando apenas os homens para concluir a função
		reordenarPorNome(L, parametro);
}
void printarMsg(int tipoMsg)
{
	if(tipoMsg == 1)
	{
		system("CLS"); printf("\n\t\t----------------| A lista foi efetivamente reordenada por nomes!|----------------\n");
		system("COLOR 2"); printf("\t\t\t\t  |"); system("PAUSE"); system("CLS");
	}
	else if(tipoMsg == 2)
	{
			
		system("CLS");
		system("COLOR 4");
		printf("\n\t|INFO:\n");
		printf("\t|Você precisa de pelo menos dois elementos para poder utilizar esta função!\n\t|");
		system("PAUSE"); system("CLS");
	}
	else
	{
		system("CLS"); printf("\n\t\t----------------| A lista foi efetivamente reordenada por sexo e nomes!|----------------\n");
		system("COLOR 2"); printf("\t\t\t\t  |");  system("PAUSE"); system("CLS");
	}
}
