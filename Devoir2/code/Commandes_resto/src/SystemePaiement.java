class SystemePaiement{
    public SystemePaiement instance;
    public ProcesseurPaiement processeur;
    public Facturation facture;


    public SystemePaiement(){
        this.facture = new FactureSimple();
    }

    public SystemePaiement getInstance(){
        if(instance == null){
            instance = new SystemePaiement();
        }
        return instance;
    }

    public void setFacture(Facturation facture){
        this.facture = facture;
    }

    public void setProcesseur(ProcesseurPaiement processeur){
        this.processeur = processeur;
    }

    public boolean effectuerPaiement(double somme, ProcesseurPaiement processeur){
        if(processeur != null){
            boolean paiement = processeur.traiterPaiement(somme);
            if(paiement){
                facture.ajouterFacture(somme);
            }
            return paiement;
        }
        return false;
    }

    public double genererFacture(){
        return facture.genereFacture();
    }
}