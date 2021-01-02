package silly;

//import java.util.Scanner;

import javax.swing.JOptionPane;


public class Digito_Antigo {
	static long num,aux;
	static int d3;
	
	public static void calcDigi()
	{	
		
		int i,d1=0, d2=0;
		d3=0;
		
		aux=num/100;
		
		for (i=9; i>0;i--)
		{
			d1=(int) (d1+aux%10*i);
			aux=aux/10;
		}
		
			d1=d1%11%10;
			d2=d1*9;
			aux=num/100;
		
		for (i=8;i>0;i--)
		{
			d2=(int) (d2+aux%10*i);
			aux=aux/10;
		}
		
		d2=d2%11%10;
		d3=(int) (d1*10+d2);
		aux=num/100;
	}
		
	static void verDig()
	{
		int a;
		a=(int) (num%100);
		if(a==d3)
		{
			//System.out.println("Digito V�lido!");
			JOptionPane.showMessageDialog(null,"Digito V�lido");
		}
		else
		{
			//System.out.println("Digito Inv�lido!");
			JOptionPane.showMessageDialog(null,"Digito Inv�lido");
			
		}
	}
	public static void main(String args[]) 
	{
		
		/*Scanner input = new Scanner(System.in);
		
		System.out.print("Digite o CPF(sem tra�o): ");
		num = input.nextLong();
		calcDigi();
		verDig();
		System.out.println("Seu CPF � "+aux+"-"+d3);
		*/
		
		String num1 = JOptionPane.showInputDialog("Digite o numero do CPF sem o digito: ");
		num = Long.parseLong(num1);
		calcDigi();
		verDig();
		//JOptionPane.showMessageDialog(null,"\nO CPF inteiro � : "+aux+"-"+d3);
		
		
	}

}
