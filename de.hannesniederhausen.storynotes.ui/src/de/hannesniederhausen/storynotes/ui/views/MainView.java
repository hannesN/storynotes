package de.hannesniederhausen.storynotes.ui.views;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.css.swt.CSSSWTConstants;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.modeling.ISelectionListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;
import de.hannesniederhausen.storynotes.ui.navigation.widgets.NavigationBar;
import de.hannesniederhausen.storynotes.ui.navigation.widgets.StoryNotesActionProvider;
import de.hannesniederhausen.storynotes.ui.navigation.widgets.StoryNotesLabelProvider;
import de.hannesniederhausen.storynotes.ui.navigation.widgets.StoryNotesModelContentProvider;
import de.hannesniederhausen.storynotes.ui.xwt.WelcomeView;

/**
 * Main View for the application including the "breadcrumb" navigation and a
 * stack of widgets for the different input masks
 * 
 * 
 * @author Hannes Niederhausen
 * 
 */
public class MainView  {
	@Inject
	private IModelProviderService modelProvider;
	
	@Inject
	private Logger logger;
	
	@Inject
	private IEclipseContext context;
	
	@Inject
	private Composite parent;

	private StackLayout stackLayout;

	private NavigationBar navigationBar;

	@PostConstruct
	public void init() {

		modelProvider.newFile();
		
		// TODO remove test model
		File file = modelProvider.getFile();
		Project project = modelProvider.getModelFactory().createProject();
		project.setName("Test Project");
		file.getProjects().add(project);
		
		// create some stuff to see how the dependency injection works

		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		comp.setLayout(layout);

		navigationBar = new NavigationBar(comp);
		navigationBar.getControl().setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
		navigationBar.setContentProvider(new StoryNotesModelContentProvider());
		navigationBar.setActionProvider(new StoryNotesActionProvider());
		navigationBar.setLabelProvider(new StoryNotesLabelProvider());
		navigationBar.setSelectionService(context.get(ESelectionService.class));
		navigationBar.setInput(file);
		
		final Composite stack = new Composite(comp, SWT.NONE);
		stack.setData(CSSSWTConstants.CSS_ID_KEY, "mainstack");
		stack.setLayoutData(new GridData(GridData.FILL_BOTH));
		stackLayout = new StackLayout();
		stack.setLayout(stackLayout);

		final Label l1 = new Label(stack, SWT.NONE);
		l1.setText("Label 1");
		stackLayout.topControl = l1;

		final WelcomeView welcomeView = new WelcomeView(stack, SWT.NONE,
				context);
		welcomeView.setLayoutData(new GridData(GridData.FILL_BOTH));

	}
	
	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Object selection) {
		if (selection!=null)
			navigationBar.setInput(selection);
	}

}
