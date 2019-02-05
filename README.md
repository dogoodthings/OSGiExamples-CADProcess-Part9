# Own CAD Process
How to create an own ECTR CAD process to be called from integration through connector
Setup project in eclipse:

1. File - Import - Maven - Checkout Maven Projects from SCM
2. SCM URL: git, https://github.com/dogoodthings/OSGiExamples-CADProcess-Part9.git
3. wait a while :P
4. open pom.xml and check the property ectr.installation.directory
5. locate your ECTR installation ( in most cases it is C:\Program Files (x86)\SAP\ECTR )
6. edit pom.xml and set the property ectr.installation.directory to this path
7. (do any meaningful changes to the source code)
8. right click on the project - run as - maven - goals: clean package - hit "run"
9. take the generated jar from target folder: OSGi-Examples-CADProcess-Part9-1.0.0.jar
10. goto ECTR installation, create a folder(s) OSGi-Examples\basis\plugins inside <ectr_inst_dir>\addons (mkdir "C:\Program Files (x86)\SAP\ECTR\addons\OSGi-Examples\basis\plugins")
11. put OSGi-Examples-CADProcess-Part9-1.0.0.jar inside OSGi-Examples\basis\plugins
12. start ECTR 

On the CAD Integration Side:
1. get a connector instance
2. use following example java code to call a CAD Process from the OSGi:


PlmRequest request = new PlmRequest("osgi.process.OptionDialogProcess");
request.getParameters().addOption("DIALOG_MESSAGE","Are you sure that you sure?");
request.getParameters().addOption("DIALOG_TITLE", "Its' all only for your own safety");
request.getParameters().addOption("DIALOG_OPTION_TYPE","1"); //1 = YES NO CANCEL
request.getParameters().addOption("DIALOG_MESSAGE_TYPE","3"); //3 = QUESTION
PlmResponse response = conn.callPlmProcess(request);
	
