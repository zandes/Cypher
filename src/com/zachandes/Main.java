package com.zachandes;

public class Main {

    public static void main(String[] args) {

        FileInput rawFileIn = new FileInput("UnencryptedInputFile");
        FileOutput encryptedFileOut = new FileOutput("EncryptedFile");
        String line;
        char[] charArray;
        while ((line = rawFileIn.fileReadLine()) != null){

            char key = 'A';
            charArray = line.toCharArray();
            for(int i = 0; i < charArray.length; i++){
                char letter = charArray[i];
                letter+=5;
                charArray[i] = letter;
                //charArray[i] = (char)((int)charArray[i] ^ (int)key);
            }

            encryptedFileOut.fileWrite(new String(charArray));
        }
        rawFileIn.fileClose();
        encryptedFileOut.fileClose();

        FileInput encryptedFileIn = new FileInput("EncryptedFile");
        FileOutput rawFileOut = new FileOutput("UnencryptedOutputFile");
        while((line = encryptedFileIn.fileReadLine()) != null){

            char key = 'A';
            charArray = line.toCharArray();
            for(int i = 0; i < charArray.length; i++){
                char letter = charArray[i];
                letter-=5;
                charArray[i] = letter;
                //charArray[i] = (char)((int)charArray[i] ^ (int)key);
            }

            rawFileOut.fileWrite(new String(charArray));
        }
        encryptedFileIn.fileClose();
        rawFileOut.fileClose();
    }
}
