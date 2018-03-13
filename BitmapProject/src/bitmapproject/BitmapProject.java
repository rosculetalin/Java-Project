/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmapproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.nanoTime;

/**
 *
 * @author alin_ionut.rosculet
 */
public class BitmapProject{
    
  
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File fileOrigin = new File("C:\\Users\\alin_ionut.rosculet\\Documents\\NetBeansProjects\\BitmapProject\\src\\bitmapproject\\tiger.bmp");
        FileInputStream fis = new FileInputStream(fileOrigin);
        DataInputStream in = new DataInputStream(fis);
        
        long t1 = nanoTime();
        
        byte metadata [] = new byte[54];
        for(int k = 0; k < 54; k++)
            metadata[k] = in.readByte();
        
        long t2 = nanoTime();
        
        BitmapFileHeader bfh = new BitmapFileHeader();
        bfh.setType(metadata[0], metadata[1]);   //2
        bfh.setSize(metadata[2], metadata[3], metadata[4], metadata[5]);  //6
        bfh.setReserved1(metadata[6], metadata[7]);  //8
        bfh.setReserved2(metadata[8], metadata[9]);  //10
        bfh.setOffsetPixels(metadata[10], metadata[11], metadata[12], metadata[13]);   //14
        
        System.out.println("Bitmap File Header");
        System.out.println("Type: " + bfh.getType());
        System.out.println("Size: " + bfh.getSize());
        System.out.println("Reserved1: " + bfh.getReserved1());
        System.out.println("Reserved2: " + bfh.getReserved2());
        System.out.println("Offset Pixels:" + bfh.getOffsetPixels());
        
        BitmapInformationHeader bih = new BitmapInformationHeader();
        bih.setSize(metadata[14], metadata[15], metadata[16], metadata[17]);  //18  
        bih.setHeaderName();
        if(bih.getSize() == 40){
            bih.setWidthPixels(metadata[18], metadata[19], metadata[20], metadata[21]);  //22
            bih.setHeightPixels(metadata[22], metadata[23], metadata[24], metadata[25]);  //26
            bih.setColorPlanes(metadata[26], metadata[27]);   //28
            bih.setBitsPerPixel(metadata[28], metadata[29]);  //30
            bih.setCompression(metadata[30], metadata[31], metadata[32], metadata[33]);  //34
            bih.setSizeImage(metadata[34], metadata[35], metadata[36], metadata[37]);   //38
            bih.setHorizontalResolution(metadata[38], metadata[39], metadata[40], metadata[41]);  //42
            bih.setVerticalResolution(metadata[42], metadata[43], metadata[44], metadata[45]);  //46
            bih.setColors( metadata[46], metadata[47], metadata[48], metadata[49] );  //50
            bih.setImportantColors(metadata[50], metadata[51], metadata[52], metadata[53]);  //54
        }
        
        System.out.println();
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
        
        long t3 = nanoTime();
        
        PixelArray pa = new PixelArray();
        pa.setRowSize(bih.getBitsPerPixel(), bih.getWidthPixels());
        pa.setPixelArraySize(bih.getHeightPixels());
        int m = pa.getPixelArraySize() / pa.getRowSize();
        int n = pa.getRowSize();
        byte data [][] = new byte[m][n];
        byte padding[][] = new byte[m][2];
        for(int i = 0; i < m; i++)
        for(int j = 0; j < n; j++){
            data[i][j] = in.readByte();
            if(j == n-2)    padding[i][0] = data[i][j];
            if(j == n-1)    padding[i][1] = data[i][j];
        }
        pa.setData(data);
        
        System.out.println();
        System.out.println("Bitmap Pixel Array");
        System.out.println("Row size: " + pa.getRowSize());
        System.out.println("Pixel array size: " + pa.getPixelArraySize());
        //pa.displayData(); 
        
