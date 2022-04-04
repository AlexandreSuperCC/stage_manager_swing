package com.ycaocc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktop;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		
		setTitle("stage manager\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/java.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 582);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("stage");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("2021_stage");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("manager");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StageAll stageAll = new StageAll();
				stageAll.setVisible(true);
				desktop.add(stageAll);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmAdd = new JMenuItem("add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stageAddActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mntmAdd);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("logout safely");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutActionPerformed(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("about us");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("about yuanc");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUsActionPerformed(e);

			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		desktop = new JDesktopPane();
		desktop.setBackground(new Color(255, 250, 205));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktop, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktop, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void logoutActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "you want to leave the system?");
		if(result == 0) {
			dispose();
		}
	}

	private void stageAddActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		StageAdd stageAdd = new StageAdd();
		stageAdd.setVisible(true);
		desktop.add(stageAdd);
	}

	private void aboutUsActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		YuancInterFrm yuancInterFrm = new YuancInterFrm();
		yuancInterFrm.setVisible(true);
		desktop.add(yuancInterFrm);
	}
}
