package adia.example.Dynamic.EMFREST.API;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Example.Family;

public abstract class DaughterMixin {
	@JsonIgnore
    abstract Family getFamily();

}
