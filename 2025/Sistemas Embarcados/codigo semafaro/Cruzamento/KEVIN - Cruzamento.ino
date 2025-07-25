void setup()
{
  // Configuração dos pinos dos LEDs como saída
  pinMode(2, OUTPUT);  // Verde 1
  pinMode(3, OUTPUT);  // Amarelo 1
  pinMode(4, OUTPUT);  // Vermelho 1
  
  pinMode(5, OUTPUT);  // Verde 2
  pinMode(6, OUTPUT);  // Amarelo 2
  pinMode(7, OUTPUT);  // Vermelho 2
  
  pinMode(8, OUTPUT); // Verde 3
  pinMode(9, OUTPUT);  // Amarelo 3
  pinMode(10, OUTPUT);  // Vermelho 3
  
  pinMode(11, OUTPUT); // Verde 4
  pinMode(12, OUTPUT); // Amarelo 4
  pinMode(13, OUTPUT); // Vermelho 4
}

void loop()
{
  // Acende os dois LEDs verdes e os dois vermelhos
  digitalWrite(2, HIGH);
  digitalWrite(8, HIGH);
  digitalWrite(7, HIGH);
  digitalWrite(13, HIGH);
  delay(5000); // Aguarda 10 segundos
  
  // Apaga os verdes
  digitalWrite(2, LOW);
  digitalWrite(8, LOW);
  delay(500); // Pequena pausa
  
  // Acende os amarelos enquanto os vermelhos continuam acesos
  digitalWrite(3, HIGH);
  digitalWrite(9, HIGH);
  digitalWrite(7, HIGH);
  digitalWrite(13, HIGH);
  delay(2000); // Aguarda 5 segundos
  
  // Apaga os amarelos e os vermelhos
  digitalWrite(3, LOW);
  digitalWrite(9, LOW);
  digitalWrite(7, LOW);
  digitalWrite(13, LOW);
  delay(500); // Pequena pausa
  
  // Acende os outros dois LEDs verdes
  digitalWrite(5, HIGH);
  digitalWrite(11, HIGH);
  digitalWrite(4, HIGH);
  digitalWrite(10, HIGH);
  delay(5000); // Aguarda 10 segundos
  
    
  
  // Apaga os verdes
  digitalWrite(5, LOW);
  digitalWrite(11, LOW);
  delay(500); // Pequena pausa
  
  // Acende os amarelos enquanto os vermelhos continuam acesos
  digitalWrite(6, HIGH);
  digitalWrite(12, HIGH);
  digitalWrite(4, HIGH);
  digitalWrite(10, HIGH);
  delay(2000); // Aguarda 5 segundos
  
  // Apaga os verdes
  digitalWrite(6, LOW);
  digitalWrite(12, LOW);
  digitalWrite(4, LOW);
  digitalWrite(10, LOW);
  delay(500); // Pequena pausa
}
