package com.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import com.logic.SimpleValueReplacer;


public class Launch2 extends JFrame implements ActionListener{
	private JTextField srcFileLoc;
	private JTextField tgtFileFld;
	private JTextField bKeyFld;
	private JTextField numFiles;
	private JTextField extFld;
	private JButton btnsrcFile;
	private JButton btnTgtFile;
	private JFileChooser srcFielLocfld=new JFileChooser();
	private JFileChooser tgtFielLocfld=new JFileChooser();
	private JMenuItem resetMenuItem;
	private JMenuItem mntmHelp;
	private JMenuItem mntmAbout;
	private JButton btnGenerate;
	
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		Object src=evt.getSource();
		System.out.println("a button clicked");
		if(src.equals(mntmAbout))
		{
			JOptionPane.showMessageDialog(this, "Author: Ankur Srivastava, ankcrimson@yahoo.com");
		}
		if(src.equals(btnsrcFile))
		{
			int i=srcFielLocfld.showOpenDialog(this);
			if(i==0)
				srcFileLoc.setText(srcFielLocfld.getSelectedFile().getPath());
		}
		else if(src.equals(btnTgtFile))
		{
			
			
			int i=tgtFielLocfld.showOpenDialog(this);
			if(i==0)
				tgtFileFld.setText(tgtFielLocfld.getSelectedFile().getPath());
		}
		else if(src.equals(btnGenerate))
		{
			String filename=srcFileLoc.getText();
			String allBusinessKeys=bKeyFld.getText();
			String numberOfOccurances=numFiles.getText();
			String outputDir=tgtFileFld.getText();
			String convertor=extFld.getText();
			int numOccur=Integer.parseInt(numberOfOccurances); 
			//get vals and call the method
			SimpleValueReplacer svr=new SimpleValueReplacer();
			if(svr.otherCaller(filename, allBusinessKeys, outputDir, convertor, numOccur))
				JOptionPane.showMessageDialog(null, "Done");
			else
				JOptionPane.showMessageDialog(null, "Error");
		}
	}
	
	public Launch2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(204, 204, 255));
		//header.add(menuBar);
		
		
		JMenu fmenu = new JMenu("File");
		fmenu.setBackground(new Color(204, 204, 255));
		fmenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(fmenu);
		
		resetMenuItem = new JMenuItem("Reset");
		resetMenuItem.setBackground(new Color(204, 204, 255));
		fmenu.add(resetMenuItem);
		resetMenuItem.addActionListener(this);
		
		JMenuItem menuItem_1 = new JMenuItem("Exit");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuItem_1.setBackground(new Color(204, 204, 255));
		fmenu.add(menuItem_1);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setBackground(new Color(204, 204, 255));
		mnHelp.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnHelp);
		
		mntmHelp = new JMenuItem("Help");
		mntmHelp.setBackground(new Color(204, 204, 255));
		mnHelp.add(mntmHelp);
		mntmHelp.addActionListener(this);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.setBackground(new Color(204, 204, 255));
		mnHelp.add(mntmAbout);
		mntmAbout.addActionListener(this);
		
		setJMenuBar(menuBar);
		
		JPanel footer = new JPanel();
		//footer.setBackground(Color.CYAN);
		getContentPane().add(footer, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		panel.setBorder(null);
		//panel.setBackground(new Color(204, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		
		
		JLabel lblSourceFile = new JLabel("Source File");
		lblSourceFile.setToolTipText("Please Select A source File to replicate");
		GridBagConstraints gbc_lblSourceFile = new GridBagConstraints();
		gbc_lblSourceFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblSourceFile.anchor = GridBagConstraints.EAST;
		gbc_lblSourceFile.gridx = 0;
		gbc_lblSourceFile.gridy = 1;
		panel.add(lblSourceFile, gbc_lblSourceFile);
		
		srcFileLoc = new JTextField();
		GridBagConstraints gbc_srcFileLoc = new GridBagConstraints();
		gbc_srcFileLoc.insets = new Insets(0, 0, 5, 5);
		gbc_srcFileLoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_srcFileLoc.gridx = 1;
		gbc_srcFileLoc.gridy = 1;
		panel.add(srcFileLoc, gbc_srcFileLoc);
		srcFileLoc.setColumns(65);
		
		btnsrcFile = new JButton("Open");
		GridBagConstraints gbc_btnsrcFile = new GridBagConstraints();
		gbc_btnsrcFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnsrcFile.gridx = 2;
		gbc_btnsrcFile.gridy = 1;
		panel.add(btnsrcFile, gbc_btnsrcFile);
		
		JLabel tgtFile = new JLabel("Target Directory");
		tgtFile.setToolTipText("Target Directory which will contain all the generated data");
		GridBagConstraints gbc_tgtFile = new GridBagConstraints();
		gbc_tgtFile.anchor = GridBagConstraints.EAST;
		gbc_tgtFile.insets = new Insets(0, 0, 5, 5);
		gbc_tgtFile.gridx = 0;
		gbc_tgtFile.gridy = 2;
		panel.add(tgtFile, gbc_tgtFile);
		
		tgtFileFld = new JTextField();
		GridBagConstraints gbc_tgtFileFld = new GridBagConstraints();
		gbc_tgtFileFld.insets = new Insets(0, 0, 5, 5);
		gbc_tgtFileFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_tgtFileFld.gridx = 1;
		gbc_tgtFileFld.gridy = 2;
		panel.add(tgtFileFld, gbc_tgtFileFld);
		tgtFileFld.setColumns(65);
		
		btnTgtFile = new JButton("Open");
		GridBagConstraints gbc_btnTgtFile = new GridBagConstraints();
		gbc_btnTgtFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnTgtFile.gridx = 2;
		gbc_btnTgtFile.gridy = 2;
		panel.add(btnTgtFile, gbc_btnTgtFile);
		
		JLabel lblBusinessKey = new JLabel("Business Keys");
		lblBusinessKey.setToolTipText("Business Keys eg. 112233::11{01}33;;1234-56::12{45}-56");
		GridBagConstraints gbc_lblBusinessKey = new GridBagConstraints();
		gbc_lblBusinessKey.anchor = GridBagConstraints.EAST;
		gbc_lblBusinessKey.insets = new Insets(0, 0, 5, 5);
		gbc_lblBusinessKey.gridx = 0;
		gbc_lblBusinessKey.gridy = 3;
		panel.add(lblBusinessKey, gbc_lblBusinessKey);
		
		bKeyFld = new JTextField();
		GridBagConstraints gbc_bKeyFld = new GridBagConstraints();
		gbc_bKeyFld.insets = new Insets(0, 0, 5, 5);
		gbc_bKeyFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_bKeyFld.gridx = 1;
		gbc_bKeyFld.gridy = 3;
		panel.add(bKeyFld, gbc_bKeyFld);
		bKeyFld.setColumns(65);
		
		JLabel lblNumberOfOccourences = new JLabel("Number of Files");
		lblNumberOfOccourences.setToolTipText("Number of target files desired");
		GridBagConstraints gbc_lblNumberOfOccourences = new GridBagConstraints();
		gbc_lblNumberOfOccourences.anchor = GridBagConstraints.EAST;
		gbc_lblNumberOfOccourences.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfOccourences.gridx = 0;
		gbc_lblNumberOfOccourences.gridy = 4;
		panel.add(lblNumberOfOccourences, gbc_lblNumberOfOccourences);
		
		numFiles = new JTextField();
		GridBagConstraints gbc_numFiles = new GridBagConstraints();
		gbc_numFiles.insets = new Insets(0, 0, 5, 5);
		gbc_numFiles.fill = GridBagConstraints.HORIZONTAL;
		gbc_numFiles.gridx = 1;
		gbc_numFiles.gridy = 4;
		panel.add(numFiles, gbc_numFiles);
		numFiles.setColumns(65);
		
		JLabel lblExtension = new JLabel("Extension");
		lblExtension.setToolTipText("extension if extension is needed to be modified for each file");
		lblExtension.setBackground(new Color(253, 249, 204));
		GridBagConstraints gbc_lblExtension = new GridBagConstraints();
		gbc_lblExtension.anchor = GridBagConstraints.EAST;
		gbc_lblExtension.insets = new Insets(0, 0, 5, 5);
		gbc_lblExtension.gridx = 0;
		gbc_lblExtension.gridy = 5;
		panel.add(lblExtension, gbc_lblExtension);
		
		extFld = new JTextField();
		GridBagConstraints gbc_extFld = new GridBagConstraints();
		gbc_extFld.insets = new Insets(0, 0, 5, 5);
		gbc_extFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_extFld.gridx = 1;
		gbc_extFld.gridy = 5;
		panel.add(extFld, gbc_extFld);
		extFld.setColumns(65);
		
		btnGenerate = new JButton("Generate");
		GridBagConstraints gbc_btnGenerate = new GridBagConstraints();
		gbc_btnGenerate.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerate.gridx = 1;
		gbc_btnGenerate.gridy = 6;
		panel.add(btnGenerate, gbc_btnGenerate);
		
		JButton button = new JButton("?");

		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 6;
		panel.add(button, gbc_button);
		
		
		// TODO Auto-generated constructor stub
		btnsrcFile.addActionListener(this);
		btnTgtFile.addActionListener(this);
		tgtFielLocfld.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		btnGenerate.addActionListener(this);
	}
	
	public static void main(String[] args) {
		
		
		Launch2 l2=new Launch2();
		l2.setVisible(true);
		l2.pack();
		//l2.setSize(800, 600);
	}
}
