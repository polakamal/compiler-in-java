/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;

/**
 *
 * @author pola
 */
public class LexicalAnalysis {
    private String text;
    public LexicalAnalysis(String text) {
        this.text = text;
    }
public ArrayList<String> scan(){
ArrayList<String> tokens = new ArrayList();
int i=0;
String op;
String sep;
char operator1;
   String key = "";
while(i < text.length() )
{
// variable and numbers and char and keywords tokens
 if( (Character.isLetter(text.charAt(i))|| Character.isDigit(text.charAt(i)) || text.charAt(i) =='.' || String.valueOf(text.charAt(i)).equals("'"))   && text.charAt(i) !=' ')
 {

    key += String.valueOf(text.charAt(i));
     
      
 }
 else
 {
       
            // System.out.println(key.isEmpty());  
   if(!key.isEmpty())
   {   
 tokens.add(key);
 key = "";
 }
  }
 //operators tokens
 switch (text.charAt(i)){
                           case'+': 
                         tokens.add(String.valueOf(text.charAt(i)));
                          break;
                            
               case'-':    
                 tokens.add(String.valueOf(text.charAt(i)));
                          break;
                            case'/':
                  tokens.add(String.valueOf(text.charAt(i)));
                break;
            case'*':
                tokens.add(String.valueOf(text.charAt(i)));
                break;
            case'%':
                  tokens.add(String.valueOf(text.charAt(i)));
                break;
            case'^': 
                    tokens.add(String.valueOf(text.charAt(i)));
                break;
            case'=':
                operator1 = text.charAt(i+1);
                if(operator1=='='){
                      tokens.add(String.valueOf("=="));
                      i++;
                       break; 
                }
                     else{
                      tokens.add(String.valueOf(text.charAt(i)));
                          break;
                             }
            case'!':
  operator1 = text.charAt(i+1);
                if(operator1=='='){
                    
                       tokens.add(String.valueOf("!="));
                      
                 i++;
                  break;
                }
                     else{
                          tokens.add(String.valueOf(text.charAt(i)));
                          break;
                             }
            case'&': 
               operator1 = text.charAt(i+1);
                 if(operator1=='&'){
                     
                       tokens.add(String.valueOf("&&"));
                        i++;
                       break; }
                     else{
                        tokens.add(String.valueOf(text.charAt(i)));
                          break;
                             }
            case'|':
                  operator1 = text.charAt(i+1);
                 if(operator1=='|'){
                     i++;
                     tokens.add(String.valueOf("||"));
                       break; }
                     else{
                        tokens.add(String.valueOf(text.charAt(i)));
                          break;
                             }
            case'>':
                operator1 = text.charAt(i+1);
                 if(operator1=='='){
                     i++;
                 tokens.add(String.valueOf("=="));
                       break; }
                     else{
                         tokens.add(String.valueOf(text.charAt(i)));
                          break;
                             }
            case'<': 
             operator1 = text.charAt(i+1);
                if(operator1=='='){
                    i++;
                     tokens.add(String.valueOf("<="));
                       break; }
                     else{
                          tokens.add(String.valueOf(text.charAt(i)));
                          break;
                             }




}   
 
  //sepetrators tokens
sep = get_seperators (text.charAt(i));  
 if (!sep.isEmpty())
  {
  tokens.add(sep);
  }

i++;
}
if(!key.isEmpty()){
tokens.add(key);

}


return tokens;

}
 
  public String get_seperators ( char operator)
  {
  String sep = "";
   switch(operator){
            case',':
                 sep=  String.valueOf(operator);
            case'(':
               sep = String.valueOf(operator);
         
             case')':
               sep = String.valueOf(operator);
        
             case'{':
               sep = String.valueOf(operator);
            
             case'}':
             sep = String.valueOf(operator);
               
            
             case';':
             sep = String.valueOf(operator);
               
               
        }
  
  return sep;
  }
 public ArrayList<String> tokens(ArrayList<String> tokens)
 {
 
 return tokens;
 }  
  
  

}