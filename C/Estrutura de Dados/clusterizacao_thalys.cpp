#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include<time.h>
#include<locale.h>
/**
  *-----------------------------------------*
  *	Aluno: Thalys Fabrete Cândido			*
  * Turma: Sistemas de Informação V06		*
  *	Disciplina: Estrutura de Dados			*
  *-----------------------------------------*
  */
typedef struct tipoElemento {
	float altura;
	float peso;
	float sexo; //0 = homem e 1 = mulher
	char classe[40];
	tipoElemento *ante, *prox;
	int grupo;
	float distancia;
}TElemento;

typedef struct tipoGrupo {
	int grupo;
	TElemento *centroide;
	TElemento *inicio;
	tipoGrupo *ante, *prox;
}TGrupo;

typedef struct tipoLista {
	TGrupo *inicio;
	TGrupo *fim;
	int k;
}TLista;

TLista lista;
//=================================================================================
void inicializa(TLista *L);
void insereElemento(TLista **L, float alt, float pes, float sx);
void exibeElementosNaoAgrupados(TLista *L);
void exibeGrupos(TLista *L);
void agrupaInstancias(TLista *L);
void sobre();
void selecaoDeCentroides(TLista *L);
void avaliacao(TLista *L);
void recalculaCentroide(TLista *L, int tipoDeAlteracao);
void imc(TLista *L, TElemento * atual);
void calcularDistancia(TLista *L);

//=================================================================================

int main(){
   setlocale(LC_ALL, "Portuguese");
   inicializa(&lista);
   exibeElementosNaoAgrupados(&lista);
   exibeGrupos(&lista); // -> Grupos originais
   agrupaInstancias(&lista);
   
   // -> Aqui eu recalculo o centróide de todos grupos incluindo assim o centróide original como instância comum do grupo
   recalculaCentroide(&lista, 1);
   printf("\n\n ################################## - CENTROIDES RECALCULADOS 1º PASSO - ##################################\n\n");
   exibeGrupos(&lista); // -> grupo depois da primeira passagem da função de recalculo de centroides
   
   printf("\n\n ################################## - CENTROIDES RECALCULADOS 2º PASSO - ##################################\n\n");
   
   // -> Aqui é onde ocorre o processo do recálculo das distâncias, onde caso a instância possua uma distância menor para o centróide...
   // -> ...Que foi anteriomente recalculado, esta será então transferida para o grupo cuja distância é menor, e então os centroides são...
   // -> ... Recalculados com base na média dos grupos, e o processo é totalmente repetido até que não ocorram mais modificações.
   calcularDistancia(&lista);
 
   exibeGrupos(&lista); // -> grupo com todas modificações já concluídas
   printf("\n\n ################################## - FIM DO PROGRAMA - ##################################\n\n");
}

