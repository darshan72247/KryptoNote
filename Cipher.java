package com.example.kryptonoteapp;

public class Cipher {
    private String key;
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Cipher(String k){
        this.key = k;
    }

//    public static void main(String[] args) {
////        String x = "1234";
////        String y = "THIS IS A TEST";
////        Cipher test = new Cipher(x);
////        System.out.println(y);
////        System.out.println(test.Encrypt(y));
////        System.out.println(test.Decrypt(y));
////    }

    private String makePad(String note){
        String pad = this.key;
        for(;pad.length()<note.length();){
            pad += this.key;
        }
        return pad;
    }

    public String Encrypt(String note){
      String pad = makePad(note);
      String result = "";
      for ( int i =0; i < note.length(); i++){
          String c = note.substring(i,i+1);
          int position = ALPHABET.indexOf(c);
          int shift = Integer.parseInt(pad.substring(i , i+1));
          int newPosition = (position + shift ) % ALPHABET.length();
          result = result + ALPHABET.substring(newPosition,newPosition+1);
      }
      return result;
    }


    public String Decrypt(String note){
        String pad = makePad(note);
        String result = "";
        for ( int i =0; i < note.length(); i++){
            String c = note.substring(i,i+1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i , i+1));
            int newPosition = (position - shift) % ALPHABET.length();
            if (newPosition < 0){
                newPosition = newPosition + ALPHABET.length();
            }
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }
        return result;
    }
}
