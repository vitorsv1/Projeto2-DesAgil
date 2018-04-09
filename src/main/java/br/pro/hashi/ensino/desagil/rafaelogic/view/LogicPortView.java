package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class LogicPortView extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Gate gate;
	
	private JCheckBox checkIn1;
	private JCheckBox checkIn2;
	private JCheckBox checkOut;
	
	public LogicPortView(Gate gate){
		this.gate = gate;
		
		//Criando 3 CheckLists
		checkIn1 = new JCheckBox();
		checkIn2 = new JCheckBox();
		checkOut = new JCheckBox();
		
		//Definindo nomes dos labels que definiram os checklist
		JLabel entradaLabel = new JLabel("Entrada");
		JLabel saidaLabel = new JLabel("Saida");
		
		//Setando o layout da janela
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Caso o Gate seja tamanho 2
		if(gate.getSize() == 1){
			add(entradaLabel);
			add(checkIn1);
			add(checkIn2);
		}
		//Caso o Gate seja tamanho 1
		if(gate.getSize() == 0){
			add(entradaLabel);
			add(checkIn1);
		}
		
		//Adicionando a janela os labels de saida e o checklist de saida
		add(saidaLabel);
		add(checkOut);
		
		//Aplicando os met�dos do ActionListener para responder ao usu�rio
		checkIn1.addActionListener(this);
		checkIn2.addActionListener(this);
		
		//Definir o checkbot de resultado como n�o responsivo ao usu�rio
		checkOut.setEnabled(false);
		
		update();
		
	}
	
	private void update(){
		
		//Criando objetos da classe Source
		Source source1 = new Source();
		Source source2 = new Source();
		
		//Defidindo pino1
		boolean pino1 = checkIn1.isSelected();
		
		//Ver se o pino um foi trocado
		if(pino1){
			source1.turn(true);
		}
		
		else{
			source1.turn(false);
		}
		
		boolean pino2 = checkIn2.isSelected();
		
		//Ver se o pino dois foi trocado
		if(pino2){
			source2.turn(true);
		}
		
		else{
			source2.turn(false);
		}
		
		//Conectando os sources criados de acordo com os pinos
		if(gate.getSize() == 0){
			gate.connect(0, source1);
		}
		
		if(gate.getSize() == 1){
			gate.connect(1, source2);
			gate.connect(0, source1);
		}

		//Gerando o resultado da conex�o
		boolean result = gate.read();
		
		//Definindo a saida do resultad
		checkOut.setSelected(result);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}
