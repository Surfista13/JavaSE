package fr.eni.papeterie.bo;

import java.util.Objects;

/**
 * Classe mère Article <strong>abstraite</strong> regroupant les attributs :<br>
 * <ul><li>idArticle : identifiant permettant de référencer un article de façon unique</li>
 * <li>reference : reference d'un article</li>
 * <li>marque : marque d'un article</li>
 * <li>designation : designation d'un article</li>
 * <li>prixUnitaire : prix unitaire de l'article</li>
 * <li>qteStock : quantité en stock d'un article</li></ul>
 * Cette classe mère <strong>généralisant</strong> les classes filles Ramette et Stylo  
 * @author Thierry
 *
 */
public abstract class Article {
	//Attributs d'instance
	private Integer idArticle;
	private String reference;
	private String marque;
	private String designation;
	private float prixUnitaire;
	private int qteStock;

	//Constructeurs
	/**
	 * Constructeur par défaut
	 */
	public Article(){
	}
	
	/**
	 * Constructeur surchargé
	 * @param marque : la marque de l'article
	 * @param ref : la reference
	 * @param designation : la designation
	 * @param pu : le prix unitaire
	 * @param qte : la quantité en stock
	 */
	public Article( String marque, String ref, String designation, float pu, int qte)  {
		setMarque(marque);
		setReference(ref);
		setDesignation(designation);
		setPrixUnitaire(pu);
		setQteStock(qte);
	}
	
	/**
	 * Constructeur surchargé
	 * @param idArticle : l'identifiant de l'article
	 * @param marque : la marque de l'article
	 * @param ref : la reference
	 * @param designation : la designation
	 * @param pu : le prix unitaire
	 * @param qte : la quantité en stock
	 */
	public Article( Integer idArticle, String marque, String ref, String designation, float pu, int qte)  {
		this(  marque, ref, designation, pu, qte);
		setIdArticle(idArticle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [idArticle="+ idArticle +", reference=" + reference + ", marque=" + marque + ", designation=" + designation
				+ ", prixUnitaire=" + prixUnitaire + ", qteStock=" + qteStock + "]\n";
	}

	//Getters et Setters
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference)  {
		this.reference = reference;
	}

	/// *MARQUE*///
	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque
	 *            the marque to set
	 */
	public void setMarque(String marque)  {

		this.marque = marque;
	}

	/// *DESIGNATION*///
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation)  {

		this.designation = designation;

	}

	/// *PRIX UNITAIRE*///
	/**
	 * @return the prixUnitaire
	 */
	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	/**
	 * @param prixUnitaire
	 *            the prixUnitaire to set
	 */
	public void setPrixUnitaire(float prixUnitaire)  {
		this.prixUnitaire = prixUnitaire;

	}

	/// *QUANTITE STOCK*///
	/**
	 * @return the qteStock
	 */
	public int getQteStock() {
		return qteStock;
	}

	/**
	 * @param qteStock
	 *            the qteStock to set
	 */
	public void setQteStock(int qteStock) {

		this.qteStock = qteStock;
	}


	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Article)) return false;
		Article article = (Article) o;
		return idArticle.equals(article.idArticle);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idArticle);
	}
}
