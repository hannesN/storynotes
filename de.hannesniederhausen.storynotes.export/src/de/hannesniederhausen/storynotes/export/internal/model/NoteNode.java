/**
 * 
 */
package de.hannesniederhausen.storynotes.export.internal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.hannesniederhausen.storynotes.model.PlotNote;

/**
 * 
 * A node of the outline tree
 * 
 * @author Hannes Niederhausen
 *
 */
public class NoteNode {

	private final int level;
	
	private List<NoteNode> children;
	
	private PlotNote note;
	
	public NoteNode(int level) {
		this.level=level;
	}

	public List<NoteNode> getChildren() {
		if (children==null) {
			return Collections.emptyList();
		}
		return children;
	}
	
	
	
	public void addPlotNote(PlotNote note) {
		addChildNote(note, ("0."+note.getNumber()).split("\\."), this);
	}
	
	private void addChildNote(PlotNote child, String number[], NoteNode parent) {
		int childLevel = Integer.parseInt(number[0]);
		
		if (childLevel==level) {
			if (number.length==1) {
				note =child;
				return;
			} else {
				int nextLvl = Integer.parseInt(number[1]);
				NoteNode childNode = getChildNode(nextLvl);
				parent.addChildNode(childNode);
				childNode.addChildNote(child, Arrays.copyOfRange(number, 1, number.length), childNode);
			}
		}
		
	}

	private void addChildNode(NoteNode childNode) {
		if (children==null)
			children = new ArrayList<NoteNode>();
		
		if (children.contains(childNode))
			return;
		
		children.add(childNode);
	}

	private NoteNode getChildNode(int nextLvl) {
		for (NoteNode nn:getChildren()) {
			if (nn.getLevel()==nextLvl)
				return nn;
		}
		
		return new NoteNode(nextLvl);
		
	}
	
	public int getLevel() {
		return level;
	}

	public PlotNote getNote() {
		return note;
	}
	
	public void sortChildren() {
		Collections.sort(getChildren(), new Comparator<NoteNode>() {

			@Override
			public int compare(NoteNode o1, NoteNode o2) {
				int l1 = o1.getLevel();
				int l2 = o2.getLevel();
				
				if (l1==l2)
					return 0;
				
				return (l1<l2) ? -1 : 1;
						
			}
		});
		
		for (NoteNode nn:getChildren()) {
			nn.sortChildren();
		}
	}
	
	public void dump() {
		dump(0);
	}
	
	private void dump(int lvl) {
		for (int i=0;i<lvl; i++)
			System.out.print("  ");
		
		System.out.print(level+":  ");
		
		if (note!=null)
			System.out.println(note.getNumber());
		else {
			System.out.println("No Note");
		}
		
		for (NoteNode nn : getChildren()) {
			nn.dump(lvl+1);
		}
	}
}
