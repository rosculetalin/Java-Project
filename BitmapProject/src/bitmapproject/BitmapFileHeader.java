/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmapproject;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author alin_ionut.rosculet
 */
public class BitmapFileHeader extends BytesOperations{
    String type;
    int size;
    short reserved1;
    short reserved2;
    int offsetPixels;
    
    public BitmapFileHeader(){}
    
    void setType(byte b1, byte b2) throws UnsupportedEncodingException{
        this.type = new String(new byte[]{b1,b2},"US-ASCII");  //transform unicode in ASCII 
    }
    
    void setType(String type){
        this.type = type;
    }
    
    String getType(){
        return this.type;
    }
    
    void setSize(byte b1, byte b2, byte b3, byte b4){
        this.size = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setSize(int size){
        this.size = size;
    }
    
    int getSize(){
        return this.size;
    }
    
    void setReserved1(byte b1, byte b2){
        byte b3 = 0;
        byte b4 = 0;
        this.reserved1 = (short)intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setReserved1(short reserved1){
        this.reserved1 = reserved1;
    }
    
    short getReserved1(){
        return this.reserved1;
    }
    
    void setReserved2(byte b1, byte b2){
        byte b3 = 0;
        byte b4 = 0;
        this.reserved2 = (short)intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setReserved2(short reserved2){
        this.reserved2 = reserved2;
    }
    
    short getReserved2(){
        return this.reserved2;
    }
    
    void setOffsetPixels(byte b1, byte b2, byte b3, byte b4){
        this.offsetPixels = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setOffsetPixels(int offsetPixels){
        this.offsetPixels = offsetPixels;
    }
    
   int getOffsetPixels(){
       return this.offsetPixels;
   }
}
