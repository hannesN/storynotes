package de.hannesniederhausen.storynotes.ui.internal.views;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.css.swt.CSSSWTConstants;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;
import de.hannesniederhausen.storynotes.ui.internal.navigation.widgets.NavigationBar;
import de.hannesniederhausen.storynotes.ui.internal.navigation.widgets.StoryNotesActionProvider;
import de.hannesniederhausen.storynotes.ui.internal.navigation.widgets.StoryNotesLabelProvider;
import de.hannesniederhausen.storynotes.ui.internal.navigation.widgets.StoryNotesModelContentProvider;
import de.hannesniederhausen.storynotes.ui.internal.services.ICategoryProviderManager;
import de.hannesniederhausen.storynotes.ui.internal.views.xwt.WelcomeView;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.category.CategoryInputMask;

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
	private ICategoryProviderManager categoryProviderManager;
	
	@Inject
	private Composite parent;

	private StackLayout stackLayout;

	private NavigationBar navigationBar;

	private Composite stack;

	@PostConstruct
	public void init() {

		context.set(MainView.class, this);
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

		StoryNotesActionProvider actionProvider = new StoryNotesActionProvider();
		actionProvider.setContext(context);
		
		navigationBar = new NavigationBar(comp);
		navigationBar.getControl().setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
		navigationBar.setContentProvider(new StoryNotesModelContentProvider());
		navigationBar.setActionProvider(actionProvider);
		navigationBar.setLabelProvider(new StoryNotesLabelProvider());
		
		navigationBar.setContext(context);
		navigationBar.setInput(project);
		
		stack = new Composite(comp, SWT.NONE);
		stack.setData(CSSSWTConstants.CSS_ID_KEY, "mainstack");
		stack.setLayoutData(new GridData(GridData.FILL_BOTH));
		stackLayout = new StackLayout();
		stack.setLayout(stackLayout);

		final WelcomeView welcomeView = new WelcomeView(stack, SWT.NONE,
				context);
		welcomeView.setLayoutData(new GridData(GridData.FILL_BOTH));

		
	}
	
	public Composite getParent() {
		return parent;
	}
	
	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Object selection) {
		if (selection!=null)
			navigationBar.setInput(selection); 
		
		if (selection instanceof Category) {
			CategoryInputMask catIM = new CategoryInputMask(stack, SWT.NONE);
			catIM.setModel((EObject) selection);
			stackLayout.topControl = catIM;
			stack.layout();
		}
	}

}
