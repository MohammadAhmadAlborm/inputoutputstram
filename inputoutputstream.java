/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package datainputandoutputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Mohammad
 */
public class DataInputAndOutputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException ,EOFException{
        // TODO code application logic here
        int id []={1,2,3,4,5};
        String name[]={"Mohammad","Ahmad","Ali","Tamer","Malek"};
        double avg[]={80,85,67,90,78};
        DataOutputStream dataOutputStream = new DataOutputStream(
                new FileOutputStream("C:\\Users\\Mohammad\\Desktop\\2019-2\\JavaExamples\\InputOutputStram.txt"));
        for(int i=0;i<id.length;i++)
        {
            
            dataOutputStream.writeInt(id[i]);
            dataOutputStream.writeChar('\t');
            dataOutputStream.writeUTF(name[i]);
            dataOutputStream.writeChar('\t');
            dataOutputStream.writeDouble(avg[i]);
            dataOutputStream.writeChar('\n');      
        }
        DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream("C:\\Users\\Mohammad\\Desktop\\2019-2\\JavaExamples\\InputOutputStram.txt"));
        int Id;
        String Name;
        double Avg;
        boolean status =true;
        while(status)
        {
            try {
                
                Id=dataInputStream.readInt();
                dataInputStream.readChar();
                Name=dataInputStream.readUTF();
                dataInputStream.readChar();
                Avg=dataInputStream.readDouble();
                dataInputStream.readChar();
                System.out.println("ID : "+Id);
                System.out.println("Name : "+Name);
                System.out.println("Avg : "+Avg);
                System.out.println(".............");
            } catch (EOFException eOFException) {
                status=false;
                System.out.println("Error : "+eOFException);
            }
        }
        
    }
    
}
