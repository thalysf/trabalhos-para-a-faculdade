#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
/**
  *
  *	Aluno: Thalys Fabrete Cândido
  * Curso: Sistemas de Informação
  * Turma: V06
  * Matéria: Estrutura de dados
  * 03/06/2020
  *
  */
typedef struct reg {
   int posicao; 
   struct reg *prox;
}Elemento;

typedef struct Pilha {
	Elemento *topo;
	int quantidade;
}TPilha;

typedef struct instru {
	char comando[20];
	char complemento[20];
} instrucao;

void criaPilha (TPilha **p);
void empilha (int valor, TPilha **p);
int desempilha (TPilha **p); 
int pilhaVazia(TPilha *p);
void simulacaoDeExecucao(instrucao prog[20]);
void formataPrograma(instrucao prog[20]);
void ExibirPilha(TPilha * p);
instrucao programa[20];

int main(){
   setlocale(LC_ALL, "Portuguese");
   simulacaoDeExecucao(programa);
   system("PAUSE");
}

void criaPilha (TPilha *p) {
   p = (TPilha *)malloc (sizeof (TPilha)); 
   p->topo = NULL; 
   p->quantidade = 0;
}

void Empilha (int valor, TPilha **p) { 
	Elemento * novo_elemento;
	novo_elemento = (Elemento *) malloc (sizeof (Elemento));
	
	novo_elemento->posicao =  valor;
	novo_elemento->prox = (*p)->topo;
	
	(*p)->topo = novo_elemento;
   	(*p)->quantidade++;
}
void ExibirPilha(TPilha * p)
{
	// -> Se pilha vazia não há nada a ser exibido
	if(pilhaVazia(p))
	{
		printf("Pilha vazia...\n");
		return;
	}
	int i = 0;
	Elemento * elem = p->topo;
	printf("|Exibindo Pilha...\n");
	printf("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
	for(i; i < p->quantidade; i++)
	{
		printf("Pilha[%d]: %d\n", i, elem->posicao);
		elem = elem->prox;
	}
	printf("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
}
int Desempilha (TPilha **p) { // talvez aqui seja int
	
	if(pilhaVazia(*p))
	{
		printf("Pilha vazia... Portanto não há nada para ser desempilhado...\n");
		return (-1);
	}
    Elemento *elem;
    elem = (*p)->topo;
   
    int pos = (*p)->topo->posicao;
    (*p)->topo = (*p)->topo->prox;
   
    free(elem);
    (*p)->quantidade--;
   
    return pos; 
}

int pilhaVazia(TPilha *p){
	if(p->topo == NULL)	return 1;
	else  return 0;
}

void simulacaoDeExecucao(instrucao prog[20]){
	int i = 0;
	int posicao = 0;
	TPilha * pilha = NULL;
	criaPilha(pilha);
	formataPrograma(prog);
	
	do
	{
		// ->iniciando uma rotina iremos procurar o próximo comando
		if(strcmp(prog[i].comando, "INICIO") == 0)
		{
			printf("<[%d]>\n", i);
			i++;
		}
		
		if(strcmp(prog[i].comando, "CALL") == 0)
		{
			printf("<[%d]>\n", i);
			// -> convertendo tipo caractere para tipo inteiro e recuperando o complemento da instrução
			posicao = atoi(prog[i].complemento);
			// -> a posição seguinte a i que será empilhada
			Empilha(i+1, &pilha);
			//ExibirPilha(pilha); // -> Caso queira exibir a pilha, retire o comentário
			i = posicao;
		}
		// instrução de impressão do complemento
		if(strcmp(prog[i].comando, "IMPRIMA") == 0)
		{
			printf("<[%d]> ", i);
			printf("| %s \n", prog[i].complemento);
			i++;
		}
		
		if(strcmp(prog[i].comando, "LEIA") == 0)
		{
			printf("<[%d]>\n", i);
			i++;
		}
		// -> se uma sub-rotina foi finalizada, iremos desempilhar um elemento da pilha
		if(strcmp(prog[i].comando, "FIM_SUB") == 0)
		{
			printf("<[%d]>\n", i);
			// -> elemento desempilhado é recuperado e passado para variável i
			i = Desempilha(&pilha);
			//ExibirPilha(pilha); // -> Caso queira exibir a pilha, retire o comentário
		}
		if(strcmp(prog[i].comando, "FIM") == 0)
		{
			// -> se o "FIM" foi alcançado apenas iremos printar a última posição acessada e encerrar o programa
			printf("<[%d]>\n", i);
		}
	}while(strcmp(prog[i].comando, "FIM")!= 0);
	// -> medida de segurança, para garantir que a memória será liberada ao final da execução
	free(pilha);
}

void formataPrograma(instrucao prog[20]){
    //Carregamento do Programa na MEMÓRIA PRINCIPAL
	
	strcpy(prog[0].comando,"INICIO");
	strcpy(prog[0].complemento,"");
	
	strcpy(prog[1].comando,"CALL"); //chamada da Rotina A (iniciada na posição 5 do vetor).
	strcpy(prog[1].complemento,"5"); 
	
	strcpy(prog[2].comando,"CALL"); //chamada da Rotina B (iniciada na posição 10 do vetor).
	strcpy(prog[2].complemento,"10");
		
	strcpy(prog[3].comando,"IMPRIMA"); //escrever na tela "QTD"
	strcpy(prog[3].complemento,"QTD");
		
	strcpy(prog[4].comando,"FIM");
	strcpy(prog[4].complemento,"");
	
	strcpy(prog[5].comando,"INICIO");
	strcpy(prog[5].complemento,"SUB_A");			

	strcpy(prog[6].comando,"CALL"); //chamada da Rotina B (iniciada na posição 10 do vetor).
	strcpy(prog[6].complemento,"10");

	strcpy(prog[7].comando,"CALL"); //chamada da Rotina C (iniciada na posição 15 do vetor).
	strcpy(prog[7].complemento,"15");
	
	strcpy(prog[8].comando,"IMPRIMA"); //escrever na tela "TOT"
	strcpy(prog[8].complemento,"TOT");
	
	strcpy(prog[9].comando,"FIM_SUB");
	strcpy(prog[9].complemento,"");
	
	strcpy(prog[10].comando,"INICIO");
	strcpy(prog[10].complemento,"SUB_B");
	
	strcpy(prog[11].comando,"IMPRIMA");
	strcpy(prog[11].complemento,"VAL");
	
	strcpy(prog[12].comando,"CALL");
	strcpy(prog[12].complemento,"15");
	
	strcpy(prog[13].comando,"IMPRIMA"); //escrever na tela "DIF"
	strcpy(prog[13].complemento,"DIF");
	
	strcpy(prog[14].comando,"FIM_SUB");
	strcpy(prog[14].complemento,"");
	
	strcpy(prog[15].comando,"INICIO");
	strcpy(prog[15].complemento,"SUB_C");
	
	strcpy(prog[16].comando,"LEIA");
	strcpy(prog[16].complemento,"SAL");
	
	strcpy(prog[17].comando,"IMPRIMA");
	strcpy(prog[17].complemento,"BRU");
	
	strcpy(prog[18].comando,"IMPRIMA");
	strcpy(prog[18].complemento,"LIQ");
	
	strcpy(prog[19].comando,"FIM_SUB");
	strcpy(prog[19].complemento,"");
}
