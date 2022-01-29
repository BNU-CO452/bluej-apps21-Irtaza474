public class Launch implements CaveSite {
	
public Launch(CaveSite out, CaveSite in, Hammer hammer){
	myHammer = hammer;
	inSite = in;
	outSite = out;
}
private CaveSite inSite;
private CaveSite outSite;
private Hammer myHammer;

public void launch(Player player)
{
	if (player.haveItem(myHammer))
	{
		System.out.println("Hammer works! the hill is broken,");			//if user have keys for the respective door
		if (player.getLoc() == outSite) inSite.launch(player);
		else if (player.getLoc() == inSite) outSite.launch(player);
	}
	else {
		System.out.println("You don't have the Hammer to break the hill!");		//if user don't have keys
		System.out.println("Find the Hammer and try again");
	}
}
}