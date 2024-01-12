package adia.example.Dynamic.EMFREST.API;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Example.Family;

public abstract class SonMixin {
	@JsonIgnore
    abstract Family getFamily();

}
