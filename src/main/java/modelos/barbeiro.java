package modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity (name="barbeiro")
public class barbeiro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbarbeiro;
    private String nome;
    private String cpf;
    private String telefone;
    @ManyToOne
    @JoinColumn(name = "gerente_id")
    private gerente gerente;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private usuario usuario;
    
    public barbeiro() {
    }

    public barbeiro(int idbarbeiro, String nome, String cpf, String telefone, gerente gerente, usuario usuario) {
        this.idbarbeiro = idbarbeiro;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.gerente = gerente;
        this.usuario = usuario;
    }

    public int getIdbarbeiro() {
        return idbarbeiro;
    }

    public void setIdbarbeiro(int idbarbeiro) {
        this.idbarbeiro = idbarbeiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public gerente getGerente() {
        return gerente;
    }

    public void setGerente(gerente gerente) {
        this.gerente = gerente;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }
    
}
