package tmp;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class GB01 extends Applet implements ActionListener {

   Button B1 = new Button("NE");
   Button B2 = new Button("SouthWest");
   GridBagLayout gridbag;

   public void init() {
      setup_layout();
   }

   private void setup_layout() {
      setBackground(Color.yellow);
      gridbag = new GridBagLayout();
      GridBagConstraints c = new GridBagConstraints();
      setLayout(gridbag);
      c.weightx = 1;
      c.weighty = 1;
      c.gridx = 0;
      c.gridy = 0;
      c.anchor = GridBagConstraints.SOUTHWEST;
      gridbag.setConstraints(B1,c);
      B1.setBackground(Color.cyan);
      add(B1);
      c.weightx = 0;
      c.gridx = 1;
      c.anchor = GridBagConstraints.NORTH;
      c.fill = GridBagConstraints.BOTH;
      gridbag.setConstraints(B2,c);
      B2.setBackground(Color.pink);
      add(B2);
      B1.addActionListener(this);
      B2.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e) {
      GridBagConstraints c = gridbag.getConstraints(B1);
      if (e.getSource() == B1) {
         c.anchor = GridBagConstraints.NORTHEAST;
         showStatus("NE pushed");
      }
      else if (e.getSource() == B2) {
         c.anchor = GridBagConstraints.SOUTHWEST;
         showStatus("SouthWest pushed");
      }
      gridbag.setConstraints(B1,c);
      invalidate();
      validate();
   }
}
