package sintesis.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Table;

@Entity
@Table(name = "missatges")
public class Missatge // Definició de missatge en el sistema.
{

	public Missatge() {

	}

	public Missatge(int id, Chat chat, Usuari remitent, Usuari receptor, String content, boolean estatLectura,
			LocalDateTime dataEnviament) {
		super();
		this.id = id;
		this.chat = chat;
		this.remitent = remitent;
		this.receptor = receptor;
		this.content = content;
		this.estatLectura = estatLectura;
		this.dataEnviament = dataEnviament;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "chat_id", nullable = false)
	private Chat chat;

	@ManyToOne
	@JoinColumn(name = "remitent_id", nullable = false)
	private Usuari remitent;

	@ManyToOne
	@JoinColumn(name = "receptor_id", nullable = false)
	private Usuari receptor;

	@Column(nullable = false)
	private String content;

	private boolean estatLectura = false;

	@Column(nullable = false)
	private LocalDateTime dataEnviament = LocalDateTime.now();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Usuari getRemitent() {
		return remitent;
	}

	public void setRemitent(Usuari remitent) {
		this.remitent = remitent;
	}

	public Usuari getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuari receptor) {
		this.receptor = receptor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isEstatLectura() {
		return estatLectura;
	}

	public void setEstatLectura(boolean estatLectura) {
		this.estatLectura = estatLectura;
	}

	public LocalDateTime getDataEnviament() {
		return dataEnviament;
	}

	public void setDataEnviament(LocalDateTime dataEnviament) {
		this.dataEnviament = dataEnviament;
	}

}
