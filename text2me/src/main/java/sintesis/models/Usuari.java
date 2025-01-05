package sintesis.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuaris")
public class Usuari // Definició dels usuaris en el sistema.
{

	public Usuari() {

	}

	public Usuari(int id, String nom, String cognom, String correu, String telefon, String adreça, String password,
			String rol, Date dataDeCreacio) {
		super();
		this.id = id;
		this.nom = nom;
		this.cognom = cognom;
		this.correu = correu;
		this.telefon = telefon;
		this.adreça = adreça;
		this.password = password;
		this.rol = rol;
		this.dataDeCreacio = dataDeCreacio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;
	private String cognom;

	@Column(unique = true, nullable = false)
	private String correu;

	private String telefon;
	private String adreça;
	private String password;
	private String rol;
	private Date dataDeCreacio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getDataDeCreacio() {
		return dataDeCreacio;
	}

	public void setDataDeCreacio(Date dataDeCreacio) {
		this.dataDeCreacio = dataDeCreacio;
	}

}
