/**
 * 
 */
package de.hannesniederhausen.storynotes.export.internal.ui;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.wizard.Wizard;

import de.hannesniederhausen.storynotes.export.internal.generators.HTMLFactory;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;

/**
 * Wizard for the export of the outline
 * 
 * @author Hannes Niederhausen
 *
 */
public class OutlineExportWizard extends Wizard {

	private File file;
	private OutlineExportWizardPage page;
	
	
	
	public OutlineExportWizard(File file) {
		super();
		this.file = file;
	}

	@Override
	public void addPages() {
		page = new OutlineExportWizardPage(file);
		addPage(page);
	}
	
	@Override
	public boolean performFinish() {

		Project p = page.getSelectedProject();
		String filename = page.getFilename();
		DocType docType = page.getDocType();

		
		if (docType == DocType.HTML) {
			try {
				String htmlContent = HTMLFactory.getHTML(p);

				java.io.File f = new java.io.File(filename);
				FileWriter fw = new FileWriter(f);
				fw.write(htmlContent);
				fw.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		return true;
	}

}
