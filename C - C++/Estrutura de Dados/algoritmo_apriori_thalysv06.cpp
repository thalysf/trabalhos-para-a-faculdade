#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
/**
  *-----------------------------------------*
  *	Aluno: Thalys Fabrete Cândido			*
  * Turma: Sistemas de Informação V06		*
  *	Disciplina: Estrutura de Dados			*
  *-----------------------------------------*
  */
typedef struct tipoEntrada {
int id;
int leite;    
int pao;      
int bolacha; 
int suco;     
int ovos;     
int cafe;     
int manteiga;
tipoEntrada *ante;
tipoEntrada *prox;
}TEntrada;

typedef struct tipoCandidato {
int leite;
int pao;
int bolacha;
int suco;
int ovos;
int cafe;
int manteiga;
float frequencia;
float confiabilidade;
char combinacao[100];
tipoCandidato *ante, *prox;
}TCandidato;

typedef struct tipoDados {
TEntrada *entrada;
float frequenciaMinima;
float confiancaMinima;
int totalCand;
TCandidato *candidatos1Item;
TCandidato *candidatos2Itens;
TCandidato *candidatos3Itens;
TCandidato *regrasFortes;

TEntrada *tabelaItensFrequentes;
TCandidato *tabelaGrupoItensFrequentes;

}TDados;
TDados dados;
// ----------------------------------------------------------------------
// -> funções
void limpaVet(int vet[]);
void inicializa(TDados * dados);
void gerarRegrasFortes(TDados *dados);
void limpar(TCandidato *novoCandidato);
void printarRegrasFortes(TDados *dados);
void tabela1ItensFrequentes(TDados *dados);
void tabelaFrequenciasCandidatos(TDados *dados);
void gerarCandidatos(TDados *dados, int tipoDeCand);
void confiabilidade(TDados *dados, int tipo_operacao);
void gerarComb(TDados *dados, TCandidato *atual, int a, int b, int c, float confiab);
void insereNoGrupo(TCandidato **inicio, TCandidato *cand, char comb[], float conf);
void inserirCandidato(TDados **dados, char combinac[], float freq, TCandidato **inicio, int i, int j, int k);
void insere(TDados **dados, int id, int leite, int pao, int bolacha, int suco, int ovos, int cafe, int manteiga);
int gerarGrupoCandidatos(TDados *dados, int tipoCand, int tipo_operac);
int verificaExistenciaDaComb(TDados *dados, char comb[]);
float ocorrenciaConf(TDados *dados, int a, int b, int c);
float verificaFrequencia(TDados *dados, int i, int j, int k);
// ----------------------------------------------------------------------
int main()
{
	int tipo_operacao = 0;
	int i = 2;
	setlocale(LC_ALL, "Portuguese");
	inicializa(&dados);
	tabelaFrequenciasCandidatos(&dados);

	while(i <= 3) //-> algoritmo está limitado a no máximo candidatos com 3 itens
	{			 // -> mas poderia muito bem ser adaptado para aceitar mais candidatos
		gerarCandidatos(&dados, i);
		tipo_operacao = gerarGrupoCandidatos(&dados, i, tipo_operacao);
		i++;
	}
	confiabilidade(&dados, tipo_operacao);
	gerarRegrasFortes(&dados);
	printarRegrasFortes(&dados);
	return 0;
}
// ----------------------------------------------------------------------
void inicializa(TDados *dados)
{
	dados->frequenciaMinima = 0.50;
	dados->confiancaMinima = 0.75;
	
	// -> inserção dos dados 
	insere(&dados, 1, 1, 1, 1, 1, 0, 0, 1 );
	insere(&dados, 2, 1, 1, 0, 1, 0, 0, 0 );
	insere(&dados, 3, 1, 0, 0, 0, 1, 1, 1 );
	insere(&dados, 4, 0, 1, 1, 0, 0, 1, 1 );
/*
	exemplo original 2 comb:
	insere(&dados, 1, 1, 1, 1, 1, 0, 0, 0 );
	insere(&dados, 2, 1, 0, 0, 1, 0, 0, 0 );
	insere(&dados, 3, 1, 0, 0, 0, 1, 0, 0 );
	insere(&dados, 4, 0, 1, 1, 0, 0, 1, 0 );	
	3 comb:
	insere(&dados, 1, 1, 1, 1, 1, 0, 0, 1 );
	insere(&dados, 2, 1, 1, 0, 1, 0, 0, 0 );
	insere(&dados, 3, 1, 0, 0, 0, 1, 1, 1 );
	insere(&dados, 4, 0, 1, 1, 0, 0, 1, 1 );
*/	
}
// ----------------------------------------------------------------------
void insere(TDados **dados, int id, int leite, int pao, int bolacha, int suco, int ovos, int cafe, int manteiga)
{
	TEntrada *novaEntrada = (TEntrada *)malloc(sizeof(TEntrada));
	if((*dados)->entrada == NULL)
	{
		(*dados)->entrada = novaEntrada;
		novaEntrada->ante = NULL;
		novaEntrada->prox = NULL;
	}
	else
	{
		TEntrada *atual = (*dados)->entrada;
		TEntrada *ante = NULL;
		
		while(atual != NULL)
		{
				if(atual->prox == NULL)
			{
				atual->prox = novaEntrada;
				novaEntrada->prox = NULL;
				novaEntrada->ante = ante;
			}
			ante = atual;	
			atual = atual->prox;
		}		
	}
	// Inserção de elementos
	novaEntrada->id = id;
	novaEntrada->pao = pao;
	novaEntrada->leite = leite;
	novaEntrada->suco = suco;
	novaEntrada->bolacha = bolacha;
	novaEntrada->ovos = ovos;
	novaEntrada->cafe = cafe;
	novaEntrada->manteiga = manteiga;
}
// ----------------------------------------------------------------------
void printarRegrasFortes(TDados *dados)
{
	TCandidato *atual = dados->regrasFortes;
	printf("\n\t\t   --------- TABELA DE REGRAS FORTES ---------\n\n"); //REGRAS FORTES
	system("COLOR F");
	while(atual != NULL)
	{
		printf("\n\t\t\t      - Em %.1f%% das vezes - \n",((atual->frequencia) * 100));
		printf("\t\t\t\t| %s | \n", atual->combinacao);
		printf("\t\t\t\tleite: %d\n", atual->leite);
		printf("\t\t\t\tpao: %d\n", atual->pao);
		printf("\t\t\t\tbolacha: %d\n", atual->bolacha);
		printf("\t\t\t\tsuco: %d\n", atual->suco);
		printf("\t\t\t\tovos: %d\n", atual->ovos);
		printf("\t\t\t\tcafe: %d\n", atual->cafe);
		printf("\t\t\t\tmanteiga: %d\n", atual->manteiga);
		printf("\t\t\t\tCONFIABILIDADE: %.1f%% \n",((atual->confiabilidade) * 100));	
		printf("\n\t\t-----------------------------------------------\n");
		atual = atual->prox;
	}
}
// ----------------------------------------------------------------------
void tabelaFrequenciasCandidatos(TDados *dados)
{
	TEntrada *atual = NULL;
	char combinacao[100];
	float leite, pao, bolacha, suco, ovos, cafe, manteiga, frequencia;
	int totalDeClientes = 0;
	// -> Extraindo a frequência dos elementos
	for(atual = dados->entrada; atual != NULL; atual = atual->prox)
	{
		leite += atual->leite; 
		pao += atual->pao;
		bolacha += atual->bolacha;
		suco += atual->suco;
		ovos += atual->ovos;
		cafe += atual->cafe;
		manteiga += atual->manteiga;	
		totalDeClientes++;  
	}
	dados->totalCand  = totalDeClientes;
	leite = leite/totalDeClientes;
	pao = pao/totalDeClientes;
	bolacha = bolacha/totalDeClientes;
	suco = suco/totalDeClientes;
	ovos = ovos/totalDeClientes;
	cafe = cafe/totalDeClientes;
	manteiga = manteiga/totalDeClientes;
	
	if(leite > 0)
	{
		strcpy(combinacao, "leite");
		inserirCandidato(&dados, combinacao, leite, &dados->candidatos1Item, 0, 0, 0);
	}
	if(pao > 0)
	{
		strcpy(combinacao, "pao");
		inserirCandidato(&dados, combinacao, pao, &dados->candidatos1Item, 1, 1, 1);
	}
	if(bolacha > 0)
	{
		strcpy(combinacao, "bolacha");
		inserirCandidato(&dados, combinacao, bolacha, &dados->candidatos1Item, 2, 2, 2);
	}
	if(suco > 0)
	{
		strcpy(combinacao, "suco");
		inserirCandidato(&dados, combinacao, suco, &dados->candidatos1Item, 3, 3, 3);
	}
	if(ovos > 0)
	{
		strcpy(combinacao, "ovos");
		inserirCandidato(&dados, combinacao, ovos, &dados->candidatos1Item, 4, 4, 4);
	}
	if(cafe > 0)
	{
		strcpy(combinacao, "cafe");
		inserirCandidato(&dados, combinacao, cafe, &dados->candidatos1Item, 5, 5, 5);
	}
	if(manteiga > 0)
	{
		strcpy(combinacao, "manteiga");
		inserirCandidato(&dados, combinacao, manteiga, &dados->candidatos1Item, 6, 6, 6);
	}
	tabela1ItensFrequentes(dados);
}

