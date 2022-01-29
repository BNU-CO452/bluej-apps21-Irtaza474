
public class Item {
	//public String description;
	private String description;
	public void setDesc(String description)					//setting up the description
	{
		this.description = description;
	}
	
	public String getDesc()									// getting description
	{
		return this.description;
	}
}

/////////////////////////////////////////
class Hammer extends Item {
	// directly inheriting form the parent(super) class
}


/////////////////////////////////////
class Gold extends Item {

}

class EnergyDrink extends Item {

}

class FlashLight extends Item {

}


//////////////////////
class Hill implements CaveSite {			//this class is implementing Cavesite interface
	public void launch(Player player) {
		System.out.println("Ohh! That hurts.");
	}
}