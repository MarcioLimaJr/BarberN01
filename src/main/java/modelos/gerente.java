
package modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity (name="gerente")
public class gerente {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idgerente;
private String nome;
private String cpf;
private String telefone;
@ManyToOne
@JoinColumn(name = "usuario_id")
private usuario usuario;


    public gerente() {
    }

    public gerente(int idgerente, String nome, String cpf, String telefone, usuario usuario) {
        this.idgerente = idgerente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.usuario = usuario;
    }

    public int getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(int idgerente) {
        this.idgerente = idgerente;
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

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    
}
