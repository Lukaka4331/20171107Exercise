import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame{


    private Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    private int screenW=dim.width;
    private int screenH=dim.height;
    private int frmW=300;
    private int frmH=150;
    private JPanel jplNumber =new JPanel(new GridLayout(1,6,3,3));
    private JPanel jplControl =new JPanel(new GridLayout(1,2,3,3));
    private JButton jbClose =new JButton("Close");
    private JButton jbgGenerate =new JButton("Generate");
    private Random rnd =new Random(System.currentTimeMillis());

    private int data[]=new int[6];
    private JLabel jlLoto[]=new JLabel[6];
    private void GenerateNum(){
        for(int i = 0;i<6;i++){
            jlLoto[i] = new JLabel();
            jlLoto[i].setHorizontalAlignment(SwingConstants.CENTER);
            //讓每格不透明
            jlLoto[i].setOpaque(true);
            jlLoto[i].setBackground(new Color(40,143,255));
            jlLoto[i].setText(Integer.toString(data[i]));
            jplNumber.add(jlLoto[i]);
        }

    }

    private void Number(){
        for(int i = 0;i <6;i++){
            data[i] = rnd.nextInt(42)+1;
            for(int j = 0;j<i;j++){
                if(data[i]==data[j]){
                    i--;
                    break;
                }
            }
        }
    }

    public MainFrame(){
        initComp();
    }
    private void initComp(){

     this.setBounds((screenW-frmW)/2,(screenH-frmH)/2,frmW,frmH);
     this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     Container cp;
     cp=this.getContentPane();
     cp.setLayout(new BorderLayout(3,3));
     cp.add(jplNumber,BorderLayout.CENTER);
     cp.add(jplControl,BorderLayout.SOUTH);
     jplControl.add(jbClose);
     jplControl.add(jbgGenerate);
        Number();
        GenerateNum();
     jbClose.addActionListener(new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
             System.exit(0);
         }
     });

     jbgGenerate.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
             Number();
             for(int i=0;i<6;i++){

                 jlLoto[i].setText(Integer.toString(data[i]));
             }
         }
     });

    }


}
