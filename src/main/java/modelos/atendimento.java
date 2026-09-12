
package modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity (name="atendimento")

public class atendimento {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idatendimento;
@ManyToOne
@JoinColumn(name = "cliente_id")
private cliente cliente;
@ManyToOne
@JoinColumn(name = "servicos_id")
private servico servico;
@ManyToOne
@JoinColumn(name = "atendente_id")
private atendente atendente;
@ManyToOne
@JoinColumn(name = "barbeiro_id")
private barbeiro barbeiro;
private double valorTotal;
private String data;
private String hora;
private boolean status;



    public atendimento() {
    }

    public atendimento(int idatendimento, cliente cliente, servico servico, atendente atendente, barbeiro barbeiro,double valorTotal, String data, String hora, boolean status) {
        this.idatendimento = idatendimento;
        this.cliente = cliente;
        this.servico = servico;
        this.atendente = atendente;
        this.barbeiro = barbeiro;
        this.valorTotal = valorTotal;
        this.data = data;
        this.hora = hora;
        this.status = status;
    }

    public int getIdatendimento() {
        return idatendimento;
    }

    public void setIdatendimento(int idatendimento) {
        this.idatendimento = idatendimento;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public servico getServico() {
        return servico;
    }

    public void setServico(servico servico) {
        this.servico = servico;
    }

    public atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(atendente atendente) {
        this.atendente = atendente;
    }

    public barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}