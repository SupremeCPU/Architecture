package edu.gwu.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import edu.gwu.common.Util;
import edu.gwu.core.Cache;
import edu.gwu.core.Log;
import edu.gwu.core.MainMemory;
import edu.gwu.core.ProgramCompiler;
import edu.gwu.exception.IllegalMemoryAddressException;

public class CodeLoader extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7881020205292583683L;

	private JTextArea code;
	private JTextArea binCode;
	private JTextArea lineText;
	private JScrollPane js;
	private JPanel action;
	private JButton clear,load;
	private Log log = Log.getInstance();
	
	public CodeLoader(){
		TitledBorder nameTitle =new TitledBorder("Code Editor"); 	
		this.setBorder(nameTitle);
		
		code = new JTextArea();
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		//code.append("\nAIR 2,100\nSTR 2,0,200\nAIR 1,50\nAMR 1,0,200\nSMR 1,0,200\nSIR 2,10");
		
		code.append("STR 0,0,126");
		code.append("\nLDR 0,0,126");
		code.append("\nAIR 0,127");
		code.append("\nAIR 3,4");
		code.append("\nSTR 0,0,127");
		code.append("\nLDX 1,127");
		code.append("\nLDR 0,0,126");
		code.append("\nSTR 0,1,0");
		code.append("\nLDR 0,0,126");
		code.append("\nIN 1,0");
		code.append("\nSTR 1,1,1");
		code.append("\nOUT 1,1");
		code.append("\nSIR 1,13");
		code.append("\nJZ 1,0,23");
		code.append("\nSIR 1,35");
		code.append("\nLDR 2,0,126");
		code.append("\nAIR 2,10");
		code.append("\nLDR 0,1,0");
		code.append("\nMLT 0,2");
		code.append("\nSTR 0,1,0");
		code.append("\nAMR 1,1,0");
		code.append("\nSTR 1,1,0");
		code.append("\nJMP 0,8");
		code.append("\nSTX 1,125");
		code.append("\nLDR 0,0,126");
		code.append("\nAIR 0,1");
		code.append("\nAMR 0,0,125");
		code.append("\nSTR 0,0,125");
		code.append("\nLDX 1,125");
		code.append("\nLDR 0,0,126");
		code.append("\nSTR 0,1,0");
		code.append("\nAIR 0,10");
		code.append("\nOUT 0,1");
		code.append("\nSOB 3,0,8");
		code.append("\nLDR 0,0,126");
		code.append("\nAIR 0,127");
		code.append("\nSTR 0,0,125");
		code.append("\nLDX 2,125");
		code.append("\nSTX 1,125");
		code.append("\nLDR 0,0,125");
		code.append("\nSIR 0,1");
		code.append("\nSTR 0,0,125");
		code.append("\nLDX 3,125");
		code.append("\nLDR 3,0,126");
		code.append("\nAIR 3,3");
		code.append("\nLDR 0,2,0");
		code.append("\nSMR 0,3,0");
		code.append("\nSTR 0,1,0");
		code.append("\nLDR 2,0,126");
		code.append("\nAIR 2,1");
		code.append("\nSTX 1,125");
		code.append("\nAMR 2,0,125");
		code.append("\nSTR 2,0,125");
		code.append("\nLDX 1,125");
		code.append("\nLDR 2,0,126");
		code.append("\nAIR 2,1");
		code.append("\nSTX 2,125");
		code.append("\nAMR 2,0,125");
		code.append("\nSTR 2,0,125");
		code.append("\nLDX 2,125");
		code.append("\nSOB 3,0,45");
		code.append("\nLDR 2,0,126");
		code.append("\nAIR 2,1");
		code.append("\nSTX 2,125");
		code.append("\nAMR 2,0,125");
		code.append("\nSTR 2,0,125");
		code.append("\nLDX 2,125");
		code.append("\nSTX 2,125");
		code.append("\nLDR 2,0,125");
		code.append("\nLDR 1,0,126");
		code.append("\nAMR 1,2,0");
		code.append("\nLDR 3,0,126");
		code.append("\nAIR 3,2");
		code.append("\nSTX 2,125");
		code.append("\nLDR 0,0,125");
		code.append("\nAIR 0,1");
		code.append("\nSTR 0,0,125");
		code.append("\nLDX 2,125");
		code.append("\nSTR 1,0,125");
		code.append("\nLDR 0,0,125");
		code.append("\nSMR 0,2,0");
		code.append("\nJCC 0,0,85");
		code.append("\nLDR 1,2,0");
		code.append("\nSTX 2,125");
		code.append("\nLDR 2,0,125");
		code.append("\nSOB 3,0,73");
		code.append("\nSIR 2,4");
		code.append("\nSTR 2,0,125");
		code.append("\nLDX 1,125");
		code.append("\nLDR 1,0,126");
		code.append("\nAIR 1,10");
		code.append("\nOUT 1,1");
		code.append("\nLDR 1,0,126");
		code.append("\nAIR 1,100");
		code.append("\nLDR 2,0,126");
		code.append("\nAIR 2,100");
		code.append("\nMLT 2,1");
		code.append("\nLDR 0,1,0");
		code.append("\nDVD 0,2");
		code.append("\nJNE 0,0,101");
		code.append("\nJZ 3,0,104");
		code.append("\nAIR 0,48");
		code.append("\nOUT 0,1");
		code.append("\nAIR 3,1");
		code.append("\nLDR 0,0,126");
		code.append("\nAIR 0,10");
		code.append("\nSTR 3,0,125");
		code.append("\nDVD 2,0");
		code.append("\nLDR 3,0,125");
		code.append("\nSTR 1,0,125");
		code.append("\nLDR 0,0,125");
		code.append("\nJNE 2,0,98");
			
		code.setBounds(0, 0, 400, 200);
		binCode = new JTextArea("101010  10  10 1 1010101");
		binCode.setBounds(0, 0, 400, 200);
		
		binCode.setBackground(Color.gray);
		
		lineText = new JTextArea();
		lineText.setBackground(Color.gray);
		lineText.setEditable(false);
		
		JPanel inner = new JPanel();
		inner.setLayout(new BorderLayout());
		inner.setBackground(Color.red);
		inner.add(code,BorderLayout.CENTER);
		inner.add(binCode,BorderLayout.EAST);
		inner.add(lineText,BorderLayout.WEST);
		
		binCode.setEditable(false);
		js = new JScrollPane(inner);
		this.setLayout(new GridLayout());
		
		action = new JPanel();
		action.setLayout(new GridLayout(1,1));
		Box box=Box.createVerticalBox();
		clear = new JButton("Clear");
		clear.setVisible(false);
		load = new JButton("Load");
		box.add(clear);
		box.add(load);
		action.add(box);
		
		this.setLayout(new BorderLayout());
		this.add(js,BorderLayout.CENTER);
		this.add(action,BorderLayout.EAST);
		
		this.addListener();
		updateBinaryCode();
	}
	
	private void addListener(){
		code.addKeyListener(
				new KeyListener(){

					@Override
					public void keyTyped(KeyEvent e) {
						
					}

					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						if(e.getKeyCode()==8||e.getKeyCode()==10)
							updateBinaryCode();
					}
					
				});
		load.addMouseListener(
				new MouseAdapter(){

					@Override
					public void mouseClicked(MouseEvent e) {
						loadBinaryCodeIntoMemory();
					}
					
				});
	}
	
	private void updateBinaryCode(){
		BufferedReader reader = new BufferedReader(new StringReader(code.getText()));
		try {
			binCode.setText("");
			lineText.setText("");
			String line = reader.readLine();
			int count = 0;
			while(line!=null){
				
				int[] bin = ProgramCompiler.decodeInstruction(line);
				binCode.append(Util.getBinaryStringFormBitsInInstructionFormat(bin));
				binCode.append("\n");
				lineText.append(count+"\n");
				count++;
				line = reader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadBinaryCodeIntoMemory(){
		if(binCode.getText().contains("-")){
			
		}
		BufferedReader reader = new BufferedReader(new StringReader(code.getText()));
		try {
			binCode.setText("");
			String line = reader.readLine();
			MainMemory mem = MainMemory.getInstance();
			int index = 0;
			int count = 0;
			while(line!=null){
				
				//if(line.indexOf("-")>=0){
				int[] bin = ProgramCompiler.decodeInstruction(line);
				binCode.append(Util.getBinaryStringFormBitsInInstructionFormat(bin));
				binCode.append("\n");
				count++;
				if(bin!=null){
					mem.write(index, bin);
					index++;
				}else{
					log.console("[ERROR] line:"+count+" cannot compile into binary code, ignored!");
				}
				
				
				
				line = reader.readLine();
			}
			
			log.console("Load program into MEMORY");
			
			Cache.getInstance().clear();
		} catch (IOException | IllegalMemoryAddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
