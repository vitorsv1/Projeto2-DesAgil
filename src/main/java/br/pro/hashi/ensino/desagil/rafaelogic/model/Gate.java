package br.pro.hashi.ensino.desagil.rafaelogic.model;

public abstract class Gate implements Emitter, Receiver {
	private String name;
	private int size;
	
	protected Gate(String name,int size){
		this.name = name;
		this.size = size;
	}
	
	public String toString() {
			return name;
	}
	
	//Fun��o que retorna o tamanho do Gate
	public int getSize() {
		return size;
	}


}
