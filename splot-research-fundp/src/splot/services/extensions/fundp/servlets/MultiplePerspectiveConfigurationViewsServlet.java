package splot.services.extensions.fundp.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import splot.core.HandlerBasedServlet;
import splot.services.extensions.fundp.handlers.CreateFeatureModelViewsHandler;
import splot.services.extensions.fundp.handlers.DeleteViewSpecificationFromRepository;
import splot.services.extensions.fundp.handlers.ImportWorkflowSpecificationHandler;
import splot.services.extensions.fundp.handlers.ShowWorkflowListHandler; 
import splot.services.extensions.fundp.handlers.ViewSpecificationEditorHandler; 
import splot.services.extensions.fundp.handlers.ParseWorkflowSpecificationHandler;
import splot.services.extensions.fundp.handlers.ResponseViewDetailsHandler;
import splot.services.extensions.fundp.handlers.SaveViewSpecificationToRepositoryHandler;
import splot.services.extensions.fundp.handlers.ValidateXPathHandler;
import splot.services.extensions.fundp.handlers.ViewAllocationEditorHandler;
import splot.services.extensions.fundp.handlers.LoadViewAllocationInformationHandler;
import splot.services.extensions.fundp.handlers.ResponseWorkflowAndFeatureListHandler;
import splot.services.extensions.fundp.handlers.DeleteViewAllocationHandler;
import splot.services.extensions.fundp.handlers.SaveViewAllocationToRepository;
import splot.services.extensions.fundp.handlers.conf.FCWInteractiveConfigurationExportConfigurationHandler;
import splot.services.extensions.fundp.handlers.conf.FCWSATInteractiveConfigurationDetectConflictsHandler;
import splot.services.extensions.fundp.handlers.conf.FCWSATInteractiveConfigurationMainHandler;
import splot.services.extensions.fundp.handlers.conf.FCWSATInteractiveConfigurationUpdatesHandler;
import splot.services.extensions.fundp.handlers.conf.FCWSelectFeatureModelHandler;
import splot.services.extensions.fundp.workflow.handlers.SelectWorkflowHandler;
import splot.services.extensions.fundp.workflow.handlers.ShowWorkflowInfoHandler;
import splot.services.handlers.conf.SATInteractiveConfigurationDetectConflictsHandler;














import freemarker.template.Configuration;


/** MultiplePerspectiveConfigurationViewsServlet is a servlet to handle the requests received from the clients. 
* 
* @author  PReCISE (research center of the University of FUNDP)
* @version 0.1
*/
public class MultiplePerspectiveConfigurationViewsServlet extends HandlerBasedServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiplePerspectiveConfigurationViewsServlet() {
        super();
    }
    
	Configuration cfg = new Configuration();
    public void createHandlers(ServletConfig config) {
        cfg.setServletContextForTemplateLoading(getServletContext(), "WEB-INF/templates/extensions/fundp");
        try {
        	addHandler(new CreateFeatureModelViewsHandler ("multiple_conf_views", this, cfg, cfg.getTemplate("multiple_conf_views.ftl")));
        	addHandler(new ImportWorkflowSpecificationHandler ("import_workflow_specification",this));
           	addHandler(new ShowWorkflowListHandler("show_workflow_list", this, cfg, cfg.getTemplate("workflow_list.ftl")));
        	addHandler(new ViewSpecificationEditorHandler("view_specification_editor", this, cfg, cfg.getTemplate("view_specification_editor.ftl")));
        	addHandler(new ParseWorkflowSpecificationHandler("parse_workflow_specification",this,cfg,cfg.getTemplate("parsed_workflow_list.ftl")));
        	addHandler(new ResponseViewDetailsHandler("response_view_detail",this));
        	addHandler(new SaveViewSpecificationToRepositoryHandler("save_view_to_repository",this));
        	addHandler(new ValidateXPathHandler("validate_xpath", this));
        	addHandler(new ViewAllocationEditorHandler("view_allocation_editor", this, cfg, cfg.getTemplate("view_allocation_editor.ftl")));
        	addHandler(new LoadViewAllocationInformationHandler("load_view_allocation_information", this));
        	addHandler(new ResponseWorkflowAndFeatureListHandler ("response_workflow_feature_list",this));
        	addHandler(new DeleteViewAllocationHandler ("delete_view_allocation",this));
        	addHandler(new SaveViewAllocationToRepository ("save_view_allocation",this));
        	addHandler(new FCWSelectFeatureModelHandler("select_model", this, cfg, cfg.getTemplate("fcw_select_model.ftl")));
        	addHandler(new FCWSATInteractiveConfigurationMainHandler("interactive_configuration_main", this, cfg, cfg.getTemplate("fcw_interactive_configuration_main2.ftl")));
        	addHandler(new FCWSATInteractiveConfigurationMainHandler("splot_config_main", this, cfg, cfg.getTemplate("fcw_interactive_configuration_main2.ftl")));
        	addHandler(new FCWSATInteractiveConfigurationUpdatesHandler("interactive_configuration_updates", this, cfg, cfg.getTemplate("fcw_interactive_configuration_updates2.ftl")));
           	addHandler(new FCWInteractiveConfigurationExportConfigurationHandler("export_configuration_csv", this, cfg, cfg.getTemplate("fcw_export_configuration_csv.ftl")));
        	addHandler(new FCWInteractiveConfigurationExportConfigurationHandler("export_configuration_xml", this, cfg, cfg.getTemplate("fcw_export_configuration_xml.ftl")));
           	addHandler(new SelectWorkflowHandler("select_workflow", this, cfg, cfg.getTemplate("select_workflow.ftl")));
           	addHandler(new ShowWorkflowInfoHandler("show_workflow_info", this, cfg, cfg.getTemplate("show_workflow_info.ftl")));
        	addHandler(new DeleteViewSpecificationFromRepository ("delete_view_specification",this));
        	addHandler(new FCWSATInteractiveConfigurationDetectConflictsHandler("detect_conflicts", this, cfg, cfg.getTemplate("fcw_detect_conflicts.ftl")));


        	
        	
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
    }
    
}
