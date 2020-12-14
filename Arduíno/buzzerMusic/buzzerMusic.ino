int i = 0;
int mode = 0;
int x = 0; int y =0;
const int LEDRED = 8;
const int LEDYELLOW = 9;
const int LEDGREEN = 10;
const int Buzzer = 13;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(Buzzer, OUTPUT);
  pinMode(LEDRED, OUTPUT);
  pinMode(LEDYELLOW, OUTPUT);
  pinMode(LEDGREEN, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  
 while (x < 2) {
  tone(Buzzer, 392, 200);
  digitalWrite(LEDGREEN, LOW);
  digitalWrite(LEDRED, HIGH);
  delay(500);
  tone(Buzzer, 440, 200);
    digitalWrite(LEDRED, LOW);
  digitalWrite(LEDYELLOW, HIGH);
  delay(250);
  tone(Buzzer, 468, 200);
  digitalWrite(LEDYELLOW, LOW);
  digitalWrite(LEDRED, HIGH);
  delay(400);
  tone(Buzzer, 589, 200);
   digitalWrite(LEDRED, LOW);
  digitalWrite(LEDGREEN, HIGH);
  delay(400);
  digitalWrite(LEDGREEN, LOW);
  digitalWrite(LEDRED, HIGH);
  tone(Buzzer, 663, 200);
  digitalWrite(LEDRED, LOW);
  digitalWrite(LEDGREEN, HIGH);
  delay(400);
  tone(Buzzer, 701, 200);
  digitalWrite(LEDGREEN, LOW);
  digitalWrite(LEDYELLOW, HIGH);
  delay(250);
  tone(Buzzer, 589, 200);
   digitalWrite(LEDYELLOW, LOW);
  digitalWrite(LEDRED, HIGH);
  delay(400);
  tone(Buzzer, 663, 200);
  digitalWrite(LEDRED, LOW);
  digitalWrite(LEDGREEN, HIGH);
  delay(250);
  tone(Buzzer, 526, 200);
  digitalWrite(LEDGREEN, LOW);
  digitalWrite(LEDRED, HIGH);
  delay(400);
  tone(Buzzer, 589, 200);
  digitalWrite(LEDRED, LOW);
  digitalWrite(LEDYELLOW, HIGH);
  delay(350);
  tone(Buzzer, 440, 200);
  digitalWrite(LEDYELLOW, LOW);
  digitalWrite(LEDGREEN, HIGH);
  delay(400);
  x++;
}

while (y <  1) {
  tone(Buzzer, 440, 200);
  digitalWrite(LEDYELLOW, LOW);
  digitalWrite(LEDGREEN, HIGH);
  delay(600);
  digitalWrite(LEDGREEN, LOW);
  digitalWrite(LEDYELLOW, HIGH);
  tone(Buzzer, 468, 200);
  delay(300);
  y++;
}
  
}
