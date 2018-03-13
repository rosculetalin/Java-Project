/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmapproject;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author alin_ionut.rosculet
 */
public class BytesOperations {
    public BytesOperations(){}
    
    int intFrom4Bytes(byte b1, byte b2, byte b3, byte b4){
        byte [] arr = new byte[4];
        arr[0] = b1;
        arr[1] = b2;
        arr[2] = b3;
        arr[3] = b4;
        ByteBuffer bb = ByteBuffer.wrap(arr);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        return bb.getInt();
    }
    
    
}
