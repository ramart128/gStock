package com.rmzb.gstock.gui.menu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class AbstractMenu implements IMenu {
	
	/**
	 * 
	 */
	private Menu menu;
	
	/**
	 * 
	 * @param text
	 */
	public AbstractMenu(String text) {
		this.menu = new Menu(text);
	}

	/**
	 * 
	 */
	@Override
	public Menu getMenu() {
		return menu;
	}
	
	protected void addMenuItem(String id, String text, String icon) {
		MenuItem item = new MenuItem();
		item.setId(id);
		item.setText(text);
		addMenuItem(item);
	}
	
	/**
	 * 
	 */
	protected void addSeparator() {
		SeparatorMenuItem smi = new SeparatorMenuItem();
		addMenuItem(smi);
	}
	
	/**
	 * 
	 * @param item
	 */
	private void addMenuItem(MenuItem item) {
		this.menu.getItems().add(item);
	}
	
}