// ----------------------------------------------------------------------
void inserirCandidato(TDados **dados, char combinac[], float freq, TCandidato **inicio, int i, int j, int k)
{
	TCandidato *novoCandidato = (TCandidato *)malloc(sizeof(TCandidato));

	TCandidato *atual = NULL;
	TCandidato *ante = NULL;
	
	if((*inicio) == NULL)
	{
		(*inicio) = novoCandidato;
		novoCandidato->ante = NULL;
		novoCandidato->prox = NULL;
	}
	else
	{
		atual =	(*inicio);
		while(atual != NULL)
		{
				if(atual->prox == NULL)
			{
				atual->prox = novoCandidato;
				novoCandidato->prox = NULL;
				novoCandidato->ante = ante;
			}
			ante = atual;	
			atual = atual->prox;
		}		
	}
	limpar(novoCandidato);
	
	if(i == 0 || j == 0 || k == 0) novoCandidato->leite = 1;
	if(i == 1 || j == 1 || k == 1) novoCandidato->pao = 1;
	if(i == 2 || j == 2 || k == 2) novoCandidato->bolacha = 1;
	if(i == 3 || j == 3 || k == 3) novoCandidato->suco = 1;
	if(i == 4 || j == 4 || k == 4) novoCandidato->ovos = 1;
	if(i == 5 || j == 5 || k == 5) novoCandidato->cafe = 1;
	if(i == 6 || j == 6 || k == 6) novoCandidato->manteiga = 1;
	
	novoCandidato->frequencia = freq;
	strcpy(novoCandidato->combinacao, combinac);
}
// ----------------------------------------------------------------------
void limpar(TCandidato *novoCandidato)
{
	novoCandidato->leite = 0;
	novoCandidato->pao = 0;
	novoCandidato->bolacha = 0;
	novoCandidato->suco = 0;
	novoCandidato->ovos = 0;
	novoCandidato->cafe = 0;
	novoCandidato->manteiga = 0;
	novoCandidato->frequencia = 0;
	strcpy(novoCandidato->combinacao, "");
}
// ----------------------------------------------------------------------
void tabela1ItensFrequentes(TDados *dados)
{
	TEntrada *itensFreq = (TEntrada *)malloc(sizeof(TEntrada));
	TCandidato *atual = dados->candidatos1Item;
	dados->tabelaItensFrequentes = itensFreq;
	
	while(atual != NULL)
	{
		
		if(atual->frequencia >= dados->frequenciaMinima)
		{
			if(strcmp(atual->combinacao, "leite") == 0) itensFreq->leite = 1;
			else if(strcmp(atual->combinacao, "pao") == 0) itensFreq->pao = 1;
			else if(strcmp(atual->combinacao, "bolacha") == 0) itensFreq->bolacha = 1;
			else if(strcmp(atual->combinacao, "suco") == 0) itensFreq->suco = 1;
			else if(strcmp(atual->combinacao, "ovos") == 0) itensFreq->ovos = 1;
			else if(strcmp(atual->combinacao, "cafe") == 0) itensFreq->cafe = 1;
			else if(strcmp(atual->combinacao, "manteiga") == 0) itensFreq->manteiga = 1;
		}
		atual = atual->prox;
	}
	itensFreq->id = -1;
}
// ----------------------------------------------------------------------
void gerarCandidatos(TDados *dados, int tipoDeCand)
{
	TEntrada *tbItensFreq = dados->tabelaItensFrequentes;
	TEntrada *atual = dados->entrada;
	int qtd = 2;
	float freq = 0;
	int i, j, k;
	int vetor[7]; // -> vetor auxiliar para comparar a existencia dos itens com a posicao do vetor
	char comb[100] = ""; // -> vetores auxiliares para permutar o char comb[100];
	char vetorcomb[7][100] = {"leite", "pao", "bolacha", "suco", "ovos", "cafe", "manteiga"};
	vetor[0] = tbItensFreq->leite; 
	vetor[1] = tbItensFreq->pao;
	vetor[2] = tbItensFreq->bolacha;
	vetor[3] = tbItensFreq->suco;
	vetor[4] = tbItensFreq->ovos;
	vetor[5] = tbItensFreq->cafe;
	vetor[6] = tbItensFreq->manteiga;
	
	if(tipoDeCand == 2) //-> permutação com 2 candidatos 
	{
		for(i = 0; i < 7; i++)
		{
			for(j = i + 1; j < 7; j++)
			{
				if(vetor[i] == 1 && vetor[j] == 1)
				{
					strcat(comb, vetorcomb[i]); strcat(comb, "->");
					strcat(comb, vetorcomb[j]);
					freq = verificaFrequencia(dados, i, j, 0); // -> verifica a frequência da combinação
					inserirCandidato(&dados, comb, freq, &dados->candidatos2Itens, i, j, k); //-> insere candidato
				}
				strcpy(comb, "");
			}
		} 
	}
	else if(tipoDeCand == 3) //-> permutação com 3 candidatos 
	{
		for(i = 0; i < 7; i++)
		{
			for(j = i + 1; j < 7; j++)
			{
				for(k = j + 1; k< 7; k++)
				{
					if(vetor[i] == 1 && vetor[j] == 1 && vetor[k] == 1)
				{
					strcat(comb, vetorcomb[i]); strcat(comb, "->");
					strcat(comb, vetorcomb[j]); strcat(comb, "->");
					strcat(comb, vetorcomb[k]);
					freq = verificaFrequencia(dados, i, j, k); // -> verifica a frequência da combinação
					inserirCandidato(&dados, comb, freq, &dados->candidatos3Itens, i, j, k); //-> insere candidato
				}
				strcpy(comb, "");
				}	
			}
		} 
	}
}
// ----------------------------------------------------------------------
float ocorrenciaConf(TDados *dados, int a, int b, int c)
{
	TEntrada *atual = dados->entrada;
	float confiab;
	float totalA = 0;
	float totalAB = 0;
	float totalB = 0;
	float totalB_2 = 0;
	float totalC = 0;
	// -> verifica ocorrencia de ab e depois c 
	for(atual; atual != NULL; atual = atual->prox)
	{
		switch(a)
		{
			case 0: if(atual->leite == 1) totalA++; break;
			case 1: if(atual->pao == 1) totalA++; break;	
			case 2: if(atual->bolacha == 1) totalA++; break;			
			case 3:	if(atual->suco == 1) totalA++; break;
			case 4: if(atual->ovos == 1) totalA++; break;
			case 5: if(atual->cafe == 1) totalA++; break;
			case 6:	if(atual->manteiga == 1) totalA++; break;
		}
		switch(b)
		{
			case 0: if(atual->leite == 1) totalB++; break;
			case 1: if(atual->pao == 1) totalB++; break;	
			case 2: if(atual->bolacha == 1) totalB++; break;			
			case 3:	if(atual->suco == 1) totalB++; break;
			case 4: if(atual->ovos == 1) totalB++; break;
			case 5: if(atual->cafe == 1) totalB++; break;
			case 6:	if(atual->manteiga == 1) totalB++; break;
		}
		switch(c)
		{
			case 0: if(atual->leite == 1) totalC++; break;
			case 1: if(atual->pao == 1) totalC++; break;	
			case 2: if(atual->bolacha == 1) totalC++; break;			
			case 3:	if(atual->suco == 1) totalC++; break;
			case 4: if(atual->ovos == 1) totalC++; break;
			case 5: if(atual->cafe == 1) totalC++; break;
			case 6:	if(atual->manteiga == 1) totalC++; break;
		}
		totalB_2 += totalB;
		if(totalA == 1 && totalB == 1) totalAB++;
		totalA = 0; totalB = 0;
	}
	if(c == -1) confiab = totalAB/totalB_2;
	else confiab = (float)(totalAB/totalC);
	return  confiab;
}
// ----------------------------------------------------------------------
float verificaFrequencia(TDados *dados, int i, int j, int k)
{
	TEntrada *atual = dados->entrada;
	float freq = 0;
	float total = 0;
	int aux = 0;
	
	while(atual != NULL)
	{
		switch(i)
		{
			case 0: if(atual->leite == 1) aux++; break;
			case 1: if(atual->pao == 1) aux++; break;	
			case 2: if(atual->bolacha == 1) aux++; break;			
			case 3:	if(atual->suco == 1) aux++; break;
			case 4: if(atual->ovos == 1) aux++; break;
			case 5: if(atual->cafe == 1) aux++; break;
			case 6:	if(atual->manteiga == 1) aux++; break;
		}
		switch(j)
		{
			case 1: if(atual->pao == 1) aux++; break;	
			case 2: if(atual->bolacha == 1) aux++; break;			
			case 3:	if(atual->suco == 1) aux++; break;
			case 4: if(atual->ovos == 1) aux++; break;
			case 5: if(atual->cafe == 1) aux++; break;
			case 6:	if(atual->manteiga == 1) aux++; break;
		}
		if(k > 0)
		{
			switch(k)
			{	
				case 2: if(atual->bolacha == 1) aux++; break;			
				case 3:	if(atual->suco == 1) aux++; break;
				case 4: if(atual->ovos == 1) aux++; break;
				case 5: if(atual->cafe == 1) aux++; break;
				case 6:	if(atual->manteiga == 1) aux++; break;
			}
		}
		if(k > 0 && aux == 3) total++; 
		if(aux == 2 && k == 0) total++;
		atual = atual->prox;
		aux = 0;
	}
	total = total/dados->totalCand; 
	
	return total;
}
// ----------------------------------------------------------------------
int gerarGrupoCandidatos(TDados *dados, int tipoCand, int tipo_operac)
{
	int aux = 0;
	int teste = 0;
	int tipo_operacao = tipo_operac;
	TCandidato *cand = NULL;
	tipoCand == 2 ? cand = dados->candidatos2Itens: cand = dados->candidatos3Itens;
	// -> verifica se existe pelo menos um com freq >= 50
	while(cand != NULL)
	{	
		if(cand->frequencia >= 0.50) {
			aux = 1; 
		}
		cand = cand->prox;
	}
	tipoCand == 2 ? cand = dados->candidatos2Itens: cand = dados->candidatos3Itens;
	if(aux == 1)
	{
		while(cand != NULL)
		{
			if(cand->frequencia >= 0.50 && tipoCand == 2)
			{
				tipo_operacao = 2;
				insereNoGrupo(&dados->tabelaGrupoItensFrequentes, cand, cand->combinacao, 0);
			}
			else if(cand->frequencia >= 0.50)
			{
				tipo_operacao = 3;
				if(teste == 0)
				{
					dados->tabelaGrupoItensFrequentes = NULL;
					teste = 1;
				}
				insereNoGrupo(&dados->tabelaGrupoItensFrequentes, cand, cand->combinacao, 0);
			}
			cand = cand->prox;
		}
	}
	return tipo_operacao;
}
// ----------------------------------------------------------------------
void insereNoGrupo(TCandidato **inicio, TCandidato *cand, char comb[], float conf)
{
	TCandidato *novoC = (TCandidato *)malloc(sizeof(TCandidato));
	TCandidato *atual = NULL;
	TCandidato *ante = NULL;
	
	if((*inicio) == NULL)
	{
		(*inicio) = novoC;
		novoC->ante = NULL;
		novoC->prox = NULL;
	}
	else
	{
		atual =	(*inicio);
		while(atual != NULL)
		{
				if(atual->prox == NULL)
			{
				atual->prox = novoC;
				novoC->prox = NULL;
				novoC->ante = ante;
			}
			ante = atual;	
			atual = atual->prox;
		}		
	}
	novoC->leite = cand->leite;
	novoC->pao = cand->pao;
	novoC->bolacha = cand->bolacha;
	novoC->suco = cand->suco;
	novoC->ovos = cand->ovos;
	novoC->cafe = cand->cafe;
	novoC->manteiga = cand->manteiga;
	novoC->frequencia = cand->frequencia;
	novoC->confiabilidade = conf;
	strcpy(novoC->combinacao, comb);
}
// ----------------------------------------------------------------------
void confiabilidade(TDados *dados, int tipo_operacao) 
{
	TCandidato *atual = NULL;
	TEntrada *atualE = dados->entrada;
	int ab[7];
	limpaVet(ab);
	int inverte = 0;
	int i, j, k = 0;
	int a = -1; int b = -1; int c = -1;
	int aux = 0;
	int numIntegrantes = 0;
	float confiabilidade = 0;
	float total = 0;
	char combinacao[100] = "";
	for(atual = dados->tabelaGrupoItensFrequentes; atual != NULL; atual = atual->prox)
	{
		numIntegrantes++;
	}

		for(atual = dados->tabelaGrupoItensFrequentes, i = 0, k = 0; atual != NULL && k < numIntegrantes; atual = atual->prox)
	{
		if(atual->leite == 1) ab[i] = 1; i++; 
		if(atual->pao == 1) ab[i] = 1; i++;
		if(atual->bolacha == 1) ab[i] = 1; i++;		
		if(atual->suco == 1) ab[i] = 1; i++;
		if(atual->ovos == 1) ab[i] = 1; i++;
		if(atual->cafe == 1) ab[i] = 1; i++;
		if(atual->manteiga == 1) ab[i] = 1; 	
		while(aux < 7)
		{
				if(ab[aux] == 1)
				{
					if(a == -1 && b == -1 && c == -1) a = aux;
					else if(a != -1 && b == -1 && c == -1) b = aux;
					else if(a != -1 && b != -1 && c == -1) c = aux;
				}
				aux++;
		}
		if(tipo_operacao == 2)
		{
			confiabilidade = ocorrenciaConf(dados, a, b, c);
			atual->confiabilidade = confiabilidade;
			
			confiabilidade = ocorrenciaConf(dados, b, a, c);
			gerarComb(dados, atual, b, a, c, confiabilidade);
	
		}
		else
		{
			confiabilidade = ocorrenciaConf(dados, a, b, c);
			atual->confiabilidade = confiabilidade;
			
			confiabilidade = ocorrenciaConf(dados, a, c, b);
			gerarComb(dados, atual, b, a, c, confiabilidade);
			
			confiabilidade = ocorrenciaConf(dados, b, c, a);
			gerarComb(dados, atual, b, a, c, confiabilidade);
		}
		
		a = -1; b = -1;	c = -1;
		aux = 0; i = 0;
		k++;
		limpaVet(ab); 
	}
	
}
// ----------------------------------------------------------------------
void gerarRegrasFortes(TDados *dados)
{
	TCandidato *atual = NULL;
	
	for(atual = dados->tabelaGrupoItensFrequentes; atual != NULL; atual = atual->prox)
	{
		if(atual->confiabilidade >= dados->confiancaMinima)
		{
			insereNoGrupo(&dados->regrasFortes, atual, atual->combinacao, atual->confiabilidade);
		}
	}
}
// ----------------------------------------------------------------------
void limpaVet(int vet[])
{
	int i = 0;
	while(i < 7){
		vet[i] = 0; i++;
	}
}
// ----------------------------------------------------------------------
void gerarComb(TDados *dados, TCandidato *atual, int a, int b, int c, float confiab)
{
	char combA[100] = "";
	char combB[100] = "";
	char combC[100] = "";
	int autoriza = 0;
	switch(a)
	{
		case 0: strcpy(combA, "leite"); break;
		case 1: strcpy(combA, "pao"); break;
		case 2: strcpy(combA, "bolacha"); break;
		case 3: strcpy(combA, "suco"); break;
		case 4: strcpy(combA, "ovos"); break;
		case 5: strcpy(combA, "ovos"); break;
		case 6: strcpy(combA, "manteiga"); break;
	}
	switch(b)
	{
		case 0: strcpy(combB, "leite"); break;
		case 1: strcpy(combB, "pao"); break;
		case 2: strcpy(combB, "bolacha"); break;
		case 3: strcpy(combB, "suco"); break;
		case 4: strcpy(combB, "ovos"); break;
		case 5: strcpy(combB, "ovos"); break;
		case 6: strcpy(combB, "manteiga"); break;
	}
	switch(c)
	{
		case 0: strcpy(combC, "leite"); break;
		case 1: strcpy(combC, "pao"); break;
		case 2: strcpy(combC, "bolacha"); break;
		case 3: strcpy(combC, "suco"); break;
		case 4: strcpy(combC, "ovos"); break;
		case 5: strcpy(combC, "ovos"); break;
		case 6: strcpy(combC, "manteiga"); break;
	}
	if(c == -1) 
	{
	strcat(combA, "->"); strcat(combA, combB); 
	}
	else {
		strcat(combA, "->"); strcat(combA, combB); strcat(combA, "->"); strcat(combA, combC);
	}
	autoriza = verificaExistenciaDaComb(dados, combA);
	if(autoriza) insereNoGrupo(&dados->tabelaGrupoItensFrequentes, atual, combA, confiab);
}
// ----------------------------------------------------------------------
int verificaExistenciaDaComb(TDados *dados, char comb[])
{
	TCandidato *atual = NULL;
	for(atual = dados->tabelaGrupoItensFrequentes; atual != NULL; atual = atual->prox)
	{
		if(strcmp(atual->combinacao, comb) == 0) return 0;
	}
	return 1;
}
// ----------------------------------------------------------------------
