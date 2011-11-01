/**
 * 
 */
package de.hannesniederhausen.storynotes.export.internal.generators;

import de.hannesniederhausen.storynotes.export.internal.model.NodeFactory;
import de.hannesniederhausen.storynotes.export.internal.model.NoteNode;
import de.hannesniederhausen.storynotes.model.Project;

/**
 * Gets a project and creates the document for the outline in textile markup.
 * 
 * @author Hannes Niederhausen
 *
 */
public class TextileFactory {

	public String getTextile(Project project) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("h1. Project: ");
		buffer.append(project.getName());
		buffer.append("\n\n");
		
		NoteNode root = new NodeFactory().getRootNode(project);
		
		appendChildren(root, buffer, 0);
		
		
		return buffer.toString();
	}

	private void appendChildren(NoteNode root, StringBuilder buffer, int lvl) {
		
		if (root.getNote()!=null) {
			buffer.append("h"+lvl+". ");
			buffer.append(root.getNote().getTitle());
			buffer.append("\n\n");
			String description = root.getNote().getDescription();
			if (description!=null)
				buffer.append(description);
			
			buffer.append("\n\n");
		}

		for (NoteNode nn : root.getChildren()) {
			appendChildren(nn, buffer, lvl+1);
		}
		
	}
	
}
