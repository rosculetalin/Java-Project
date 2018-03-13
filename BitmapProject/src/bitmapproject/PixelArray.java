/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmapproject;

/**
 *
 * @author alin_ionut.rosculet
 */
public class PixelArray {
    int rowSize;
    int pixelArraySize;
    byte [][] data;
    
    public PixelArray(){}
    
    void setRowSize(short bitsPerPixel,int widthPixels){
        this.rowSize = ( ( ((int)bitsPerPixel) * widthPixels + 31) / 32) * 4;
    }
    
    int getRowSize(){
        return this.rowSize;
    }
    
    void setPixelArraySize(int heightPixels){
        this.pixelArraySize = this.rowSize * Math.abs(heightPixels);
    }
    
    int getPixelArraySize(){
        return this.pixelArraySize;
    }
    
    void setData(byte [][] data){
        int m = this.pixelArraySize / this.rowSize;
        int n = this.rowSize;
        this.data = new byte[m][n];
        for(int i = 0; i < m; i++)
        for(int j = 0; j < n; j++)
            this.data[i][j] = data[i][j];
    }
    
    byte[][] getData(){
        return this.data;
    }
    
    void displayData(){
        int m = this.pixelArraySize / this.rowSize;
        int n = this.rowSize;
        int aux;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                aux = data[i][j] & 0xFF;
                System.out.format("%03d"+"  ", aux);
            }
            System.out.println();
        }
    }
}
