
package modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity (name="usuario")
public class usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String senha;
    private String tipo;

    public usuario(int id, String login, String senha, String tipo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }
  
    public usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
        public String acharnome(int id){
        if (id == id){
            
        return login;

            
        }else{
           String  a = "não existe esse usuario";
            return a;
        }
        
    }
    
}
