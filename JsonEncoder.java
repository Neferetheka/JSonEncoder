package tools;

import java.lang.reflect.*;
import java.util.List;

public class JsonEncoder
{
  public static String EncodeJSon(List<Object> toSerialize, List<String> sortParameters) throws IllegalArgumentException, IllegalAccessException
  {   
    if(toSerialize.size() == 0)
      return null;
    Class c = toSerialize.get(0).getClass();
    String result = "{\""+c.getName()+"s\":[";
    
    for(Object objet : toSerialize)
    {
      result += "{";
      for(Field proprietes : objet.getClass().getFields())
      {
       
        String name = proprietes.getName();
        
        if(!sortParameters.contains(name))
        {
          result += "\""+name+" \" : \""+proprietes.get(proprietes).toString()+"\",";
        }

      }
      result = result.substring(0, result.length()-1);
      result += "}";
      
      if(!toSerialize.get(toSerialize.size()-1).equals(objet))
        result+=",";
    }
    
    result +="]}";
    
    return result;
  }
}