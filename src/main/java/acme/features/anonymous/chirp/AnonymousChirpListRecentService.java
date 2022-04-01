package acme.features.anonymous.chirp;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.Chirp;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Anonymous;
import acme.framework.services.AbstractListService;

public class AnonymousChirpListRecentService implements AbstractListService<Anonymous, Chirp> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousChirpRepository repository;

	// AbstractListService<Anonymus, Chirp> interface ---------------------------


	@Override
	public boolean authorise(final Request<Chirp> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Chirp> findMany(final Request<Chirp> request) {
		assert request != null;

		Collection<Chirp> result;
		Calendar calendar;
		Date deadLine;
		
		calendar=Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		deadLine=calendar.getTime();
		
		result=this.repository.findRecentsChirps(deadLine);

		return result;
	}
	
	@Override
	public void unbind(final Request<Chirp> request, final Chirp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creationMoment", "title", "author", "body", "emailAddress");
	}
}