        long t4 = nanoTime();
        
        
        /*
        FileOutputStream fos = new FileOutputStream("C:\\Users\\alin_ionut.rosculet\\Documents\\NetBeansProjects\\BitmapProject\\src\\bitmapproject\\tiger222.bmp");
        DataOutputStream out = new DataOutputStream(fos);
        out.write(metadata);
        
        
        int x = 0;
        byte [] y = new byte[3];
        y[0] = 0;
        y[1] = 0;
        y[2] = 0;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-3; j >= 0; j--){
                if(x == 0){
                    y[2] = data[i][j];
                }
                if(x == 1){
                    y[1] = data[i][j];
                }
                if(x == 2){
                    y[0] = data[i][j];
                    out.write(y);
                }
                x = (x + 1) % 3;
            }
            out.write(padding[i][1]);
            out.write(padding[i][0]);
        }
        */
        Bitmap bmp1 = new Bitmap();
        bmp1.setBitmapInformationHeader(bih);
        bmp1.setBitmapFileHeader(bfh);
        bmp1.setPixelArray(pa);
        bmp1.setLocation("C:\\Users\\alin_ionut.rosculet\\Documents\\NetBeansProjects\\BitmapProject\\src\\bitmapproject\\tiger.bmp");
        
        FileOutputStream fos = new FileOutputStream("C:\\Users\\alin_ionut.rosculet\\Documents\\NetBeansProjects\\BitmapProject\\src\\bitmapproject\\tiger2.bmp");
        DataOutputStream out = new DataOutputStream(fos);
        
        long t5 = nanoTime();
        
        BitmapFileHeader bfh90 = new BitmapFileHeader();
        BitmapInformationHeader bih90 = new BitmapInformationHeader();
        PixelArray pa90 = new PixelArray();
        
        bfh90.setType(bfh.getType());
        //lipsa aici de size = linia *
        bfh90.setReserved1(bfh.getReserved1());
        bfh90.setReserved1(bfh.getReserved2());
        bfh90.setOffsetPixels(bfh.getOffsetPixels());
        
        bih90.setSize(bih.getSize());
        bih90.setHeaderName(bih.getHeaderName());
        bih90.setWidthPixels(bih.getHeightPixels());
        bih90.setHeightPixels(bih.getWidthPixels());
        bih90.setColorPlanes(bih.getColorPlanes());
        bih90.setBitsPerPixel(bih.getBitsPerPixel());
        bih90.setCompression(bih.getCompression());
        //lipsa aici de sizeImage = linia **
        bih90.setHorizontalResolution(bih.getHorizontalResolution());
        bih90.setVerticalResolution(bih.getVerticalResolution());
        bih90.setColors(bih.getColors());
        bih90.setImportantColors(bih.getImportantColors());
        
        
        pa90.setRowSize(bih90.getBitsPerPixel(),bih90.getWidthPixels());
        pa90.setPixelArraySize(bih90.getHeightPixels());
        //lipsa aici de date = linia ***
        
        bfh90.setSize(pa90.getPixelArraySize() + bfh90.getOffsetPixels());   //linia *
        bih90.setSizeImage(pa90.getPixelArraySize());  //linia **
        
        System.out.println();
        System.out.println("Bitmap File Header");
        System.out.println("Type: " + bfh90.getType());
        System.out.println("Size: " + bfh90.getSize());
        System.out.println("Reserved1: " + bfh90.getReserved1());
        System.out.println("Reserved2: " + bfh90.getReserved2());
        System.out.println("Offset Pixels:" + bfh90.getOffsetPixels());
        
        System.out.println();
        System.out.println("Bitmap Information Header");
        System.out.println("Size: " + bih90.getSize());
        System.out.println("Header Name: " + bih90.getHeaderName());
        System.out.println("Width in pixels: " + bih90.getWidthPixels());
        System.out.println("Height in pixels: " + bih90.getHeightPixels());
        System.out.println("Number of color planes: " + bih90.getColorPlanes());
        System.out.println("Numbe of bits per pixel: " + bih90.getBitsPerPixel());
        System.out.println("Compression method: " + bih90.getCompression());
        System.out.println("Size of image: " + bih90.getSizeImage());
        System.out.println("Horizontal Resolution: " + bih90.getHorizontalResolution());
        System.out.println("Vertical Resolution: " + bih90.getVerticalResolution());
        System.out.println("Number of colors: " + bih90.getColors());
        System.out.println("Number of important colors: " + bih90.getImportantColors());
        
        System.out.println();
        System.out.println("Bitmap Pixel Array");
        System.out.println("Row size: " + pa90.getRowSize());
        System.out.println("Pixel array size: " + pa90.getPixelArraySize());
        
        long t6 = nanoTime();
        
        out.write(metadata[0]);  //type
        out.write(metadata[1]);  //2
        out.write(intToByteArray(bfh90.getSize()));   //6
        out.write(intToByteArrayTwo(bfh90.getReserved1())); //8
        out.write(intToByteArrayTwo(bfh90.getReserved2()));  //10
        out.write(intToByteArray(bfh90.getOffsetPixels()));  //14
        
