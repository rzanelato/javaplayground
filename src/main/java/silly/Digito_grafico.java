package silly;

import javax.swing.JOptionPane;

public class Digito_grafico {
	static int d3 = 0;
	
	public static void main(String args[]){
		String num1 = JOptionPane.showInputDialog("Digite o numero do CPF sem o digito: ");
		Long num = Long.parseLong(num1);
		
		JOptionPane.showMessageDialog(null,"\nO CPF inteiro � : "+calcDigi(num)+"-"+d3);
	}
	public static Long calcDigi(Long cpf){	
		
		Long aux;
		int i,d1=0, d2=0;
		aux = cpf/100;
		for (i=9; i>0;i--){
		d1 = (int)(d1+aux%10 *i);
		aux= aux/10;
		}
		d1=d1%11%10;
		d2=d1*9;
		aux=cpf/100;
		
		for (i=8;i>0;i--){
		d2=(int) (d2+aux%10*i);
		aux=aux/10;
		}
		d2=d2%11%10;
		d3=(int) (d1*10+d2);
		aux=cpf/100;
	return aux;
	}

	}
