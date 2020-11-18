#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <locale.h>
/**
	THALYS FABRETE CÂNDIDO
	SISTEMAS DE INFORMAÇÃO
	TURMA V06
	ESTRUTURA DE DADOS
	26/05/2020
*/
typedef struct Item
{
    int numero;
    char palavra[50];
    struct Item *proximo;
}Item;

typedef struct Fila
{
    Item *inicio;
    Item *fim;
    int qtd;
}Fila;

void Inicializar(Fila **fila)
{
    // -> Recebe a fila por referencia
    //    para inicializá-la
    *fila = (Fila *) malloc(sizeof(Fila));
    (*fila)->inicio = NULL;
    (*fila)->fim = NULL;
}

int EstaVazia(Fila *fila)
{
    return fila->inicio == NULL;
}

void Inserir(Fila *fila, int elemento, char * nome)
{
    Item *novo;
    novo = (Item *)malloc(sizeof(Item));  

    // -> Verifica se a memória foi alocada com sucesso
    if (novo != NULL)
    {
    	// -> Atribuindo os elementos para então passarem para a fila
        novo->numero = elemento;
        strcpy(novo->palavra, nome);
        novo->proximo = NULL;

        if(EstaVazia(fila))
        {
            // -> Primeiro Item da Fila.
            fila->inicio = novo;
            fila->fim = novo;
        }
        else
        {
            // -> Ultimo item da Fila
            fila->fim->proximo = novo;
            fila->fim=novo;
        }
    }
    // -> atribuição feita com sucesso == +1 para o tamanho da fila
    if(fila->qtd >= 0)fila->qtd = fila->qtd + 1;
}
void reinfileirar(Fila *fila, Item * item)
{	
	// -> recebendo por parâmetro o elemento a ser passado para o início da fila
	Item * p = item;
    Item save;
    Item save1;
    item = fila->inicio; 
    // -> agora iremos salvar os valores iniciais para que a fila possa ser "realocada"
    save.numero = fila->inicio->numero;
    strcpy(save.palavra, fila->inicio->palavra);
    				
    fila->inicio->numero = p->numero;
    strcpy(fila->inicio->palavra, p->palavra);
    
    		while(item != p)
    		{
    			// -> a ideia: step 1 elemento com prioridade passa a ser o elemento inicial
    			// -> step 2 os elementos do início até a posição do elemento prioritário irão pular uma casa...
    			// -> ... até que a fila seja completamente movida "uma casa", sendo assim, reinfileirada.
    			if(item->proximo == NULL) break;
    		    item = item->proximo;
    			save1.numero = item->numero;
    			strcpy(save1.palavra, item->palavra);
    			
    			item->numero = save.numero;
    			strcpy(item->palavra, save.palavra);
    			if(item->proximo == NULL || item == p) break;
    			item = item->proximo;
    			
    			save.numero = item->numero;
    			strcpy(save.palavra, item->palavra);
    			
    			item->numero = save1.numero;
    			strcpy(item->palavra, save1.palavra);
    			
			}
}
int Retirar(Fila *fila, int count, int  i)
{
    Item *item;
    int aux = 0;
    int prio[3] = {2, 2, 3}; 
    if(!EstaVazia(fila))
    {
    	// Preparar remoção com prioridade
    	// -> caso a remoção com prioriedade esteja acontecendo e este elemento já estiver no início da fila
    	// -> não haverá necessidade de fazer nenhuma tratativa, e a remoção ocorrerá normalmente
	if(count == 0 && fila->inicio->numero == prio[i])
	{
		aux = 1;
		i++;
	}
    else if(count == 0)
	{
		// -> busca do elemento com a prioridade atual a ser atendidade
		item = fila->inicio->proximo; 
	    while(item != NULL)
	    {
	    	if(item->numero == prio[i])
	    	{
	    		// caso esse elemento prioritário exista, ele será encaminhado para a funcão reinfileirar()
	    		reinfileirar(fila, item);
	    		i++;
	    		aux = 1;
	    		break;
			}
	    	item = item->proximo;
		}
	}
	// Fim do preparo para remoção prioritária
	
	// Remoção sem prioridade 

	  	
		item = fila->inicio; 
        fila->inicio = item->proximo; 
        free(item); 
        // -> Se a fila acabou o final é atualizado
        if (fila->inicio == NULL) fila->fim = NULL;
	// Fim sem prioridade 
    } 
    // -> a cada remoção bem sucedida, a fila diminui em 1 seu tamanho
	if(fila->qtd > 0)fila->qtd = fila->qtd - 1;
   
    return i;
   
}

