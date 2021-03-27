import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;
public class Forza4Frame extends JFrame implements ActionListener{

	private int r = 6;
	private int c = 7;
	private int turno;
	private int cont[] = new int[c];
	private JPanel pnl = new JPanel();
	private JButton V[] = new JButton[c];
	private JButton M[][] = new JButton[r][c];
	private JButton rigioca = new JButton("RIGIOCA");
	
	public Forza4Frame() {
		super("Forza 4");
		pnl.setLayout(new GridLayout(r+1, c));
		Container C = this.getContentPane();
		C.setLayout(new BorderLayout());
		int i,j;
		for(i=0; i<c; i++)
		{
			V[i] = new JButton("INSERISCI");
			pnl.add(V[i]);
			V[i].setBackground(Color.LIGHT_GRAY);
			V[i].addActionListener(this);
		}
		for(i=0; i<r; i++)
			for(j=0; j<c; j++)
			{
				M[i][j] = new JButton();
				pnl.add(M[i][j]);
				M[i][j].setBackground(Color.WHITE);
						
			}
		rigioca.addActionListener(this);
		C.add(pnl, BorderLayout.CENTER);
		C.add(rigioca, BorderLayout.SOUTH);
		turno = 1;
	    for(i=0; i<c; i++)
	    	cont[i] = 0;
		setSize(500,500);
		setVisible(true);
	}
	public boolean controllo() {
		int i,j;
		for(i=0; i<r; i++)
			for(j=0; j<c-3; j++)
				if((M[i][j].getBackground() == M[i][j+1].getBackground()) && (M[i][j].getBackground() == M[i][j+2].getBackground()) &&
						(M[i][j].getBackground() == M[i][j+3].getBackground())&&(M[i][j].getBackground() != Color.WHITE))
					   return true;
		
		for(j=0; j<c; j++)
			for(i=0; i<r-3; i++)
				if((M[i][j].getBackground() == M[i+1][j].getBackground()) && (M[i][j].getBackground() == M[i+2][j].getBackground()) &&
						(M[i][j].getBackground() == M[i+3][j].getBackground())&&(M[i][j].getBackground() != Color.WHITE))
					   return true;
		for(i=r-1; i>r-4; i--)
			for(j=0; j<c-3; j++)
				if((M[i][j].getBackground() == M[i-1][j+1].getBackground()) && (M[i][j].getBackground() == M[i-2][j+2].getBackground()) &&
						(M[i][j].getBackground() == M[i-3][j+3].getBackground())&&(M[i][j].getBackground() != Color.WHITE))
					   return true;
		for(i=0; i<r-3; i++)
			for(j=0; j<c-3; j++)
				if((M[i][j].getBackground() == M[i+1][j+1].getBackground()) && (M[i][j].getBackground() == M[i+2][j+2].getBackground()) &&
						(M[i][j].getBackground() == M[i+3][j+3].getBackground())&&(M[i][j].getBackground() != Color.WHITE))
					   return true;
		return false;
	}
	public void actionPerformed(ActionEvent e) {
		int i;
		for(i=0; i<c; i++)
		if(e.getSource() == V[i])
		{
			if(cont[i] < r) {
				if(turno == 1) {
					
					M[r-1-cont[i]][i].setBackground(Color.RED);
					turno = 2;
					if(controllo() == true)
					{
						JOptionPane.showMessageDialog(null, "HA VINTO: ROSSO");
						turno = 0;
					}		
				}
				else if(turno == 2) {
					
					M[r-1-cont[i]][i].setBackground(Color.YELLOW);
					turno = 1;
					if(controllo() == true)
					{
						JOptionPane.showMessageDialog(null, "HA VINTO: GIALLO");
						turno = 0;
					}
				}
                cont[i]++;
			}
      
		}
		
		if(e.getSource() == rigioca)
		{
			int j;
			turno = 1;
			for(i=0; i<c; i++)
				cont[i] = 0;
			for(i=0; i<r; i++)
				for(j=0; j<c; j++)
					M[i][j].setBackground(Color.WHITE);
		}		
	}
 }