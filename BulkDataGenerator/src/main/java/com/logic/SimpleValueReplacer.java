package com.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.swing.JOptionPane;

public class SimpleValueReplacer {

	/**
	 * @param args
	 */
	int outputNumber=1;
	File opFolder;
	public String readFile(String filename)
	{
		String fileContents="";
		StringBuffer contents=new StringBuffer();
		File f=new File(filename);
		if(f.isFile())
		{}
		else{
			JOptionPane.showMessageDialog(null, "Not A File");
		}
		FileReader fr=null;
		try{
			fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			//String line="";
			int ch;
			while((ch=br.read())!=-1)
			{
				contents.append((char)ch);
			}
			fileContents=contents.toString();
			contents=null;
			/*while((line=br.readLine())!=null)
			{
				//line=line.trim();
				fileContents=(fileContents.equals(""))?line:(fileContents+"\n"+line);
				if(line.length()==0)
					fileContents+="\n";
				//System.out.println(line);
				line=null;
				System.gc();
			}*/
			fr.close();
		}catch(Exception e){System.out.println(e);}
		return fileContents;
	}
	public String convertor(String src,String[] businessKeys)
	{
		String srcCpy=new String(src);
		for(String ckey:businessKeys)
		{
		String[] keyRepl=ckey.split("::");
		String targ=keyRepl[1];
		String val=getCalculatedValue(keyRepl[1]);
		String replacer=targ.substring(0,targ.indexOf("{"))+val+targ.substring(targ.indexOf("}")+1);
		srcCpy=srcCpy.replaceAll(keyRepl[0], replacer);
		}
	outputNumber++;
	return srcCpy;
	}
	public String convertor2(String src,String[] businessKeys, String val)
	{
		String srcCpy=new String(src);
		for(String ckey:businessKeys)
		{
		String[] keyRepl=ckey.split("::");
		String targ=keyRepl[1];
		//String val=getCalculatedValue(keyRepl[1]);
		String replacer=targ.substring(0,targ.indexOf("{"))+val+targ.substring(targ.indexOf("}")+1);
		srcCpy=srcCpy.replaceAll(keyRepl[0], replacer);
		}
	outputNumber++;
	return srcCpy;
	}
	public String getCalculatedValue(String srcNode)
	{
		String src=srcNode.substring(srcNode.indexOf("{")+1,srcNode.indexOf("}"));
		System.out.print("replacing "+src);
		int i=Integer.parseInt(src);
		int len=src.length();
		i=i+outputNumber;
		String retVal=i+"";
		while(retVal.length()<len)
		{
			retVal="0"+retVal;
		}
		System.out.println(" with "+retVal);
		return retVal;
	}
	
	
	public void uiCaller()
	{
		String filename=JOptionPane.showInputDialog("Enter File Name");
		String allBusinessKeys=JOptionPane.showInputDialog("Enter Business Keys seperated by ;;");
		String numberOfOccurances=JOptionPane.showInputDialog("Enter Number of occurances");
		String outputDir=JOptionPane.showInputDialog("Enter Output Directory");
		String convertor=JOptionPane.showInputDialog("Enter Convertor String eg:\"20130822::yyyyMMdd\"");
		int numOccur=Integer.parseInt(numberOfOccurances.trim());
		process(outputDir, filename, numOccur, allBusinessKeys,convertor);
	}
	public void hcCaller()
	{
		String filename="C:/Users/319113\\Desktop\\somnath\\MessageSelectors Scenario Input Files\\CustomerAddress_Z100.xml";
		String allBusinessKeys="<VKORG>2000</VKORG>::<VKORG>{2000}</VKORG>";
		String numberOfOccurances="60";
		String outputDir="C:/Users/319113\\Desktop\\somnath\\outputs";
		String valsFileName="C:/Users/319113\\Desktop\\somnath\\VKORG_SalesOrgCd Values.txt";
		String convertor="";//"20130822::yyyyMMdd";
		int numOccur=Integer.parseInt(numberOfOccurances.trim());
		System.out.println(1);
		process2(outputDir, filename, numOccur, allBusinessKeys,convertor,valsFileName);
	}
	public boolean otherCaller(String filename, String allBusinessKeys,String outputDir,String convertor,int numOccur )
	{
		System.out.println("calling");
		try{
		process(outputDir, filename, numOccur, allBusinessKeys,convertor);
		}catch(Exception e){return false;}
		return true;
	}
	public void process(String outputDir,String filename,int numOccur,String allBusinessKeys, String convertor)
	{
		if(outputDir.equals(""))outputDir="outputs";
		
		String[] businessKeys=allBusinessKeys.split(";;");
		//op folder creation
		opFolder=new File(outputDir);
		opFolder.mkdirs();
		
		//convertor calling		
		String readFile=readFile(filename);
		
		for(int filenum=1;filenum<=numOccur;filenum++)
		{
			System.out.println("filenumber:"+filenum);
			String newFile=convertor(readFile, businessKeys);
			writeFile(filename,newFile,opFolder,convertor);
			
		}
		
		
	}
	public void process2(String outputDir,String filename,int numOccur,String allBusinessKeys, String convertor, String valsFile)
	{
		if(outputDir.equals(""))outputDir="outputs";
		
		String[] businessKeys=allBusinessKeys.split(";;");
		//op folder creation
		opFolder=new File(outputDir);
		opFolder.mkdirs();
		
		//convertor calling		
		String readFile=readFile(filename);
		try{
		File f=new File(valsFile);
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String s="";
		int filenum=1;
		while((s=br.readLine())!=null)
		{
			System.out.println("filenumber:"+filenum);
			String newFile=convertor2(readFile, businessKeys,s);
			writeFile(filename,newFile,opFolder,convertor);
			filenum++;
		}
		}catch(Exception e){e.printStackTrace();}
		
	}
	public void writeFile(String filename,String content,File folder, String convertor)
	{
		File f=new File(filename);
		filename=f.getName();
		f=null;
		String[] fnsubs=filename.split("\\.");
		String newFileName=getIncrementedExtension(fnsubs[0],(outputNumber-1),fnsubs[1],convertor);
		
		System.out.println("---- "+folder.getAbsolutePath()+"        "+newFileName);
		//System.out.println(newFileName+"\n"+content);
		File newFile=new File(folder,newFileName);
		try{
		FileWriter fw=new FileWriter(newFile);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(content);
		bw.flush();
		bw.close();
		fw.close();
		System.out.println("Written: "+newFileName);
		}catch(Exception e){e.printStackTrace();}
	}
	public String getIncrementedExtension(String filename,int val,String ext, String convertor)
	{
		String newExt="";
		if(convertor==null)
			convertor="";
		String[] e=convertor.split("::");
		if(e.length<2)
		{
			newExt=filename+val+"."+ext;
			System.out.println("simple val appender");
		}
		else
		{
			System.out.println("complex appender");
			Date d=null;
			SimpleDateFormat s=new SimpleDateFormat(e[1]);
			try{
			d=s.parse(e[0]);
			}catch(Exception ex){ex.printStackTrace();}
			Calendar c=Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.DAY_OF_MONTH, val);
			newExt=filename+"."+ext.replace(e[0], s.format(c.getTime()));
		}
		return newExt;
	}
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	SimpleValueReplacer svr=new SimpleValueReplacer();
	//svr.hcCaller();
	//svr.hcCaller();
	svr.otherCaller(filename, allBusinessKeys, outputDir, convertor, numOccur);
	}
*/
}
