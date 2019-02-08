package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Pregunta {

	private String label;
	private String question;
	private List<Pregunta> children;
	
	public Pregunta () {
		
	}
	
	public Pregunta (String label, String question, List<Pregunta> children) {
		this.label = label;
		this.question = question;
		this.children = children;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<Pregunta> getChildren() {
		return children;
	}
	
	public void setChildren(List<Pregunta> children) {
		this.children = children;
	}
	
	public Pregunta parsePrimeraPregunta() {
		// parsing file "shopExpert.json"
		Pregunta pregunta = new Pregunta();
		BufferedReader reader = null;
		List<Pregunta> respostas = new ArrayList<Pregunta>();

	    try{
	        reader = new BufferedReader(new FileReader("D:/DAW2/DWES/Servlets/eclipse/Shop expert system J2EE/WebContent/resources/shopExpert.json"));
	        Gson gson = new GsonBuilder().create();
	        pregunta = gson.fromJson(reader, Pregunta.class);

            for(Pregunta child : pregunta.getChildren()){
            	respostas.add(child);
            }
	        pregunta.setChildren(respostas);
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
	    return pregunta;
	}
	
	public Pregunta parseFromAnswer(String answer) {
		// parsing file "shopExpert.json"
		int index;
		try {
			Integer ans = Integer.parseInt(answer);
			index = ans.intValue();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage()+e);
		}		
		Pregunta pregunta = new Pregunta();
		BufferedReader reader = null;
		List<Pregunta> respostas = new ArrayList<Pregunta>();

	    try{
	        reader = new BufferedReader(new FileReader("D:/DAW2/DWES/Servlets/eclipse/Shop expert system J2EE/WebContent/resources/shopExpert.json"));
	        Gson gson = new GsonBuilder().create();
	        pregunta = gson.fromJson(reader, Pregunta.class);

            for(Pregunta child : pregunta.getChildren()){
            	respostas.add(child);
            }
	        pregunta.setChildren(respostas);
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
	    return pregunta;
	}
}
