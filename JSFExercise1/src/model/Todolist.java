package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the TODOLIST database table.
 * 
 */
@Entity
@NamedQuery(name="Todolist.findAll", query="SELECT t FROM Todolist t")
public class Todolist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "todolistSeq", sequenceName = "todolist_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todolistSeq")
	private long listid;

	private String datecompleted;

	private String description;

	private String duedate;

	private int priorityid;

	//bi-directional many-to-one association to Todostatus
	@ManyToOne
	@JoinColumn(name="STATUSID")
	private Todostatus todostatus;

	//bi-directional many-to-one association to Todouser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Todouser todouser;

	public Todolist() {
	}

	public long getListid() {
		return this.listid;
	}

	public void setListid(long listid) {
		this.listid = listid;
	}

	public String getDatecompleted() {
		return this.datecompleted;
	}

	public void setDatecompleted(String datecompleted) {
		this.datecompleted = datecompleted;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuedate() {
		return this.duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public int getPriorityid() {
		return this.priorityid;
	}

	public void setPriorityid(int priorityid) {
		this.priorityid = priorityid;
	}

	public Todostatus getTodostatus() {
		return this.todostatus;
	}

	public void setTodostatus(Todostatus todostatus) {
		this.todostatus = todostatus;
	}

	public Todouser getTodouser() {
		return this.todouser;
	}

	public void setTodouser(Todouser todouser) {
		this.todouser = todouser;
	}

}