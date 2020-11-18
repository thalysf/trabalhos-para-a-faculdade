/*
 
  * Programa: Convers�o entre tipos de dados em linguagem C
  * Data de cria��o: 07/12/2015
  * Autor: Eric Cancellgliere (http://programacaoemfoco.com.br)
  * Vers�o: 1.0
  * �ltima modifica��o em [07/12/2015] feita por [Eric Cancellgliere]
 
*/
 
//bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <windows.h>
 
int main(void){
    //vari�veis
    int numero=0;
    char texto[100];
    //comando de regionaliza��o
    setlocale(LC_ALL, "Portuguese");
    //t�tulo do programa
    SetConsoleTitle("Converter tipos de dados");
   
    printf ("\t\t***** Convers�o de inteiro para string *****\n\n");
   
    printf("Informe um n�mero (ser� armazenado em uma vari�vel int): ");
    scanf ("%d", &numero);
    getchar();
   
    sprintf (texto, "%d", numero);
   
    printf ("\nO n�mero informado convertido em uma string: %s\n\n", texto);
   
    printf ("\n\t\t***** Convers�o de string para inteiro *****\n\n");
   
    printf("Informe um n�mero (ser� armazenado em uma vari�vel char): ");
    gets (texto);
   
    numero = atoi(texto);
   
    printf ("\nO n�mero informado convertido em um int: %d\n\n", numero);
}
