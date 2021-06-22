package br.com.prosolution.cliente.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prosolution.dao.DAO;
import br.com.prosolution.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean {
	
	
	
	private Cliente cliente = new Cliente();	
	
	public Cliente getCliente() {
		return cliente;
	}
	
	//método para listar todos os clientes cadastrados
	public List<Cliente> getClientes(){
		return new DAO<Cliente>(Cliente.class).listaTodos();
	}
	
	public void cadastrar() {
		
		if(this.cliente.getId() == null) {
			new DAO<Cliente>(Cliente.class).adiciona(this.cliente);	
		}else {
			new DAO<Cliente>(Cliente.class).atualiza(this.cliente);
		}
		
		this.cliente = new Cliente();
	}
	
	//Carrega o cliente que quero editar no mesmo formulário de cadastro
	public void carregar(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//Método que remove um cliente do banco
	public void remover(Cliente cliente) {
		new DAO<Cliente>(Cliente.class).remove(cliente);
	}
}
