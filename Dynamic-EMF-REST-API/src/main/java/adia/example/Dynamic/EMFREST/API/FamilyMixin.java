package adia.example.Dynamic.EMFREST.API;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Example.Daughter;
import Example.Family;
import Example.Parent;
import Example.Son;

public abstract class FamilyMixin {
	@JsonIgnore
    abstract EList<Family> getFamilies();
	abstract EList<Parent> getParents();
	abstract EList<Son> getSons();
	abstract EList<Daughter> getDaughters();
	abstract String getAddress();
	abstract String getName();

}
