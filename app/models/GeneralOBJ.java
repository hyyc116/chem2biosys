package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.GenericModel;

@Entity
public class GeneralOBJ extends GenericModel {

	public String type;

	public String name;
	@Id
	public String id;

	public String otherid;

//	@OneToMany(mappedBy = "obj1")
//	public List<Pair> pairs;
//
//	@OneToOne(mappedBy = "obj2")
//	public Pair pair;

	public GeneralOBJ(String type, String name, String id) {
		super();
		this.type = type;
		this.name = name;
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public List<Pair> getPairs() {
//		return pairs;
//	}
//
//	public void setPairs(List<Pair> pairs) {
//		this.pairs = pairs;
//	}
//
//	public Pair getPair() {
//		return pair;
//	}
//
//	public void setPair(Pair pair) {
//		this.pair = pair;
//	}

	public String getOtherid() {
		return otherid;
	}

	public void setOtherid(String otherid) {
		this.otherid = otherid;
	}

}
