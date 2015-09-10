package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TODOSTATUS database table.
 * 
 */
@Entity
@NamedQuery(name="Todostatus.findAll", query="SELECT t FROM Todostatus t")
public class Todostatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long statusid;

	private String statustype;

	//bi-directional many-to-one association to Todolist
	@OneToMany(mappedBy="todostatus")
	private List<Todolist> todolists;

	public Todostatus() {
	}

	public long getStatusid() {
		return this.statusid;
	}

	public void setStatusid(long statusid) {
		this.statusid = statusid;
	}

	public String getStatustype() {
		return this.statustype;
	}

	public void setStatustype(String statustype) {
		this.statustype = statustype;
	}

	public List<Todolist> getTodolists() {
		return this.todolists;
	}

	public void setTodolists(List<Todolist> todolists) {
		this.todolists = todolists;
	}

	public Todolist addTodolist(Todolist todolist) {
		getTodolists().add(todolist);
		todolist.setTodostatus(this);

		return todolist;
	}

	public Todolist removeTodolist(Todolist todolist) {
		getTodolists().remove(todolist);
		todolist.setTodostatus(null);

		return todolist;
	}

}