#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include "lista.h"
/**
  * Aluno: Thalys Fabrete C�ndido
  * Turma: V06
  *	Disciplina: T�cnicas de Programa��o Avan�ada
  * Professor: Victorio Albani Carvalho
  * Data: 28/10/2020
  */
int main(int argc, char *argv[]) {
	setlocale(LC_ALL, "Portuguese");
	TLista lista;
	inicializa(&lista);
	menu(&lista);
	return 0;
}
