package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.GenericModel;

@Entity
public class Pair extends GenericModel {
	@Id
	public Long pid;

	@ManyToOne
	public GeneralOBJ obj1;

	@OneToOne
	public GeneralOBJ obj2;

	public float score;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public GeneralOBJ getObj1() {
		return obj1;
	}

	public void setObj1(GeneralOBJ obj1) {
		this.obj1 = obj1;
	}

	public GeneralOBJ getObj2() {
		return obj2;
	}

	public void setObj2(GeneralOBJ obj2) {
		this.obj2 = obj2;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
