/*
 
  * Programa: Conversão entre tipos de dados em linguagem C
  * Data de criação: 07/12/2015
  * Autor: Eric Cancellgliere (http://programacaoemfoco.com.br)
  * Versão: 1.0
  * Última modificação em [07/12/2015] feita por [Eric Cancellgliere]
 
*/
 
//bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <windows.h>
 
int main(void){
    //variáveis
    int numero=0;
    char texto[100];
    //comando de regionalização
    setlocale(LC_ALL, "Portuguese");
    //título do programa
    SetConsoleTitle("Converter tipos de dados");
   
    printf ("\t\t***** Conversão de inteiro para string *****\n\n");
   
    printf("Informe um número (será armazenado em uma variável int): ");
    scanf ("%d", &numero);
    getchar();
   
    sprintf (texto, "%d", numero);
   
    printf ("\nO número informado convertido em uma string: %s\n\n", texto);
   
    printf ("\n\t\t***** Conversão de string para inteiro *****\n\n");
   
    printf("Informe um número (será armazenado em uma variável char): ");
    gets (texto);
   
    numero = atoi(texto);
   
    printf ("\nO número informado convertido em um int: %d\n\n", numero);
}
