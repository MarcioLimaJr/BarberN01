
package modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity (name="cliente")
public class cliente {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idCliente;
private String nome;
private String cpf;
private String telefone;
private String dataNascimento;

    public cliente() {
    }

    public cliente(int idCliente, String nome, String cpf, String telefone, String dataNascimento) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String acharnome(int id){
        if (id == idCliente){
            
        return nome;

            
        }else{
           String  a = "não existe esse cliente";
            return a;
            
        }
        
    }


    
}
