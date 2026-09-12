
package modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity (name="atendente")
public class atendente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idatendente;
    private String nome;
    private String telefone;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "gerente_id")
    private gerente gerente;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private usuario usuario;


    public atendente() {
    }

    public atendente(int idatendente, String nome, String telefone, String cpf, gerente gerente, usuario usuario) {
        this.idatendente = idatendente;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.gerente = gerente;
        this.usuario = usuario;
    }

    public int getIdatendente() {
        return idatendente;
    }

    public void setIdatendente(int idatendente) {
        this.idatendente = idatendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
