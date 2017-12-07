package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static void index() {
		render();
	}

	// define a ajax action for prompting
	public static void searchPrompt(String phrase) {
		List<GeneralOBJ> objs = GeneralOBJ.find("byNameLike", "%" + phrase + "%").fetch();
		renderJSON(objs);
	}

	// define a ajax action for search result
	public static void search(String phrase, String type) {
		//return top 10 most similar compounds
		
		//return top 10 most similar proteins 
	}

}