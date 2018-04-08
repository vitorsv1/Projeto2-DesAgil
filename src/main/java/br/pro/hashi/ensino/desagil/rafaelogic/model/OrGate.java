package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate{
	private NandGate nand;
	private NotGate not1;
	private NotGate not2;
	
	public OrGate(){
		super("OR");
		//Criando Nand e Nots dentro do Or
		nand = new NandGate();
		not1 = new NotGate();
		not2 = new NotGate();
		//conecta o not 1 a primeira entrada do nand
		//e o not 2 a segunda.
		nand.connect(0,not1);
		nand.connect(1,not2);
	}
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		//ao usar o connect do Or, uma das duas entradas
		//entra no not1 e a outra no not2
		if (pinIndex == 0){    //Se o pinIndex for 0, conectamos o emissor ao not1
			not1.connect(0,emitter);
		}
		if (pinIndex == 1){	   //Se o pinIndex for 1, conectamos o emissor ao not2
			not2.connect(0,emitter);
		}
	}
	
	@Override
	public boolean read(){
		//A saída do Or é a mesma saída do nand
		return nand.read();
	}
}