        out.write(intToByteArray(bih90.getSize()));  //18
        out.write(intToByteArray(bih90.getWidthPixels()));  //22
        out.write(intToByteArray(bih90.getHeightPixels()));  //26
        out.write(intToByteArrayTwo(bih90.getColorPlanes()));  //28
        out.write(intToByteArrayTwo(bih90.getBitsPerPixel()));  //30
        out.write(intToByteArray(bih90.getCompression())); //34
        out.write(intToByteArray(bih90.getSizeImage()));  //38
        out.write(intToByteArray(bih90.getHorizontalResolution()));  //42
        out.write(intToByteArray(bih90.getVerticalResolution())); //46
        out.write(intToByteArray(bih90.getColors())); //50
        out.write(intToByteArray(bih90.getImportantColors())); //54
        
        long t7 = nanoTime();
        
        int m90 = pa90.getPixelArraySize() / pa90.getRowSize();
        int n90 = pa90.getRowSize();
        byte data90 [][] = new byte[m90][n90];
        int i90 = m90-1;
        int j90 = 0;
        int x = 0;
        byte [] y = new byte[3];
        y[0] = 0;
        y[1] = 0;
        y[2] = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n-2; j++){
                if(x == 0){
                    y[0] = data[i][j];
                }
                if(x == 1){
                    y[1] = data[i][j];
                }
                if(x == 2){
                    y[2] = data[i][j];
                    data90[i90][j90] = y[0];
                    data90[i90][j90+1] = y[1];
                    data90[i90][j90+2] = y[2];
                    i90--;
                    if(i90 == -1){
                        i90 = m90 - 1;
                        j90 = j90 + 3;
                    }
                }
                x = (x + 1) % 3;
            }
        }
        
        for(int i = 0; i < m90; i++){
            for(int j = n90-2; j < n90; j++){
                data90[i][j] = 0; 
            }
        }
        
        pa90.setData(data90);
        //pa90.displayData();
        
        long t8 = nanoTime();
        
        for(int i = 0; i < m90; i++)
        for(int j = 0; j < n90; j++)
            out.write(data90[i][j]);
        
        long t9 = nanoTime();
        
        Bitmap bmp2 = new Bitmap();
        bmp2.setBitmapInformationHeader(bih);
        bmp2.setBitmapFileHeader(bfh);
        bmp2.setPixelArray(pa);
        bmp2.setLocation("C:\\Users\\alin_ionut.rosculet\\Documents\\NetBeansProjects\\BitmapProject\\src\\bitmapproject\\tiger2.bmp");
        
        System.out.println("Timpul de citire al header-erelor, de la bitmap-ul de citire");
        System.out.println((t2-t1));
        System.out.println("Timpul de procesare si printare al header-erelor, de la bitmap-ul de citire");
        System.out.println((t3-t2));
        System.out.println("Timpul de citire si procesare al matricii de pixeli, de la bitmap-ul de citire");
        System.out.println((t4-t3));
        System.out.println("Timpul de procesare al header-erelor,la bitmap-ul de scriere");
        System.out.println((t6-t5));
        System.out.println("Timpul de scriere al header-erelor,la bitmap-ul de scriere");
        System.out.println((t7-t6));
        System.out.println("Timpul de procesare al matricii de pixeli,la bitmap-ul de scriere");
        System.out.println((t8-t7));
        System.out.println("Timpul de scriere al matricii de pixeli,la bitmap-ul de scriere");
        System.out.println((t9-t8));
        
    }
    
    static byte[] intToByteArray(int value){
        byte [] arr = new byte[4];
        byte aux;
        arr[0] = (byte)(value >>> 24);
        arr[1] = (byte)(value >>> 16);
        arr[2] = (byte)(value >>> 8);
        arr[3] = (byte)value;
        
        aux = arr[0];
        arr[0] = arr[3];
        arr[3] = aux;
        
        aux = arr[1];
        arr[1] = arr[2];
        arr[2] = aux;
        
        return arr;
    }
    
    
    static byte[] intToByteArrayTwo(short value){
        byte [] arr = new byte[2];
        arr[0] = (byte)(value & 0xff);
        arr[1] = (byte)((value >> 8) & 0xff);
        return arr;
    }
    
    
}
