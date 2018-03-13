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
public class Bitmap {
    BitmapFileHeader bfh;
    BitmapInformationHeader bih;
    PixelArray pa;
    String location;
    
    public Bitmap(){}
    
    void setBitmapFileHeader(BitmapFileHeader bfh){
        this.bfh = bfh;
    }
    
    BitmapFileHeader getBitmapFileHeader(){
        return this.bfh;
    }
    
    void printBitmapFileHeader(){
        System.out.println("Bitmap File Header");
        System.out.println("Type: " + bfh.getType());
        System.out.println("Size: " + bfh.getSize());
        System.out.println("Reserved1: " + bfh.getReserved1());
        System.out.println("Reserved2: " + bfh.getReserved2());
        System.out.println("Offset Pixels:" + bfh.getOffsetPixels());
    }
    
    void setBitmapInformationHeader(BitmapInformationHeader bih){
        this.bih = bih;
    }
    
    BitmapInformationHeader getBitmapInformationHeader(){
        return this.bih;
    }
    
    void printBitmapInformationHeader(){
        System.out.println("Bitmap Information Header");
        System.out.println("Size: " + bih.getSize());
        System.out.println("Header Name: " + bih.getHeaderName());
        System.out.println("Width in pixels: " + bih.getWidthPixels());
        System.out.println("Height in pixels: " + bih.getHeightPixels());
        System.out.println("Number of color planes: " + bih.getColorPlanes());
        System.out.println("Numbe of bits per pixel: " + bih.getBitsPerPixel());
        System.out.println("Compression method: " + bih.getCompression());
        System.out.println("Size of image: " + bih.getSizeImage());
        System.out.println("Horizontal Resolution: " + bih.getHorizontalResolution());
        System.out.println("Vertical Resolution: " + bih.getVerticalResolution());
        System.out.println("Number of colors: " + bih.getColors());
        System.out.println("Number of important colors: " + bih.getImportantColors());
    }
    
    void setPixelArray(PixelArray pa){
        this.pa = pa;
    }
    
    PixelArray getPixelArray(){
        return this.pa;
    }
    
    void printPixelArray(){
        System.out.println("Bitmap Pixel Array");
        System.out.println("Row size: " + pa.getRowSize());
        System.out.println("Pixel array size: " + pa.getPixelArraySize());
    }
    
    void setLocation(String location){
        this.location = location;
    }
    
    String getLocation(){
        return this.location;
    }
}
