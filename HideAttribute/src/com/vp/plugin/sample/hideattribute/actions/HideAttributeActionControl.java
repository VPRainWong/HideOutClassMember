package com.vp.plugin.sample.hideattribute.actions;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IClassDiagramUIModel;
import com.vp.plugin.diagram.IDiagramElement;
import com.vp.plugin.diagram.IDiagramUIModel;
import com.vp.plugin.diagram.shape.IClassUIModel;
import com.vp.plugin.model.IAttribute;
import com.vp.plugin.model.IClass;

public class HideAttributeActionControl implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		// Retrieve active diagram, and proceed if it is a class diagram
		IDiagramUIModel currentDiagram = ApplicationManager.instance().getDiagramManager().getActiveDiagram();
		if (currentDiagram instanceof IClassDiagramUIModel) {
			IClassDiagramUIModel classDiagram = (IClassDiagramUIModel) currentDiagram;
			
			// Retrieve all class shape in the diagram
			IDiagramElement[] diagramElements = classDiagram.toDiagramElementArray(IClassDiagramUIModel.SHAPETYPE_CLASS);
			if (diagramElements.length > 0) {
				// Walk through the class shapes
				for (int i = 0; i < diagramElements.length; i++) {
					IClassUIModel classShape = (IClassUIModel) diagramElements[i];
					// Retrieve class model from class shape 
					IClass classModel = (IClass) diagramElements[i].getModelElement();
					// Retrieve attributes if the class named "Customer"
					if ("Customer".equals(classModel.getName())) {
						IAttribute[] attributes = classModel.toAttributeArray();
						for (int j = 0; j < attributes.length; j++) { 
							// Walk through all attributes to see is there any name named as "name"
							if ("name".equals(attributes[j].getName())) {
								// Hide away to attribute which named as "name"
								classShape.setHiddenAttributeModels(new IAttribute[] {attributes[j]});
								classShape.setShowAttributeType(IClassUIModel.ATTR_SHOW_TYPE_CUSTOMIZED);													
							}
						}						
					}					
				}
			}
		}
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
