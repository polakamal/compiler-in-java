/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pola
 */
public class Compiler {

   
    public static void main(String[] args) throws IOException {
 ArrayList<String> tokens;
        
      Readfiles f  = new Readfiles();
      File  fl = new File("C:\\Users\\pola\\OneDrive\\Desktop\\test.txt");
     tokens   = f.readfile(fl);
  /*  for(int i=0;i<tokens.size();i++)
    {
    
        System.out.println( i +" "+ tokens.get(i));
     
    
    
    }
            
           */
            
            
       parser p  =new parser(tokens);
  
ArrayList<String> out  = p.choose_stat();
    for(int i=0;i<out.size();i++)
    {
    
        System.out.println(out.get(i));
    
    
    }
}
}