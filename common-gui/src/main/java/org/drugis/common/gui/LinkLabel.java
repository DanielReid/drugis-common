/*
 * This file is part of ADDIS (Aggregate Data Drug Information System).
 * ADDIS is distributed from http://drugis.org/.
 * Copyright (C) 2009 Gert van Valkenhoef, Tommi Tervonen.
 * Copyright (C) 2010 Gert van Valkenhoef, Tommi Tervonen, 
 * Tijs Zwinkels, Maarten Jacobs, Hanno Koeslag, Florin Schimbinschi, 
 * Ahmad Kamal, Daniel Reid.
 * Copyright (C) 2011 Gert van Valkenhoef, Ahmad Kamal, 
 * Daniel Reid, Florin Schimbinschi.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.drugis.common.gui;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import org.drugis.common.BrowserLaunch;

@SuppressWarnings("serial")
public class LinkLabel extends JLabel{

	private String d_url;

	public LinkLabel (String linkText, String url) {
		super(generateLabel("", linkText, url));
		d_url = url;
		this.addMouseListener(new ClickListener());
		this.setToolTipText("Go to " + url);
	}
	
	public LinkLabel(String text, String linkText, String url) {
		super(generateLabel(text, linkText, url));
		d_url = url;
		this.addMouseListener(new ClickListener());
		this.setToolTipText("Go to " + url);
	}

	private static String generateLabel(String text, String linkText, String url) {
		return "<html> "+text+" <a href=\""+url+"\">"+linkText+"</a></html>";
	}
	
	private class ClickListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent ev) {
			BrowserLaunch.openURL(d_url);
		}
		
		@Override
		public void mouseEntered(MouseEvent ev) {
			Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
			setCursor(handCursor);
		}
	}
	
}
