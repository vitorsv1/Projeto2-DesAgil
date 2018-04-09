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
		
		checkIn1 = new JCheckBox();
		checkIn2 = new JCheckBox();
		checkOut = new JCheckBox();
		
		JLabel entradaLabel = new JLabel("Entrada");
		JLabel saidaLabel = new JLabel("Saída");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		if(gate.getSize() == 1){
			add(entradaLabel);
			add(checkIn1);
			add(checkIn2);
		}
		if(gate.getSize() == 0){
			add(entradaLabel);
			add(checkIn1);
		}

		add(saidaLabel);
		add(checkOut);
		
		checkIn1.addActionListener(this);
		checkIn2.addActionListener(this);
		
		checkOut.setEnabled(false);
		
		update();
		
	}
	
	private void update(){
		Source source1 = new Source();
		Source source2 = new Source();
		boolean pino1 = checkIn1.isSelected();
		if(pino1){
			source1.turn(true);
		}
		else{
			source1.turn(false);
		}
		boolean pino2 = checkIn2.isSelected();
		if(pino2){
			source2.turn(true);
		}
		else{
			source2.turn(false);
		}
		gate.connect(1, source2);
		gate.connect(0, source1);
		
		boolean result = gate.read();
		checkOut.setSelected(result);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}
