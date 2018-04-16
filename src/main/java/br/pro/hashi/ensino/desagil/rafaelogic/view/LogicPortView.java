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
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class LogicPortView extends Painel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	
	private Gate gate;
	private JCheckBox checkIn1;
	private JCheckBox checkIn2;
	
	private Color color;
	private Image image;
	
	public LogicPortView(Gate gate){
		super(245,250);
		
		this.gate = gate;
		
		//Criando 2 CheckBoxes
		checkIn1 = new JCheckBox();
		checkIn2 = new JCheckBox();
		
		
				
		//Caso o Gate seja tamanho 2
		if(gate.getSize() == 1){
			add(checkIn1, 10, 65, 20, 20);
			add(checkIn2, 10, 130, 20, 20);
		}
		//Caso o Gate seja tamanho 1
		if(gate.getSize() == 0){
			add(checkIn1, 10, 95, 20, 20);
		}
		
		
		//Aplicando os metodos do ActionListener para responder ao usuario
		checkIn1.addActionListener(this);
		checkIn2.addActionListener(this);
		
		update();
		
		color = Color.red;
		
		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		image = new ImageIcon(url).getImage();
		
		addMouseListener(this);
	}
	
	private void update(){
		
		//Criando objetos da classe Source
		Source source1 = new Source();
		Source source2 = new Source();
		
		//Definindo pino1
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

		g.drawImage(image, 40, 35, 165, 145, null);

		// Desenha circulo
		//Pinta a saída de acordo com o seu valor
		if(gate.read() == true){
			g.setColor(color);
			g.fillOval(200, 93, 25, 25);
		}
		else if (gate.read() == false){
			g.setColor(Color.black);
			g.fillOval(200, 93, 25, 25);
		};

		repaint();
		getToolkit().sync();
    }
}
