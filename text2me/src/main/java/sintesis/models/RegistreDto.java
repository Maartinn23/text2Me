package sintesis.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegistreDto { // Dto per registrar usuaris al sistema.

	public RegistreDto() {

	}

	public RegistreDto(@NotEmpty String nom, @NotEmpty String cognom, @NotEmpty @Email String correu, String telefon,
			String adreça,
			@Size(min = 6, message = "La longitud minima del password ha de ser de 6 caracters!") String password,
			String confirmacioPassword) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.correu = correu;
		this.telefon = telefon;
		this.adreça = adreça;
		this.password = password;
		this.confirmacioPassword = confirmacioPassword;
	}

	@NotEmpty
	private String nom;

	@NotEmpty
	private String cognom;

	@NotEmpty
	@Email
	private String correu;

	private String telefon;

	private String adreça;

	@Size(min = 6, message = "La longitud minima del password ha de ser de 6 caracters!")
	private String password;

	private String confirmacioPassword;

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

	public String getConfirmacioPassword() {
		return confirmacioPassword;
	}

	public void setConfirmacioPassword(String confirmacioPassword) {
		this.confirmacioPassword = confirmacioPassword;
	}

}
