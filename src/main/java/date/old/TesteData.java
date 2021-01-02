package date.old;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class TesteData extends JFrame {
	private JLabel resposta;
	
	public static void main(String[] args) {
		new TesteData();
	}
	
	public TesteData (){
		super("Data");
		setSize(180, 180);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		iniciaTela();
		setVisible(true);
	}
	
	
	private void iniciaTela() {
		final JTextField dia = new JTextField();
		final JTextField mes = new JTextField();
		JLabel lbDia = new JLabel("Dia:");
		JLabel lbMes = new JLabel("Mes:");

		lbDia.setBounds(15, 10, 25, 25);
		lbMes.setBounds(15, 40, 30, 25);
		
		dia.setBounds(45, 10, 25, 25);
		mes.setBounds(45, 40, 100, 25);
		
		JButton botao = new JButton("Verifica");
		botao.setBounds(45, 70, 100, 25);
		
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dia.getText().equals("") || mes.getText().equals("")) {
					resposta.setText("Preencher Data");
				} else {
					verificaData(dia.getText(), mes.getText());
				}
			}
		});
		
		resposta = new JLabel();
		resposta.setBounds(50, 100, 100, 25);
		
		add(lbDia);
		add(lbMes);
		add(dia);
		add(mes);
		add(botao);
		add(resposta);
		
	}
	
	private void verificaData(String dia, String mes){
		
		int nrDia = new Integer(dia);
		int nrMes = converteMes(mes);

		if(isDiaMesValido(nrDia,nrMes)){
			Calendar dataAtual = Calendar.getInstance();
			
			Calendar data15Dias = Calendar.getInstance();
			data15Dias.add(Calendar.DAY_OF_MONTH, 15);
			
			Calendar dataEscolhida = new GregorianCalendar();
			dataEscolhida.set(Calendar.getInstance().get(Calendar.YEAR), nrMes, nrDia);
			
			if(dataEscolhida.before(dataAtual))
				resposta.setText("Data Anterior");
			else{
				if(dataEscolhida.after(data15Dias))
					resposta.setText("Data Posterior");
				else
					resposta.setText("Data v�lida!");
			}
		}else
			resposta.setText("Data Inv�lida");
	}
	
	private int converteMes(String mes) {
		if (mes.equals("janeiro"))
			return 0;
		if (mes.equals("fevereiro"))
			return 1;
		if (mes.equals("mar�o"))
			return 2;
		if (mes.equals("abril"))
			return 3;
		if (mes.equals("maio"))
			return 4;
		if (mes.equals("junho"))
			return 5;
		if (mes.equals("julho"))
			return 6;
		if (mes.equals("agosto"))
			return 7;
		if (mes.equals("setembro"))
			return 8;
		if (mes.equals("outubro"))
			return 9;
		if (mes.equals("novembro"))
			return 10;
		if (mes.equals("dezembro"))
			return 11;
		return -1;
	}	
	
	private boolean isDiaMesValido(int nrDia, int nrMes) {
		if(retornaTipoMes(nrMes) == 1 && nrDia > 28)
			return false;
		if(retornaTipoMes(nrMes) == 2 && nrDia > 29)
			return false;
		if(retornaTipoMes(nrMes) == 3 && nrDia > 30)
			return false;
		
		return true;
	}

	private int retornaTipoMes(int mes){
		if(mes == 1){
			if(!isBissexto())
				return 1;
			else
				return 2;
		}
        if(mes == 3 || mes == 5 || mes == 8 || mes == 10)
            return 3;
        if(mes == 0 || mes == 2 || mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11)
            return 4;
        return 0;
    }
	
	private boolean isBissexto() {
		int ano = new Integer(Calendar.getInstance().get(Calendar.YEAR));
		return (ano % 4 == 0) && ((ano < 1582) || (ano % 100 != 0) || (ano % 400 == 0));  
	}
}
