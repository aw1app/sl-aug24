

import org.springframework.stereotype.Component;

@Component
public class Brand {
	
	String name;

	public Brand() {

	}

	public Brand(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
