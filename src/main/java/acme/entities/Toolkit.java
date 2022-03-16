package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Toolkit  extends AbstractEntity{
	
	// Serialisation identifier ----------------------

	protected static final long serialVersionUID = 1L;
	
	// Attributes  ------------------------------------

	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected Integer code;
	
	
	@NotBlank
	@Length(min=0,max=100)
	protected String title;
	
	@NotBlank
	@Length(min=0,max=255)
	protected String description;
	
	@NotBlank
	@Length(min=0,max=255)
	protected String assemblyNotes;
	
	@URL
	protected String link;
	
	// Relationships ---------------------------------
	
    @Valid
    @ManyToOne
    protected Component component;
	
	@Valid
	@OneToOne
	protected Tool tool;
}
