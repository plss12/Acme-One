package acme.features.administrator.annoucement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAnnouncementCreateService implements AbstractCreateService<Administrator, Announcement> {
	


		@Autowired
		protected AdministratorAnnouncementRepository repo;

	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;
		return true;
	}
	

	@Override
	public void bind(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		
		assert request != null;
		assert entity != null;
		assert errors != null;

		

		
		request.bind(entity, errors, "title", "body", "link", "status");
		
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "body", "link", "status");
		model.setAttribute("confirm", "false");
		
	}

	@Override
	public Announcement instantiate(final Request<Announcement> request) {
		assert request != null;

		Announcement result;
		Date moment;
		result = new Announcement();
		moment = new Date(System.currentTimeMillis() - 1);
		result.setTitle("");
		result.setMoment(moment);
		result.setStatus(acme.entities.AnnouncementStatus.INFO);
		result.setBody("");
		result.setLink("");

		return result;
	}

	@Override
	public void validate(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		final Boolean confirmed = request.getModel().getBoolean("confirm");
		errors.state(request, confirmed, "confirm", "javax.validation.constraints.AssertTrue.message");
		
	}

	@Override
	public void create(final Request<Announcement> request, final Announcement entity) {
		assert request != null;
		assert entity != null;
		
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repo.save(entity);
		
	}

}
