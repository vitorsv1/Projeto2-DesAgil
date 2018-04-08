package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate{
	private NandGate nand;
	private NotGate not;
	
	public AndGate(){
		super("AND");
		//criando nand e not dentro do and.
		nand = new NandGate();
		not = new NotGate();
		//conectando not com and internamente.
		not.connect(0, nand);
	}
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		//conectando os pinos aos respectivos emissores.
		nand.connect(pinIndex, emitter);
	}
	
	@Override
	public boolean read(){
		//lendo a saída do not.
		return not.read();
	}
}
