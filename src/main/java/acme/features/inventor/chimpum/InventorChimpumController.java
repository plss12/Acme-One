package acme.features.inventor.chimpum;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.CHIMPUM;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorChimpumController extends AbstractController<Inventor,CHIMPUM>{
	
	@Autowired
	protected InventorArtifactChimpumsListService listServiceArtifact;
	
	@Autowired
	protected InventorChimpumShowService showService;
	
	@Autowired
	protected InventorChimpumCreateService createService;
	
	@Autowired
	protected InventorChimpumDeleteService deleteService;
	
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list-own","list", this.listServiceArtifact);
		super.addCommand("create", this.createService);
		super.addCommand("delete", this.deleteService);
	}

}
