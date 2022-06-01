package acme.features.patron.patronage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;

@Service
public class PatronPatronageListMineService implements AbstractListService<Patron, Patronage>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected PatronPatronageRepository repository;

	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		return true;
	}

	@Override
	public List<Patronage> findMany(final Request<Patronage> request) {
		assert request != null;
		final List<Patronage> result;
		int patronId;
		patronId = request.getPrincipal().getActiveRoleId();
		result = this.repository.findManyPatronagesByPatronId(patronId);
		
		return result;
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code","legalStuff","startDate","finishDate", "status", "inventor.userAccount.id");
		
	}

}
