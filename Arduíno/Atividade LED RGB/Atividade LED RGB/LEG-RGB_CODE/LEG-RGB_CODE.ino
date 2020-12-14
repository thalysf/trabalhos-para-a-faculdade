/*
 * Aluno: Thalys Fabrete Cândido
 * Data: 01/12/2020
 *
 */

// Incluindo biblioteca para armazenamento de valores na EEPROM
#include <EEPROM.h> 

// Definindo os pinos correspondentes a cada cor
#define RED 6 
#define GREEN 3 
#define BLUE 5 

// Definindo o pino que recebe o sinal do potenciometro
#define POTENCIOMETRO A0

// Variáveis que irão simular as saídas analógicas (variando de 0 a 255)
int red, green, blue;

// Definindo variável que irá receber o valor do potenciômetro 
int potenciometro = -1;

// Entrada de dados
String entrada;
String cor;
// Entrada de valores 0 a 255
int valor; 
bool isValue = true; // variável boolenada que demonstra se o valor é ou não int
// Definindo endereços onde serão armazenados os valores na EEPROM
int redAdress = 0;
int greenAdress = 1;
int blueAdress = 2;
// Valor para alterar os leds durante o curso do programa
int valorAtual;
void setup()
{
  // Definindo os pinos dos leds como output
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(BLUE, OUTPUT);

  // Iniciando monitor serial
  Serial.begin(9600);
  Serial.setTimeout(100);
  // Recuperando valores da EEPROM
  red = EEPROM.read(redAdress);
  green = EEPROM.read(greenAdress);
  blue = EEPROM.read(blueAdress);
}

void loop()
{
  // Leitura do monitor serial
  if(Serial.available() > 0)
  {
    entrada = Serial.readString();
    if(entrada != "S" && entrada != "R" && entrada != "G" && entrada != "B"){
      isValue = true;
      valor = entrada.toInt();
      // Em caso de valores exorbitantes:
      if(valor > 255) valor = 255;
      else if(valor < 0) valor = 0;
    } 
    else{
      isValue = false;
    }
  }
  
  if(entrada != "S" && (entrada == "R" || entrada == "G" || entrada == "B"))
  {
    cor = entrada; // salvando cor selecionada
    // Lendo da entrada analógica do potenciômetro
    potenciometro = analogRead(POTENCIOMETRO);
    // Mapeando o resultado do potenciômetro dentro do intervalor de 0 a 255
    potenciometro = map(potenciometro, 0, 1023, 0, 255);
  }
  else if(isValue)
  {
    potenciometro = -1;
  }
  if(entrada == "S")
  {
     EEPROM.write(redAdress, red);
     EEPROM.write(greenAdress, green);
     EEPROM.write(blueAdress, blue);
     entrada = "";
  }
  else if((cor == "R" || cor == "G" || cor == "B")){
    if(potenciometro != -1)
    {
      valorAtual = potenciometro;
    }
    else
    {
      valorAtual = valor;
    }
    ligarLed(cor, valorAtual);
  }
  // Acendendo os leds 
  analogWrite(RED, red);
  analogWrite(GREEN, green);
  analogWrite(BLUE, blue);
}

void ligarLed(String cor, int intensidade)
{
  if(cor == "R")
  {
    red = intensidade;
  }
  else if(cor == "G")
  {
    green = intensidade;
  }
  else if(cor == "B")
  {
    blue = intensidade;
  }
}
