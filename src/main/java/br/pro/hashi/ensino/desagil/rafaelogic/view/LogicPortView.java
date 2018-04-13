package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class LogicPortView extends Painel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	
	private Gate gate;
	private JCheckBox checkIn1;
	private JCheckBox checkIn2;
	private JCheckBox checkOut;
	
	private Color color;
	private Image image;
	
	public LogicPortView(Gate gate){
		super(245,300);
		
		this.gate = gate;
		
		//Criando 3 CheckLists
		checkIn1 = new JCheckBox();
		checkIn2 = new JCheckBox();
		checkOut = new JCheckBox();
		
		//Definindo nomes dos labels que definiram os checklist
		JLabel entradaLabel = new JLabel("Entrada");
		JLabel saidaLabel = new JLabel("Saida");
		
		
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
		
		//Aplicando os metodos do ActionListener para responder ao usuario
		checkIn1.addActionListener(this);
		checkIn2.addActionListener(this);
		
		//Definir o checkbot de resultado como nao responsivo ao usuario
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

		//Gerando o resultado da conexao
		boolean result = gate.read();
		
		//Definindo a saida do resultado
		checkOut.setSelected(result);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {

		// Ponto clicado
		int x = event.getX();
		int y = event.getY();

		// Se o clique for no led (mudar as coordenadas)
		if(x >= 195 && x < 235 && y >= 80 && y < 255) {

			// abrir o seletor de cor
			color = JColorChooser.showDialog(this, null, color);

			// pinta a tela
			repaint();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {
	}
	
	@Override
	public void mouseEntered(MouseEvent event) {
	}
	
	@Override
	public void mouseExited(MouseEvent event) {
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 10, 80, 175, 175, null);

		// Desenha retangulo (mudar para circulo)
		g.setColor(color);
		g.fillRect(195, 80, 40, 175);

		getToolkit().sync();
    }
}