//=================================================================================
void inicializa(TLista *L){
	int k;
	TGrupo *novo = (TGrupo *)malloc(sizeof(TGrupo));
	
	printf("\n\n\t\t=====| CONFIGURACAO INICIAL |=====\n\n\tInforme Total de Classes (K): ");
	scanf("%d",&k);
	
	L->inicio = novo;
	L->fim = novo;
	L->k = k;
	
	novo->ante = NULL;
	novo->prox = NULL;
	novo->centroide = NULL;
	novo->grupo = 0;
	novo->inicio = NULL;
	
	TGrupo *atual = novo;
	
	int i = 0;
	for(i = 0; i < k; i++){
	   //Cria??o dos Grupos (Clusters):
	   novo = (TGrupo *)malloc(sizeof(TGrupo));
	   novo->grupo = atual->grupo + 1;
	   novo->ante = atual;
	   atual->prox = novo;
	   novo->prox = NULL;
	   L->fim = novo;
	   novo->centroide = NULL;
	   novo->inicio = NULL;
	   
	   atual = novo;
	}//for

    insereElemento(&L,1.78,98.0,0.0);
    insereElemento(&L,1.72,72.0,0.0);
    insereElemento(&L,1.85,96.0,0.0);
    insereElemento(&L,1.82,106.0,0.0);
    insereElemento(&L,1.70,59.5,1.0);
    insereElemento(&L,1.69,46.3, 1.0);
    insereElemento(&L,1.57,89.0, 1.0);
    insereElemento(&L,1.70,69.2, 0.0);
    insereElemento(&L,1.94,99.7, 0.0);
    insereElemento(&L,1.56,51.0, 1.0);
	insereElemento(&L,1.65,120.0, 0.0);	
	
	// -> Testando o algoritmo com mais elementos
	
	insereElemento(&L,1.59,58.3, 1.0);
    insereElemento(&L,1.77,99.0, 1.0);
    insereElemento(&L,1.42,69.2, 0.0);
    insereElemento(&L,1.84,119.7, 0.0);
    insereElemento(&L,1.66,61.0, 1.0);
	insereElemento(&L,1.55,60.0, 0.0);	
	insereElemento(&L,1.55,70.0, 0.0);	
	insereElemento(&L,1.96,70.0, 0.0);	
	insereElemento(&L,1.87,80.0, 0.0);	
	
	insereElemento(&L,1.76,90.0, 0.0);	
	insereElemento(&L,1.86,80.0, 1.0);	
	insereElemento(&L,1.95,90.0, 0.0);	
	insereElemento(&L,1.45,50.0, 1.0);
	
	insereElemento(&L,1.52,78.0, 0.0);	
	insereElemento(&L,1.86,92.0, 0.0);	
	insereElemento(&L,2.0,91.0, 0.0);	
	insereElemento(&L,1.65,60.0, 0.0);	
	insereElemento(&L,1.75,90.0, 0.0);	
	insereElemento(&L,1.88,90.0, 1.0);	
	insereElemento(&L,1.95,90.0, 0.0);	
	insereElemento(&L,1.45,50.0, 1.0);
		
	insereElemento(&L,1.52,48.0, 1.0);	
	insereElemento(&L,1.66,52.0, 0.0);	
	insereElemento(&L,2.0,101.0, 1.0);	
	insereElemento(&L,1.55,30.0, 0.0);	
	insereElemento(&L,1.75,100.0, 1.0);	
	insereElemento(&L,1.58,60.0, 1.0);	
	insereElemento(&L,1.55,50.0, 0.0);	
	insereElemento(&L,1.75,40.0, 1.0);
	insereElemento(&L,1.6,50.0, 1.0);		
}
//=================================================================================
void insereElemento(TLista **L, float alt, float pes, float sx){
	float imc;
	
	TElemento *novo = (TElemento *)malloc(sizeof(TElemento));
	
	novo->altura = alt;
	novo->peso = pes;
	novo->sexo = sx;
	novo->ante = NULL;
	novo->prox = NULL;
	
	novo->grupo = 0;
	novo->distancia = -1.0;
	
	imc = (pes / (alt * alt));
	
	if (imc < 18.5){
		strcpy(novo->classe,"MAGREZA");
	} else if((imc >= 18.5) &&(imc <= 24.9)){
		strcpy(novo->classe,"NORMAL");
	} else if((imc >= 25) && (imc <= 29.9)){
		strcpy(novo->classe,"SOBREPESO");
	} else if ((imc >= 30.0) && (imc <= 39.9)){
		strcpy(novo->classe,"OBESIDADE");
	} else {
		strcpy(novo->classe,"OBESIDADE GRAVE");
	}
	
	if((*L)->inicio->inicio == NULL){
		(*L)->inicio->inicio = novo;
	} else {
		TElemento *atual = (*L)->inicio->inicio;
		
		while(atual->prox != NULL){
			atual = atual->prox;
		}//while
		atual->prox = novo;
		novo->ante = atual;
	}//if
	
}
//=================================================================================
void exibeElementosNaoAgrupados(TLista *L){
	int cont = 1;
	TElemento *atual = L->inicio->inicio;
	printf("\n\n\n\t\t=====| ELEMENTOS NAO AGRUPADOS |=====\n\n");
	
	while(atual != NULL){
	 printf("\n(%d)\nALTURA: %.2f\tPESO: %.2f", cont, atual->altura, atual->peso);
	 printf("\tSEXO: %.0f\n",  atual->sexo);
	 printf("%s\n",atual->classe);
	 printf("+------------------------------------------------------------------+\n");
	 atual = atual->prox;
	 cont++;
	}//while
	printf("\n\n");
	system("PAUSE");
}
//=================================================================================
void exibeGrupos(TLista *L){
	TGrupo *atualG = L->inicio;
	char sx;
	int cont = 0;
	
	printf("\n\n\t\t=====| EXIBE GRUPOS |=====\n\n");
	
	while(atualG != NULL){
	   printf("GRUPO: (%d)\n\tCENTROIDE: ",atualG->grupo);
	   TElemento *atualE = atualG->centroide;
	   
	   if(atualE == NULL){
	   	  printf("***** NENHUM *****\n");
	   } else {
          if (atualE->sexo == 0){
          	  sx = 'M';
		  } else {
		  	  sx = 'F';
		  }//if ... else
	   	  printf("[%c] - %.2f m - %.2f kg - ", sx,atualE->altura,atualE->peso);
	   	  printf("%s\n", atualE->classe);
	   }//if ... else
	   
	   printf("\tINSTANCIAS:\n");
	   atualE = atualG->inicio;
	   if(atualE == NULL){
	   	   printf("\t\t***** NENHUMA INSTANCIA *****\n");
	   }//if
	   
	   while (atualE != NULL){
          if (atualE->sexo == 0){
          	  sx = 'M';
		  } else {
		  	  sx = 'F';
		  }//if ... else
	   	  printf("\t\t%d [%c] - %.2f m - %.2f kg", ++cont,sx,atualE->altura,atualE->peso);
	   	  printf(" - %s\n", atualE->classe);
		  atualE = atualE->prox;	 	   	
	   }//while
	   printf("+-------------------------------------------------------------+\n");
	   atualG = atualG->prox;
	}//while
	
	printf("\n\n");
	system("PAUSE");
}

