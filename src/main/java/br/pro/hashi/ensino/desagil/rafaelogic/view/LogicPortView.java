package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;

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
		
		setLayout(new FlowLayout());
		
		add(entradaLabel);
		add(checkIn1);
		add(checkIn2);
		add(saidaLabel);
		add(checkOut);
		
		checkIn1.addActionListener(this);
		checkIn2.addActionListener(this);
		
		checkOut.setEnabled(false);
		
		update();
		
	}
	
	
	private void update(){

		try {
			
		}
		catch(NumberFormatException exception) {
			checkOut.setText("?");
			return;
		}

		//double result = gate.connect();
		//checkOut.setText(Double.toString(result));
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}
