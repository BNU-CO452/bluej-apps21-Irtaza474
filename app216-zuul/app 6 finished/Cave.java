
import java.util.*;

public class Cave implements CaveSite {
	
	private String descrip;
	
	private CaveSite[] sides = new CaveSite[6];
	
	private ArrayList<Item> contents = new ArrayList<Item>();
	
	Cave(){
		sides[0] = new Hill();
		sides[1] = new Hill();
		sides[2] = new Hill();
		sides[3] = new Hill();
		sides[4] = new Hill();
		sides[5] = new Hill();
	}
	
	public void setDesc(String descrip) {
		this.descrip = descrip;
	}
	
	public void direction(int direction, CaveSite m) {
		sides[direction] = m;
	}
	
	public void addItem(Item theItem) {				//adding item
		contents.add(theItem);
	}
	
	public void removeItem(Item theItem) {				//removing item
		contents.remove(theItem);
	}
	
	public boolean caveEmpty() {
		return contents.isEmpty();
	}
	
	public Item[] getCaveContents() {				//getting room content
		Item[] contentsArray = new Item[contents.size()];
		contentsArray = contents.toArray(contentsArray);
		return contentsArray;
	}
	
	public void launch(Player player) {
		player.setLoc(this);
	}
	
	public void exit(int direction, Player player) {
		sides[direction].launch(player);
	}
	
	public String getDesc() {
		ListIterator<Item> caveContents = contents.listIterator();
		String contentString = "";
		while(caveContents.hasNext())
			contentString = contentString + (caveContents.next()).getDesc() + " ";
		
		return descrip + '\n' + '\n' +
				"Cave Contents: " + contentString + '\n';
	}
	
}