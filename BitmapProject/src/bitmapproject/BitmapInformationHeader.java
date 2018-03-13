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
public class BitmapInformationHeader extends BytesOperations{
    int size;
    String headerName;
    int widthPixels;
    int heightPixels;
    short colorPlanes;
    short bitsPerPixel;
    int compression;
    int sizeImage;
    int horizontalResolution;
    int verticalResolution;
    int colors;
    int importantColors;
    
    public BitmapInformationHeader(){}
    
    void setSize(byte b1, byte b2, byte b3, byte b4){
        this.size = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setSize(int size){
        this.size = size;
    }
    
    int getSize(){
        return this.size;
    }
    
    void setHeaderName(){
        if(this.size != 0)
        switch(this.size){
            case 12:    this.headerName = "OS21XBITMAPHEADER";
                        break;
            case 64:    this.headerName = "OS22XBITMAPHEADER";
                        break;
            case 16:    this.headerName = "OS22XBITMAPHEADER";
                        break;
            case 40:    this.headerName = "BITMAPINFOHEADER";
                        break;
            case 52:    this.headerName = "BITMAPV2INFOHEADER";
                        break;
            case 56:    this.headerName = "BITMAPV3INFOHEADER";
                        break;
            case 108:   this.headerName = "BITMAPV4HEADER";
                        break;
            case 124:   this.headerName = "BITMAPV5HEADER";
                        break;
        }
    }
    
    void setHeaderName(String headerName){
        this.headerName = headerName;
    }
    
    String getHeaderName(){
        return this.headerName;
    }
    
    void setWidthPixels(byte b1, byte b2, byte b3, byte b4){
        this.widthPixels = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setWidthPixels(int widthPixels){
        this.widthPixels = widthPixels;
    }
    
    int getWidthPixels(){
        return this.widthPixels;
    }
    
    void setHeightPixels(byte b1, byte b2, byte b3, byte b4){
        this.heightPixels = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setHeightPixels(int heightPixels){
        this.heightPixels = heightPixels;
    }
    
    int getHeightPixels(){
        return this.heightPixels;
    }
    
    void setColorPlanes(byte b1, byte b2){
        byte b3 = 0;
        byte b4 = 0;
        this.colorPlanes = (short)intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setColorPlanes(short colorPlanes){
        this.colorPlanes = colorPlanes;
    }
    
    short getColorPlanes(){
        return this.colorPlanes;
    }
    
    void setBitsPerPixel(byte b1, byte b2){
        byte b3 = 0;
        byte b4 = 0;
        this.bitsPerPixel = (short)intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setBitsPerPixel(short bitsPerPixel){
        this.bitsPerPixel = bitsPerPixel;
    }
    
    short getBitsPerPixel(){
        return this.bitsPerPixel;
    }
    
    void setCompression(byte b1, byte b2, byte b3, byte b4){
        this.compression = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setCompression(int compression){
        this.compression = compression;
    }
    
    int getCompression(){
        return this.compression;
    }
    
    void setSizeImage(byte b1, byte b2, byte b3, byte b4){
        this.sizeImage = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setSizeImage(int sizeImage){
        this.sizeImage = sizeImage;
    }
    
    int getSizeImage(){
        return this.sizeImage;
    }
    
    void setHorizontalResolution(byte b1, byte b2, byte b3, byte b4){
        this.horizontalResolution = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setHorizontalResolution(int horizontalResolution){
        this.horizontalResolution = horizontalResolution;
    }
    
    int getHorizontalResolution(){
        return this.horizontalResolution;
    }
    
    void setVerticalResolution(byte b1, byte b2, byte b3, byte b4){
        this.verticalResolution = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setVerticalResolution(int verticalResolution){
        this.verticalResolution = verticalResolution;
    }
    
    int getVerticalResolution(){
        return this.verticalResolution;
    }
    
    void setColors(byte b1, byte b2, byte b3, byte b4){
        this.colors = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setColors(int colors){
        this.colors = colors;
    }
    
    int getColors(){
        return this.colors;
    }
    
    void setImportantColors(byte b1, byte b2, byte b3, byte b4){
        this.importantColors = intFrom4Bytes(b1,b2,b3,b4);
    }
    
    void setImportantColors(int importantColors){
        this.importantColors = importantColors;
    }
    
    int getImportantColors(){
        return this.importantColors;
    }
}
