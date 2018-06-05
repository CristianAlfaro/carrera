
package Gui;

import Threard.AnimalThreads;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Gui extends JFrame{
    private JLabel [] labels; 
    private JButton inicio;
    private JButton reiniciar;
    private String[] nombres= {"canguro","tortuga","dragon"};
    
    public Gui(){
        super("Carrera de animales");
        initialComponents();
    }
    
    public void initialComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        labels = new JLabel[3];
        inicio = new JButton("inicio");
        reiniciar = new JButton("Reiniciar");
        Container container = getContentPane();
        for(int i=0;i<3;i++){
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
            labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(labels[i]);
        }
        
        
        inicio.setBounds(10, 0, 100, 30);
        container.add(inicio);
        
        reiniciar.setBounds(120, 0, 100, 30);
        container.add(reiniciar);
        
        inicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               AnimalThreads canguro= new AnimalThreads("canguro",510,labels[0],labels[0].getX(),labels[0].getY());
               AnimalThreads tortuga= new AnimalThreads("tortuga",510,labels[1],labels[1].getX(),labels[1].getY());
               AnimalThreads dragon= new AnimalThreads("dragon",510,labels[2],labels[2].getX(),labels[2].getY());
               canguro.start();
               tortuga.start();
               dragon.start();
            }
            
        });
        
        reiniciar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
       
                for(int i=0;i<3;i++){
                labels[i].setLocation(10,(i*220));
        }
            }
            
        });
  
        setSize(700,650);
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
            
        });
    }
   
}
