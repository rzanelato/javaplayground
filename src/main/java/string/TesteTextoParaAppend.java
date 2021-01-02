package string;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TesteTextoParaAppend {

	public static void main(String[] args) {
		telaTeste();
	}
	
	private static void telaTeste() {
		JFrame frame = new JFrame("Teste");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JTextArea text = new JTextArea();
		text.setSize(400,400);

		JButton botao = new JButton("vai");
		botao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String[] texto = text.getText().split("\n");
				for(String string: texto)
					System.out.println(converteParaAppend(string));
			}
		});

		JPanel painel = new JPanel(new BorderLayout());
		painel.add(text, BorderLayout.CENTER);
		frame.add(botao, BorderLayout.SOUTH);

		frame.add(new JScrollPane(painel));
		frame.setVisible(true);
	}

	private static String converteParaAppend(String stringSql) {
		return ".append(\" "+stringSql+" \")";
	}
}