package fr.eni.editeur;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Commande {
private Date dateCde;
private final int MAX = 10;
private int position = 0;
Livre livre;
Livre [] livres ;
Client client;
/**
 * @param dateCde
 * @param position
 */
public Commande(Client client,Livre livre) {
	this.client = client;
	livres = new Livre[10];
	Add(livre);
	dateCde = new Date();
}

public Commande(Client client,Livre [] livres) {
	this.client = client;
	
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public void Add(Livre livre) {
	if (position < MAX) {
		livres[position] = livre;
		position++;
	}
}

public void afficher() {
	for(int i= 0; i < position;i++) {
		livres[i].getLivreToString();
	}
}


public String getCommandeToString() throws Exception {
	SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
    String bon = String.format("Client : %s \nCommande : %s\nDétail :\n",
                    client.getClientToString(),
                    sdf.format(dateCde));
    for (Livre livre : livres) {
        if (livre != null)
            bon += String.format("%s\n", livre.getLivreToString());
        else
            break;
	}
    return bon;
}





}
