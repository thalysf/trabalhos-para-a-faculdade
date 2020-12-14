// Definindo pinos
const int LED01 = 13;
const int LED02 = 12;
const int LED03 = 11;
const int LED04 = 10;
const int LED05 = 9;
const int BOTAO = 2;
const int TRIGGER = 4;
const int ECHO = 3;
// Definindo variáveis
bool pressionado;
float distanciaCm;
long duracao;
void setup() {
  // Iniciando monitor Serial
  Serial.begin(9600); 
  // Definindo pinos de saída
  pinMode(LED01, OUTPUT);
  pinMode(LED02, OUTPUT);
  pinMode(LED03, OUTPUT);
  pinMode(LED04, OUTPUT);
  pinMode(LED05, OUTPUT);
  pinMode(TRIGGER, OUTPUT);
  // Definindo pinos de entrada
  pinMode(BOTAO, INPUT);
  pinMode(ECHO, INPUT);
}

void loop() {
   // Limpa o trigger
   digitalWrite(TRIGGER, LOW);
   delayMicroseconds(5); // pequeno delay para dar sequência
  
   // Configurando o pino TRIGGER para nível alto, resultando em uma emissão de sinal
   digitalWrite(TRIGGER, HIGH);
   delayMicroseconds(10); // tempo para envio do sinal
   digitalWrite(TRIGGER, LOW); // Interrompendo envio de sinal
  
  // Iniciando contagem de tempo através da leitura do pino ECHO
  duracao = pulseIn(ECHO, HIGH);
  // Cálculo da distância em cm
  distanciaCm = duracao * 0.034 / 2;
  
  if(botaoPressionado())
  {
    // Executando verificações de distância para acender ou apagar os leds correspondentes
    /*
     Optei pelo modelo onde apago ou acendo a quantidade correta 
     de leds, pois caso o botão seja removido, o comportamento dos leds
     ainda estará correto
    */
    if(distanciaCm > 100)
    {
      apagarTodosLeds();
    }
    else if(distanciaCm > 80)
    {
      digitalWrite(LED01, HIGH);
      digitalWrite(LED02, LOW);
      digitalWrite(LED03, LOW);
      digitalWrite(LED04, LOW);
      digitalWrite(LED05, LOW);
    }
    else if(distanciaCm > 60)
    {
      digitalWrite(LED01, HIGH);
      digitalWrite(LED02, HIGH);
      digitalWrite(LED03, LOW);
      digitalWrite(LED04, LOW);
      digitalWrite(LED05, LOW);
    }
    else if(distanciaCm > 40)
    {
      digitalWrite(LED01, HIGH);
      digitalWrite(LED02, HIGH);
      digitalWrite(LED03, HIGH);
      digitalWrite(LED04, LOW);
      digitalWrite(LED05, LOW);
    }
    else if(distanciaCm > 20)
    {
      digitalWrite(LED01, HIGH);
      digitalWrite(LED02, HIGH);
      digitalWrite(LED03, HIGH);
      digitalWrite(LED04, HIGH);
      digitalWrite(LED05, LOW);
    }
    else
    {
      digitalWrite(LED01, HIGH);
      digitalWrite(LED02, HIGH);
      digitalWrite(LED03, HIGH);
      digitalWrite(LED04, HIGH);
      digitalWrite(LED05, HIGH);
    }
  }
  else
  {
    apagarTodosLeds();
  }
}

bool botaoPressionado()
{
  pressionado = digitalRead(BOTAO); // Verificando se o botão foi pressionado
  if(pressionado) return true; // retornando o estado do botão (true para pressioado e false para não pressionado)
  
  return false;
}
void apagarTodosLeds(){ // função que apaga todos os leds
	digitalWrite(LED01, LOW);
    digitalWrite(LED02, LOW);
    digitalWrite(LED03, LOW);
    digitalWrite(LED04, LOW);
    digitalWrite(LED05, LOW);
}
