package com.ycaocc.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.ycaocc.dao.StageDao;
import com.ycaocc.model.Stage;
import com.ycaocc.util.DbUtil;
import com.ycaocc.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StageAll extends JInternalFrame {
	private JTextField companyTxt;
	private JTextField postnameTxt;
	private JTable stageTable;
	private JComboBox cityJcb;
	private DbUtil dbUtil = new DbUtil();

	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JTextField idTxt;
	private JLabel lblNewLabel_4;
	private JTextField dataTxt;
	private JLabel lblNewLabel_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_6;
	
	private JRadioButton firstViewedJrb;
	private JRadioButton sentJrb;
	private JRadioButton secondViewedJrb;
	private JRadioButton rejectedJrb;
	private JTextArea competenceTxt;
	private JTextArea infoTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StageAll frame = new StageAll();
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
	public StageAll() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 725, 594);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "search condition", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		scrollPane = new JScrollPane();
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "form operator", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		lblNewLabel_3 = new JLabel("id");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		lblNewLabel_4 = new JLabel("data");
		
		dataTxt = new JTextField();
		dataTxt.setColumns(10);
		
		lblNewLabel_5 = new JLabel("status");
		
		sentJrb = new JRadioButton("sent");
		buttonGroup.add(sentJrb);
		sentJrb.setSelected(true);
		
		firstViewedJrb = new JRadioButton("1 viewed");
		buttonGroup.add(firstViewedJrb);
		
		secondViewedJrb = new JRadioButton("2 viewed");
		buttonGroup.add(secondViewedJrb);
		
		rejectedJrb = new JRadioButton("rejected");
		buttonGroup.add(rejectedJrb);
		
		lblNewLabel_6 = new JLabel("competence");
		
		competenceTxt = new JTextArea();
		
		JLabel lblNewLabel_7 = new JLabel("information");
		
		infoTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("change");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stageUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(StageAll.class.getResource("/images/change.png")));
		
		JButton btnNewButton_2 = new JButton("delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stageDeleteActionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(StageAll.class.getResource("/images/delete.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
							.addGap(41)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(dataTxt, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(competenceTxt, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(24)
							.addComponent(btnNewButton_2)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(infoTxt, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(sentJrb, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(firstViewedJrb, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(secondViewedJrb)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rejectedJrb))
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(dataTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(sentJrb)
						.addComponent(firstViewedJrb)
						.addComponent(secondViewedJrb)
						.addComponent(rejectedJrb))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(competenceTxt, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(infoTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		stageTable = new JTable();
		stageTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				stageTableMousePressed(e);
			}
		});
		scrollPane.setViewportView(stageTable);
		stageTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "entreprise", "emploi", "competence", "information", "ville", "date", "lien", "status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JLabel lblNewLabel = new JLabel("company");
		
		companyTxt = new JTextField();
		companyTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("post name");
		
		postnameTxt = new JTextField();
		postnameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stageSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(StageAll.class.getResource("/images/search.png")));
		
		cityJcb = new JComboBox();
		
		JLabel lblNewLabel_2 = new JLabel("city");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(companyTxt, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblNewLabel_1)
					.addGap(11)
					.addComponent(postnameTxt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cityJcb, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(6))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel)
									.addComponent(companyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(postnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(cityJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		fillVille();
		fillTable(new Stage());
		competenceTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		infoTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}

	private void stageDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "please select your content to delete");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?");
		if(n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				
				int deleteNum = StageDao.delete(con, id);
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "deleting succeeds");
					this.resetValue();
					this.fillTable(new Stage());
				}else {
					JOptionPane.showMessageDialog(null, "deleting fails");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "deleting fails");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void stageUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = this.idTxt.getText();
		Integer id_int = Integer.parseInt(id);
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "please select the record to change");
			return;
		}
		String data = this.dataTxt.getText();
		if(StringUtil.isEmpty(data)) {
			JOptionPane.showMessageDialog(null, "data must have a value");
			return;
		}
		String status = "";
		if(sentJrb.isSelected()) {
			status = "sent";
		}else if(firstViewedJrb.isSelected()) {
			status = "1 viewed";
		}else if(secondViewedJrb.isSelected()) {
			status = "2 viewed";
		}else if(rejectedJrb.isSelected()) {
			status = "rejected";
		}
		
		Stage stage = new Stage(id_int,data,status);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = StageDao.update(con,stage);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "stage changing succeeds");
				resetValue();
				this.fillTable(new Stage());
			}else {
				JOptionPane.showMessageDialog(null, "stage changing fails");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "stage changing fails");
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
		this.idTxt.setText("");
		this.dataTxt.setText("");
		this.sentJrb.setSelected(true);
		this.competenceTxt.setText("");
		this.infoTxt.setText("");
	}

	private void stageTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = this.stageTable.getSelectedRow();
		this.idTxt.setText(stageTable.getValueAt(row, 0).toString());
		this.dataTxt.setText((String) stageTable.getValueAt(row, 6));
		String status = (String) stageTable.getValueAt(row, 8);
		if("sent".equals(status)) {
			this.sentJrb.setSelected(true);
		}else if("1 viewed".equals(status)) {
			this.firstViewedJrb.setSelected(true);
		}else if("2 viewed".equals(status)) {
			this.secondViewedJrb.setSelected(true);
		}else if("rejected".equals(status)) {
			this.rejectedJrb.setSelected(true);
		}
		
		this.competenceTxt.setText((String) stageTable.getValueAt(row, 3));
		this.infoTxt.setText((String) stageTable.getValueAt(row, 4));
	}

	private void stageSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String entreprise = this.companyTxt.getText();
		String postname = this.postnameTxt.getText();
		String ville = this.cityJcb.getSelectedItem().toString();//use (String) to convert does not work
		
			//ville = (String) this.cityJcb.getSelectedItem();//use (String) to convert
		
		Stage stage = new Stage(entreprise, postname, ville);
		
		fillTable(stage);
	}

	private void fillTable(Stage stage) {
		// TODO Auto-generated method stub
		 
		 DefaultTableModel dtm = (DefaultTableModel) stageTable.getModel();
		 dtm.setRowCount(0);
		 Connection con = null;
		 try {
			con = dbUtil.getCon();
			ResultSet rs = StageDao.list(con, stage);
			while(rs.next()) {
				Vector v= new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("entreprise"));
				v.add(rs.getString("emploi"));
				v.add(rs.getString("competence"));
				v.add(rs.getString("information"));
				v.add(rs.getString("ville"));
				v.add(rs.getString("date"));
				v.add(rs.getString("lien"));
				v.add(rs.getString("status"));
				dtm.addRow(v);
			}
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
			
	}
	private void fillVille() {
		Connection con=null;
		Stage stage = null;
		try {
			con = dbUtil.getCon();
			
			ResultSet rs = StageDao.getVille(con);
			stage = new Stage();
			stage.setVille("please select...");
			this.cityJcb.addItem(stage);
			
			while(rs.next()) {
				stage = new Stage();
				stage.setVille(rs.getString("ville"));
				this.cityJcb.addItem(stage);	
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
