package controller;

import javax.swing.JOptionPane;

import br.com.serialexperimentscarina.listastrings.ListaStrings;

public class TabelaTelefoneController {
	
	ListaStrings[] tabelaDeEspalhamento;
	
	public TabelaTelefoneController() {
		tabelaDeEspalhamento = new ListaStrings[100];
		
		for (int i = 11; i <= 99; i++) {
			tabelaDeEspalhamento[i] = new ListaStrings();
		}
	}
	
	public void adiciona(String telefone) throws Exception {
		int hash = hashCode(telefone);
		ListaStrings l = tabelaDeEspalhamento[hash];
		
		l.addFirst(telefone);
	}
	
	public void remove(String telefone) throws Exception {
		int hash = hashCode(telefone);
		ListaStrings l = tabelaDeEspalhamento[hash];
		int tamanho = l.size();
		
		for (int i = 0; i < tamanho; i++) {
			String tf = l.get(i);
			if(telefone.equals(tf)) {
				l.remove(i);
				JOptionPane.showMessageDialog(null, "Telefone removido com sucesso");
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Telefone não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public String busca(String telefone) throws Exception {
		int hash = hashCode(telefone);
		ListaStrings l = tabelaDeEspalhamento[hash];
		int tamanho = l.size();
		
		for (int i = 0; i < tamanho; i++) {
			String tf = l.get(i);
			if(telefone.equals(tf)) {
				return tf;
			}
		}
		return null;
	}
	
	public void lista() throws Exception {
		for (int i = 11; i <= 99; i++) {
			ListaStrings l = tabelaDeEspalhamento[i];
			int tamanho = l.size();
			
			for (int j = 0; j < tamanho; j++) {
				System.out.println(l.get(j));
			}
		}
		
	}
		
	private int hashCode(String telefone) {
		int hash = 0;
		for (int i = 0; i < 11; i++) {
			hash += 1 + (telefone.charAt(i) % 9);
		}
		return hash;
	}

}
