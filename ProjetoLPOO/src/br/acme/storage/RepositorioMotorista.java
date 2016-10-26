package br.acme.storage;
import br.acme.users.Motorista;

public class RepositorioMotorista {
	// Atributos ----------------------------------------------------------------------------------------------------
	private Motorista[] listaMotorista = new Motorista[10];
	
	// Construtor Padr�o
	
	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public Motorista[] getListaMotorista() {
		return listaMotorista;
	}

	public void setListaMotorista(Motorista[] listaMotorista) {
		this.listaMotorista = listaMotorista;
	}
	
	// M�todos ----------------------------------------------------------------------------------------------------
	public void adicionar(Motorista novoMotorista){
		/* 
		 * Para cada elemento n�o nulo do Array:
		 * 	 > Compara o ID do atual com o ID do novo:
		 * 		> Se o ID for igual, quebra o la�o;
		 * 		> Se for diferente, segue para o pr�ximo elementoe e aumenta o �ndice;
		 * Caso encontre um elemento nulo, insere o novo elemento neste espa�oe quebra o la�o;
		 */
		int i=0;// �ndice do elemento no Array
		for(Motorista elemento: listaMotorista){
			if(elemento!=null){
				if(elemento.getId()==novoMotorista.getId())
					break;
				else
					i++;
			}
			else{
				listaMotorista[i]=novoMotorista;
				break;
			}
		}
	}
	
	public void remover(long id){
		/*
		 * Caso qualquer elemento nulo seja encontrado, o la�o � encerrado;
		 * Se o elemento com o ID especificado seja encontrado a posi��o dele � igualada � null;
		 * Caso o elemento tenha sido removido do vetor:
		 * 	 > Se o �ndice for a �ltima posi��o, o espa�o se torna null;
		 *   > Se n�o, o espa�o atual � igualado ao pr�ximo;
		 */
		boolean removido = false; // Varia de acordo com o sucesso do m�todo
		int i=0;
		for(Motorista elemento: listaMotorista){
			if(elemento==null)break;
			if(elemento.getId() == id){
				elemento=null;
				removido=true;
			}
			if(removido){
				// Se �ndice for a �ltima posi��o do vetor, � igualada � null, se n�o, ao pr�ximo elemento
				listaMotorista[i]=(i==listaMotorista.length-1)?null:listaMotorista[i+1];
			}
			i++;
		}
		if(removido){
			System.out.println("Motorista removido com sucesso.");
		}
		else
			System.out.println("Motorista n�o encontrado.");
	}
	
	public void alterar(long id, Motorista novoMotorista){
		boolean alterado = false; // Varia de acordo com o sucesso do m�todo
		int i=0;
		for(Motorista elemento: listaMotorista){
			if(elemento==null)break;
			if(elemento.getId() == id){
				listaMotorista[i]=novoMotorista;
				alterado=true;
			}
			i++;
		}
		if(alterado)
			System.out.println("Motorista alterado com sucesso.");
		else
			System.out.println("Motorista n�o encontrado.");
	}
	
	public Motorista buscar(long id){
		for(Motorista motorista : listaMotorista){
			if(motorista==null)break;
			if(motorista.getId() == id){
				return motorista;
			}
		}
		return null;
	}
	
	public Motorista[] buscarTodos(){
		return this.getListaMotorista();
	}
}