//=================================================================================
void agrupaInstancias(TLista *L){
   sobre();	
   selecaoDeCentroides(L);
   
   avaliacao(L);
   
   //Temporario
   exibeElementosNaoAgrupados(L);
   exibeGrupos(L);
   //Fim-Temporario
   
}
//=================================================================================
void sobre(){
	printf("\n\n\t\t\t======| SOBRE |======\n\n");
	printf("Este programa executa o ALGORITMO K-MEANS com o intuito de AGRUPAR dados de\n");
	printf("PESSOAS (PESO, ALTURA e SEXO).\n\n");
	printf("O USUARIO deve escolher previamente a quantidade de GRUPOS(k) em que cada\n");
	printf("PESSOA podera ser encaixada.\n\n");
	printf("Para cada GRUPO existente sera escolhido aleatoriamente um CENTROIDE dentre\n");
	printf("as INSTANCIAS de PESSOAS disponibilizadas. Posteriormente tais CENTROIDES\n");
	printf("poderao ser reajustados (substituidos por outras INSTANCIAS).\n\n");
	printf("Em seguida, o PROGRAMA calculara a DISTANCIA EUCLIDIANA entre cada INSTANCIA\n");
	printf("e o CENTROIDE de cada GRUPO. A MENOR distancia VENCE. Ou seja, a INSTANCIA\n");
	printf("sera REALOCADA para o GRUPO cujo CENTROIDE tiver a MENOR DISTANCIA em relacao a ela\n");
	printf("\n---------------------------------------------------------------------------------------\n");
	printf("Logo após iremos colocar os CENTROIDES antes aleatoriamente selecionados \n");
	printf("como instância comum de seus respectivos grupos\n\n");
	printf("Os novos centroides serão calculados com base na MÉDIA DOS VALORES das instâncias do grupo\n\n");
	printf("Após isso iremos recalcular as distâncias de todas instâncias em relação aos novos centroides\n");
	printf("realocando as instâncias se necessário aos grupos cuja distância do centroide é menor\n\n");
	printf("A cada modificação:  centroides serão recalculados,  distância das instancias recalculada \n");
	printf("e as alterações necessárias também serão feitas\n\n");
	printf("Esse processso será refeito ENQUANTO HOUVER OCORRÊNCIA DE ALTERAÇÕES\n\n");
	printf("\n---------------------------------------------------------------------------------------\n");
	system("PAUSE");
}
//===================================================================================
void selecaoDeCentroides(TLista *L){
	printf("\n\n\nEXECUTANDO SELECAO DE CENTROIDES ...\n");
	int i, r, pos, total = 0, grupo = 1;
	TElemento *atual = L->inicio->inicio;
	
	while(atual != NULL){
		total++;
		atual = atual->prox;
	}//while
	
	for(i=0; i <= L->k; i++){
	   srand(time(NULL));	// -> para garantir que sempre iremos gerar de fato um valor aleatório novo			
       r = rand(); //A fun??o rand() est? na biblioteca stdlib.h		
       r = r % total;
	   atual = L->inicio->inicio;
	   pos = 0;
	   while (atual != NULL){
	       if(pos == r)    {
	       	  //Selecionado ELEMENTO para CENTROIDE
	       	  TElemento *anterior = atual->ante;
	       	  TElemento *posterior = atual->prox;
	       	  
	       	  if(anterior != NULL){
	       	    anterior->prox = posterior;	
			  } else {
			  	L->inicio->inicio = posterior;
			  }//if... else
			  
			  if(posterior != NULL){
			  	posterior->ante = anterior;
			  } //if
			  
			  atual->ante = NULL;
			  atual->prox = NULL;
	       	  
	       	  //atual foi desconectado da LISTA ORIGINAL
	       	  TGrupo *atualGrupo = L->inicio;
			  while (atualGrupo != NULL){
			  	//buscando GRUPO para encaixar atual como CENTROIDE
			  	if(atualGrupo->grupo == grupo){
			  	   //Encontrou o Grupo
				   atualGrupo->centroide = atual;	
				}//if
				atualGrupo = atualGrupo->prox;
			  }//while
	       	  
	       	  grupo++;
	       	  break;
		   }//if
		   atual = atual->prox;
		   pos++;
       }//while
		
	}//for
}
//===================================================================================
void avaliacao(TLista *L){
	TElemento *atual = L->inicio->inicio;
	TElemento *centroide;
	TGrupo *g;
	float dis, grupo;
	
	while(atual != NULL){
	   g = L->inicio->prox;
	   while(g != NULL)	{
	   	 centroide = g->centroide;
	   	 dis = pow((atual->altura - centroide->altura), 2);
	   	 dis = dis + pow((atual->peso - centroide->peso), 2);
	   	 dis = dis + pow((atual->sexo - centroide->sexo), 2);
	   	 dis = sqrt(dis);
	   	 
	   	 if(atual->distancia == -1){
	   	 	atual->distancia = dis;
	   	 	atual->grupo = g->grupo;
		 } else if(atual->distancia > dis){
		 	atual->distancia = dis;
		 	atual->grupo = g->grupo;
		 }//if...else
		 
		 g = g->prox;
	   }//while
	   atual = atual->prox;
	}//while
	
	//==redistribuindo instancias para grupos
	TElemento *posterior, *removido, *corrente;
	
	atual = L->inicio->inicio;
	while(atual != NULL){
	   posterior = atual->prox;
	   removido = atual;
	   
	   removido->ante = NULL;
	   removido->prox = NULL;
	      
	   if(posterior != NULL){
	   	  posterior->ante = NULL;
	   }//if
	   L->inicio->inicio = posterior;
	   
	   //==Inserindo REMOVIDO no GRUPO a que pertence
	   g = L->inicio->prox;
	   while(g != NULL){
	   	  if(g->grupo == removido->grupo){
	   	      corrente = g->inicio;
			  if(corrente == NULL){
			  	 g->inicio = removido;
			  } else {
			     while(corrente->prox != NULL){
			     	corrente = corrente->prox;
				 }//while
				 corrente->prox = removido;
				 removido->ante = corrente;
			  }//if
		  }//if
		  g = g->prox;
	   }//while
	   
	   //==Movendo para a pr?xima inst?ncia.
	   
       atual = posterior;
	}//while
}
//===================================================================================

