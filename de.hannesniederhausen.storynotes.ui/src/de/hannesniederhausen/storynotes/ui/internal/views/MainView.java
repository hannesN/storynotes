package de.hannesniederhausen.storynotes.ui.internal.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.css.swt.CSSSWTConstants;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import de.hannesniederhausen.storynotes.model.Category;
import de.hannesniederhausen.storynotes.model.File;
import de.hannesniederhausen.storynotes.model.Note;
import de.hannesniederhausen.storynotes.model.Project;
import de.hannesniederhausen.storynotes.model.service.IFileListener;
import de.hannesniederhausen.storynotes.model.service.IModelProviderService;
import de.hannesniederhausen.storynotes.model.util.StorynotesAdapterFactory;
import de.hannesniederhausen.storynotes.ui.internal.handler.RedoHandler;
import de.hannesniederhausen.storynotes.ui.internal.handler.UndoHandler;
import de.hannesniederhausen.storynotes.ui.internal.navigation.widgets.NavigationBar;
import de.hannesniederhausen.storynotes.ui.internal.navigation.widgets.StoryNotesActionProvider;
import de.hannesniederhausen.storynotes.ui.internal.navigation.widgets.StoryNotesLabelProvider;
import de.hannesniederhausen.storynotes.ui.internal.navigation.widgets.StoryNotesModelContentProvider;
import de.hannesniederhausen.storynotes.ui.internal.services.ICategoryProviderManager;
import de.hannesniederhausen.storynotes.ui.internal.views.pages.ProjectInputMask;
import de.hannesniederhausen.storynotes.ui.services.ICategoryProviderService;
import de.hannesniederhausen.storynotes.ui.views.InputMask;

/**
 * Main View for the application including the "breadcrumb" navigation and a
 * stack of widgets for the different input masks
 * 
 * 
 * @author Hannes Niederhausen
 * 
 */
public class MainView implements IFileListener {
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

	private ProjectInputMask projectInputMask;

	@PostConstruct
	public void init() {

		modelProvider.addFileListener(this);
		
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

		
		initEditingDomain();
	}
	
	public void initEditingDomain() {
		BasicCommandStack cmdStack = new BasicCommandStack();
		AdapterFactory adapterFactory = new StorynotesAdapterFactory();
		EditingDomain editingDomain = new AdapterFactoryEditingDomain(adapterFactory, cmdStack);
		context.set(EditingDomain.class, editingDomain);
		
		UndoHandler uh = (UndoHandler) context.get("handler::de.hannesniederhausen.storynotes.undo");
		uh.setCommandStack(cmdStack);
		
		RedoHandler rh = (RedoHandler) context.get("handler::de.hannesniederhausen.storynotes.redo");
		rh.setCommandStack(cmdStack);
	}
	
	public Composite getParent() {
		return parent;
	}
	
	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Object selection) {
		if (selection!=null && navigationBar!=null)
			navigationBar.setInput(selection); 
		else
			return;
		
		
		InputMask im = null;
		if (selection instanceof Project) {
//			if (projectInputMask==null) { // wait until widgets are cached
				projectInputMask = ContextInjectionFactory.make(ProjectInputMask.class, context);
				projectInputMask.createControl(stack);
//			}
				
			im = projectInputMask;
		} else if (selection instanceof Category) {
			ICategoryProviderService s = categoryProviderManager.getServiceFor((Class<? extends Category>) selection.getClass());
			im = ContextInjectionFactory.make(s.getCategoryInputMaskClass(), context);
			im.createControl(stack);
		} else if (selection instanceof Note) {
			ICategoryProviderService s = categoryProviderManager.getServiceFor((Class<? extends Category>) ((EObject) selection).eContainer().getClass());
			im = ContextInjectionFactory.make(s.getNoteInputMaskClass((Class<? extends Note>) selection.getClass()), context);
			im.createControl(stack);
		}
		
		if (im!=null) {
			im.setModel((EObject) selection);
			if (stackLayout.topControl!=null)
				stackLayout.topControl.dispose();
			stackLayout.topControl = im.getControl();
			stack.layout();
		}
	}

	/* (non-Javadoc)
	 * @see de.hannesniederhausen.storynotes.model.service.IFileListener#fileChanged(de.hannesniederhausen.storynotes.model.File, de.hannesniederhausen.storynotes.model.File)
	 */
	@Override
	public void fileChanged(File oldFile, File newFile) {
		setSelection(newFile);
	}

}
