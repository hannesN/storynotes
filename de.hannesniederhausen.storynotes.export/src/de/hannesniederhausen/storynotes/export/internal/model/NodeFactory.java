package de.hannesniederhausen.storynotes.export.internal.model;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.model.PlotCategory;
import de.hannesniederhausen.storynotes.model.PlotNote;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.StorynotesFactory;

/**
 * 
 * @author Hannes Niederhausen
 *
 */
public class NodeFactory {

	
	
	public NoteNode getRootNode(Project project) {
		
		NoteNode root = new NoteNode(0);
		for (Category cat : project.getCategories()) {
			if (cat instanceof PlotCategory) {
				for (Note n : cat.getNotes()) {
					PlotNote pn = (PlotNote) n;
					if (pn.isInsideOutline()) {
						if (pn.getNumber()!=null||!pn.getNumber().isEmpty()) {
							root.addPlotNote(pn);
						}
					}
				}
			}
		}
		
		root.sortChildren();
		
		return root;
	}
	
	public static void main(String[] args) {
		StorynotesFactory fac = StorynotesFactory.eINSTANCE;
		Project project = fac.createProject();
		project.setName("Test Project");
		
		PlotCategory cat = fac.createPlotCategory();
		project.getCategories().add(cat);
		
		String[] numbers = {"1.", "1.1.", "2.1", "2", "2.5", "1.3", "1.2.5"};
		
		for (String num : numbers) {
			PlotNote pn = fac.createPlotNote();
			pn.setNumber(num);
			pn.setTitle("Title: "+num);
			pn.setInsideOutline(true);
			cat.getNotes().add(pn);
		}
		
		
		new NodeFactory().getRootNode(project).dump();
		
	}
}
