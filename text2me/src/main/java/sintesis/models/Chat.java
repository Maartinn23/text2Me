package sintesis.models;

import java.util.List;

import jakarta.persistence.*;

public class Chat {

	public Chat() {

	}

	public Chat(int id, String name, ChatType tipusChat, List<Usuari> participantsChat, List<Missatge> missatgesChat) {
		super();
		this.id = id;
		this.name = name;
		this.tipusChat = tipusChat;
		this.participantsChat = participantsChat;
		this.missatgesChat = missatgesChat;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Enumerated(EnumType.STRING)
	private ChatType tipusChat = ChatType.PRIVAT;

	@ManyToMany
	@JoinTable(name = "chat_users", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))

	private List<Usuari> participantsChat;

	@OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
	private List<Missatge> missatgesChat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ChatType getTipusChat() {
		return tipusChat;
	}

	public void setTipusChat(ChatType tipusChat) {
		this.tipusChat = tipusChat;
	}

	public List<Usuari> getParticipantsChat() {
		return participantsChat;
	}

	public void setParticipantsChat(List<Usuari> participantsChat) {
		this.participantsChat = participantsChat;
	}

	public List<Missatge> getMissatgesChat() {
		return missatgesChat;
	}

	public void setMissatgesChat(List<Missatge> missatgesChat) {
		this.missatgesChat = missatgesChat;
	}

}
