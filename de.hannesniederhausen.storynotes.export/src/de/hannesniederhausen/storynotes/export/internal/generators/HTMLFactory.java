package de.hannesniederhausen.storynotes.export.internal.generators;

import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;

import de.hannesniederhausen.storynotes.model.Project;

/**
 * 
 * Uses the {@link TextileFactory} and Mylyn Wikitext to generate an HTML
 * Outline
 * 
 * @author Hannes Niederhausen
 * 
 */
public class HTMLFactory {

	public static String getHTML(Project p) {
		String textile = new TextileFactory().getTextile(p);

		System.out.println(textile);
		MarkupParser markupParser = new MarkupParser();
		markupParser.setMarkupLanguage(new TextileLanguage());
		
		return markupParser.parseToHtml(textile);
	}

}
