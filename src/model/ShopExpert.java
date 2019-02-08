package model;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ShopExpert {
	
	public String readJSONFile() {
		// parsing file "shopExpert.json" 	
		BufferedReader reader = null;
		String temp = "";
	    try{
	        reader = new BufferedReader(new FileReader("D:/DAW2/DWES/Servlets/resources/shopExpert.json"));
	        Gson gson = new GsonBuilder().create();
	        Pregunta pregunta = gson.fromJson(reader, Pregunta.class);
	        if(pregunta != null){
	        	temp = ("\nLabel: "+pregunta.getLabel()+
                			   " Question: "+pregunta.getQuestion());
                for(Pregunta child : pregunta.getChildren()){
                    System.out.println(temp+" Answer: "+child.getLabel());
                    temp += " Answer: "+child.getLabel();
                }
	        }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
		return temp;
	}
	
}
