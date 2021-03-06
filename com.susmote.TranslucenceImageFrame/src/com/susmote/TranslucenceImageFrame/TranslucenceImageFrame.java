package com.susmote.TranslucenceImageFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

public class TranslucenceImageFrame extends JFrame {

	/**
	 * coding by susmote
	 */
	private static final long serialVersionUID = -5845538185707674011L;
	private Image img = null;
	private TranslucenceImagePanel translucencePanel = null;
	private AlphaComposite alpha = AlphaComposite.SrcOver.derive(1.0f);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TranslucenceImageFrame frame = new TranslucenceImageFrame();
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
	public TranslucenceImageFrame() {
		super();
		URL imgUrl = TranslucenceImageFrame.class.getResource("/img/imag.jpg");
		img = Toolkit.getDefaultToolkit().getImage(imgUrl);
		translucencePanel = new TranslucenceImagePanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 160, 316, 237);
		this.add(translucencePanel);
		this.setTitle("图片半透明特效");

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alpha = AlphaComposite.SrcOver.derive(0.5f);
				translucencePanel.repaint();
			}
		});
		button.setText("半透明");
		panel.add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alpha = AlphaComposite.SrcOver.derive(1.0f);
				translucencePanel.repaint();
			}
		});
		button_1.setText("不透明");
		panel.add(button_1);
	}
	class TranslucenceImagePanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 7468684672581569407L;

		@Override
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.clearRect(0, 0, getWidth(), getHeight());
			g2.setComposite(alpha);
			g2.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}

}
