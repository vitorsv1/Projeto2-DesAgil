package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class NotGate extends Gate {
	private NandGate nandgate;
	
	public NotGate() {
		//Criando objeto da classe NandGate
		nandgate = new NandGate();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		//Conectando as duas saidas do nandgate em uma porta Nand no emmitters
		nandgate.connect(0, emitter);
		nandgate.connect(1, emitter);
	}

	@Override
	public boolean read() {
		//Retornando o objeto nand ja setado como Not
		return nandgate.read();
	}
}
