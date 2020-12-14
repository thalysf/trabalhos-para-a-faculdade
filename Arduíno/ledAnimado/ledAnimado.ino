const int LED1 = 5;
const int LED2 = 6;
const int LED3 = 8;
const int BOTAO = 2;
int pressionado = 0;
int estadoLEDVerde = LOW;
int estadoLEDAmarelo = LOW;
int estadoLEDVermelho = LOW;
unsigned long tempoAnterior = 0; // Armazena o último momento em que o LED foi atualizado
long PERIODO = 500;
char vezDe = 1;
void setup() {
  Serial.begin(9600);
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
}

void loop() {
  unsigned long tempoAtual = millis();
  if ((tempoAtual - tempoAnterior) >= PERIODO) {
    tempoAnterior = tempoAtual;

    if(vezDe == 3){
          vezDe = 2;
          estadoLEDVerde = HIGH;
          estadoLEDAmarelo = LOW;
          estadoLEDVermelho = LOW; 
      }
    else if(vezDe == 2){
          vezDe = 1;
          estadoLEDVerde = LOW;
          estadoLEDAmarelo = HIGH;
          estadoLEDVermelho = LOW; 
     }
     else{
          vezDe = 3;
          estadoLEDVerde = LOW;
          estadoLEDAmarelo = LOW;
          estadoLEDVermelho = HIGH; 
      }
    
  }
  

   digitalWrite(LED1, estadoLEDVermelho);
   digitalWrite(LED2, estadoLEDAmarelo);
   digitalWrite(LED3, estadoLEDVerde);
   isPressionado();
  Serial.println(vezDe);
}

int isPressionado(){
  
  pressionado = digitalRead(BOTAO);
  if(pressionado){
    PERIODO = 2000;
    
  }
  else{
    PERIODO = 500;
   }
}
