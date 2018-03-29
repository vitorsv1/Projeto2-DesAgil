package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class NotGate extends Gate {
	private Emitter[] emitters;
	private NandGate nandgate;
	
	
	public NotGate() {
		emitters = new Emitter[2];
		//Criando objeto da classe NandGate
		nandgate = new NandGate();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		emitters[pinIndex] = emitter;
	}

	@Override
	public boolean read() {
		//Conectando as duas saidas do nandgate em uma porta Nand no emmitters
		nandgate.connect(0, emitters[0]);
		nandgate.connect(1, emitters[0]);
		//Retornando o objeto nand ja setado como Not
		return nandgate.read();
	}
}
