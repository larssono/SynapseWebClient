package org.sagebionetworks.web.shared.provenance;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.google.gwt.user.client.rpc.IsSerializable;

public abstract class ProvTreeNode implements Iterable<ProvTreeNode>, IsSerializable {

	public abstract String getId();

	private Set<ProvTreeNode> children;
	private double xPos;
	private double yPos;

	public ProvTreeNode() {
		children = new HashSet<ProvTreeNode>();
	}

	/*
	 * Position Methods 
	 */
	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}	
	
	/*
	 * Tree Methods
	 */
	public boolean addChild(ProvTreeNode n) {
		return children.add(n);
	}

	public boolean removeChild(ProvTreeNode n) {
		return children.remove(n);
	}

	public Iterator<ProvTreeNode> iterator() {
		return children.iterator();
	}
	
}
