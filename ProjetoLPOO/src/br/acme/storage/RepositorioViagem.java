package br.acme.storage;
import br.acme.location.Viagem;

public class RepositorioViagem {
	// Atributos ----------------------------------------------------------------------------------------------------
	private Viagem[] listaViagem = new Viagem[10];
	
	// Construtor Padr�o
	
	// Getters and Setters ----------------------------------------------------------------------------------------------------
	public Viagem[] getListaViagem() {
		return listaViagem;
	}

	public void setListaViagem(Viagem[] listaViagem) {
		this.listaViagem = listaViagem;
	}
	
	// M�todos ----------------------------------------------------------------------------------------------------
	public void adicionar(Viagem novoViagem){
		/* 
		 * Para cada elemento n�o nulo do Array:
		 * 	 > Compara o ID do atual com o ID do novo:
		 * 		> Se o ID for igual, quebra o la�o;
		 * 		> Se for diferente, segue para o pr�ximo elementoe e aumenta o �ndice;
		 * Caso encontre um elemento nulo, insere o novo elemento neste espa�oe quebra o la�o;
		 */
		int i=0;// �ndice do elemento no Array
		for(Viagem elemento: listaViagem){
			if(elemento!=null){
				if(elemento.getId()==novoViagem.getId())
					break;
				else
					i++;
			}
			else{
				listaViagem[i]=novoViagem;
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
		for(Viagem elemento: listaViagem){
			if(elemento==null)break;
			if(elemento.getId() == id){
				elemento=null;
				removido=true;
			}
			if(removido){
				// Se �ndice for a �ltima posi��o do vetor, � igualada � null, se n�o, ao pr�ximo elemento
				listaViagem[i]=(i==listaViagem.length-1)?null:listaViagem[i+1];
			}
			i++;
		}
		if(removido){
			System.out.println("Viagem removido com sucesso.");
		}
		else
			System.out.println("Viagem n�o encontrado.");
	}

	public Viagem buscar(long id){
		for(Viagem viagem : listaViagem){
			if(viagem==null)break;
			if(viagem.getId() == id){
				return viagem;
			}
		}
		return null;
	}
	
	public Viagem[] buscarTodos(){
		return this.getListaViagem();
	}
}
