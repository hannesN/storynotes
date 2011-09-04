package de.hannesniederhausen.storynotes.ui.internal.views.xwt;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.xwt.DefaultLoadingContext;
import org.eclipse.e4.xwt.IConstants;
import org.eclipse.e4.xwt.IXWTLoader;
import org.eclipse.e4.xwt.XWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;

public class WelcomeView extends Composite {

	private final IEclipseContext context;
	
	public WelcomeView(Composite parent, int style, IEclipseContext context) {
		super(parent, style);
		this.context = context;
		setLayout(new FillLayout());
		// load XWT
		String name = WelcomeView.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX;
		try {
			URL url = WelcomeView.class.getResource(name);
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(IXWTLoader.CLASS_PROPERTY, this);
			options.put(IXWTLoader.CONTAINER_PROPERTY, this);
			XWT.setLoadingContext(new DefaultLoadingContext(this.getClass()
					.getClassLoader()));
			XWT.loadWithOptions(url, options);
		} catch (Throwable e) {
			throw new Error("Unable to load " + name, e);
		}
	}

	public void onOpenSelection(Event event) {
		ECommandService cmdService = context.get(ECommandService.class);
		assert(cmdService!=null);
		EHandlerService handlerService = context.get(EHandlerService.class);
		assert(handlerService!=null);
		
		ParameterizedCommand cmd = cmdService.createCommand("de.hannesniederhausen.storynotes.ui.openCommand", null);
		handlerService.executeHandler(cmd);
	}
}
