
package connect;

import jakarta.persistence.*;
import java.util.List;
import modelos.*;


public class coringaJPA<T> {
    
    private Class<T> classe;

    public coringaJPA( Class<T> classe) {
        this.classe = classe;
    }

    public void salvar(T objeto) {

        EntityManager tx = JPAConexao.conectar();

        try {

            tx.getTransaction().begin(); //Inicia uma transação de dados            

            tx.persist(objeto);//Salva o objeto

            tx.getTransaction().commit();//Confirma a gravação

        } catch (Exception e) {
            System.out.println("deu ruim" + e);
            tx.getTransaction().rollback();

        }

    }

    public void atualizar(T objeto) {

        EntityManager tx = JPAConexao.conectar();

        tx.getTransaction().begin();
        tx.merge(objeto);
        tx.getTransaction().commit();

    }

    public void excluir(Integer id) {

        EntityManager tx = JPAConexao.conectar();

        tx.getTransaction().begin();

        T objeto = tx.find(classe, id);

        if (objeto != null) {
            tx.remove(objeto);
        }

        tx.getTransaction().commit();
    }

    public T buscar(Integer id) {

        EntityManager tx = JPAConexao.conectar();

        return tx.find(classe, id);

    }

    public List<T> listar() {

        EntityManager tx = JPAConexao.conectar();

        return tx.createQuery("FROM " + classe.getSimpleName(),
                classe
        ).getResultList();

    }

    public static List<atendimento> filtrarStatus(boolean status) {

        EntityManager manager = JPAConexao.conectar();

        return manager.createQuery("FROM atendimento WHERE status like :status", atendimento.class)
                .setParameter("status", "%" + status + "%")
                .getResultList();

    }

    public static usuario validarUsuario(usuario u) {

        EntityManager tx = JPAConexao.conectar();
        try {
            Query consulta
                    = tx.createQuery("SELECT u FROM usuario u WHERE u.login = :login AND u.senha = :senha");
            consulta.setParameter("login", u.getLogin());
            consulta.setParameter("senha", u.getSenha());
            List<usuario> lista = consulta.getResultList();

            if (!lista.isEmpty()) {
                return lista.get(0);
            }
        } catch (Exception e) {
            tx.getTransaction().rollback();
        }
        return null;

    }

    public List<atendimento> listarAtendimentos() {

        EntityManager em = JPAConexao.conectar();

        return em.createQuery(
                "SELECT a FROM atendimento a "
                + "JOIN FETCH a.cliente "
                + "JOIN FETCH a.servico "
                + "JOIN FETCH a.atendente "
                + "JOIN FETCH a.barbeiro",
                atendimento.class
        ).getResultList();
    }

    public usuario buscarPorLogin(String login) {

        EntityManager em = JPAConexao.conectar();

        return em.createQuery(
                "SELECT u FROM usuario u WHERE u.login = :login",
                usuario.class
        )
                .setParameter("login", login)
                .getSingleResult();
    }

    public T buscarPorNome(String nome) {

        EntityManager em = JPAConexao.conectar();

        List<T> resultados = em.createQuery(
                "SELECT t FROM " + classe.getSimpleName()
                + " t WHERE t.nome = :nome",
                classe
        )
                .setParameter("nome", nome)
                .getResultList();

        if (resultados.isEmpty()) {
            return null;
        }

        return resultados.get(0);

    }
    
    public servico buscarPorValor(double valor){
        
        EntityManager em = JPAConexao.conectar();

        return em.createQuery(
                "SELECT s FROM servico s WHERE u.valor = :valor",
                servico.class
        )
                .setParameter("valor", valor)
                .getSingleResult();
        
    }

    public List<atendimento> pesquisarAtendimentos(String data, String nomeCliente, barbeiro barbeiroSelecionado, Boolean status) {

        EntityManager em = JPAConexao.conectar();

        String jpql
                = "SELECT a FROM atendimento a "
                + "JOIN FETCH a.cliente c "
                + "JOIN FETCH a.servico s "
                + "JOIN FETCH a.atendente at "
                + "JOIN FETCH a.barbeiro b "
                + "WHERE 1=1 ";

        if (data != null && !data.trim().isEmpty()) {
            jpql += "AND a.data = :data ";
        }

        if (nomeCliente != null && !nomeCliente.trim().isEmpty()) {
            jpql += "AND LOWER(c.nome) LIKE LOWER(:cliente) ";
        }

        if (barbeiroSelecionado != null) {
            jpql += "AND b = :barbeiro ";
        }

        if (status != null) {
            jpql += "AND a.status = :status ";
        }

        var query = em.createQuery(jpql, atendimento.class);

        if (data != null && !data.trim().isEmpty()) {
            query.setParameter("data", data);
        }

        if (nomeCliente != null && !nomeCliente.trim().isEmpty()) {
            query.setParameter("cliente", "%" + nomeCliente + "%");
        }

        if (barbeiroSelecionado != null) {
            query.setParameter("barbeiro", barbeiroSelecionado);
        }

        if (status != null) {
            query.setParameter("status", status);
        }

        return query.getResultList();
    }
    
    public atendente buscarAtendentePorLogin(String login) {
        EntityManager em = JPAConexao.conectar();

        return em.createQuery(
                "SELECT a FROM atendente a "
                + "JOIN a.usuario u "
                + "WHERE u.login = :login",
                atendente.class
        )
                .setParameter("login", login)
                .getSingleResult();
    }
}

   
