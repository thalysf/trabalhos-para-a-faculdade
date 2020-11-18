#include "lista.h"

void inicializa(TLista *lista)
{
	lista->inicio = NULL;
	lista->fim = NULL;
	lista->total = 0;
}
//-------------------------------------------------------
void inserir(TLista *lista, int idade, int id, char *nome)
{
	int res = busca(lista, id);
	if(res) return;
	TElemento *novo = (TElemento *)malloc(sizeof(TElemento));
	novo->id = id;
	novo->idade = idade;
	strcpy(novo->nome, nome);
	novo->prox = NULL;
	novo->ant = NULL;
	int inserido = 0;
	if(lista->inicio == NULL) // Quando a lista está vazia, esse novo elemento passará a ser inicio e fim
	{
		lista->inicio = novo;
		lista->fim = novo;
	}
	else
	{
		TElemento *atual = lista->inicio;
		while(atual != NULL)
		{
			// Inserção por ordem alfabética e numérica
			if(strcmp(atual->nome, novo->nome) == 1 || (strcmp(atual->nome, novo->nome) == 0 && atual->idade > novo->idade))
			{
				
				if(atual == lista->inicio) // inserindo no início
				{
					novo->prox = atual;
					novo->ant = NULL;
					atual->ant = novo;
					lista->inicio = novo;
				}
				else // inserindo no meio 
				{
					novo->prox = atual;
					novo->ant = atual->ant;
					atual->ant->prox = novo;
					atual->ant = novo;
				}
				inserido = 1;
				break;
			}
			atual = atual->prox;
		}
		if(!inserido) // inserindo no fim 
		{
			lista->fim->prox = novo;
			novo->ant = lista->fim;
			lista->fim = novo;
		}
	}
	lista->total += 1; // incrementando o total de registros da lista
}
//-------------------------------------------------------
int remover(TLista *lista, int id)
{
	TElemento *atual =  lista->inicio;
	int removido = 0;
	if(atual != NULL)
	{
		while(atual != NULL)
		{
			if(atual->id == id)
			{
				if(atual == lista->inicio) // removendo do inicio
				{
					lista->inicio = atual->prox;
					if(lista->fim != atual)	lista->inicio->ant = atual->ant;
					else lista->fim = NULL;
				}
				else
				{
					if(atual == lista->fim) // removendo do fim
					{
						lista->fim->ant->prox = NULL;
						lista->fim = atual->ant;
					}
					else // removendo do meio
					{
						atual->ant->prox = atual->prox;
						atual->prox->ant = atual->ant;
					}
				}
				removido = 1;
				free(atual);
				break;
			}
			atual = atual->prox;
		}
	}
	else
	{
		printf("\t\t\t|Impossível remover de lista vazia...");
	}
	if(removido) // decrementando o total de registros da lista quando a remoção é efetuada com sucesso
		lista->total -= 1;
	
	return removido;
}
//-------------------------------------------------------
void exibir(TLista *lista)
{
	TElemento *atual =  lista->inicio;
	int i = 1;
	printf("\n\t\t\t-------------------------------\n");
	if(atual != NULL)
	{
		while(atual != NULL)
		{
			printf("\t\t\t |%dº Nome: %s | idade: %d | id: %d\n", i ,atual->nome, atual->idade, atual->id);
			atual = atual->prox; i++;
		}
		printf("\t\t\t |Total: %d", lista->total);
	}
	else
	{
		printf("\t\t\tLISTA VAZIA!");
	}
	printf("\n\t\t\t-------------------------------\n\n");
}
//-------------------------------------------------------
int busca(TLista *lista, int id)
{
	TElemento *atual =  lista->inicio;
	if(atual != NULL)
	{
		while(atual != NULL)
		{
			if(atual->id == id)
			{
				printf("\n\t\t\t--------------------------------------------------------");
				printf("\n\t\t\t  |Registro com id informado já se encontra cadastrado: \n");
				printf("\t\t\t  |-> Nome: %s \n\t\t\t  |-> Idade: \n\t\t\t  |-> Id:%d ", atual->nome, atual->idade);
				printf("\n\t\t\t--------------------------------------------------------");
				return 1;
			}
			atual = atual->prox;
		}
	}
	return 0;
}
void zerarLista(TLista *lista) // libera memória de todos registros que compõe a lista
{
	TElemento *atual =  lista->inicio;
	TElemento *previa;
	if(atual != NULL)
	{
		while(atual != NULL)
		{
			previa = atual;
			atual = atual->prox;
			free(previa);
		}
	}
	else
	{
		printf("\t\t\tLISTA VAZIA!");
	}
	lista->inicio = NULL;
	lista->fim = NULL;
	lista->total = 0;
}
//-------------------------------------------------------
void menu(TLista *lista) // menu de interação com o programa de lista
{
	int op = 0, idade = 0, id = 0, res = 0;
	char nome[50];
	do
	{
		printf("\n\t\t\t|========================================|\n");
		printf("\t\t\t|                [1] INSERIR             |\n");
		printf("\t\t\t|                [2] REMOVER             |\n");
		printf("\t\t\t|                [3] EXIBIR              |\n");
		printf("\t\t\t|                [4] PROCURAR            |\n");
		printf("\t\t\t|                [5] ZERAR LISTA         |\n");
		printf("\t\t\t|                [0] SAIR                |\n");
		printf("\t\t\t|========================================|\n");
		printf("\t\t\t           -> Digite sua opção: ");
		scanf(" %d", &op);
		setbuf(stdin, NULL);
		switch(op)
		{
			case 1: 
				  printf("\t\t\t|-> Inserindo ...\n");
				  printf("\n\t\t\t|Informe a idade: ");
				  scanf(" %d", &idade);
				  printf("\n\t\t\t|Informe o nome: ");
				  scanf("%s", &nome);
				  printf("\n\t\t\t|Informe o id: ");
				  scanf("%d", &id);
				  inserir(lista, idade, id, nome);
				  break;
			case 2: 
				  printf("\t\t\t|-> Removendo ...\n");
				  printf("\n\t\t\t|Informe o id: ");
				  scanf("%d", &id);	 
				  res = remover(lista, id);
				  if(res) printf("\n\t\t\tRegistro removido com sucesso ...\n");
				  else printf("\n\t\t\t|Registro não encontrado ...\n");
				  break;
			case 3: 
				  printf("\n\t\t\t|-> Exibindo lista ...\n");
				  exibir(lista);
				  break;
			case 4:
				 printf("\n\t\t\t|-> Procurando Registro ...\n");
				 printf("\n\t\t\t|Informe o id: ");
				 scanf("%d", &id);
				 res = busca(lista, id);
				 if(!res) printf("\n\t\t\t|Registro não encontrado...\n");
				 break;
			case 5:
				 printf("\n\t\t\t|-> Zerando a lista ...\n");
				 zerarLista(lista);
				 break;
			default:
				 printf("\n\t\t\t|-> Encerrando ...\n"); zerarLista(lista);	
		}
	}while(op != 0); 
}
