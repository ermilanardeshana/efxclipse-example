package com.mil.debra.app.service;

import org.eclipse.fx.ui.workbench.renderers.fx.services.FlyInTransitionService;
import org.eclipse.fx.ui.workbench.renderers.fx.services.LightweightDialogTransitionService;
import org.osgi.service.component.annotations.Component;

@Component(service=LightweightDialogTransitionService.class)
public class LightWeightDialogueService extends FlyInTransitionService{
	public LightWeightDialogueService() {
		super(true);
	}

}
