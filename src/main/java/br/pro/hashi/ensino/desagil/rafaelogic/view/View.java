	package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;

public class View extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Gate> menu;
	private LogicPortView logicGateView;

	public View(LinkedList<Gate> model) {

		menu = new JComboBox<>();

		for(Gate gate: model) {
			menu.addItem(gate);
		}

		//Layout da janela
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(menu);

		addLogicPortView(0);

		// Usa Action Listner para a janela reagir a mudanças no menu
		menu.addActionListener(this);
	}

	// Adiciona o subpainel de um gate a este painel.
	private void addGateView(int index) {
		Gate gate = menu.getItemAt(index);
		logicGateView = new LogicPortView(gate);
		add(logicGateView);
	}

	// Troca a interface do gate ja presente
	@Override
	public void actionPerformed(ActionEvent event) {
		remove(logicGateView);
		int index = menu.getSelectedIndex();
		addGateView(index);

		((JFrame) SwingUtilities.getRoot(this)).pack();
	}
}

