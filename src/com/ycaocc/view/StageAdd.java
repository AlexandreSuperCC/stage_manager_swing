package com.ycaocc.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.ycaocc.dao.StageDao;
import com.ycaocc.model.Stage;
import com.ycaocc.util.DbUtil;
import com.ycaocc.util.StringUtil;

public class StageAdd extends JInternalFrame {
	private JTextField entrepriseTxt;
	private JTextField emploiTxt;
	private JTextField villeTxt;
	private JTextField lienTxt;
	private JTextArea competenceTxt;
	private JTextArea infoTxt;
	
	private DbUtil dbUtil = new DbUtil();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StageAdd frame = new StageAdd();
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
	public StageAdd() {
		setIconifiable(true);
		setClosable(true);
		setTitle("stage add");
		setBounds(100, 100, 480, 341);
		
		JLabel lblNewLabel = new JLabel("company");
		
		entrepriseTxt = new JTextField();
		entrepriseTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("post");
		
		emploiTxt = new JTextField();
		emploiTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("competence");
		
		JLabel lblNewLabel_3 = new JLabel("information");
		
		competenceTxt = new JTextArea();
		
		infoTxt = new JTextArea();
		
		JLabel lblNewLabel_4 = new JLabel("city");
		
		villeTxt = new JTextField();
		villeTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("lien");
		
		lienTxt = new JTextField();
		lienTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stageAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(StageAdd.class.getResource("/images/add.png")));
		
		JButton btnNewButton_1 = new JButton("reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValuePerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(StageAdd.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(entrepriseTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(emploiTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(villeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lienTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
									.addComponent(btnNewButton_1))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(infoTxt, Alignment.LEADING)
									.addComponent(competenceTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(entrepriseTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(villeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(emploiTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(lienTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(competenceTxt, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(infoTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addComponent(btnNewButton_1)))
						.addComponent(lblNewLabel_3))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		competenceTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		infoTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}

	private void resetValuePerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	private void stageAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String entreprise = this.entrepriseTxt.getText();
		String emploi = this.emploiTxt.getText();
		String competence = this.competenceTxt.getText();
		String info = this.infoTxt.getText();
		String ville = this.villeTxt.getText();
		String lien = this.lienTxt.getText();
		
		if(StringUtil.isEmpty(entreprise)) {
			JOptionPane.showMessageDialog(null, "company name must have a value");
			return;
		}
		if(StringUtil.isEmpty(emploi)) {
			JOptionPane.showMessageDialog(null, "emploi name must have a value");
			return;
		}
		
		Stage stage = new Stage(entreprise, emploi, competence, info, ville, lien);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = StageDao.add(con, stage);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "stage adding succeeds");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "stage adding fails");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "stage adding fails");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void resetValue() {
		// TODO Auto-generated method stub
		this.entrepriseTxt.setText("");
		this.emploiTxt.setText("");
		this.competenceTxt.setText("");
		this.infoTxt.setText("");
		this.villeTxt.setText("");
		this.lienTxt.setText("");
	}

}
