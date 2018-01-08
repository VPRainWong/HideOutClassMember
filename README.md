This open source plugin support hide out class member in Visual Paradigm's UML class diagram.

Details about how to deploy this plugin to Visual Paradigm can be found at https://knowhow.visual-paradigm.com/openapi/how-to-deploy-plugins-to-vp-application/

The basic flow is:
1. Walk through the class members (attributes/operations)
2. When the target class member was found. uUse the setHiddenAttributeModels/setHiddenOperationModels method to out it into hidden list
3. Call the setShowAttributeType/setShowOperationType to IClassUIModel.ATTR_SHOW_TYPE_CUSTOMIZED to hide them away in diagram

More details about this plugin can be found at https://knowhow.visual-paradigm.com/openapi/hiding-attributes/
