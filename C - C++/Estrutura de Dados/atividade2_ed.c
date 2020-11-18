#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>
#include<time.h>
#define TAM 5

typedef char nomes[20];
typedef struct dados
{
	nomes pessoas[TAM];
	int matriz[TAM][TAM];
	
	
}Dados;
void desenharGrafo;
void gerarNomes;
void relacao;
void printar;
void indicarAmizade;
Dados info; // Var global
void gerarNomes(Dados * d) // Inicializa nomes
{
	
	strcpy(d->pessoas[0],"Wesley");
	strcpy(d->pessoas[1],"Carlos");
	strcpy(d->pessoas[2],"Alexandre");
	strcpy(d->pessoas[3],"Samuel");
	strcpy(d->pessoas[4],"Igor");
	
	
} 
void relacao(Dados * d) // Relação de amizade, cada pessoa possui uma linha e coluna própria
{
	srand(time(NULL));
  
  	int l = 0;
  	int c = 0;
  	int qtd = 0;
  	while(qtd < 4) // Criando 4 relações randômicas
  	{
	do
	{
		l = rand() % TAM;
		c = rand() % TAM;
	}while(c == l || d->matriz[c][l] == 1);
	d->matriz[l][c] = 1;
	d->matriz[c][l] = 1;
	qtd++;
	}
  	
}

void printar(Dados * d)
{
	int i = 0, j = 0, aux = 0;
	// Printar matriz é opcional
	printf("Matriz de relações:\n\n");
	while(i < TAM)
	{
		printf("  %d ", i); 
		i++;
	}
	printf("\n");
	for(i = 0; i < TAM; i++)
	{
		printf("%d ", i); 
		for(j = 0; j < TAM; j++)
		{
			printf("[%d] ", d->matriz[i][j]);
		}	
		printf("\n\n");
	}
	// Quem é amigo de quem:
	i = 0; j = 0;
	printf("Amizades: \n");
	printf("\n#====================================================#\n");
	while(j < TAM)
	{
		for(j; i < TAM; )
		{
			if(d->matriz[i][j] == 1)
			{
				if(aux == 0) printf("Lista de amigos de %s: \n", d->pessoas[j]);
				printf("[ %s ] ", d->pessoas[i]);
				aux = 1;
			}
			i++;
		}
		
		printf("\n____________________________________\n");
		j++;
		aux = 0, i = 0;;
	}
	printf("\n#====================================================#\n");		
}
void indicarAmizade(Dados * d)
{
	int i = 0, j = 0, aux = 0, msg = 0;
	while(j < TAM)
	{
		for(i=0; i < TAM; i++)
		{
			if(d->matriz[i][j] == 1)
			{
				while(aux < TAM)
				{
					if(d->matriz[i][aux] == 1)
					{
						if (msg == 0) printf("Indicando amizades para %s: \n", d->pessoas[j]);
							if((aux != j) && (aux != i)) 
							{
								if(d->matriz[j][aux] != 1)printf("[ %s ] \n", d->pessoas[aux]);	
							}
						msg = 1;
					}
					aux++;
				}
				aux = 0;
			}
		}
		printf("\n");
		j++;
		msg = 0;
	}
}
int main(){
	FILE * p;
	setlocale(LC_ALL, "Portuguese");
	gerarNomes(&info);
	relacao(&info); 
	printar(&info);
	printf("\nAgora iremos começar as sugestões de amizade...(Pressione qualquer tecla)...\n\n");
	getch();
	indicarAmizade(&info);
	
	fclose(desenhoGrafo);
	return 0;
}




void desenharGrafo(Dados * d, FILE * p)
{
	int i, j;
	for(i = 0; i < TAM; i++)
	{
		for(j = 0; j < TAM; j++)
		{
			if(d->matriz[i][i] == 1)
			{
				fprintf(p, "\t%s -- %d;\n", d->pessoas[i], d->pessoas[j]);
			} 
		}
	}
}
