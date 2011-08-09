package de.hannesniederhausen.storynotes.ui.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.css.swt.CSSSWTConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.hannesniederhausen.storynotes.ui.xwt.WelcomeView;

/**
 * Main View for the application including the "breadcrumb" navigation
 * and a stack of widgets for the different input masks
 * 
 * 
 * @author Hannes Niederhausen
 *
 */
public class MainView {

	@Inject
	private Logger logger;
	@Inject
	private IEclipseContext context;
	@Inject
	private Composite parent;
	private StackLayout stackLayout;
	
	@PostConstruct
	public void init() {
		
		// create some stuff to see how the dependency injection works
		
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth=0;
		layout.marginHeight=0;
		comp.setLayout(layout);
		
		Composite breadCrumb = new Composite(comp, SWT.NONE);
		breadCrumb.setData(CSSSWTConstants.CSS_ID_KEY, "breadcrumbbar");
		breadCrumb.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		breadCrumb.setLayout(new FillLayout());
		
		
		
		
		
		final Composite stack = new Composite(comp, SWT.NONE);
		stack.setData(CSSSWTConstants.CSS_ID_KEY, "mainstack");
		stack.setLayoutData(new GridData(GridData.FILL_BOTH));
		stackLayout = new StackLayout();
		stack.setLayout(stackLayout);
		
		final Label l1 = new Label(stack, SWT.NONE);
		l1.setText("Label 1");
		stackLayout.topControl=l1;
		
		final WelcomeView welcomeView = new WelcomeView(stack, SWT.NONE, context);
		welcomeView.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Button b = new Button(breadCrumb, SWT.PUSH);
		b.setText("Switch");
		b.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (stackLayout.topControl==l1) {
					stackLayout.topControl=welcomeView;
				} else {
					stackLayout.topControl=l1;
				}
				stack.layout();
			}
		});
	}
	
	
	
}
