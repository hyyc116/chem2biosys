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
		// return top 10 most similar compounds
		List<GeneralOBJ> objs = new ArrayList<GeneralOBJ>();
		// GeneralOBJ obj = GeneralOBJ.findById(id);
		// for(Pair pair:obj.getPairs()){
		// objs.add(pair.getObj2());
		// }
		Set<String> alreadys = new HashSet<String>();
		List<Pair> ps = Pair.find("obj1.id = ? and score = 2", id).fetch();
		for (Pair p : ps) {
			if (!alreadys.contains(p.getObj2().getId())) {
				objs.add(p.obj2);
				alreadys.add(p.obj2.getId());
			}
		}
		// return top 10 most similar proteins
		renderJSON(objs);
	}

	public static void recomend(String id) {
		List<Pair> pairs = new ArrayList<Pair>();
		Set<String> alreadys = new HashSet<String>();
		List<Pair> ps = Pair
				.find("obj1.id = ? and score <=1 and score > 0.85 and obj2.type='Compound' order by score desc", id)
				.fetch(20);
		for (Pair p : ps) {
			if (!alreadys.contains(p.getObj2().getId())) {
				pairs.add(p);
				alreadys.add(p.obj2.getId());
			}
		}

		List<Pair> ps2 = Pair
				.find("obj1.id = ? and score <=1 and score > 0.85 and obj2.type='Protein' order by score desc", id)
				.fetch(20);
		for (Pair p : ps2) {
			if (!alreadys.contains(p.getObj2().getId())) {
				pairs.add(p);
				alreadys.add(p.obj2.getId());
			}
		}
		renderJSON(pairs);
	}

}