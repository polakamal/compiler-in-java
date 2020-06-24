/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author pola
 */
public class Readfiles {
    
    private String line;
    private ArrayList<String>  tokens = new ArrayList();
    private ArrayList<String>  lines = new ArrayList();
    String output;
    public ArrayList<String> readfile(File f) throws FileNotFoundException, IOException{
   FileReader fr  =new FileReader(f);
   BufferedReader  br = new BufferedReader(fr);
   int i=1;
ArrayList<String> old= new ArrayList();
   while((line = br.readLine()) != null )
   {
LexicalAnalysis lx =new LexicalAnalysis(line);    
lines = lx.scan();
lines.add("@");
for(i=0;i<lines.size();i++)
{
   
 tokens.add(lines.get(i));

}
  

      
   i++;
   }
   br.close();
  fr.close();
    
   return tokens; 
     
    }
    
    
    
}