void recalculaCentroide(TLista *L, int tipoDeAlteracao)
{
	TGrupo *atualG = L->inicio;
	
	float mediaAltura = 0;
	float mediaPeso = 0;
	int totalElementos = 0;
	
	// -> 1ª parte:
	// -> incluindo centróide como parte das instâncias do grupo
	// -> alocando memória para o novo centróide
	if(tipoDeAlteracao == 1)
	{
			while(atualG != NULL)
		{
			
			if(atualG->grupo != NULL)
			{
				
				TElemento *atualE = atualG->inicio;
				TElemento *proxE = NULL;
				// -> Incluindo o centroide como parte do grupo
				// -> O centróide irá para o início da lista
				if(atualE == NULL) //-> Caso o grupo esteja vazio, basta inserir o centróide no início
				{
					atualG->inicio = atualG->centroide;
					atualG->inicio->grupo = atualG->grupo; 
				}
				else // -> caso não: salvo a posição do início para que o novo início tenha ele como prox
				{	 // -> e o inicio anterior tem como ante o novo inicio
					proxE = atualE;
					atualE->ante = atualG->centroide;
					atualG->inicio = atualG->centroide;
					atualG->inicio->prox = proxE;
					atualG->inicio->grupo = atualG->grupo; 
				}
				// -> media dos dados para redefinir o centróide
				// -> Resgatando a quantidade de elementos do grupo
		
				for(atualE = atualG->inicio, totalElementos = 0; atualE != NULL; atualE = atualE->prox)
				{
					totalElementos++;
				}	
				// -> Agrupando os valores da altura e peso dos elementos do grupo
				for(atualE = atualG->inicio, mediaAltura = 0, mediaPeso = 0; atualE != NULL; atualE = atualE->prox)
				{
					mediaAltura += atualE->altura;
					mediaPeso += atualE->peso;
				}
				// -> Calculando as respectivas médias
				mediaAltura = mediaAltura/totalElementos;
				mediaPeso = mediaPeso/totalElementos; 
				
				// -> definindo o novo Centróide
				// -> Como estou tornando a posição de memória do centróide o novo início do grupo
				// -> Preciso de uma posição de memória nova para que os valores do início do grupo não sejam sobrescritos
				TElemento *novoCentroide = (TElemento *)malloc(sizeof(TElemento));
				atualG->centroide = novoCentroide;
				
				atualG->centroide->altura = mediaAltura;
				atualG->centroide->peso = mediaPeso;
				atualG->centroide->distancia = -1;
				atualG->centroide->grupo = 0;
				atualG->centroide->sexo = atualG->inicio->sexo;
				imc(L, atualG->centroide); // -> Calculando o imc do novo centróide

			}
			atualG = atualG->prox;	
		}
	}
	else // -> Quando há modificação no grupo, apenas vamos o recálculo das instâncias(média), para gerar o novo centróide
	{    // -> Mesmo se o grupo não sofreu modificação, a sua média será igual a média anterior, portanto apenas grupos alterados irão receber um novo centróide
		while(atualG != NULL)
		{
		
			if(atualG->grupo != NULL)
			{
				TElemento *atualE = atualG->inicio;
				for(atualE = atualG->inicio, totalElementos = 0; atualE != NULL; atualE = atualE->prox)
				{
					totalElementos++;
				}	
					
				for(atualE = atualG->inicio, mediaAltura = 0, mediaPeso = 0; atualE != NULL; atualE = atualE->prox)
				{
					mediaAltura += atualE->altura;
					mediaPeso += atualE->peso;
				}
				
				mediaAltura = mediaAltura/totalElementos;
				mediaPeso = mediaPeso/totalElementos; 
				if(mediaAltura <= 0 || mediaPeso <= 0) // -> Se o grupo está vazio, ele será zerado
				{
					atualG->centroide->altura = 0;
					atualG->centroide->peso = 0;
					atualG->centroide->distancia = 0;
					atualG->centroide->grupo = 0;
					atualG->centroide->sexo = 0;
					strcpy(atualG->centroide->classe,"0");
				}
				else
				{
					atualG->centroide->altura = mediaAltura;
					atualG->centroide->peso = mediaPeso;
					atualG->centroide->distancia = -1;
					atualG->centroide->grupo = 0;
					imc(L, atualG->centroide); // -> Calculando o imc do novo centróide
				}
				
			}
			atualG = atualG->prox;
		}
	}
	
}
//===================================================================================
void imc(TLista *L, TElemento * atual)
{
	TElemento *elemento = atual;
	float imc = (elemento->peso / (elemento->altura * elemento->altura));
	if (imc < 18.5){
				
			strcpy(elemento->classe,"MAGREZA");
			} 
			
			else if((imc >= 18.5) &&(imc <= 24.9))
			{
				strcpy(elemento->classe,"NORMAL");
			} 
			else if((imc >= 25) && (imc <= 29.9))
			{
				strcpy(elemento->classe,"SOBREPESO");
			}
			 else if ((imc >= 30.0) && (imc <= 39.9))
			 {
				strcpy(elemento->classe,"OBESIDADE");
			 } 
			 else{
					strcpy(elemento->classe,"OBESIDADE GRAVE");
				}
}
//===================================================================================
void calcularDistancia(TLista *L)
{
	float dis;
	float menorDis;
	int aux = 0;
	int grupo = 0;
	int houveMod = 0;
	TGrupo *atualG = L->inicio;
	TGrupo *percorreG = L->inicio;
	
	TElemento *atualE = NULL;
	TElemento *atualT = NULL;
	TElemento *centroide = NULL;
	TElemento *transfere = NULL;
	TElemento *atualizaAnte = NULL;
	TElemento *atualizaProx = NULL;
	
	while(atualG != NULL)
	{
		atualE = atualG->inicio;
		while(atualE != NULL)
		{
				aux = 0;
				// -> LOOP QUE COLETA A MENOR DISTÂNCIA DA INSTÂNCIA EM RELAÇÂO AOS CENTRÓIDES
				for(percorreG = L->inicio->prox; percorreG != NULL; percorreG = percorreG->prox)
			{
					centroide =  percorreG->centroide;
				
					dis = pow((atualE->altura - centroide->altura), 2);
					dis = dis + pow((atualE->peso - centroide->peso), 2);
					dis = dis + pow((atualE->sexo - centroide->sexo), 2);
					dis = sqrt(dis);
					if(aux == 0)
					{
						menorDis = dis;
						grupo = percorreG->grupo; // -> ATRIBUINDO A VARIÁVEL GRUPO O GRUPO QUE CONTÉM O CENTROÍDE MAIS PRÓXIMO
						aux = 1;
					}
					if(dis < menorDis)
					{
						menorDis = dis;
						grupo = percorreG->grupo; // -> ATRIBUINDO A VARIÁVEL GRUPO O GRUPO QUE CONTÉM O CENTROÍDE MAIS PRÓXIMO
					}							
			}
			
			if(atualE->grupo == grupo) // -> SE A INSTÂNCIA NÃO SERA REALOCADA, APENAS SUA DISTÂNCIA EM RELAÇÃO...
			{						   //... AO SEU CENTRÓIDE SERÁ ATUALIZADA
				atualE->distancia = menorDis; 	
			}

			else
			{
				atualT = atualE;
				houveMod = 1;
				if(atualT == atualG->inicio )  // -> INSTÂNCIA DO INÍCIO QUE SERÁ TRANSFERIDA
				{ 			
					transfere = atualT;
					atualG->inicio = atualT->prox;
				}
				else if(atualT != NULL && atualT->prox == NULL) // -> INSTÂNCIA DO FIM QUE SERÁ TRANSFERIDA
				{
					
					transfere = atualT;
					atualT->ante->prox = NULL; 					
				}
				else // -> INSTÂNCIA DO MEIO QUE SERÁ TRANSFERIDA
				{	
					
					atualizaAnte = atualT->ante;
					atualizaProx = atualT->prox;
					transfere = atualT;
					atualT->ante->prox = atualizaProx;
					atualT->prox->ante = atualizaAnte;

				}
				TGrupo *atualizaGrupo = L->inicio;
				while(atualizaGrupo != NULL)
				{						
					if(atualizaGrupo->grupo == grupo)
					{
					
						atualT = atualizaGrupo->inicio;
						if(atualT == NULL) // -> Grupo vazio, inserimos a instância como seu primeiro elemento
						{
							atualT = transfere;
							transfere->prox = NULL;
							transfere->ante = NULL;
							transfere->grupo = grupo;
							transfere->distancia = menorDis;
						}
						while(atualT != NULL)
						{
							if(atualT != NULL && atualT->prox == NULL) // -> inserindo instância no final do grupo cuja proximidade...
							{									       // ... Do Centróide é menor
							atualT->prox = transfere;
							transfere->prox = NULL;
							transfere->ante = atualT;
							transfere->grupo = grupo;
							transfere->distancia = menorDis;
							}
							atualT = atualT->prox;
						}
					}
					atualizaGrupo = atualizaGrupo->prox;
				}
				
			}
			atualE = atualE->prox;
		} 
		atualG = atualG->prox;
	}

	if(houveMod == 1) // -> Se algum grupo foi modificado, o processo é repetido
	{
		recalculaCentroide(L, 0);
		calcularDistancia(L);
	}
	
}
//=================================================================================
