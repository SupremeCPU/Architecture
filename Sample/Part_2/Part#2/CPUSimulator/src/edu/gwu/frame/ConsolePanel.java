package edu.gwu.frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Queue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import edu.gwu.common.Util;
import edu.gwu.core.Log;

public class ConsolePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3789059821467636448L;

	private Log log = Log.getInstance();
	
	/**
	 * use JTextPane instead of JTextArea 
	 * <br>because JTextPane can set different lines into different colors
	 * <br> normal logs will be in White foreground (Black background)
	 * <br> error logs will be in Red foreground (Black background)
	 */
	private JTextPane text;
	
	
	/**
	 * construction
	 */
	public ConsolePanel(){
		
		TitledBorder nameTitle =new TitledBorder("Console"); 
		
		this.setBorder(nameTitle);
		
		this.setLayout(new GridLayout());
		
		text = new JTextPane();
		text.setBounds(0, 0, 400, 200);
		text.setBackground(Color.black);
		text.setForeground(Color.white);
		//text.setEditable(false);
		
		//this.add(text);
		JScrollPane js = new JScrollPane(text);
		js.setBackground(Color.black);
		this.add(js);
		
	}
	
	
	public void update(){
		Queue<String> msgs = log.getConsoleMessage();
		while(!msgs.isEmpty()){
			//text.append("["+Util.getCurrentTime()+"] "+msgs.poll());
			//text.append("\n");
			addMessage(msgs.poll());
		}
	}
	
	private void addMessage(String content){
		SimpleAttributeSet attrSet = new SimpleAttributeSet();
		if(content.contains("[ERROR]"))
			StyleConstants.setForeground(attrSet, Color.red);
		else if(content.contains("[END]"))
			StyleConstants.setForeground(attrSet, Color.green);
		Document doc = text.getDocument();
		try {
			doc.insertString(doc.getLength(),"["+Util.getCurrentTime()+"] "+content+"\n",attrSet);
			text.setSelectionStart(text.getText().length());
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//insert(str, attrSet);
	}
	
}
