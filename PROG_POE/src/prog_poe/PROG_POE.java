package prog_poe;

import javax.swing.JOptionPane;

public class PROG_POE {

   public static void main(String[] args) {
      
      //Create Object from Class Worker
      WORKER work = new WORKER();
      //Call Worker Method
      work.mainThread();
      
      JOptionPane.showMessageDialog(null,"Thanks for using the app, have a great day..."
        ,"Closing Application",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);//Terminate program
    }
   
}