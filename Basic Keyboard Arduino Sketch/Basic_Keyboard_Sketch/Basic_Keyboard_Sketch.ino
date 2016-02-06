/**
 * Author: Giuseppe Barbato
 */

#include <SoftwareSerial.h>

SoftwareSerial mySerial(6, 5); // this serial represents communication with the Android app

String value;
int prevValue = 0;
char command;

unsigned long inputTime = 0;
long interval = 1000;

void setup() {
  Serial.begin(57600);
  Serial.println("Communication");
  mySerial.begin(9600);
  noTone(7);
}

void loop() {
  unsigned long currentTime = millis();
  
  // if there's a new command reset the string and update last input action time
  if (mySerial.available()) {
    inputTime = currentTime;
    value = "";
  }

  // Check if 1 second passed, if so interrupts sound
  if (currentTime - inputTime < interval) {
    // Construct the command string fetching the bytes, sent by Android, one by one.
    while (mySerial.available()) {
      command = ((byte)mySerial.read());
      // I chose ':' as escape char to interupt command fetching from the serial communication
      if (command == ':') {
        break;
      } else {
        value += command;
      }
      delay(1);
    }

    int casted = value.toInt();
    if (prevValue != casted) {
      /*Note that Arduino.cc reports these frequency values to reproduce note:
       * NOTE_C4 = 262;
       * NOTE_CS4 = 277;
       * NOTE_D4 =  294;
       * NOTE_DS4 = 311;
       * NOTE_E4 =  330;
       * NOTE_F4 = 349;
       * NOTE_FS4 = 370;
       * NOTE_G4 =  392;
       * NOTE_GS4 = 415;
       * NOTE_A4 =  440;
       * NOTE_AS4 = 466;
       * NOTE_B4 =  494;
       * NOTE_C5 =  523;
       */
      Serial.println(casted);
      tone(7, casted);
      prevValue = casted;
    } else {
      prevValue = casted;
    }

    delay(1);
  } else {
    noTone(7);
  }
}
