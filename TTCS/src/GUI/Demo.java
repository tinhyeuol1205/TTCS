package GUI;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CTDL.ArrayList;
import CTDL.LinkedPositionalList;
import CTDL.Position;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;

public class Demo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ArrayList<String> arr = new ArrayList<>();
	private JTextField textField_3;
	private JTextField textField_4;
	private LinkedPositionalList<Integer> ds= new LinkedPositionalList<>();
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo frame = new Demo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Demo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(12, 46, 423, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 82, 342, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				String[] s = text.split(" ");
				arr = new ArrayList<>();
				for(int i=0;i<s.length;i++)
					arr.add(i, s[i]);
			}
		});
		btnNewButton.setBounds(370, 82, 66, 24);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(49, 108, 51, 20);
		contentPane.add(textField_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(textField_1.getText());
				String value = textField_2.getText();
				if(index<=arr.size()) {
				arr.add(index, value);
				JOptionPane.showMessageDialog(null, "Done");}
				else {
					JOptionPane.showMessageDialog(null, "Index Out Of Bounds");
				}
			}
		});
		btnAdd.setBounds(10, 135, 66, 20);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel_1 = new JLabel("Index:");
		lblNewLabel_1.setBounds(10, 108, 40, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Value:");
		lblNewLabel_1_1.setBounds(107, 108, 40, 20);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 108, 86, 20);
		contentPane.add(textField_2);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(textField_1.getText());
				if(index<arr.size()) {
					arr.remove(index);
				    JOptionPane.showMessageDialog(null, "Done");}
					else {
						JOptionPane.showMessageDialog(null, "Index Out Of Bounds");
					}
			}
		});
		btnRemove.setBounds(88, 135, 80, 20);
		contentPane.add(btnRemove);
		
		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(textField_1.getText());
				if(index<arr.size()) {
				    JOptionPane.showMessageDialog(null, arr.get(index));}
					else {
						JOptionPane.showMessageDialog(null, "Index Out Of Bounds");
					}
			}
		});
		btnGet.setBounds(178, 135, 66, 20);
		contentPane.add(btnGet);
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(textField_1.getText());
				String value = textField_2.getText();
				if(index<=arr.size()) {
				arr.set(index, value);
				JOptionPane.showMessageDialog(null, "Done");}
				else {
					JOptionPane.showMessageDialog(null, "Index Out Of Bounds");
				}
			}
		});
		btnSet.setBounds(254, 135, 66, 20);
		contentPane.add(btnSet);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = "";
//				for(int i=0;i<arr.size();i++)
//					text+= arr.get(i)+" ";
				Iterator<String> iterator = arr.iterator();
				while(iterator.hasNext()) {
					text+= iterator.next()+" ";
				}
			    lblNewLabel.setText(text);
			}
		});
		btnNewButton_1.setBounds(12, 23, 66, 20);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sort");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<arr.size()-1;i++)
					for(int j=i+1;j<arr.size();j++) {
						if(Integer.valueOf(arr.get(i))>Integer.valueOf(arr.get(j))) {
							String tmp = arr.get(i);
							arr.set(i, arr.get(j));
							arr.set(j, tmp);
						}
					}
				JOptionPane.showMessageDialog(null, "Done");
			}
		});
		btnNewButton_2.setBounds(335, 135, 66, 20);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Size");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Size: "+arr.size());
			}
		});
		btnNewButton_3.setBounds(83, 23, 66, 20);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Array List:");
		lblNewLabel_2.setBounds(12, 0, 68, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Linked Positional List:");
		lblNewLabel_3.setBounds(10, 166, 139, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBackground(Color.BLUE);
		lblNewLabel_4.setBounds(10, 209, 425, 31);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("Show");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = "";
				Iterator<Position<Integer>> iterable = ds.positions().iterator();
				while (iterable.hasNext()) {
					Position<Integer> pos = iterable.next();
					text+=pos.getElement()+" ";
				}
				lblNewLabel_4.setText(text);
			}
		});
		btnNewButton_4.setBounds(10, 184, 74, 20);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Size");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ds.size());
			}
		});
		btnNewButton_5.setBounds(88, 184, 74, 20);
		contentPane.add(btnNewButton_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 246, 342, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("New");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField_3.getText();
				String[] s = text.split(" ");
				ds = new LinkedPositionalList<>();
				Position<Integer> p=ds.addFirst(Integer.valueOf(s[0]));
				for(int i=1;i<s.length;i++) {
					p =ds.addAfter(p,Integer.valueOf(s[i]));
				}
				JOptionPane.showMessageDialog(null, "Done");
			}
		});
		btnNewButton_6.setBounds(368, 245, 68, 21);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Value:");
		lblNewLabel_1_1_1.setBounds(13, 277, 40, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(63, 277, 86, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton_7 = new JButton("Add");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Add First", "Add Last", "Add After", "Add Before"};
				 int x = JOptionPane.showOptionDialog(null, "Choose a method",
			                "Click a button",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			        System.out.println(x);
			     Integer element=Integer.valueOf(textField_4.getText());
			     Integer position =Integer.valueOf(textField_5.getText());
			     if(x==0) ds.addFirst(element);
			     if(x==1) ds.addLast(element);
			     Integer tmp=0;
			     Iterator<Position<Integer>> iterable = ds.positions().iterator();
					while (iterable.hasNext()) {
						Position<Integer> pos = iterable.next();
						if(position==tmp) {
							if(x==2)
							ds.addAfter(pos, element);
							if(x==3) ds.addBefore(pos, element);
							break;
						}
						tmp++;
						//System.out.print(pos.getElement()+" ");
					}
			     //if(x==2) ds.addAfter(, element);
			     JOptionPane.showMessageDialog(null, "Done");
			}
		});
		btnNewButton_7.setBounds(11, 304, 66, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Set");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer position =Integer.valueOf(textField_5.getText());
				Integer tmp = 0;
				Integer value = Integer.valueOf(textField_4.getText());
				Iterator<Position<Integer>> iterable = ds.positions().iterator();
				while (iterable.hasNext()) {
					Position<Integer> pos = iterable.next();
					if(position==tmp) {
						ds.set(pos, value);
						break;
					}
					tmp++;
					//System.out.print(pos.getElement()+" ");
				}
				JOptionPane.showMessageDialog(null, "Done");
			}
		});
		btnNewButton_8.setBounds(88, 304, 66, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Remove");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer position =Integer.valueOf(textField_5.getText());
				Integer tmp = 0;
				Iterator<Position<Integer>> iterable = ds.positions().iterator();
				while (iterable.hasNext()) {
					Position<Integer> pos = iterable.next();
					if(position==tmp) {
						ds.remove(pos);
						break;
					}
					tmp++;
					//System.out.print(pos.getElement()+" ");
				}
				JOptionPane.showMessageDialog(null, "Done");
			}
		});
		btnNewButton_9.setBounds(165, 304, 86, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Sort");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedPositionalList.insertionSort(ds);
				JOptionPane.showMessageDialog(null, "Done");
			}
		});
		btnNewButton_10.setBounds(261, 304, 66, 23);
		contentPane.add(btnNewButton_10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(212, 277, 51, 20);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("Label:");
		lblNewLabel_1_2.setBounds(173, 277, 40, 20);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton_11 = new JButton("Iterator");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Demo1 dialog = new Demo1();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_11.setBounds(345, 304, 89, 23);
		contentPane.add(btnNewButton_11);
	}
}
