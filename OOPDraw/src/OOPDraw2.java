/* 
 * Filename: OOPDraw2.java 
 * Written By: Sunit Katkar 
 * E-Mail:sunitkatkar@hotmail.com 
 * Home-Page : http://www.vidyut.com/sunit 
 * Java Page : www.vidyut.com/sunit/JavaPage.html 
 ****************************************************************** 
 * Description: 
 * A very simple vector drawing example. I have used the OO concept 
 * of Polymorphism to declare on abstract Shape class and then derived  
 * line, rectangle and oval shape classes. The shapes are stored in a 
 * Vector so that they remain on screen as new shapes are drawn. 
 * An offscreen image technique is used to avoid flicker. 
 **************************************************************** 
 * Copyright (c) 1997 Sunit Katkar All Rights Reserved. 
 * 
 * Permission to use, copy, modify, and distribute this software 
 * for NON-COMMERCIAL or COMMERCIAL purposes and without fee 
 * is hereby granted. 
 * 
 * Whew ! That was too much legalese..even to have copied and pasted 
 * from some other place... PLEASE DO NOT BLAME ME in any way 
 * if your system crashes because of this code, or if anything else 
 * bad happens. In short "DO WHAT YOU WANT BUT DONT BLAME ME !" 
 *****************************************************************/
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Filename: OOPDraw2.java<br/>
 * Written By: Sunit Katkar<br/>
 * E-Mail:sunitkatkar@hotmail.com<br/>
 * Home-Page : [url]http://www.vidyut.com/sunit[/url]<br/>
 * Java Page : [url]www.vidyut.com/sunit/JavaPage.html[/url]
 * <p/>
 ******************************************************************************* <p/>
 * Description: A very simple vector drawing example. I have used the OO concept
 * of Polymorphism to declare on abstract Shape class and then derived line,
 * rectangle and oval shape classes. The shapes are stored in a Vector so that
 * they remain on screen as new shapes are drawn. An offscreen image technique
 * is used to avoid flicker.
 * <p/>
 ******************************************************************************* <p/>
 * Copyright (c) 1997 Sunit Katkar All Rights Reserved.
 * <p/>
 * 
 * Permission to use, copy, modify, and distribute this software for
 * NON-COMMERCIAL or COMMERCIAL purposes and without fee is hereby granted.
 * <p/>
 * 
 * Whew ! That was too much legalese..even to have copied and pasted from some
 * other place... PLEASE DO NOT BLAME ME in any way if your system crashes
 * because of this code, or if anything else bad happens. In short
 * "DO WHAT YOU WANT BUT DONT BLAME ME !"
 * <p/>
 ******************************************************************************* <p/>
 * This code was modified by BugSlayer to change it from an applet into a
 * desktop application. Also, refactored the code a little bit to comply to
 * naming conventioned, infomration hiding and several other basic OO
 * principles.
 * <p/>
 ******************************************************************************/
public class OOPDraw2 extends JFrame implements MouseListener,
		MouseMotionListener {

	private static final long serialVersionUID = 4695753453561082104L;

	private static OOPDraw2 _instance;
	private ShapeComposer currentComposer;

	// ArrayList for storing the shapes
	private ArrayList<ShapeComposer> objectsOnScreen;

	

	public static void main(String[] args) {
		OOPDraw2 frame = new OOPDraw2();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private OOPDraw2() {
		// Do nothing in constructor off applet
		objectsOnScreen = new ArrayList<ShapeComposer>();
		currentComposer = new LineComposer();
		initGUI();
	}

	public static OOPDraw2 getInstance() {
		if (_instance == null) {
			_instance = new OOPDraw2();
		}
		return _instance;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Where the mouse went down is the start
		// position of the shape to be drawn
		int x = e.getX();
		int y = e.getY();
		Point coordinates =  new Point(x,y);
		objectsOnScreen.add(currentComposer.create(coordinates));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Fianlly the mouse is up indicating shape drawing is over.
		// So set these mouseUp coordinates to set the end position.
		// Then update the Vector count.
		int x = e.getX();
		int y = e.getY();
		Point coordinates = new Point(x,y);
		currentComposer.complete(coordinates);
		repaint();
	}

	/*
	 * Mouse Drag i.e. Left mouse button is down and mouse is being moved
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent
	 * )
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// Now the mouse is being dragged without releasing,
		// which means that the user may stop his mouse over a
		// point but not release it. So that point is the
		// current endpoint
		int x = e.getX();
		int y = e.getY();
		Point coordinates = new Point(x,y);
		currentComposer.expand(coordinates);
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	/*
	 * Paint method overridden for custom rendering of the screen
	 * 
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		// To get a shadow effect
		g.setColor(Color.black);
		g.fillRect(0, 0, getSize().width, getSize().height);
		g.setColor(new Color(255, 255, 154));
		g.fillRect(1, 1, getSize().width - 3, getSize().height - 3);
		for (ShapeComposer shape : objectsOnScreen) {
			shape.Draw((Graphics2D)g);

		}
	}

	/*
	 * method initializes GUI components
	 */
	private void initGUI() {
		setSize(800, 600);
		setTitle("jeffs awesome draw tool thingy");
		setLayout(new FlowLayout());
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		// Create and Add the buttons
		Button btnLine = new Button("Line");
		btnLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentComposer = new LineComposer();
			}
		});
		Button btnOval = new Button("Oval");
		btnOval.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentComposer = new OvalComposer();
			}
		});
		Button btnRect = new Button("Rectangle");
		btnRect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentComposer = new RectComposer();
			}
		});
		Button btnClear = new Button("Clear");
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Clear the entire drawing screen
				// First remove all elements
				objectsOnScreen.clear();
				// then make vector index zero
				// finally, call repaint()
				repaint();
			}
		});
		add(btnLine);
		add(btnOval);
		add(btnRect);
		add(btnClear);
	}

} // ALL ends :)