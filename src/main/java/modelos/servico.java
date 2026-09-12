package modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico")
public class servico {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idservicos;
    private String nome;
    private double valor;

    public servico(int idservico, String nome, double valor) {
        this.idservicos = idservico;
        this.nome = nome;
        this.valor = valor;
    }
    
    public servico() {
    }

    public int getIdservico() {
        return idservicos;
    }

    public void setIdservico(int idservico) {
        this.idservicos = idservico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double acharvalor(int id){
        if (id == idservicos){
            
        return valor;

            
        }else{
            return 0.0;
            
        }
        
    }
        public String acharnome(int id){
        if (id == idservicos){
            
        return nome;

            
        }else{
           String  a = "não existe esse serviço";
            return a;
        }
        
    }



    
}
