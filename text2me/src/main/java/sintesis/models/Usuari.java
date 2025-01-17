package sintesis.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuaris")
public class Usuari // Definició dels usuaris en el sistema.
{

	public Usuari() {

	}

	public Usuari(int id, String username, String correu, String password, boolean estatActivitat,
			List<Missatge> missatgesEnviats, List<Missatge> missatgesRebuts, List<Chat> chatsIniciats,
			List<Chat> chatsRebuts) {
		super();
		this.id = id;
		this.username = username;
		this.correu = correu;
		this.password = password;
		this.estatActivitat = estatActivitat;
		this.missatgesEnviats = missatgesEnviats;
		this.missatgesRebuts = missatgesRebuts;
		this.chatsIniciats = chatsIniciats;
		this.chatsRebuts = chatsRebuts;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = true, nullable = false)
	private String correu;

	@Column(unique = true, nullable = false)
	private String password;

	private boolean estatActivitat = true;

	@OneToMany(mappedBy = "remitent", cascade = CascadeType.ALL)
	private List<Missatge> missatgesEnviats;

	@OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL)
	private List<Missatge> missatgesRebuts;

	@OneToMany(mappedBy = "usuari1", cascade = CascadeType.ALL)
	private List<Chat> chatsIniciats;

	@OneToMany(mappedBy = "usuari2", cascade = CascadeType.ALL)
	private List<Chat> chatsRebuts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEstatActivitat() {
		return estatActivitat;
	}

	public void setEstatActivitat(boolean estatActivitat) {
		this.estatActivitat = estatActivitat;
	}

	public List<Missatge> getMissatgesEnviats() {
		return missatgesEnviats;
	}

	public void setMissatgesEnviats(List<Missatge> missatgesEnviats) {
		this.missatgesEnviats = missatgesEnviats;
	}

	public List<Missatge> getMissatgesRebuts() {
		return missatgesRebuts;
	}

	public void setMissatgesRebuts(List<Missatge> missatgesRebuts) {
		this.missatgesRebuts = missatgesRebuts;
	}

	public List<Chat> getChatsIniciats() {
		return chatsIniciats;
	}

	public void setChatsIniciats(List<Chat> chatsIniciats) {
		this.chatsIniciats = chatsIniciats;
	}

	public List<Chat> getChatsRebuts() {
		return chatsRebuts;
	}

	public void setChatsRebuts(List<Chat> chatsRebuts) {
		this.chatsRebuts = chatsRebuts;
	}

}