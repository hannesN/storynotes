package de.hannesniederhausen.storynotes.export.internal.ui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;

/**
 * Wizardpage for the {@link OutlineExportWizard}
 * @author Hannes Niederhausen
 *
 */
public class OutlineExportWizardPage extends WizardPage {
	
	private Project selectedProject;
	
	private String filename;
	
	private DocType docType;
	
	private Text fileNameText;

	private Combo typeCombo;
	
	private Combo projectCombo;

	private File file;

	private Button browseButton;
	
	/**
	 * Create the wizard.
	 */
	public OutlineExportWizardPage(File file) {
		super("wizardPage");
		this.file = file;
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblTargetFile = new Label(container, SWT.NONE);
		lblTargetFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTargetFile.setText("Target File:");
		
		fileNameText = new Text(container, SWT.BORDER);
		fileNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		browseButton = new Button(container, SWT.NONE);
		browseButton.setText("Browse...");
		
		Label lblFileType = new Label(container, SWT.NONE);
		lblFileType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFileType.setText("File Type:");
		
		typeCombo = new Combo(container, SWT.NONE);
		
		String items[] = new String[DocType.values().length];
		for (int i=0; i<DocType.values().length; i++) {
			items[i]=DocType.values()[i].name();
		}
		
		typeCombo.setItems(items);
		typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		new Label(container, SWT.NONE);
		
		Label lblProject = new Label(container, SWT.NONE);
		lblProject.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProject.setText("Project:");
		
		projectCombo = new Combo(container, SWT.NONE);
		projectCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		projectCombo.setItems(getProjectNames());
		
		
		new Label(container, SWT.NONE);
		docType=DocType.HTML;
		hookListneners();
		
		typeCombo.select(0);
		projectCombo.select(0);
		
		docType = DocType.valueOf(typeCombo.getItem(0));
		selectedProject=file.getProjects().get(0);
	}
	
	public DocType getDocType() {
		return docType;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public Project getSelectedProject() {
		return selectedProject;
	}

	private String[] getProjectNames() {
	
		String[] names = new String[file.getProjects().size()];
		
		int i=0;
		for (Project p : file.getProjects()) {
			names[i]=p.getName();
			i++;
		}
		
		return names;
	}

	private void hookListneners() {
		fileNameText.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				filename = fileNameText.getText();				
			}
		});
		
		typeCombo.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				docType = DocType.valueOf(typeCombo.getItem(typeCombo.getSelectionIndex()));
			}
		});
		
		projectCombo.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Selection changed");
				selectedProject=file.getProjects().get(projectCombo.getSelectionIndex());
			}
		});
		
		browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell(), SWT.SAVE);
				
				
				String name = dlg.open();
				if (name!=null) {
					filename=name;
					fileNameText.setText(filename);
				}
			}
		});
	}

	
}
