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
	public static void search(String id) {
		//return top 10 most similar compounds
		List<GeneralOBJ> objs = new ArrayList<GeneralOBJ>();
		GeneralOBJ obj = GeneralOBJ.findById(id);
		for(Pair pair:obj.getPairs()){
			objs.add(pair.getObj2());
		}
		//return top 10 most similar proteins
		renderJSON(objs);
	}

}