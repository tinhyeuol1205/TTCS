package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CTDL.ArrayList;
import CTDL.ArrayList.ArrayIterator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Demo1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private final JLabel lblNewLabel = new JLabel("Iterator:");
	private final JLabel lblIteratorhasnext = new JLabel("Iterator.hasNext():");
	private final JButton btnNewButton_1 = new JButton("Remove");
	private final JTextField textField_1 = new JTextField();
	private JTextField textField_2;
	private final JLabel lblNewLabel_2 = new JLabel("");
	private final JLabel lblNewLabel_3 = new JLabel("");
	private final JLabel lblNewLabel_4 = new JLabel("");
	private final JLabel lblNewLabel_5 = new JLabel("");
	private final JLabel lblNewLabel_6 = new JLabel("");
	private final JLabel lblNewLabel_7 = new JLabel("");
	private final JLabel lblNewLabel_8 = new JLabel("");
	private final JLabel lblNewLabel_9 = new JLabel("");
	private ArrayList<Integer> a = new ArrayList<>();
	private JLabel[] lbLabels = new JLabel[10];
	private final JButton btnNewButton_2 = new JButton("Run");
	int d=0;
	Iterator<Integer> iterator = a.iterator();
	private final JButton btnNewButton_3 = new JButton("Refresh");

	/**
	 * Create the dialog.
	 */
	public Demo1() {
		textField_1.setBounds(122, 75, 86, 20);
		textField_1.setColumns(10);
		setTitle("Iterator");
		setBounds(100, 100, 443, 202);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setBounds(10, 11, 34, 23);
		contentPanel.add(lblNewLabel_1);
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.GRAY);
		lblNewLabel_2.setBounds(54, 11, 34, 23);
		
		contentPanel.add(lblNewLabel_2);
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.GRAY);
		lblNewLabel_3.setBounds(98, 11, 34, 23);
		
		contentPanel.add(lblNewLabel_3);
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.GRAY);
		lblNewLabel_4.setBounds(142, 10, 34, 23);
		
		contentPanel.add(lblNewLabel_4);
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(Color.GRAY);
		lblNewLabel_5.setBounds(186, 10, 34, 23);
		
		contentPanel.add(lblNewLabel_5);
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(Color.GRAY);
		lblNewLabel_6.setBounds(230, 10, 34, 23);
		
		contentPanel.add(lblNewLabel_6);
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(Color.GRAY);
		lblNewLabel_7.setBounds(274, 11, 34, 23);
		
		contentPanel.add(lblNewLabel_7);
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(Color.GRAY);
		lblNewLabel_8.setBounds(318, 11, 34, 23);
		
		contentPanel.add(lblNewLabel_8);
		lblNewLabel_9.setForeground(Color.BLUE);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setBackground(Color.GRAY);
		lblNewLabel_9.setBounds(362, 11, 34, 23);
		
		contentPanel.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(10, 44, 317, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = 0;
				iterator = a.iterator();
				lbLabels[0] = lblNewLabel_1;
				lbLabels[1] = lblNewLabel_2;
				lbLabels[2] = lblNewLabel_3;
				lbLabels[3] = lblNewLabel_4;
				lbLabels[4] = lblNewLabel_5;
				lbLabels[5] = lblNewLabel_6;
				lbLabels[6] = lblNewLabel_7;
				lbLabels[7] = lblNewLabel_8;
				lbLabels[8] = lblNewLabel_9;
				String[] txt = textField.getText().split(" ");
				for(int i=0;i<txt.length;i++) {
					a.add(i, Integer.valueOf(txt[i]));
					lbLabels[i].setText(txt[i]);
					lbLabels[i].setForeground(Color.BLUE);
				}
			}
		});
		btnNewButton.setBounds(335, 43, 89, 23);
		contentPanel.add(btnNewButton);
		lblNewLabel.setBounds(10, 75, 89, 20);
		
		contentPanel.add(lblNewLabel);
		lblIteratorhasnext.setBounds(10, 101, 115, 20);
		
		contentPanel.add(lblIteratorhasnext);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iterator.remove();
			}
		});
		btnNewButton_1.setBounds(10, 129, 89, 23);
		
		contentPanel.add(btnNewButton_1);
		
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 101, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(iterator.hasNext()) {
					lbLabels[d++].setForeground(Color.RED);
					textField_2.setText("True");
					textField_1.setText(iterator.next().toString());
					break;
				}
				if(iterator.hasNext()==false) textField_2.setText("False");
			}
		});
		btnNewButton_2.setBounds(109, 129, 89, 23);
		
		contentPanel.add(btnNewButton_2);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = 0;
				iterator = a.iterator();
				lbLabels[0] = lblNewLabel_1;
				lbLabels[1] = lblNewLabel_2;
				lbLabels[2] = lblNewLabel_3;
				lbLabels[3] = lblNewLabel_4;
				lbLabels[4] = lblNewLabel_5;
				lbLabels[5] = lblNewLabel_6;
				lbLabels[6] = lblNewLabel_7;
				lbLabels[7] = lblNewLabel_8;
				lbLabels[8] = lblNewLabel_9;
				for(int i=0;i<a.size();i++) {
					lbLabels[i].setText(String.valueOf(a.get(i)));
					lbLabels[i].setForeground(Color.BLUE);
				}
				for(int i=a.size();i<9;i++) {
					lbLabels[i].setText("");
				}
			}
		});
		btnNewButton_3.setBounds(208, 129, 89, 23);
		
		contentPanel.add(btnNewButton_3);
		
	}
}
