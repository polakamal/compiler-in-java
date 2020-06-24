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
public class parser {

  private  ArrayList<String> tokens;
  private int line=1;
  private int i=0;
  int x=i;
  private String token;
  String keyword;
  private ArrayList<String> output = new ArrayList() ;
    public parser(ArrayList<String> tokens) {
        this.tokens = tokens;
    token = tokens.get(0);
    }
 public ArrayList<String> choose_stat()
{
    
while(i < tokens.size()){
    
if(match_keyword(token))
{

declare();

}
else 
{
  
undirect_declare();

}


 
if (token.equals("@"))
{
    
line++;
  
}

 if(i+1<tokens.size()) 
 {
     gettoken(i);
 }else i++; 
   
   


}
return output;
}
   void gettoken(int i)
{ 
  
   if(i+1<tokens.size()) 
   {
this.i=i+1;
 this.token = this.tokens.get(this.i);
  }
   else this.token = this.tokens.get(i);

}

  public Boolean match_keyword(String token)

{
if(token.equals("int")||token.equals("float")||token.equals("char"))
{
gettoken(i);
return true;

}
 else return false;
}// 
void declare()
{
    
   
   keyword  = define_type(token);
   //System.out.println(keyword);
if(match_var().contains("Error"))
{
    output.add(match_var() +  " at line " +line);
    gettoken(i);
while(match_comma(token) && !token.equals(";"))
  {   
       
      if(match_var().contains("Error") )
      { 
      
     output.add(match_var() +  " at line " +line);
          gettoken(i);
      }
      
   }
}
else {
  while(match_comma(token) && !token.equals(";"))
  {   
       
      if(match_var().contains("Error") )
      { 
      
     output.add(match_var() +  " at line " +line);
          gettoken(i);
      }
      
   }  
    
} 
if (match_assignmt(token))
   {
  
   assigment();
       
   
   
   }
  if(match_endofStatment(token).contains("Error"))
  {
  
  output.add(match_endofStatment(token) +  " at line " +line);
  
  
  }
  else
  { 
      
      if(output.size() ==0)
      {
      output.add("sucess");
      }
      
  }

}   
String match_var()
 {
     String out;
 if(!Character.isDigit(token.charAt(0)))
 {
   gettoken(i);
 out = "sucess";
 }
 else 
 {
 
 out = "Error : begin with digit " + token ;

 }
 return out;
 }  
   
  public String match_endofStatment(String token)
{
String out;
if(!token.equals(";"))
{


out = "Error : semi colon   missing at the end of statment";



}
else {
    out = "succuess";
    gettoken(i);
}

  return  out;
}//
  Boolean match_comma(String token)
{
  
if(token.equals(","))
{
    gettoken(i);
return true;

}
else return false;
   }//
  Boolean match_assignmt(String token)
{
  
if(token.equals("="))
{
    gettoken(i);
return true;

}
else return false;
   }//
  void  assigment ()
{
    
   if (sep_left(token))
   {
  
   assigment();
   
  sep_right(token);
    if(op(token))
   {
   
  assigment();
     
   } 
     }
   

   if(type().contains("Error") ) 
   { 
  
     
    output.add(type());
       gettoken(i);
   
       }
 
   
   if(op(token))
   {
   
  assigment();
     
   }


}

String type()
{
     
  String type = keyword;
  String out = "suecess";
  String type2 = define_type(token);
 if (keyword.isEmpty()){}
 else
 {
  if(type.equals("int"))  
  { 
if(!token.contains("'") &&!token.contains(".") && !type2.equals("char") )
{
  if(!token.equals(";") && !token.equals(")") )
  {
    gettoken(i);
out = "sucess";
 
  }
 
}
else {
   if(token.contains("."))
   {
   out= "Error : wrong expression u defined int and get "+ token +" float " +"at line "+ line;
   
   }
  else out = "Error : wrong expression u defined int and get "+ token +" char "+"at line "+ line;
} 
  
  }
  else if (type.equals("char"))
  {
      if(token.contains("'") && (!type2.equals("float") ||!type2.equals("int"))  )
  {
      if(!token.equals(";") && !token.equals(")"))
   {
    gettoken(i);
out = "sucess";
 
  }
 

}
else
{
out = "Error : wrong expression u defined char and get " + token +" number " +" at line "+ line;
}
  }
 else if (type.equals("float"))
              {
    
          if(!token.contains("'") && !type2.equals("char"))
{
  
 if(!token.equals(";")  && !token.equals(")"))
  {
    gettoken(i);
out = "sucess";
 
  }
                        }    
          else out= "Error : wrong expression u defined float and get "+ token +" char" +" at line " + line;
              } 
 }

return out;
} 
Boolean op(String token)
{
 
if (token.equals("*") || token.equals("+") ||token.equals("/")||token.equals("-"))
{
    gettoken(i);
return true;
}

else return false;
}
Boolean sep_left (String token)
{
if(token.equals("("))
{
    gettoken(i);
return true;
}
else
{
    return false;
} 
}
Boolean sep_right (String token)
{
   
if(token.equals(")"))
{ 
    
    gettoken(i);
    
return true;
}
else
{
    output.add("missing right operand )" +" at line "+ line);
    return false;
}
}//

String define_type(String token)
{
   String old = null ; 
   int counter=0;
   int q =0;

 while (q< tokens.size())
  {
    
  if(!tokens.get(q).equals(token))
  {
     
   counter +=counter; 
  }
  else break;
 
q++;  
  }
 
while (q>=0)
{

if(tokens.get(q).equals("int")||tokens.get(q).equals("char")|| tokens.get(q).equals("float") )
{
    
old = tokens.get(q) ;
break;
}
else old = null;
q--;
}

return old;
  }//
void undirect_declare()
{
    
   keyword  = define_type(token); 
    System.out.println(define_type(token));
   if(keyword.equals(null))
   {
   System.out.println("sss");
   
   }
   else declare();

} 
Boolean match_if(String token)
 {
    
 if(token.equals("if"))
 {
  gettoken(i);
 return true;
 
 }
 else return false;
 
 }
}
 