void exibir6Proximos(Fila *fila, int count, int i)
{
	int quantidade = fila->qtd;
	int j = 0;
	int totalExibidos = 0;
	Item * item;
	int exib[quantidade]; 
	while(j < quantidade)
	{
		exib[j] = 0; j++;
	}
	// essa parte não é obrigatória
	// -> caso seja removida, será printado toda sequência correta de atendimento
	if(quantidade < 6)
	{
		printf("Fila menor que 6, insira mais elementos!");
		return;
	}
	printf("Exibindo 6 próximos a serem atendidos... \n\n");
	int prio[3] = {2, 2, 3};
	j = 0;
	item = fila->inicio;
	// o total de exibidos controla a quantidade de elementos que serão exibidos
	// -> alterando ele poderá exibir mais ou menos elementos (de acordo com o tamanho da fila, é claro)
	printf("_ _ _ _ _- - - - - -_ _ _ _ _ _ _ _- - - - - -_ _ _ _ _ _ _- - - - - -_ _ _ _ _ _\n");
	while(totalExibidos != 6)
	{
		
		if(count > 0 && exib[j] == 0)
		{
			// exibindo elementos fora da prioridade
			printf("\nPrioridade )=> %d  ", item->numero);
			printf("Nome )=> %s \n", item->palavra);
			// se o elemento possuir prioridade 1 o contador de prioridade será decrementado
			if(item->numero == 1) count--;
			exib[j] = 1;
			totalExibidos++;
		}
		
		else if(item->numero == prio[i] && exib[j] == 0)
		{
			printf("\nPrioridade )=> %d  ", item->numero);
			printf("Nome )=> %s \n", item->palavra);
			exib[j] = 1;
			totalExibidos++;
			i++;
		}
		if(i > 2)
		{
			count = 3;
			i = 0;
		}
		
		if(j != quantidade)
		{
			j++;
			item = item->proximo;	
		}
		// se chegamos no final da fila e a sequência de exibição não foi concluída...
		// ...o ciclo é reiniciado
		if(j == quantidade && count == 0) i++;
		if(j == quantidade) 
		{
			j = 0;
			item = fila->inicio;
		}
		
	}
	printf("\n_ _ _ _ _- - - - - -_ _ _ _ _ _ _ _- - - - - -_ _ _ _ _ _ _- - - - - -_ _ _ _ _ _");
}
void MostrarFila(Fila *fila)
{
    int i = 0;
    Item *item;
    printf("\n\n Listando...\n\n");
    printf("---------------------------------\n");

    if (EstaVazia(fila))
    {
        printf ("A Fila esta vazia!\n");
    }
    else
    {      
        item = fila->inicio;

        while(item != NULL)
        {
            i++;
            printf("Prioridade: [%i] -> %i\t", i, item->numero);
            printf("Nome: [%i] -> %s\n", i, item->palavra);
            item = item->proximo;
        }
    }

    printf("---------------------------------\n");
}

void Menu()
{
    printf( "Digite a sua escolha: \n"
        "    1 - Inserir elemento \n"
        "    2 - Retirar da fila \n"
        "    3 - Exibir fila \n"
         "   4 - Exibir 6 Próximos \n"
         "   5 - Exibir Menu \n"
        "    0 - Para finalizar \n"
        "Digite sua opção: ");
}

void main()
{   
	setlocale(LC_ALL, "Portuguese");
    Fila *fila = NULL;
    int remov;
	int opcao;
    int numero;
	char nome[50];
	/// Controle da remoção
	int count = 3;
	int i = 0;
	
	//
    Inicializar(&fila);
    Menu();
    scanf("%i", &opcao);

    while (opcao != 0)
    {
        switch (opcao)
        {
        	case 0:
        		free(fila);
        		exit(0);
            case 1:
            	do
				{
					printf( "\nDigite uma prioridade: ");
                	scanf("\n%i", &numero);
				}while(numero > 3 || numero < 1);
				printf( "Digite um nome: ");
				setbuf(stdin, NULL);
                scanf("\n%s", &nome);
                Inserir(fila, numero, nome);
                //MostrarFila(fila);
                printf("\nQuantidade de elementos enfileirados: %i\n", fila->qtd);
                break;
            case 2:
            	if(fila->inicio == NULL) 
            	{
            		opcao = 5;
            		printf("\nFila vazia...\n");
					printf("Por favor, insira pelo menos um elemento para utilizar essa função!\n\n");
					break;
				}
            	//system("COLOR C");
				remov = 0;
            	if(fila->inicio->numero == 1 && count > 0) remov = 1;
            	i = Retirar(fila, count, i);
                if(count > 0 && remov == 1)count--;
                if(i == 3) 
				{
					count = 3; 
					i = 0;	
				}
                MostrarFila(fila);
                printf("\nQuantidade de elementos enfileirados: %i\n", fila->qtd);
                break;
			case 3:
				system("CLS"); 
				system("COLOR B");
            	MostrarFila(fila);
                break;
            case 4:
            	system("CLS"); 
            	exibir6Proximos(fila, count, i);
            	//MostrarFila(fila);
                break;
            case 5:
				system("CLS"); 
            	Menu();
            	break;
            default:
                printf("Escolha inválida.\n\n");
                Menu();
                break;
        }
		printf("\n|Digite uma opção: ");
        scanf("%i", &opcao);   
    }

    system("pause");
}
